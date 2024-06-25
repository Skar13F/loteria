package mx.edu.unsis.loteria.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.model.Sala;
import mx.edu.unsis.loteria.service.JugadorService;
import mx.edu.unsis.loteria.service.SalaService;
@Controller
public class JuegoWebSocketController {
    @Autowired
    private SalaService salaService;
    
    @Autowired
    private JugadorService jugadorService;
    
    @MessageMapping("/salas")
    @SendTo("/topic/salas")
    public List<Sala> getSalas() {
        return salaService.obtenerSalas();
    }

    @MessageMapping("/create-player")
    @SendTo("/topic/player-created")
    public Jugador createPlayer(Jugador jugador) {
        Jugador jugadorCreado = jugadorService.crearJugador(jugador);
        return jugadorCreado;
    }
}
