package mx.edu.unsis.loteria.service;

import mx.edu.unsis.loteria.model.Carta;
import org.springframework.stereotype.Service;

@Service
public class CartaService {

    public Carta crearCarta(String nombre, String rutaCarta, int idCarta, int x, int y) {
        return new Carta(idCarta, nombre, rutaCarta, x, y);
    }

    public void actualizarDatosCarta(Carta carta, String nuevoNombre, String nuevaRuta) {
        carta.setNombre(nuevoNombre);
        carta.setRutaCarta(nuevaRuta);
    }
}
