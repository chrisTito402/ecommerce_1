package IPersistencia;


import entidades.Producto;
import entidades.Resenias;
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


    public List<Resenias> consultarResenias();

    public void eliminarResenia(int id);
    
    public Producto consultarProducto(int idProducto);
    

}
