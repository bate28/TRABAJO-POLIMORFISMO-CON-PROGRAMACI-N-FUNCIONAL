package cocina2.cocina2.Model;

import java.util.List;
import java.util.stream.Collectors;

public class Chef implements IDefinitiva{

    List<Plato> plato;
    String nombre;

    public Chef(List<Plato> plato) {
        this.plato = plato;
        this.nombre = "Chef";
    }

    public List<Plato> getPlato() {
        return plato;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String Hornear(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "No hay platos para hornear.";
        }
        String horneando = platos.stream()
                .map(plato -> "horneando: " + plato.getNombre())
                .collect(Collectors.joining(","));
        return "El chef esta " + horneando + " en el horno.";
    }

    @Override
    public String Preparar(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "No hay platos para preparar.";
        }
        String preparando = platos.stream()
                .map(plato -> "preparando: " + plato.getNombre())
                .collect(Collectors.joining(","));
        return "El chef esta " + preparando + " en el horno.";
    }

    @Override
    public String Servir(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "No hay platos para Servir.";
        }
        String sirviendo = platos.stream()
                .map(plato -> "sirviendo: " + plato.getNombre())
                .collect(Collectors.joining(","));
        return "El chef esta " + sirviendo + " en el horno.";
    }
}
