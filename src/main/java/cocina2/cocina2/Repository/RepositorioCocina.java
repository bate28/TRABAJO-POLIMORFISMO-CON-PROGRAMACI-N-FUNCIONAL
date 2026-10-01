package cocina2.cocina2.Repository;

import cocina2.cocina2.Model.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCocina {
    private final Plato ensalada = new Plato("Ensalada", 45, "01");
    private final Plato platano = new Plato("Platano", 50, "01");
    private final Plato frijoles = new Plato("Frijoles", 45, "01");
    private final Plato morrillo = new Plato("Morrillo", 45, "01");
    private final Plato cerdo = new Plato("Cerdo", 45, "01");
    private final Plato albondiga = new Plato("Albondigas", 45, "01");
    private final Plato brownie = new Plato("Brownie", 20, "01");
    private final Plato pollo = new Plato("Pollo", 50, "01");

    public List<IDefinitiva> getPlato() {
        List<IDefinitiva> platos = new ArrayList<>();

        // Chefs
        platos.add(new Chef(List.of()));                                              // 0 platos
        platos.add(new Chef(List.of(platano)));                                        // 1 plato
        platos.add(new Chef(List.of(ensalada, frijoles)));                               // 2 platos
        platos.add(new Chef(List.of(morrillo, ensalada, cerdo)));                   // 3 platos

        // Robots de cocina
        platos.add(new RobotCocina(List.of(albondiga, cerdo, morrillo, frijoles)));            // 4 platos
        platos.add(new RobotCocina(List.of(ensalada, frijoles, pollo, brownie, albondiga))); // 5 platos
        platos.add(new RobotCocina(List.of()));                                       // 0 platos
        platos.add(new RobotCocina(List.of(brownie)));                             // 1 plato

        // Novatos
        platos.add(new Novato(List.of(frijoles, platano)));                                 // 2 platos
        platos.add(new Novato(List.of(ensalada, pollo, brownie)));                  // 3 platos
        platos.add(new Novato(List.of(pollo, brownie, morrillo, cerdo)));             // 4 platos
        platos.add(new Novato(List.of(morrillo, platano, pollo, brownie, ensalada)));

        return platos;
    }
}
