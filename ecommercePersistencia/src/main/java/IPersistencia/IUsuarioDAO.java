package IPersistencia;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IUsuarioDAO {
    public Usuario consultarUsuario(String correo);
    
    public List<Usuario> consultarTodosLosUsuarios();
    
    public Usuario registrarUsuario(Usuario usuario);
    
    public Usuario editarUsuario(Usuario usuario);
    
}
