package mx.edu.unsis.loteria.service;

import mx.edu.unsis.loteria.model.Loteria;
import mx.edu.unsis.loteria.model.Sala;

import java.util.Map;

public class LoteriaService {
    private final Loteria loteria;

    public LoteriaService() {
        this.loteria = Loteria.obtenerInstancia();
    }

    public void agregarSala(Sala sala) {
        loteria.agregarSala(sala);
    }

    public Sala obtenerSala(String id) {
        return loteria.obtenerSala(id);
    }

    public void eliminarSala(String id) {
        loteria.eliminarSala(id);
    }

    public Map<String, Sala> obtenerTodasLasSalas() {
        return loteria.obtenerTodasLasSalas();
    }
}
