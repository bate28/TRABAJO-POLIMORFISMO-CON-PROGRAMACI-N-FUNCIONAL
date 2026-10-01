package cocina2.cocina2.Model;

import java.util.List;
import java.util.stream.Collectors;

public class RobotCocina implements IDefinitiva{

    List<Plato> plato;
    String nombre;

    public RobotCocina (List<Plato> plato) {
        this.plato = plato;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Plato> getPlato() {
        return plato;
    }

    @Override
    public String Hornear(List<Plato> platos) {
        if(platos == null || platos.isEmpty()){
            return "No hay platos para hornear.";
        }
        String horneando = platos.stream()
                .map(plato -> "horneando: " + plato.getNombre())
                .collect(Collectors.joining(","));
        return "El robot de cocina ayuda al chef " + horneando + " el plato en el horno.";
    }
    @Override
    public String Preparar(List<Plato> platos) {
        if(platos == null || platos.isEmpty()){
            return "No hay platos para preparar.";
        }
        String preparando = platos.stream()
                .map(plato -> "preparando: " + plato.getNombre())
                .collect(Collectors.joining(","));
        return "El novato ayuda al chef " + preparando + " en el plato.";
    }
    @Override
    public String Servir(List<Plato> platos) {
        if(platos == null || platos.isEmpty()){
            return "No hay platos para servir.";
        }
        String sirviendo = platos.stream()
                .map(plato -> "sirviendo: " + plato.getNombre())
                .collect(Collectors.joining(","));
        return "El novato ayuda al chef " + sirviendo + " en el plato.";
    }
}
