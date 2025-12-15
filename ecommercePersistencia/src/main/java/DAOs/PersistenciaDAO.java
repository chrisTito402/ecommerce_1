package DAOs;

import IPersistencia.IFichaDetalladaProductoDAO;
import IPersistencia.IProductoDAO;
import entidades.*;

import IPersistencia.IReseniasDAO;
import IPersistencia.IUsuarioDAO;

import implementaciones.FichaDetalladaDAO;
import implementaciones.ProductoDAO;
import implementaciones.ReseniasDAO;
import implementaciones.UsuariosDAO;
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
        //USUARIODAO = UsuarioMokitoDAO.getInstance();
        //PRODUCTODAO = ProductoMokitoDAO.getInstance();
        //RESENIASDAO = ReseniasDAO.getInstance();
        //FICHADETALLADADAO = FichaDetalladaProductoMokitoDAO.getInstance();

        PRODUCTODAO = new ProductoDAO();
        USUARIODAO = new UsuariosDAO();
        FICHADETALLADADAO = new FichaDetalladaDAO();
        RESENIASDAO = new ReseniasDAO();
    }

    @Override
    public Usuario consultarUsuario(String correo) {
        return USUARIODAO.consultarUsuario(correo);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return USUARIODAO.registrarUsuario(usuario);
    }

    @Override
    public List<Producto> consultarProductos() {
        return PRODUCTODAO.consultarProductos();
    }

    @Override
    public List<Producto> consultarProductos(String nombre) {
        return PRODUCTODAO.consultarProductos(nombre);
    }
    
    @Override
    public List<Producto> consultarProductosPorCategoria(String categoria) {
        return PRODUCTODAO.consultarProductosPorCategoria(categoria);
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
    public Usuario editarUsuario(Usuario usuario) {
        return USUARIODAO.editarUsuario(usuario);
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
    public Resenia agregarResenia(Resenia resenia) {
        return RESENIASDAO.agregarResenia(resenia);
    }

    @Override
    public void eliminarProducto(int idProducto) {
        PRODUCTODAO.elimianarProducto(idProducto);
    }

    @Override
    public void crearProducto(Producto producto) {
        PRODUCTODAO.crearProducto(producto);
    }

    @Override
    public void editarProducto(Producto producto) {
        PRODUCTODAO.editarProducto(producto);
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return USUARIODAO.consultarUsuarioPorId(id);

    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        USUARIODAO.actualizarUsuario(usuario);
    }

}
