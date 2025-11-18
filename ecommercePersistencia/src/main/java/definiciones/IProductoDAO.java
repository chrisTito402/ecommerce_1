package definiciones;

import entidades.Producto;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IProductoDAO {
    public boolean registrarProducto(Producto producto) throws PersistenciaException;
    public List<Producto> obtenerProductos() throws PersistenciaException;
}
