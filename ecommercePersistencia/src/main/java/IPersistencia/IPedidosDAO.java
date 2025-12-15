package IPersistencia;

import entidades.DetallesPedido;
import entidades.Pedido;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPedidosDAO {
    
    public Pedido crearPedido(Pedido pedido);
    
    public List<Pedido> consultarPedidosPorUsuario(Long idUsuario);
    
    public Pedido consultarPedido(Long idPedido);
    
    public List<DetallesPedido> cosultarDetallesPedidoPorPedido(Long idPedido);
    
}
