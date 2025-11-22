package IPersistencia;

import entidades.Producto;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IProductoDAO {
    public List<Producto> consultarProductos();
    
    public Producto consultarProducto(int idProducto);
    
    public void elimianarProducto(int idProducto);
    
    public void crearProducto(Producto producto);
    
    void editarProducto(Producto producto);
}
