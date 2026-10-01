package cocina2.cocina2.Model;

public class Plato {

    private String nombre;
    private Integer tiempoMinutos;
    private String mesa;

    public Plato(String nombre, Integer tiempoMinutos, String mesa) {
        this.nombre = nombre;
        this.tiempoMinutos = tiempoMinutos;
        this.mesa = mesa;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTiempoMinutos() {
        return tiempoMinutos;
    }

    public String getMesa() {
        return mesa;
    }

    @Override
    public String toString() {
        return nombre + " (" + tiempoMinutos + " min, mesa " + mesa + ")";
    }
}
