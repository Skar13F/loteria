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

    /*@MessageMapping("/join")
    @SendTo("/topic/player-joined")
    public Jugador joinGame(Jugador jugador) {
        //JugadorService jugadorService=new JugadorService();
        //Jugador jugador2=jugadorService.crearJugador(jugador);
        return jugador2;
    }*/

    /*@MessageMapping("/game-over")
    @SendTo("/topic/game-over")
    public GameResult endGame(GameResult result) {
        // Lógica para manejar el final del juego y enviar resultado
        return result;
    }*/

    @MessageMapping("/create-player")
    @SendTo("/topic/player-created")
    public Jugador createPlayer(Jugador jugador) {
        Jugador jugadorCreado = jugadorService.crearJugador(jugador);
        return jugadorCreado;
    }
}
