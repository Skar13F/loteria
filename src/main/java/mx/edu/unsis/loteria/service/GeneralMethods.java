package mx.edu.unsis.loteria.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mx.edu.unsis.loteria.model.Carta;
import mx.edu.unsis.loteria.model.Carton;
import mx.edu.unsis.loteria.model.Jugador;
import mx.edu.unsis.loteria.model.NumsRandom;

public class GeneralMethods {
    private static CartonService cartonService = new CartonService();
    private static CartaService cartaService = new CartaService();
    private static NumsRandom nr = new NumsRandom();

    // creamos un cartón con todas las imagenes que se cargará en la vista
    public Carton crearCartonImg() {
        // obtenemos un hash de todas las imagenes
        Map<Integer, String> cards = new HashMap<>();
        mapearImagenes(cards);
        int[][] matrizMarcado = new int[4][4];
        Carton carton = new Carton();

        carton.setCartasEnCarton(new ArrayList<>());

        cartonService.crearMatrizCarton(matrizMarcado);

        carton.setMatrizMarcado(matrizMarcado);
        ArrayList<Integer> idsCartas = nr.GenerarNumeros(16);


        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                int indice = fila * 4 + columna;
                if (indice < idsCartas.size()) {
                    Carta carta = cartaService.crearCarta(cards.get(indice),
                            "assets/img/" + idsCartas.get(indice) + ".jpg", idsCartas.get(indice));
                    cartonService.agregarCartaAlCarton(carton, carta);
                }
            }
        }
        return carton;
    }

    public ArrayList<Carta> agregarCartasCantaro() {
        ArrayList<Carta> cartasEnCantaro = new ArrayList<>();
        // obtenemos un hash de las cartas
        Map<Integer, String> cards = new HashMap<>();
        mapearImagenes(cards);
        // revolvemos las cartas
        ArrayList<Integer> idsCartas = nr.GenerarNumeros(cards.size());
        for (int i = 0; i < cards.size(); i++) {
            Carta carta = cartaService.crearCarta(cards.get(idsCartas.get(i)),
                    "assets/img/" + idsCartas.get(i) + ".jpg", idsCartas.get(i));
            cartasEnCantaro.add(carta);
        }
        return cartasEnCantaro;
    }

    private void mapearImagenes(Map<Integer, String> cards) {
        cards.put(1, "El Gallo");
        cards.put(2, "El Diablito");
        cards.put(3, "La Dama");
        cards.put(4, "El Catrín");
        cards.put(5, "El Paraguas");
        cards.put(6, "La Sirena");
        cards.put(7, "La Escalera");
        cards.put(8, "La Botella");
        cards.put(9, "El Barril");
        cards.put(10, "El Árbol");
        cards.put(11, "El Melón");
        cards.put(12, "El Valiente");
        cards.put(13, "El Gorrito");
        cards.put(14, "La Muerte");
        cards.put(15, "La Pera");
        cards.put(16, "La Bandera");
        cards.put(17, "El Bandolón");
        cards.put(18, "El Violoncello");
        cards.put(19, "La Garza");
        cards.put(20, "El Pájaro");
        cards.put(21, "La Mano");
        cards.put(22, "La Bota");
        cards.put(23, "La Luna");
        cards.put(24, "El Cotorro");
        cards.put(25, "El Borracho");
        cards.put(26, "El Negrito");
        cards.put(27, "El Corazón");
        cards.put(28, "La Sandía");
        cards.put(29, "El Tambor");
        cards.put(30, "El Camarón");
        cards.put(31, "Las Jaras");
        cards.put(32, "El Músico");
        cards.put(33, "La Araña");
        cards.put(34, "El Soldado");
        cards.put(35, "La Estrella");
        cards.put(36, "El Cazo");
        cards.put(37, "El Mundo");
        cards.put(38, "El Apache");
        cards.put(39, "El Nopal");
        cards.put(40, "El Alacrán");
        cards.put(41, "La Rosa");
        cards.put(42, "La Calavera");
        cards.put(43, "La Campana");
        cards.put(44, "El Cantarito");
        cards.put(45, "El Venado");
        cards.put(46, "El Sol");
        cards.put(47, "La Corona");
        cards.put(48, "La Chalupa");
        cards.put(49, "El Pino");
        cards.put(50, "El Pescado");
        cards.put(0, "La Palma");
    }

    // marcamos las cartas
    public void MarcarCartasJugadores(Jugador jugador, Carta cartaSacada) {

        Carton c = jugador.getCarton();
        int idPosicionCarta = cartonService.buscarPosicionCartaEnCarton(c, cartaSacada.getIdCarta());
        if (idPosicionCarta != (-1)) {
            int[] xy = cartonService.obtenerPosicionesXY(idPosicionCarta);
            cartonService.marcarCarta(c, xy[0], xy[1]);
        }

    }

    public void VerificarGanado(Jugador jugador) {

        Carton c = jugador.getCarton();
        if (cartonService.verificarMatrizLlena(c)) {
            jugador.setGanado(true);
        }
    }
}
