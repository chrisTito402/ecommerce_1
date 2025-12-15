package prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import entidades.FichaDetalladaProducto;
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
        FichaDetalladaProducto ficha = new FichaDetalladaProducto();
        ficha.setDescripcion("Es una canción de Luis Miguel");
        ficha.setExistencias(2);
        
    }
}
