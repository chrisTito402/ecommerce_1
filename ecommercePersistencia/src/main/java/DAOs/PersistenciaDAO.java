package DAOs;

import IPersistencia.IProductoDAO;
import IPersistencia.IUsuarioDAO;
import entidades.Producto;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author janot
 */
public class PersistenciaDAO implements IPersistencia.IPersistencia{
    private final IUsuarioDAO USUARIODAO;
    private final IProductoDAO PRODUCTODAO;

    public PersistenciaDAO() {
        USUARIODAO = UsuarioMokitoDAO.getInstance();
        PRODUCTODAO = ProductoMokitoDAO.getInstance();
    }
    
    @Override
    public Usuario consultarUsuario(String correo) {
       return USUARIODAO.consultarUsuario(correo);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        USUARIODAO.registrarUsuario(usuario);
    }

    @Override
    public List<Producto> consultarProductos() {
        return PRODUCTODAO.consultarProductos();
    }
    
}
