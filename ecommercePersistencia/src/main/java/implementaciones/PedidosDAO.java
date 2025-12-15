package implementaciones;

import Conexion.Conexion;
import IPersistencia.ICarritoDAO;
import IPersistencia.IPedidosDAO;
import entidades.Carrito1;
import entidades.DetallePedido;
import entidades.Pedido;
import entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.time.LocalDateTime;
import java.util.List;

public class PedidosDAO implements IPedidosDAO {
    
    private final ICarritoDAO carritoDAO = new CarritoDAO(); 

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
            
            if (pedido != null && pedido.getDetalles() != null) {
                pedido.getDetalles().size(); 
            }
            
            return pedido;
        } catch (Exception ex) {
            throw new RuntimeException("Error al consultar el detalle del pedido: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    @Override
    public Pedido realizarTransaccionCompra(Long idUsuario) throws Exception {
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();

        try {
            List<Carrito1> itemsCarrito = carritoDAO.consultarArticulosCarritoPorUsuario(idUsuario);

            if (itemsCarrito == null || itemsCarrito.isEmpty()) {
                throw new NoResultException("El carrito está vacío. No se puede realizar la compra.");
            }

            Usuario usuario = em.find(Usuario.class, idUsuario);
            if (usuario == null) {
                throw new Exception("Usuario no encontrado.");
            }
            
            double subtotal = itemsCarrito.stream()
                                         .mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad())
                                         .sum();
            double costoEnvio = 50.00;
            double totalFinal = subtotal + costoEnvio;

            Pedido pedido = new Pedido();
            pedido.setUsuario(usuario);
            pedido.setFechaPedido(LocalDateTime.now());
            pedido.setTotal(totalFinal);
            pedido.setEstado("En Proceso");
            pedido.setDireccionEnvio(usuario.getDireccion() != null ? usuario.getDireccion() : "Dirección no especificada");
            
            em.persist(pedido);

            for (Carrito1 item : itemsCarrito) {
                
                DetallePedido detalle = new DetallePedido();
                detalle.setPedido(pedido);
                detalle.setProducto(em.getReference(item.getProducto().getClass(), item.getProducto().getId()));
                detalle.setCantidad(item.getCantidad());
                detalle.setPrecioUnitario(item.getProducto().getPrecio());
                
                em.persist(detalle);

                em.remove(em.merge(item)); 
            }

            em.getTransaction().commit(); 
            return pedido;

        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
            throw new Exception("El carrito está vacío. Por favor, agregue productos.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
            throw new Exception("Fallo en la transacción de compra: " + e.getMessage(), e); 
        } finally {
            if (em != null && em.isOpen()) {
                 em.close();
            }
        }
    }
}