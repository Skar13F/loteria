package mx.edu.unsis.loteria.controller;

import mx.edu.unsis.loteria.model.Carton;
import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @PostMapping("/crear")
    public Jugador crearJugador(@RequestBody Jugador jugador) {
        return jugadorService.crearJugador(jugador.getIdJugador(), jugador.getNombre(), jugador.getCarton());
    }

    @PutMapping("/actualizarCarton")
    public void actualizarCarton(@RequestBody Jugador jugador, @RequestBody Carton nuevoCarton) {
        jugadorService.actualizarCarton(jugador, nuevoCarton);
    }

    @GetMapping("/buscarPorId/{id}")
    public Jugador buscarPorId(@RequestBody List<Jugador> jugadores, @PathVariable int id) {
        return jugadorService.buscarPorId(jugadores, id);
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public Jugador buscarPorNombre(@RequestBody List<Jugador> jugadores, @PathVariable String nombre) {
        return jugadorService.buscarPorNombre(jugadores, nombre);
    }
}
