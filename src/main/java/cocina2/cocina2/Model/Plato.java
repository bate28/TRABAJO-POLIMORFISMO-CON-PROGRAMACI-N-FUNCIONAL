package cocina2.cocina2.Model;

import java.util.Stack;
import java.util.function.Function;

public class Plato {

    private String nombre;
    private Double precio;
    private Integer tiempoPreparacion;
    private EnumPlato tipo;
    private Categoria categoria;

    private Stack<Integer> contar = new Stack<>();

    public Plato() {
    }

    public Plato(String nombre, Double precio, Integer tiempoPreparacion, EnumPlato tipo, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void Conteo(Integer porciones) {
        contar.push(porciones);
    }

    public String verTotales(Function<Plato, Integer> funcion) {
        Integer total = funcion.apply(this);
        return "El plato " + nombre + " tiene un total de " + total
                + " porciones cocinadas " + contar + ".";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public EnumPlato getTipo() {
        return tipo;
    }

    public void setTipo(EnumPlato tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Stack<Integer> getConteo() {
        return contar;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.contar = conteo;
    }

    @Override
    public String toString() {
        return nombre + " | $" + precio + " | " + tiempoPreparacion + " min | "
                + tipo + " | " + categoria + " | conteo " + contar;
    }
}
