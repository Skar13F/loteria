package mx.edu.unsis.loteria.model;

import java.util.ArrayList;

public class NumsRandom {

    public ArrayList<Integer> GenerarNumeros(int tamanio) {
        ArrayList<Integer> numeros=new ArrayList<>();
        while (numeros.size() < tamanio) {
            int nuevoNumero = (int) (Math.random() * 54 + 1);
            if (!numeros.contains(nuevoNumero)) {
                numeros.add(nuevoNumero);
            }
        }
        return numeros;
        
    }
}