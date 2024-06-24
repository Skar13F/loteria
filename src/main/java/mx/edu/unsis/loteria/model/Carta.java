package mx.edu.unsis.loteria.model;

public class Carta {

    private int idCarta;
    private String nombre;
    private String rutaCarta;

    public Carta(int idCarta, String nombre, String rutaCarta) {
        this.idCarta = idCarta;
        this.nombre = nombre;
        this.rutaCarta = rutaCarta;
    }


    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaCarta() {
        return rutaCarta;
    }

    public void setRutaCarta(String rutaCarta) {
        this.rutaCarta = rutaCarta;
    }

}
