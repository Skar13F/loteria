package mx.edu.unsis.loteria.controller;

import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carta")
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @PostMapping("/crear")
    public Carta crearCarta(@RequestBody Carta carta) {
        return cartaService.crearCarta(carta.getNombre(), carta.getRutaCarta(), carta.getIdCarta(), carta.getPosX(), carta.getPosY());
    }

    @PutMapping("/actualizar")
    public void actualizarDatosCarta(@RequestBody Carta carta) {
        cartaService.actualizarDatosCarta(carta, carta.getNombre(), carta.getRutaCarta());
    }
}
