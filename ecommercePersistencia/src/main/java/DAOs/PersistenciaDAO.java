package DAOs;

import IPersistencia.IUsuarioDAO;
import entidades.Usuario;

/**
 *
 * @author janot
 */
public class PersistenciaDAO implements IPersistencia.IPersistencia{
    private final IUsuarioDAO USUARIODAO;

    public PersistenciaDAO() {
        USUARIODAO = UsuarioMokitoDAO.getInstance();
    }
    
    @Override
    public Usuario consultarUsuario(String correo) {
       return USUARIODAO.consultarUsuario(correo);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        USUARIODAO.registrarUsuario(usuario);
    }
    
}
