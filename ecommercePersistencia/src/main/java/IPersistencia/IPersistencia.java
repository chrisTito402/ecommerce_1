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

    public void registrarUsuario(Usuario usuario);

    
    public List<Producto> consultarProductos();


    List<Resenias> consultarResenias();

    void eliminarResenia(int id);

}
