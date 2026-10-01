package cocina2.cocina2.Repository;

import cocina2.cocina2.Model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioCocina {

    private final Plato ensalada  = new Plato("Ensalada", 45, "01");
    private final Plato platano   = new Plato("Platano", 50, "02");
    private final Plato frijoles  = new Plato("Frijoles", 45, "03");
    private final Plato morrillo  = new Plato("Morrillo", 45, "01");
    private final Plato cerdo     = new Plato("Cerdo", 45, "04");
    private final Plato albondiga = new Plato("Albondigas", 45, "02");
    private final Plato brownie   = new Plato("Brownie", 20, "03");
    private final Plato pollo     = new Plato("Pollo", 60, "04");

    public List<IDefinitiva> getCocineros() {
        List<IDefinitiva> cocineros = new ArrayList<>();

        cocineros.add(new Chef(List.of()));
        cocineros.add(new Chef(List.of(platano)));
        cocineros.add(new Chef(List.of(ensalada, frijoles)));
        cocineros.add(new Chef(List.of(morrillo, ensalada, cerdo)));

        cocineros.add(new RobotCocina(List.of(albondiga, cerdo, morrillo, frijoles)));
        cocineros.add(new RobotCocina(List.of(ensalada, frijoles, pollo, brownie, albondiga)));
        cocineros.add(new RobotCocina(List.of()));
        cocineros.add(new RobotCocina(List.of(brownie)));

        cocineros.add(new Novato(List.of(frijoles, platano)));
        cocineros.add(new Novato(List.of(ensalada, pollo, brownie)));
        cocineros.add(new Novato(List.of(pollo, brownie, morrillo, cerdo)));
        cocineros.add(new Novato(List.of(morrillo, platano, pollo, brownie, ensalada)));

        return cocineros;
    }
}
