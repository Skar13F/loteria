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

import mx.edu.unsis.loteria.dto.Room;
import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/create")
    public ResponseEntity<Room> createRoom() {
        Room room = roomService.createRoom();
        messagingTemplate.convertAndSend("/topic/rooms", room);

        return ResponseEntity.ok(room);
    }

    @PostMapping("/join")
    public ResponseEntity<Room> joinRoom(@RequestParam String roomId, @RequestBody Jugador jugador) {
        Room room = roomService.addPlayerToRoom(roomId, jugador);
        return ResponseEntity.ok(room);
    }

    @GetMapping("/available")
    public ResponseEntity<?> getAvailableRooms() {
        // Lógica para obtener salas disponibles
        return ResponseEntity.ok(roomService.getAllRooms());
    }
}
