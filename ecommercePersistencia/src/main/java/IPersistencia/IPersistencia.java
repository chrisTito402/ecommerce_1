package IPersistencia;


import entidades.FichaDetalladaProducto;
import entidades.Producto;
import entidades.Resenia;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IPersistencia {

    public Usuario consultarUsuario(String correo);
    
    public List<Usuario> consultarTodosLosUsuarios();

    public void registrarUsuario(Usuario usuario);

    public void editarUsuario(Usuario usuario);
    
    public List<Producto> consultarProductos();

    public List<Resenia> consultarReseniasDeProducto(int idProducto);
    
    public List<Resenia> consultarResenias();

    public void eliminarResenia(int id);
    
    public Producto consultarProducto(int idProducto);
    
    public FichaDetalladaProducto consultarFichaDetalladaDeProducto(int idProducto);
    
    public void agregarResenia(Resenia resenia);
    
}
