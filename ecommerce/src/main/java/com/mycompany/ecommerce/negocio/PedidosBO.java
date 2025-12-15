package com.mycompany.ecommerce.negocio;

import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.DetallesPedidosDTO;
import com.mycompany.ecommerce.dtos.PedidoDTO;
import com.mycompany.ecommerce.mappers.DetallesPedidoMapper;
import com.mycompany.ecommerce.mappers.PedidoMapper;
import com.mycompany.ecommerce.mappers.UsuarioMapper;
import entidades.DetallesPedido;
import entidades.Pedido;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class PedidosBO {
    
    private final IPersistencia persistencia;

    public PedidosBO(IPersistencia persistencia) {
        this.persistencia = persistencia;
    }
    
    public void crearPedido(PedidoDTO pedido) throws Exception {
        for (DetallesPedidosDTO detalles : pedido.getDetallesPedido()) {
            if (detalles.getProducto().getCantidad() <= 0) {
                throw new Exception("Error, cantidad fuera de rango.");
            }
        }
        
        
        Pedido p = new Pedido();
        p.setFechaPedido(LocalDateTime.now());
        UsuarioMapper usuarioMapper = new UsuarioMapper();
        p.setUsuario(usuarioMapper.toEntity(pedido.getUsuario()));
        p.setTotal(pedido.getTotal());
        List<DetallesPedido> detalles = pedido.getDetallesPedido().stream()
                .map(DetallesPedidoMapper::toEntity)
                .toList();
        
        detalles.forEach(e -> e.setPedido(p));
        p.setDetalles(detalles);
        p.setEstado("Pendiente");
        
        persistencia.crearPedido(p);
    }
    
    public List<PedidoDTO> consultarPedidosPorUsuario(Long idUsuario) {
        List<Pedido> pedidos = persistencia.consultarPedidosPorUsuario(idUsuario);
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            List<DetallesPedido> detalles = persistencia.cosultarDetallesPedidoPorPedido(pedido.getId());
            List<DetallesPedidosDTO> detallesDTO = detalles.stream()
                    .map(DetallesPedidoMapper::toDto)
                    .toList();
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setEstado(pedido.getEstado());
            pedidoDTO.setFecha(pedido.getFechaPedido().toString());
            pedidoDTO.setDetallesPedido(detallesDTO);
            pedidosDTO.add(pedidoDTO);
        }
        
        return pedidosDTO;
    }
}
