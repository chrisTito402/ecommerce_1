package IPersistencia;

import entidades.Producto;
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
}
