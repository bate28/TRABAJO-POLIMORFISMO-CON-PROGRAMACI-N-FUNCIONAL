package cocina2.cocina2.Model;

import java.util.List;

public interface IDefinitiva extends IPreparar, IHornear, IServir {

    String getNombre();

    List<Plato> getPlato();
}
