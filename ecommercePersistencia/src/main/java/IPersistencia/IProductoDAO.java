package IPersistencia;

import entidades.Producto;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IProductoDAO {
    public List<Producto> consultarProductos();
    
    public Producto consultarProducto(long idProducto);
    
    public void elimianarProducto(long idProducto);
    
    public void crearProducto(Producto producto);
    
    void editarProducto(Producto producto);
}
