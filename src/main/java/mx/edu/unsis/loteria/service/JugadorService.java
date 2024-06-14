package mx.edu.unsis.loteria.service;

import mx.edu.unsis.loteria.model.Carton;
import mx.edu.unsis.loteria.model.Jugador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    public Jugador crearJugador(int idJugador, String nombre, Carton carton) {
        Jugador jugador = new Jugador();
        jugador.setIdJugador(idJugador);
        jugador.setNombre(nombre);
        jugador.setCarton(carton);
        return jugador;
    }

    public void actualizarCarton(Jugador jugador, Carton nuevoCarton) {
        jugador.setCarton(nuevoCarton);
    }

    public Jugador buscarPorId(List<Jugador> jugadores, int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getIdJugador() == id) {
                return jugador;
            }
        }
        return null;
    }

    public Jugador buscarPorNombre(List<Jugador> jugadores, String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }
}
