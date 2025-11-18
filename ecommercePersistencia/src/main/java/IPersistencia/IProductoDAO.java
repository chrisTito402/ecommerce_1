package IPersistencia;

import entidades.Producto;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IProductoDAO {
    public List<Producto> consultarProductos();
}
