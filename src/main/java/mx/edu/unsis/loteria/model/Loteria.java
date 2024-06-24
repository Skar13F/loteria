package mx.edu.unsis.loteria.model;

import java.util.HashMap;
import java.util.Map;

public class Loteria {
    // Instancia única de Loteria
    private static Loteria instancia;
    private Map<String, Sala> salas;

    // Constructor privado para evitar instanciación externa
    private Loteria() {
        this.salas = new HashMap<>();
    }

    // Método estático para obtener la instancia única
    public static synchronized Loteria obtenerInstancia() {
        if (instancia == null) {
            instancia = new Loteria();
        }
        return instancia;
    }

    // Método para agregar una sala
    public void agregarSala(Sala sala) {
        this.salas.put(sala.getId(), sala);
    }

    // Método para obtener una sala por ID
    public Sala obtenerSala(String id) {
        return this.salas.get(id);
    }

    // Método para eliminar una sala por ID
    public void eliminarSala(String id) {
        this.salas.remove(id);
    }

    // Método para obtener todas las salas
    public Map<String, Sala> obtenerTodasLasSalas() {
        return this.salas;
    }
}
