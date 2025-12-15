package IPersistencia;

import entidades.Producto;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IProductoDAO {
    public List<Producto> consultarProductos();
    
    public List<Producto> consultarProductos(String nombre);
    
    public List<Producto> consultarProductosPorCategoria(String categoria);
    
    public Producto consultarProducto(long idProducto);
    
    public void elimianarProducto(long idProducto);
    
    public void crearProducto(Producto producto);
    
    void editarProducto(Producto producto);
}
