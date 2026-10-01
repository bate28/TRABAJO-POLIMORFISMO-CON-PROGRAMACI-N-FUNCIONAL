package cocina2.cocina2.Model;

import java.util.List;

public interface IDefinitiva extends IHornear, IPreparar, IServir {
    String getNombre();

    List<Plato> getPlato();
}
