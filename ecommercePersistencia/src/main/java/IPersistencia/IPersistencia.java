package IPersistencia;

import entidades.Usuario;

/**
 *
 * @author janot
 */
public interface IPersistencia {
    
    public Usuario consultarUsuario(String correo);
    
    public void registrarUsuario(Usuario usuario);
}
