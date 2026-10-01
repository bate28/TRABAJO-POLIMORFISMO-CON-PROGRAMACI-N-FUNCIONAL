package cocina2.cocina2.Model;

import java.util.List;
import java.util.stream.Collectors;

public class RobotCocina implements IDefinitiva {

    private List<Plato> plato;
    private final String nombre;

    public RobotCocina(List<Plato> plato) {
        this.plato = plato;
        this.nombre = "RobotCocina";
    }

    @Override
    public List<Plato> getPlato() {
        return plato;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String preparar(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "El robot de cocina no tiene platos para preparar.";
        }
        int tiempoTotal = platos.stream()
                .mapToInt(Plato::getTiempoMinutos)
                .sum();
        String preparando = platos.stream()
                .map(Plato::getNombre)
                .collect(Collectors.joining(" -> "));
        return "El robot de cocina ayuda al chef preparando: " + preparando
                + " (tiempo total " + tiempoTotal + " min).";
    }

    @Override
    public String hornear(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "El robot de cocina no tiene platos para hornear.";
        }
        String horneando = platos.stream()
                .map(Plato::getNombre)
                .collect(Collectors.joining(", "));
        return "El robot de cocina ayuda al chef horneando: " + horneando + " en el horno.";
    }

    @Override
    public String servir(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "El robot de cocina no tiene platos para servir.";
        }
        String sirviendo = platos.stream()
                .map(plato -> plato.getNombre() + " a la mesa " + plato.getMesa())
                .collect(Collectors.joining(", "));
        return "El robot de cocina ayuda al chef sirviendo: " + sirviendo + ".";
    }
}
