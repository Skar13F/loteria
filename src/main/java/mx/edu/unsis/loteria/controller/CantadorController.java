package mx.edu.unsis.loteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.service.CantadorService;

@RestController
@RequestMapping("/cantador")
public class CantadorController {

    @Autowired
    private CantadorService cantadorService;

    @PostMapping("/agregarCarta")
    public void agregarCarta(@RequestBody Carta carta) {
        cantadorService.inicializarCartas(List.of(carta));
    }

    @MessageMapping("/sacarCarta")
    @SendTo("/topic/carta")
    public Carta sacarCarta() {
        return cantadorService.sacarCarta();
    }

    @PostMapping("/reiniciarCantaro")
    public void reiniciarCantaro() {
        cantadorService.reiniciarCantaro();
    }
}
