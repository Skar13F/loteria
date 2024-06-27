package mx.edu.unsis.loteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.model.Sala;
import mx.edu.unsis.loteria.service.CantadorService;
import mx.edu.unsis.loteria.service.JugadorService;
import mx.edu.unsis.loteria.service.SalaService;

@Controller
public class JuegoWebSocketController {
    @Autowired
    private SalaService salaService;

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private CantadorService cantadorService;

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
    //roomId es el id de la sala al que se enviarán las cartas
    @MessageMapping("/tablero/{roomId}")//la ruta de donde viene la solicitud, o a la cual se va a conectar
    @SendTo("/topic/{roomId}")//La ruta a la cual queremos redireccionar, prefix topic
    public Carta mensaje(@DestinationVariable String roomId){
        Carta cartaSacada = cantadorService.sacarCarta(salaService.obtenerSalaPorId(roomId).getCantador());
        return cartaSacada;
    }

}
