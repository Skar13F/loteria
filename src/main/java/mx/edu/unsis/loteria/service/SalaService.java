package mx.edu.unsis.loteria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.model.Sala;

@Service
public class SalaService {

    private final LoteriaService loteriaService;

    public SalaService() {
        this.loteriaService = new LoteriaService();
    }

    public List<Sala> obtenerSalas() {
        return new ArrayList<>(loteriaService.obtenerTodasLasSalas().values());
    }

    public Sala obtenerSalaPorId(String salaId) {
        return loteriaService.obtenerSala(salaId);
    }

    public Sala crearSala() {
        Sala sala = new Sala();
        sala.setId(UUID.randomUUID().toString());
        sala.setCantador(new CantadorService().getCantador());
        sala.setJugadores(new ArrayList<>());
        //inicializamos el cantador agregandole las cartas al cántaro
        sala.getCantador().setCartasEnCantaro(new GeneralMethods().agregarCartasCantaro());
        loteriaService.agregarSala(sala);
        return sala;
    }

    public Sala agregarJugadorSala(String salaId, Jugador jugador) {
        Sala sala = loteriaService.obtenerSala(salaId);
        if (sala != null) {
            sala.getJugadores().add(jugador);
            loteriaService.agregarSala(sala); // Actualiza la sala con el nuevo jugador
        }
        return sala;
    }
}
