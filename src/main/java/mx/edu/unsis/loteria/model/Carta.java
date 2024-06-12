package mx.edu.unsis.loteria.model;

public class Carta {

    private int idCarta;
    private String nombre;
    private String rutaCarta;
    private int posX;
    private int posY;

    public Carta(int idCarta, String nombre, String rutaCarta, int posX, int posY) {
        this.idCarta = idCarta;
        this.nombre = nombre;
        this.rutaCarta = rutaCarta;
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
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
