package itson.org.ecommercepersistencia;

import definiciones.IProductoDAO;
import entidades.FichaDetalladaProducto;
import entidades.Producto;
import excepciones.PersistenciaException;
import implementaciones.ProductoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class EcommercePersistencia {

    public static void main(String[] args) throws PersistenciaException {
        System.out.println("Hello World!");
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
//        EntityManager em = emf.createEntityManager();
//        
        Producto producto = new Producto("Pizza", 20.0, "comida");
        producto.setFicha(new FichaDetalladaProducto("a", 1, "ninguna", producto));
//        
//        em.getTransaction().begin();
//        em.persist(producto);
//        em.getTransaction().commit();
//        
//        
//        String jpql = "SELECT p FROM Producto P";
//        TypedQuery query = em.createQuery(jpql, Producto.class);
//        query.setMaxResults(5);
//        System.out.println(query.getResultList());
            
        IProductoDAO pD = new ProductoDAO();
        
//        pD.registrarProducto(producto);
        System.out.println(pD.obtenerProductos().getFirst().getFicha().getEspecificacionesTecnicas());
    }
}
