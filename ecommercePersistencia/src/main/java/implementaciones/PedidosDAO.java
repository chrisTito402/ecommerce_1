package implementaciones;

import Conexion.Conexion;
import IPersistencia.IPedidosDAO;
import entidades.DetallesPedido;
import entidades.Pedido;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PedidosDAO implements IPedidosDAO {

    @Override
    public Pedido crearPedido(Pedido pedido) {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            return pedido;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al crear el pedido: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Pedido> consultarPedidosPorUsuario(Long idUsuario) {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Pedido p WHERE p.usuario.id = :idUsuario ORDER BY p.fechaPedido DESC";
            List<Pedido> pedidos = em.createQuery(jpql, Pedido.class)
                                     .setParameter("idUsuario", idUsuario)
                                     .getResultList();
            return pedidos;
        } catch (Exception ex) {
            throw new RuntimeException("Error al consultar pedidos del usuario: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    @Override
    public Pedido consultarPedido(Long idPedido) {
        EntityManager em = Conexion.crearConexion();
        try {
            Pedido pedido = em.find(Pedido.class, idPedido);
            
            return pedido;
        } catch (Exception ex) {
            throw new RuntimeException("Error al consultar el detalle del pedido: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    @Override
    public List<DetallesPedido> cosultarDetallesPedidoPorPedido(Long idPedido) {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT d FROM DetallesPedido d WHERE d.pedido.id = :idPedido";
            List<DetallesPedido> pedidos = em.createQuery(jpql, DetallesPedido.class)
                                     .setParameter("idPedido", idPedido)
                                     .getResultList();
            return pedidos;
        } catch (Exception ex) {
            throw new RuntimeException("Error al consultar los detalles pedidos: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

}