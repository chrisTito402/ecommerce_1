package implementaciones;

import Conexion.Conexion;
import IPersistencia.ICarritoDAO;
import entidades.Carrito1;
import entidades.Producto;
import entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class CarritoDAO implements ICarritoDAO {

    @Override
    public Carrito1 consultarProductoEnCarrito(Long idUsuario, Long idProducto) {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Carrito1> query = em.createQuery(
                    "SELECT c FROM Carrito1 c WHERE c.usuario.id = :uId AND c.producto.id = :pId", Carrito1.class);
            query.setParameter("uId", idUsuario);
            query.setParameter("pId", idProducto);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; 
        } finally {
            em.close();
        }
    }

    @Override
    public Carrito1 guardarOActualizarCarrito(Carrito1 carrito) {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Carrito1 carritoPersistido = em.merge(carrito);
            em.getTransaction().commit();
            return carritoPersistido;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al guardar/actualizar el carrito: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Carrito1 agregarOActualizarProducto(Long idUsuario, Long idProducto, int cantidad) {
        Carrito1 carritoExistente = consultarProductoEnCarrito(idUsuario, idProducto);

        if (carritoExistente != null) {
            int nuevaCantidad = carritoExistente.getCantidad() + cantidad;
            carritoExistente.setCantidad(nuevaCantidad);
            return guardarOActualizarCarrito(carritoExistente);
        } else {
            EntityManager em = Conexion.crearConexion();
            try {
                Usuario usuario = em.find(Usuario.class, idUsuario);
                Producto producto = em.find(Producto.class, idProducto);

                if (usuario == null || producto == null) {
                    throw new RuntimeException("Usuario o Producto no encontrado al intentar agregar al carrito.");
                }

                Carrito1 nuevoCarrito = new Carrito1();
                nuevoCarrito.setUsuario(usuario);
                nuevoCarrito.setProducto(producto);
                nuevoCarrito.setCantidad(cantidad);
                
                return guardarOActualizarCarrito(nuevoCarrito);

            } catch (Exception e) {
                 throw new RuntimeException("Error al crear la nueva línea de carrito: " + e.getMessage());
            } finally {
                em.close();
            }
        }
    }

    @Override
    public void eliminarProductoDeCarrito(Long idCarrito) {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            Carrito1 itemCarrito = em.find(Carrito1.class, idCarrito);

            if (itemCarrito != null) {
                em.remove(itemCarrito);
            } else {
                throw new NoResultException("No se encontró la línea de carrito con ID: " + idCarrito);
            }

            em.getTransaction().commit();
        } catch (NoResultException e) {
             if (em.getTransaction().isActive()) {
                 em.getTransaction().rollback();
             }
             throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al eliminar producto del carrito: " + e.getMessage());
            throw new RuntimeException("Error en la base de datos al eliminar el producto del carrito.", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Carrito1> consultarArticulosCarritoPorUsuario(Long idUsuario) {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Carrito1> query = em.createQuery(
                    "SELECT c FROM Carrito1 c WHERE c.usuario.id = :uId ORDER BY c.id", Carrito1.class);
            query.setParameter("uId", idUsuario);

            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error al consultar el carrito por usuario: " + e.getMessage());
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

    @Override
    public Long contarArticulosCarrito(Long idUsuario) { 
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT SUM(c.cantidad) FROM Carrito1 c WHERE c.usuario.id = :uId", Long.class);
            query.setParameter("uId", idUsuario);

            Long resultado = query.getSingleResult();
            return (resultado != null) ? resultado : 0L;
        } catch (Exception e) {
             return 0L;
        } finally {
            em.close();
        }
    }
}