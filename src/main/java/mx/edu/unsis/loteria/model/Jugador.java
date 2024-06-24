package mx.edu.unsis.loteria.model;

public class Jugador {

    private String idJugador;
    private String nombre;
    private Carton carton;
    private boolean ganado=false;
    

    public boolean isGanado() {
        return ganado;
    }

    public void setGanado(boolean ganado) {
        this.ganado = ganado;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carton getCarton() {
        return carton;
    }

    public void setCarton(Carton carton) {
        this.carton = carton;
    }

}
