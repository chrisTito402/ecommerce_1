package DAOs;

import IPersistencia.ICarritoDAO;
import IPersistencia.IFichaDetalladaProductoDAO;
import IPersistencia.IPedidosDAO;
import IPersistencia.IProductoDAO;
import entidades.*;

import IPersistencia.IReseniasDAO;
import IPersistencia.IUsuarioDAO;
import implementaciones.CarritoDAO;

import implementaciones.FichaDetalladaDAO;
import implementaciones.PedidosDAO;
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
    private final IPedidosDAO PEDIDOSDAO;
    private final ICarritoDAO CARRITODAO; // NUEVO ATRIBUTO

    public PersistenciaDAO() {
        //USUARIODAO = UsuarioMokitoDAO.getInstance();
        //PRODUCTODAO = ProductoMokitoDAO.getInstance();
        //RESENIASDAO = ReseniasDAO.getInstance();
        //FICHADETALLADADAO = FichaDetalladaProductoMokitoDAO.getInstance();

        PRODUCTODAO = new ProductoDAO();
        USUARIODAO = new UsuariosDAO();
        FICHADETALLADADAO = new FichaDetalladaDAO();
        RESENIASDAO = new ReseniasDAO();
        PEDIDOSDAO = new PedidosDAO();
        CARRITODAO = new CarritoDAO();
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
    public void agregarResenia(Resenia resenia) {
        RESENIASDAO.agregarResenia(resenia);
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

    @Override
    public List<Pedido> consultarPedidosPorUsuario(Long idUsuario) {
        return PEDIDOSDAO.consultarPedidosPorUsuario(idUsuario);
    }

    @Override
    public Pedido consultarPedido(Long idPedido) {
        return PEDIDOSDAO.consultarPedido(idPedido);
    }
    
    public Carrito1 guardarOActualizarCarrito(Carrito1 carrito) {
        return CARRITODAO.guardarOActualizarCarrito(carrito);
    }
    
    public Carrito1 consultarProductoEnCarrito(Long idUsuario, Long idProducto) {
        return CARRITODAO.consultarProductoEnCarrito(idUsuario, idProducto);
    }
}
