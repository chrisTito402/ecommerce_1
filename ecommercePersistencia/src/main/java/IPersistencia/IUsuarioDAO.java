package IPersistencia;

import entidades.Usuario;

/**
 *
 * @author janot
 */
public interface IUsuarioDAO {
    public Usuario consultarUsuario(String correo);
    
    public void registrarUsuario(Usuario usuario);
    
}
