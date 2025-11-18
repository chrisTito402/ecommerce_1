package DAOs;

import IPersistencia.IProductoDAO;
import entidades.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author janot
 */
public class ProductoMokitoDAO implements IProductoDAO {

    private static ProductoMokitoDAO instance = null;
    private List<Producto> listaProductos = new ArrayList<>();

    private ProductoMokitoDAO() {
        Producto producto1 = new Producto(1, "Por Que La Demora", "IMGS/imgsProductos/porqueLaDemora.jpg", 500.0, 4.5, Arrays.asList("trap", "regional mexicano", "Natanael Cano"));
        Producto producto2 = new Producto(2, "Debi Tirar Mas Fotos", "IMGS/imgsProductos/DebiTirarMasFotosAlbum.jfif", 750.0, 4.0, Arrays.asList("regueton", "colombia", "Bad Bunny"));
        Producto producto3 = new Producto(3, "Adison", "IMGS/imgsProductos/adisonAlbum.jpg", 350.0, 3.8, Arrays.asList("pop", "EUA", "Adison"));
        Producto producto4 = new Producto(4, "Let Go Letters", "IMGS/imgsProductos/letGoLettersAlbum.jfif", 850.0, 4.5, Arrays.asList("pop", "EUA", "Lupita"));
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);
    }

    public static ProductoMokitoDAO getInstance() {
        if (instance == null) {
            instance = new ProductoMokitoDAO();
        }
        return instance;
    }

    @Override
    public List<Producto> consultarProductos() {
        return listaProductos;
    }

    @Override
    public Producto consultarProductoPorId(int idProducto) {
        return listaProductos.stream()
                .filter(p -> p.getIdProducto() == idProducto)
                .findFirst()
                .orElse(null);
    }
}
