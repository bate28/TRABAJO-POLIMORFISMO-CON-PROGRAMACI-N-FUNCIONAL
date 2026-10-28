package cocina2.cocina2.Controller;

import cocina2.cocina2.Model.Categoria;
import cocina2.cocina2.Model.EnumPlato;
import cocina2.cocina2.Model.Menu;
import cocina2.cocina2.Model.Plato;
import cocina2.cocina2.Repository.RepositorioCocina;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.Predicate;

@Controller
public class Controlador {

    static Function<Plato, Integer> sumarConteo = plato -> plato.getConteo().stream()
            .mapToInt(Integer::intValue)
            .sum();

    static Predicate<Plato> esPlatoGrande = plato -> Categoria.GRANDE.equals(plato.getCategoria());

    private final RepositorioCocina repositorioCocina;

    public Controlador(RepositorioCocina repositorioCocina) {
        this.repositorioCocina = repositorioCocina;
    }

    @GetMapping("/punto1")
    public String punto1(Model model) {
        model.addAttribute("pilaPlatos", repositorioCocina.getPilaPlatos());
        model.addAttribute("menu", repositorioCocina.getMenu());
        return "punto1";
    }

    @GetMapping("/punto2")
    public String punto2(Model model) {
        Stack<Plato> pilaPlatos = repositorioCocina.getPilaPlatos();
        ListIterator<Plato> listIterator = pilaPlatos.listIterator();
        List<Plato> platosListIterator = new ArrayList<>();
        while (listIterator.hasNext()) {
            platosListIterator.add(listIterator.next());
        }

        Menu menu = repositorioCocina.getMenu();
        Iterator<Plato> iterator = menu.getPlatos().iterator();
        List<Plato> platosIterator = new ArrayList<>();
        while (iterator.hasNext()) {
            platosIterator.add(iterator.next());
        }

        model.addAttribute("platosListIterator", platosListIterator);
        model.addAttribute("platosIterator", platosIterator);
        model.addAttribute("menu", menu);
        return "punto2";
    }

    @GetMapping("/punto3")
    public String punto3(Model model) {
        Deque<Plato> deque = new ArrayDeque<>(repositorioCocina.getMenu().getPlatos());

        List<Plato> platosGrandes = deque.stream()
                .filter(esPlatoGrande)
                .toList();

        model.addAttribute("enumBuscado", Categoria.GRANDE);
        model.addAttribute("platosFuertes", platosGrandes);
        return "punto3";
    }

    @GetMapping("/punto4")
    public String punto4(Model model) {
        Map<Plato, Integer> sumas = new LinkedHashMap<>();
        for (Plato plato : repositorioCocina.getPilaPlatos()) {
            sumas.put(plato, sumarConteo.apply(plato));
        }

        model.addAttribute("sumas", sumas);
        return "punto4";
    }

    @GetMapping("/punto5")
    public String punto5(Model model) {
        Plato carne = repositorioCocina.getPilaPlatos().firstElement();
        String total = carne.verTotales(sumarConteo);

        model.addAttribute("total", total);
        return "punto5";
    }
}
