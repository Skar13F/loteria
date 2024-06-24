package mx.edu.unsis.loteria.service;

import mx.edu.unsis.loteria.model.Carta;
import org.springframework.stereotype.Service;

@Service
public class CartaService {

    public Carta crearCarta(String nombre, String rutaCarta, int idCarta) {
        return new Carta(idCarta, nombre, rutaCarta);
    }

    public void actualizarDatosCarta(Carta carta, String nuevoNombre, String nuevaRuta) {
        carta.setNombre(nuevoNombre);
        carta.setRutaCarta(nuevaRuta);
    }
}
