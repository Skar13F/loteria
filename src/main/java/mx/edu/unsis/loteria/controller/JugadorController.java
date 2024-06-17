package mx.edu.unsis.loteria.controller;

import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.service.JugadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    // Endpoint para crear un nuevo jugador
    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador) {
        Jugador jugadorCreado = jugadorService.crearJugador(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jugadorCreado);
    }

    // Endpoint para actualizar un jugador existente
    @PutMapping("/{idJugador}")
    public ResponseEntity<Jugador> actualizarJugador(@RequestBody Jugador jugador, Carta carta) {
        Jugador jugadorActualizado = jugadorService.actualizarJugador(jugador, carta);
        if (jugadorActualizado != null) {
            return ResponseEntity.ok(jugadorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
