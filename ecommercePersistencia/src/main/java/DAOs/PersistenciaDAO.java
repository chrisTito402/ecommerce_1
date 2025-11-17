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
        USUARIODAO = new UsuarioMokitoDAO();
    }
    
    @Override
    public Usuario consultarUsuario(String correo) {
       return USUARIODAO.consultarUsuario(correo);
    }
    
}
