package implementaciones;

import conexion.Conexion;
import definiciones.IProductoDAO;
import entidades.Producto;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class ProductoDAO implements IProductoDAO {

    @Override
    public boolean registrarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar Producto");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> obtenerProductos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Producto P";
            TypedQuery query = em.createQuery(jpql, Producto.class);
            query.setMaxResults(5);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar la Lista de Productos");
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean actualizarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar Producto");
        } finally {
            em.close();
        }
    }
    
    @Override
    public Producto obtenerProducto(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT pi FROM Producto pi WHERE "
                    + "pi.nombre = :nombre";
            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
            query.setParameter("nombre", nombre);
            query.setMaxResults(1);
            List<Producto> producto = query.getResultList();
            
            if (producto.isEmpty()) {
                return null;
            } else {
                return producto.getFirst();
            }
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar Producto.");
        } finally {
            em.close();
        }
    }
    
    @Override
    public Producto obtenerProducto(Long id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Producto producto = em.find(Producto.class, id);
            return producto;
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar Producto.");
        } finally {
            em.close();
        }
    }
    
    
}
