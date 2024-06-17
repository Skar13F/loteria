package mx.edu.unsis.loteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.unsis.loteria.service.JuegoService;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private JuegoService gameService;

    /*@PostMapping("/start")
    public ResponseEntity<Game> startGame(@RequestParam String roomId) {
        Game game = gameService.startGame(roomId);
        return ResponseEntity.ok(game);
    }
    
    @GetMapping("/status")
    public ResponseEntity<?> getGameStatus() {
        // Lógica para obtener el estado del juego
        return ResponseEntity.ok(/* Estado actual del juego );
    }*/
}

