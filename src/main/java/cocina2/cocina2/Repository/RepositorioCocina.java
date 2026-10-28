package cocina2.cocina2.Repository;

import cocina2.cocina2.Model.Categoria;
import cocina2.cocina2.Model.EnumPlato;
import cocina2.cocina2.Model.Menu;
import cocina2.cocina2.Model.Plato;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public class RepositorioCocina {

    private final Stack<Plato> pilaPlatos = new Stack<>();
    private final Menu menu;

    public RepositorioCocina() {
        Plato carne = new Plato("Churrasco", 32000.0, 30, EnumPlato.CARNE, Categoria.GRANDE);
        carne.Conteo(12);
        carne.Conteo(15);
        carne.Conteo(9);

        Plato pescado = new Plato("Tilapia", 30000.0, 25, EnumPlato.PESCADO, Categoria.MEDIANO);
        pescado.Conteo(20);
        pescado.Conteo(18);

        Plato frijoles = new Plato("Pezuña", 16000.0, 20, EnumPlato.SOPA, Categoria.MEDIANO);
        frijoles.Conteo(7);

        Plato postre = new Plato("Tiramisu", 15000.0, 10, EnumPlato.POSTRE, Categoria.PEQUENO);
        postre.Conteo(10);
        postre.Conteo(11);
        postre.Conteo(13);
        postre.Conteo(8);

        Plato pasta = new Plato("Pasta con albondigas", 25000.0, 35, EnumPlato.PASTA, Categoria.MEDIANO);

        pilaPlatos.push(postre);
        pilaPlatos.push(pescado);
        pilaPlatos.push(frijoles);
        pilaPlatos.push(carne);
        pilaPlatos.push(pasta);

        menu = new Menu("Menu del dia", "Lunes", EnumPlato.CARNE, Categoria.GRANDE);
        menu.agregarPlato(postre);
        menu.agregarPlato(pescado);
        menu.agregarPlato(frijoles);
        menu.agregarPlato(carne);
        menu.agregarPlato(pasta);
    }

    public Stack<Plato> getPilaPlatos() {
        return pilaPlatos;
    }

    public Menu getMenu() {
        return menu;
    }
}
