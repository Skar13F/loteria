package mx.edu.unsis.loteria.controller;

import mx.edu.unsis.loteria.model.Carton;
import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.service.CartonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carton")
public class CartonController {

    @Autowired
    private CartonService cartonService;

    @PostMapping("/crear")
    public Carton crearMatrizCarton(@RequestBody int[][] matrizMarcado) {
        return cartonService.crearMatrizCarton(matrizMarcado);
    }

    @PutMapping("/marcarCarta")
    public void marcarCarta(@RequestBody Carton carton, @RequestParam int fila, @RequestParam int columna) {
        cartonService.marcarCarta(carton, fila, columna);
    }

    @PutMapping("/desmarcarCarta")
    public void desmarcarCarta(@RequestBody Carton carton, @RequestParam int fila, @RequestParam int columna) {
        cartonService.desmarcarCarta(carton, fila, columna);
    }

    @GetMapping("/verificarLlena")
    public boolean verificarMatrizLlena(@RequestBody Carton carton) {
        return cartonService.verificarMatrizLlena(carton);
    }

    @PostMapping("/agregarCarta")
    public void agregarCartaAlCarton(@RequestBody Carton carton, @RequestBody Carta carta) {
        cartonService.agregarCartaAlCarton(carton, carta);
    }

    @GetMapping("/buscarPosicion/{idCarta}")
    public int buscarPosicionCartaEnCarton(@RequestBody Carton carton, @PathVariable int idCarta) {
        return cartonService.buscarPosicionCartaEnCarton(carton, idCarta);
    }

    @GetMapping("/obtenerPosiciones/{idPosicion}")
    public int[] obtenerPosicionesXY(@PathVariable int idPosicion) {
        return cartonService.obtenerPosicionesXY(idPosicion);
    }
}
