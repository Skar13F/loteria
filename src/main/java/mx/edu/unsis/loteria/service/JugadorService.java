package mx.edu.unsis.loteria.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.model.Carton;
import mx.edu.unsis.loteria.model.Jugador;

@Service
public class JugadorService {
    private static GeneralMethods generalMethods = new GeneralMethods();


    public Jugador crearJugador(Jugador jugador){
        UUID uuid = UUID.randomUUID();

        Carton carton=generalMethods.crearCartonImg();

        jugador.setIdJugador(uuid.toString());
        jugador.setNombre(jugador.getNombre());
        jugador.setCarton(carton);

        return jugador;
    }

    public Jugador actualizarJugador(Jugador jugador,Carta carta) {
        generalMethods.MarcarCartasJugadores(jugador, carta);
        return jugador;
    }

    public Jugador buscarPorId(List<Jugador> jugadores, String id) {
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
