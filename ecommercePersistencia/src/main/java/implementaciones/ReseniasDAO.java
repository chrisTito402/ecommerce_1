/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Conexion.Conexion;
import IPersistencia.IReseniasDAO;
import entidades.Resenia;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author chris
 */
public class ReseniasDAO implements IReseniasDAO {

    @Override
    public void agregarResenia(Resenia resenia) {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(resenia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al agregar reseña: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Resenia> consultarResenias() {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery(
                    "SELECT r FROM Resenia r",
                    Resenia.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Resenia> consultarReseniasPorProducto(int idProducto) {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery(
                    "SELECT r FROM Resenia r WHERE r.producto.id = :idProd",
                    Resenia.class
            )
                    .setParameter("idProd", idProducto)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarResenia(int id) {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Resenia r = em.find(Resenia.class, id);
            if (r != null) {
                em.remove(r);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al eliminar reseña: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

}
