package cocina2.cocina2.Model;

import java.util.List;

public interface IHornear extends IPreparar {
    String hornear(List<Plato> platos);
}
