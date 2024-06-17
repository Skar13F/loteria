package mx.edu.unsis.loteria.model;

import java.util.ArrayList;

public class Juego {
    private String idJuego;
    private Cantador cantador;
    private ArrayList<Jugador> jugadores;
    
    public String getIdJuego() {
        return idJuego;
    }

    public Cantador getCantador() {
        return cantador;
    }

    public void setCantador(Cantador cantador) {
        this.cantador = cantador;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }
}
