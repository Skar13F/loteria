package mx.edu.unsis.loteria.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Sala {
    public Sala(){}
    private String id;
    private Cantador cantador;
    private List<Jugador> jugadores;
    private boolean juegoIniciado;
}
