package mx.edu.unsis.loteria.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import mx.edu.unsis.loteria.dto.Room;
import mx.edu.unsis.loteria.model.Jugador;

@Service
public class RoomService {

    private Map<String, Room> rooms = new HashMap<>();

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    public Room getRoomById(String roomId) {
        return rooms.get(roomId);
    }

    public Room createRoom() {
        Room room = new Room();
        room.setId(UUID.randomUUID().toString());
        rooms.put(room.getId(), room);
        return room;
    }

    public Room addPlayerToRoom(String roomId, Jugador jugador ) {
        Room room = rooms.get(roomId);
        if (room != null) {
            room.getJugadores().add(jugador);
        }
        return room;
    }
}

