package IPersistencia;


import entidades.*;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IPersistencia {

    public Usuario consultarUsuario(String correo);
    
    public List<Usuario> consultarTodosLosUsuarios();

    public Usuario registrarUsuario(Usuario usuario);

    public Usuario editarUsuario(Usuario usuario);
    
    public List<Producto> consultarProductos();
    
    public List<Producto> consultarProductos(String nombre);
    
    public List<Producto> consultarProductosPorCategoria(String categoria);

    public List<Resenia> consultarReseniasDeProducto(int idProducto);
    
    public List<Resenia> consultarResenias();

    public void eliminarResenia(int id);
    
    public Producto consultarProducto(int idProducto);
    
    public FichaDetalladaProducto consultarFichaDetalladaDeProducto(int idProducto);
    
    public Resenia agregarResenia(Resenia resenia);
    
    public void eliminarProducto(int idProducto);
    
    public void crearProducto(Producto producto);
    
    public void editarProducto(Producto producto);
    
    public Usuario buscarUsuarioPorId(Long id);
    
    public void actualizarUsuario(Usuario usuario);
    
    public Pedido crearPedido(Pedido pedido);
    
    public List<Pedido> consultarPedidosPorUsuario(Long idUsuario);
    
    public Pedido consultarPedido(Long idPedido);
    
    public List<DetallesPedido> cosultarDetallesPedidoPorPedido(Long idPedido);
}
