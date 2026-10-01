package cocina2.cocina2.Model;

import java.util.List;
import java.util.stream.Collectors;

public class Novato implements IDefinitiva {

    private List<Plato> plato;
    private String nombre;

    public Novato(List<Plato> plato) {
        this.plato = plato;
        this.nombre = "Novato";
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
            return "El novato no tiene platos para preparar.";
        }

        String preparando = platos.stream()
                .map(plato -> plato.getNombre() + " (" + (plato.getTiempoMinutos() * 2) + " min)")
                .collect(Collectors.joining(", "));
        return "El novato mira al chef y prepara: " + preparando + ".";
    }

    @Override
    public String hornear(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "El novato no tiene platos para hornear.";
        }
        String horneando = platos.stream()
                .map(plato -> plato.getNombre())
                .collect(Collectors.joining(", "));
        return "El novato mira al chef hornear: " + horneando + ".";
    }

    @Override
    public String servir(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            return "El novato no tiene platos para servir.";
        }
        String sirviendo = platos.stream()
                .map(plato -> plato.getNombre() + " a la mesa " + plato.getMesa())
                .collect(Collectors.joining(", "));
        return "El novato sirve con cuidado " + platos.size() + " plato(s): " + sirviendo + ".";
    }
}
