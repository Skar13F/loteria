package mx.edu.unsis.loteria.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import mx.edu.unsis.loteria.model.Jugador;


@Data
@AllArgsConstructor
public class Room {
    public Room(){}
    private String id;
    private List<Jugador> jugadores;
    private boolean gameStarted;
}
