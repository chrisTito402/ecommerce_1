package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daniel
 */
public class Conexion {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    public static EntityManager crearConexion() {
        return emf.createEntityManager();
    }

    public static void cerrarConexion(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
    
    public static void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
