package mx.edu.unsis.loteria.service;

import mx.edu.unsis.loteria.model.Cantador;
import mx.edu.unsis.loteria.model.Juego;
import mx.edu.unsis.loteria.model.Jugador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JuegoService {

    public Juego crearJuego(Cantador cantador, ArrayList<Jugador> jugadores) {
        Juego juego = new Juego();
        juego.setCantador(cantador);
        juego.setJugadores(jugadores);
        return juego;
    }

    public Jugador obtenerJugadorPorId(Juego juego, String id) {
        for (Jugador jugador : juego.getJugadores()) {
            if (jugador.getIdJugador() == id) {
                return jugador;
            }
        }
        return null;
    }

    public void agregarJugador(Juego juego, Jugador jugador) {
        juego.getJugadores().add(jugador);
    }

    public void eliminarJugador(Juego juego, Jugador jugador) {
        juego.getJugadores().remove(jugador);
    }

    public int obtenerCantidadJugadores(Juego juego) {
        return juego.getJugadores().size();
    }

    public Cantador obtenerCantador(Juego juego) {
        return juego.getCantador();
    }
}
