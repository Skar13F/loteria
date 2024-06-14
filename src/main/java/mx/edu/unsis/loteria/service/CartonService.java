package mx.edu.unsis.loteria.service;

import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.model.Carton;
import org.springframework.stereotype.Service;

@Service
public class CartonService {

    public Carton crearMatrizCarton(int[][] matrizMarcado) {
        Carton carton = new Carton();
        for (int i = 0; i < matrizMarcado.length; i++) {
            for (int j = 0; j < matrizMarcado[i].length; j++) {
                matrizMarcado[i][j] = 0;
            }
        }
        carton.setMatrizMarcado(matrizMarcado);
        return carton;
    }

    public void marcarCarta(Carton carton, int fila, int columna) {
        carton.getMatrizMarcado()[fila][columna] = 1;
    }

    public void desmarcarCarta(Carton carton, int fila, int columna) {
        carton.getMatrizMarcado()[fila][columna] = 0;
    }

    public boolean verificarMatrizLlena(Carton carton) {
        for (int[] fila : carton.getMatrizMarcado()) {
            for (int marcado : fila) {
                if (marcado == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void agregarCartaAlCarton(Carton carton, Carta carta) {
        carton.getCartasEnCarton().add(carta);
    }

    public int buscarPosicionCartaEnCarton(Carton carton, int idCarta) {
        for (int i = 0; i < carton.getCartasEnCarton().size(); i++) {
            if (carton.getCartasEnCarton().get(i).getIdCarta() == idCarta) {
                return i;
            }
        }
        return -1;
    }

    public int[] obtenerPosicionesXY(int idPosicion) {
        return new int[]{idPosicion / 4, idPosicion % 4};
    }
}
