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

    public List<Resenia> consultarReseniasDeProducto(int idProducto);
    
    public List<Resenia> consultarResenias();

    public void eliminarResenia(int id);
    
    public Producto consultarProducto(int idProducto);
    
    public FichaDetalladaProducto consultarFichaDetalladaDeProducto(int idProducto);
    
    public void agregarResenia(Resenia resenia);
    
    public void eliminarProducto(int idProducto);
    
    public void crearProducto(Producto producto);
    
    public void editarProducto(Producto producto);
}
