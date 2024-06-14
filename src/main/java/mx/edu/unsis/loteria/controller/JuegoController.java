package mx.edu.unsis.loteria.controller;

import mx.edu.unsis.loteria.model.Cantador;
import mx.edu.unsis.loteria.model.Juego;
import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/juego")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @PostMapping("/crear")
    public Juego crearJuego(@RequestBody Cantador cantador, @RequestBody ArrayList<Jugador> jugadores) {
        return juegoService.crearJuego(cantador, jugadores);
    }

    @PostMapping("/agregarJugador")
    public void agregarJugador(@RequestBody Juego juego, @RequestBody Jugador jugador) {
        juegoService.agregarJugador(juego, jugador);
    }

    @DeleteMapping("/eliminarJugador")
    public void eliminarJugador(@RequestBody Juego juego, @RequestBody Jugador jugador) {
        juegoService.eliminarJugador(juego, jugador);
    }

    @GetMapping("/cantidadJugadores")
    public int obtenerCantidadJugadores(@RequestBody Juego juego) {
        return juegoService.obtenerCantidadJugadores(juego);
    }

    @GetMapping("/estadoCantaro")
    public Cantador obtenerEstadoCantaro(@RequestBody Juego juego) {
        return juegoService.obtenerCantador(juego);
    }

    @GetMapping("/obtenerJugador/{id}")
    public Jugador obtenerJugadorId(@RequestBody Juego juego, @PathVariable int id) {
        return juegoService.obtenerJugadorPorId(juego, id);
    }
}
