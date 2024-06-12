package mx.edu.unsis.loteria.model;

import java.util.ArrayList;

public class Cantador {
    private ArrayList<Carta> cartasEnCantaro;
    private ArrayList<Carta> cartasSacadas;

    public ArrayList<Carta> getCartasEnCantaro() {
        return cartasEnCantaro;
    }

    public void setCartasEnCantaro(ArrayList<Carta> cartasEnCantaro) {
        this.cartasEnCantaro = cartasEnCantaro;
    }

    public ArrayList<Carta> getCartasSacadas() {
        return cartasSacadas;
    }

    public void setCartasSacadas(ArrayList<Carta> cartasSacadas) {
        this.cartasSacadas = cartasSacadas;
    }
    
}
