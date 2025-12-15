/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import IPersistencia.IProductoDAO;
import entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author chris
 */
public class ProductoDAO implements IProductoDAO {

    @Override
    public List<Producto> consultarProductos() {
        EntityManager em = Conexion.Conexion.crearConexion();
        List<Producto> productos = em
                .createQuery("SELECT p FROM Producto p", Producto.class)
                .getResultList();
        em.close();
        return productos;
    }
    
    @Override
    public List<Producto> consultarProductos(String nombre) {
        EntityManager em = Conexion.Conexion.crearConexion();
        String jpql = "SELECT p FROM Producto p "
                + "WHERE (:nombre IS NULL OR p.nombre LIKE CONCAT(:nombre, '%'))";
        TypedQuery query = em.createQuery(jpql, Producto.class);
        query.setParameter("nombre", nombre);

        return query.getResultList();
    }
    
    @Override
    public List<Producto> consultarProductosPorCategoria(String categoria) {
        EntityManager em = Conexion.Conexion.crearConexion();
        String jpql = "SELECT p FROM Producto p "
                + "JOIN p.categorias c "
                + "WHERE c = :categoria";
        TypedQuery query = em.createQuery(jpql, Producto.class);
        query.setParameter("categoria", categoria);

        return query.getResultList();
    }
    
    @Override
    public Producto consultarProducto(long idProducto) {
        EntityManager em = Conexion.Conexion.crearConexion();
        Producto producto = em.find(Producto.class, idProducto);
        em.close();
        return producto;
    }

    @Override
    public void elimianarProducto(long idProducto) {
        EntityManager em = Conexion.Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Producto producto = em.find(Producto.class, idProducto);
            if (producto != null) {
                em.remove(producto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al eliminar producto: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void crearProducto(Producto producto) {
        EntityManager em = Conexion.Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al crear producto: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void editarProducto(Producto producto) {
        EntityManager em = Conexion.Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al editar producto: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

}
