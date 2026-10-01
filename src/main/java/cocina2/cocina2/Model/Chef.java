package cocina2.cocina2.Model;

import java.util.List;
import java.util.stream.Collectors;

public class Chef implements IDefinitiva {

    private List<Plato> plato;
    private String nombre;

    public Chef(List<Plato> plato) {
        this.plato = plato;
        this.nombre = "Chef";
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
            return "El chef no tiene platos para preparar.";
        }
        String preparando = platos.stream()
                .map(plato -> plato.getNombre() + " (" + plato.getTiempoMinutos() + " min)")
                .collect(Collectors.joining(", "));
        return "El chef esta preparando: " + preparando + ".";
    }

    @Override
    public String hornear(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "El chef no tiene platos para hornear.";
        }
        String horneando = platos.stream()
                .map(plato -> plato.getNombre())
                .collect(Collectors.joining(", "));
        return "El chef esta horneando: " + horneando + " en el horno.";
    }

    @Override
    public String servir(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "El chef no tiene platos para servir.";
        }
        String sirviendo = platos.stream()
                .map(plato -> plato.getNombre() + " a la mesa " + plato.getMesa())
                .collect(Collectors.joining(", "));
        return "El chef esta sirviendo: " + sirviendo + ".";
    }
}
