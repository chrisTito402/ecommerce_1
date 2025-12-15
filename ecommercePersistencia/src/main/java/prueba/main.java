package prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import entidades.DetallesPedido;
import entidades.Pedido;
import entidades.Producto;
import entidades.Usuario;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author janot
 */
public class main {
    public static void main(String[] args) {
        IPersistencia persistencia =  new PersistenciaDAO();
//        Producto producto = new Producto();
//        producto.setNombre("Ayer");
//        producto.setPrecio(100.00);
//        producto.setEstrellas(5.0);
//        List<String> categorias = Arrays.asList("Pop");
//        producto.setCategorias(categorias);
//        producto.setRutaImg("");
//        
//        persistencia.crearProducto(producto);
        
        Producto producto = persistencia.consultarProducto(1);
        Usuario usuario = persistencia.consultarUsuario("a@gmail.com");
        Pedido pedido = new Pedido(usuario, LocalDateTime.now(), "Pendiente", 100.00, null);
        DetallesPedido detalles = new DetallesPedido(pedido, producto, 1, 100.00);
        pedido.setDetalles(Arrays.asList(detalles));
        persistencia.crearPedido(pedido);
    }
}
