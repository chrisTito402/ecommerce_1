package DAOs;

import IPersistencia.IFichaDetalladaProductoDAO;
import IPersistencia.IProductoDAO;
import entidades.Producto;

import IPersistencia.IReseniasDAO;
import IPersistencia.IUsuarioDAO;
import entidades.FichaDetalladaProducto;
import entidades.Resenia;

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
    private final IFichaDetalladaProductoDAO FICHADETALLADADAO;

    public PersistenciaDAO() {
        USUARIODAO = UsuarioMokitoDAO.getInstance();
        PRODUCTODAO = ProductoMokitoDAO.getInstance();
        RESENIASDAO = ReseniasDAO.getInstance();
        FICHADETALLADADAO = FichaDetalladaProductoMokitoDAO.getInstance();
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
    public List<Resenia> consultarResenias() {
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

    @Override
    public List<Usuario> consultarTodosLosUsuarios() {
        return USUARIODAO.consultarTodosLosUsuarios();
    }

    @Override
    public List<Resenia> consultarReseniasDeProducto(int idProducto) {
        return RESENIASDAO.consultarReseniasPorProducto(idProducto);
    }

    @Override
    public FichaDetalladaProducto consultarFichaDetalladaDeProducto(int idProducto) {
        return FICHADETALLADADAO.consultarFichaDetalladaDeProducto(idProducto);
    }

    @Override
    public void agregarResenia(Resenia resenia) {
        RESENIASDAO.agregarResenia(resenia);
    }
}
