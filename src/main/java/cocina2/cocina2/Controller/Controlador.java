package cocina2.cocina2.Controller;

import cocina2.cocina2.Model.IDefinitiva;
import cocina2.cocina2.Model.Plato;
import cocina2.cocina2.Repository.RepositorioCocina;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Controlador {

    private final RepositorioCocina repositorioCocina;

    public Controlador(RepositorioCocina repositorioCocina) {
        this.repositorioCocina = repositorioCocina;
    }

    // Punto 1: nombres de los 12 cocineros en una sola linea separados por coma
    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        String salida = repositorioCocina.getPlato().stream()
                .map(IDefinitiva::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("salida", salida);
        return "punto1";
    }

    // Punto 2: estadisticas del tamano de la lista de platos de los 12 cocineros
    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        DoubleSummaryStatistics estadisticas = repositorioCocina.getPlato().stream()
                .collect(Collectors.summarizingDouble(cocinero -> cocinero.getPlato().size()));

        model.addAttribute("conteo", estadisticas.getCount());
        model.addAttribute("sumatotal", estadisticas.getSum());
        model.addAttribute("promedio", estadisticas.getAverage());
        model.addAttribute("min", estadisticas.getMin());
        model.addAttribute("max", estadisticas.getMax());
        return "punto2";
    }

    // Punto 3: una lista con TODOS los platos de los 12 cocineros,
    // y de ella otra lista solo con el nombre (String) de cada plato
    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        List<Plato> todosLosPlatos = repositorioCocina.getPlato().stream()
                .flatMap(cocinero -> cocinero.getPlato().stream())
                .toList();

        List<String> nombresPlatos = todosLosPlatos.stream()
                .map(Plato::getNombre)
                .toList();

        model.addAttribute("todosLosPlatos", todosLosPlatos);
        model.addAttribute("nombresPlatos", nombresPlatos);
        return "punto3";
    }

//    // Punto 4: consultas con anyMatch() y noneMatch()
//    @GetMapping("/peticion4")
//    public String peticion4(Model model) {
//        List<IDefinitiva> cocineros = repositorioCocina.getPlato();
//
//        // Hay algun cocinero sin platos?
//        Boolean sinPlatos = cocineros.stream()
//                .anyMatch(cocinero -> cocinero.getPlato().isEmpty());
//
//        // Hay algun cocinero con mas de 3 platos?
//        Boolean masDeTres = cocineros.stream()
//                .anyMatch(cocinero -> cocinero.getPlato().size() > 3);
//
//        // Ningun plato (de todos los cocineros) tarda mas de 90 minutos?
//        Boolean ningunoMasDe90 = cocineros.stream()
//                .flatMap(cocinero -> cocinero.getPlato().stream())
//                .noneMatch(plato -> plato.getTiempoPreparacion() > 90);
//
//        model.addAttribute("sinPlatos", sinPlatos);
//        model.addAttribute("masDeTres", masDeTres);
//        model.addAttribute("ningunoMasDe90", ningunoMasDe90);
//        return "punto4";
//    }
//
//    // Punto 5: de la lista de todos los platos, el que tiene mayor tiempoPreparacion (Integer)
//    @GetMapping("/peticion5")
//    public String peticion5(Model model) {
//        List<Plato> todosLosPlatos = cocinaRepository.obtenerCocineros().stream()
//                .flatMap(cocinero -> cocinero.getPlatos().stream())
//                .toList();
//
//        Plato platoMasLargo = todosLosPlatos.stream()
//                .max(Comparator.comparing(Plato::getTiempoPreparacion))
//                .orElse(null);
//
//        model.addAttribute("todosLosPlatos", todosLosPlatos);
//        model.addAttribute("platoMasLargo", platoMasLargo);
//        return "punto5";
//    }
}
