package cocina2.cocina2.Model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Menu {

    private String nombre;
    private String dia;
    private EnumPlato tipo;
    private Categoria categoria;

    private Deque<Plato> platos = new ArrayDeque<>();

    public Menu() {
    }

    public Menu(String nombre, String dia, EnumPlato tipo, Categoria categoria) {
        this.nombre = nombre;
        this.dia = dia;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void agregarPlato(Plato plato) {
        platos.addLast(plato);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public Deque<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(Deque<Plato> platos) {
        this.platos = platos;
    }
}
