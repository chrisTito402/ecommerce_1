package prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import entidades.Producto;
import entidades.Usuario;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author janot
 */
public class main {
    public static void main(String[] args) {
        IPersistencia persistencia =  new PersistenciaDAO();
        Producto producto = new Producto();
        producto.setNombre("Ayer");
        producto.setPrecio(100.00);
        producto.setEstrellas(5.0);
        List<String> categorias = Arrays.asList("Pop");
        producto.setCategorias(categorias);
        producto.setRutaImg("");
        
        persistencia.crearProducto(producto);
    }
}
