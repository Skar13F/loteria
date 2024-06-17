package mx.edu.unsis.loteria.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import mx.edu.unsis.loteria.dto.Room;
import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.service.JugadorService;
import mx.edu.unsis.loteria.service.RoomService;
@Controller
public class GameWebSocketController {
    @Autowired
    private RoomService roomService;
    
    @MessageMapping("/rooms")
    @SendTo("/topic/rooms")
    public List<Room> getRooms() {
        return roomService.getAllRooms();
    }

    @MessageMapping("/join")
    @SendTo("/topic/player-joined")
    public Jugador joinGame(Jugador jugador) {
        //creamos un jugador
        JugadorService jugadorService=new JugadorService();
        Jugador jugador2=jugadorService.crearJugador(jugador);
        
        return jugador2;
    }

    /*@MessageMapping("/game-over")
    @SendTo("/topic/game-over")
    public GameResult endGame(GameResult result) {
        // Lógica para manejar el final del juego y enviar resultado
        return result;
    }*/
}
