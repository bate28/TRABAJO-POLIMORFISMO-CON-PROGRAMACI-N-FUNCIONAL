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

    @GetMapping("/cocineros")
    public String cocineros(Model model) {
        model.addAttribute("cocineros", repositorioCocina.getCocineros());
        return "cocineros";
    }

    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        String salida = repositorioCocina.getCocineros().stream()
                .map(IDefinitiva::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("salida", salida);
        return "punto1";
    }

    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        DoubleSummaryStatistics estadisticas = repositorioCocina.getCocineros().stream()
                .collect(Collectors.summarizingDouble(cocinero -> cocinero.getPlato().size()));

        model.addAttribute("conteo", estadisticas.getCount());
        model.addAttribute("sumatotal", estadisticas.getSum());
        model.addAttribute("promedio", estadisticas.getAverage());
        model.addAttribute("min", estadisticas.getMin());
        model.addAttribute("max", estadisticas.getMax());
        return "punto2";
    }

    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        List<Plato> todosLosPlatos = repositorioCocina.getCocineros().stream()
                .flatMap(cocinero -> cocinero.getPlato().stream())
                .toList();

        List<String> nombresPlatos = todosLosPlatos.stream()
                .map(Plato::getNombre)
                .toList();

        model.addAttribute("todosLosPlatos", todosLosPlatos);
        model.addAttribute("nombresPlatos", nombresPlatos);
        return "punto3";
    }

    @GetMapping("/peticion4")
    public String peticion4(Model model) {
        List<IDefinitiva> cocineros = repositorioCocina.getCocineros();

        Boolean sinPlatos = cocineros.stream()
                .anyMatch(cocinero -> cocinero.getPlato().isEmpty());

        Boolean masDeTres = cocineros.stream()
                .anyMatch(cocinero -> cocinero.getPlato().size() > 3);

        Boolean ningunoMasDe60 = cocineros.stream()
                .flatMap(cocinero -> cocinero.getPlato().stream())
                .noneMatch(plato -> plato.getTiempoMinutos() > 60);

        model.addAttribute("sinPlatos", sinPlatos);
        model.addAttribute("masDeTres", masDeTres);
        model.addAttribute("ningunoMasDe60", ningunoMasDe60);
        return "punto4";
    }

    @GetMapping("/peticion5")
    public String peticion5(Model model) {
        List<Plato> todosLosPlatos = repositorioCocina.getCocineros().stream()
                .flatMap(cocinero -> cocinero.getPlato().stream())
                .toList();

        Plato platoMasLargo = todosLosPlatos.stream()
                .max(Comparator.comparing(Plato::getTiempoMinutos))
                .orElse(null);

        model.addAttribute("todosLosPlatos", todosLosPlatos);
        model.addAttribute("platoMasLargo", platoMasLargo);
        return "punto5";
    }
}
