package mx.edu.unsis.loteria.model;

import java.util.ArrayList;

public class Juego {
    private Cantador cantador;
    private ArrayList<Jugador> jugadores;

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
}
