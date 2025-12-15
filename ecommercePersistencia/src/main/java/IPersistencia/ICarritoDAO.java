package IPersistencia;

import entidades.Carrito1;
import java.util.List;

public interface ICarritoDAO {
    

    Carrito1 consultarProductoEnCarrito(Long idUsuario, Long idProducto);
    
    public Carrito1 guardarOActualizarCarrito(Carrito1 carrito);
    
    Carrito1 agregarOActualizarProducto(Long idUsuario, Long idProducto, int cantidad);
    
    void eliminarProductoDeCarrito(Long idCarrito);
    
    List<Carrito1> consultarArticulosCarritoPorUsuario(Long idUsuario);
    
    Long contarArticulosCarrito(Long idUsuario);
}

