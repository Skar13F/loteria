package mx.edu.unsis.loteria.model;

import java.util.ArrayList;

public class Carton {

    private ArrayList<Carta> cartasEnCarton;
    private int[][] matrizMarcado;

    public ArrayList<Carta> getCartasEnCarton() {
        return cartasEnCarton;
    }

    public void setCartasEnCarton(ArrayList<Carta> cartasEnCarton) {
        this.cartasEnCarton = cartasEnCarton;
    }

    public int[][] getMatrizMarcado() {
        return matrizMarcado;
    }

    public void setMatrizMarcado(int[][] matrizMarcado) {
        this.matrizMarcado = matrizMarcado;
    }
}
