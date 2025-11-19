package DAOs;

import IPersistencia.IProductoDAO;
import IPersistencia.IUsuarioDAO;
import entidades.Producto;

import IPersistencia.IReseniasDAO;
import IPersistencia.IUsuarioDAO;
import entidades.Resenias;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author janot
 */
public class PersistenciaDAO implements IPersistencia.IPersistencia {

    private final IUsuarioDAO USUARIODAO;
    private final IReseniasDAO RESENIASDAO;
    private final IProductoDAO PRODUCTODAO;

    public PersistenciaDAO() {
        USUARIODAO = UsuarioMokitoDAO.getInstance();
        PRODUCTODAO = ProductoMokitoDAO.getInstance();
        RESENIASDAO = ReseniasDAO.getInstance();

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

    @Override
    public List<Resenias> consultarResenias() {
        return RESENIASDAO.consultarResenias();
    }

    @Override
    public void eliminarResenia(int id) {
        RESENIASDAO.eliminarResenia(id);
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        USUARIODAO.editarUsuario(usuario);
    }

    @Override
    public Producto consultarProducto(int idProducto) {
        return PRODUCTODAO.consultarProducto(idProducto);
    }
}
