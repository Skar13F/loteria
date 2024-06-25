package mx.edu.unsis.loteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.model.Sala;
import mx.edu.unsis.loteria.service.SalaService;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/crear")
    public ResponseEntity<Sala> crearSala() {
        Sala sala = salaService.crearSala();
        messagingTemplate.convertAndSend("/topic/salas", sala);
        return ResponseEntity.ok(sala);
    }

    @PostMapping("/unirse")
    public ResponseEntity<Sala> unirseSala(@RequestParam String salaId, @RequestBody Jugador jugador) {
        Sala sala = salaService.agregarJugadorSala(salaId, jugador);
        return ResponseEntity.ok(sala);
    }

    @GetMapping("/disponible")
    public ResponseEntity<?> getAvailableRooms() {
        // Lógica para obtener salas disponibles
        return ResponseEntity.ok(salaService.obtenerSalas());
    }

    @GetMapping("/carta")
    public ResponseEntity<Carta> getCarta(@RequestParam String salaId) {
        Carta carta = salaService.cartaEnCurso(salaId);
        return ResponseEntity.ok(carta);
    }
}
