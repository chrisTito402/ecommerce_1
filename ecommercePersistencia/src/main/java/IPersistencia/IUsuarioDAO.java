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
    
    public void registrarUsuario(Usuario usuario);
    
    public void editarUsuario(Usuario usuario);
    
}
