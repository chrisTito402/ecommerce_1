package itson.org.ecommercepersistencia;

import entidades.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daniel
 */
public class EcommercePersistencia {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        
        Producto producto = new Producto("Vinil");
        
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
        
    }
}
