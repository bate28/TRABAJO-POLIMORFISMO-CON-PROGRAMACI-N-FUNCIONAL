package cocina2.cocina2.Model;

public class Plato {
    String nombre;
    int tiempoMinutos;
    String mesa;

    public Plato(String nombre, int tiempoMinutos, String mesa) {
        this.nombre = nombre;
        this.tiempoMinutos = tiempoMinutos;
        this.mesa = mesa;
    }

    public String getMesa() {
        return mesa;
    }

    public String getNombre() {
        return nombre;
    }
}
