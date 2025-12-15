package com.mycompany.ecommerce.prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.DetallesPedidosDTO;
import com.mycompany.ecommerce.dtos.FichaDetalladaProductoDTO;
import com.mycompany.ecommerce.dtos.PedidoDTO;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.ReseniaDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.negocio.AutenticacionBO;
import com.mycompany.ecommerce.negocio.FichaDetalladaProductoBO;
import com.mycompany.ecommerce.negocio.PedidosBO;
import com.mycompany.ecommerce.negocio.ProductoBO;
import com.mycompany.ecommerce.negocio.ReseniasBO;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author daniel
 */
public class pruebaBO {
    public static void main(String[] args) {
        IPersistencia persistencia = new PersistenciaDAO();
        ProductoDTO p = new ProductoDTO();
        p.setIdProducto(1);
        p.setPrecio(100.00);
        UsuarioDTO u = new UsuarioDTO();
        u.setIdUsuario(1L);
        DetallesPedidosDTO detalles = new DetallesPedidosDTO(p, 1);
        PedidoDTO pedido = new PedidoDTO();
        pedido.setDetallesPedido(Arrays.asList(detalles));
        pedido.getDetallesPedido().forEach(e -> e.setProducto(p));
        
        pedido.setUsuario(u);
        pedido.setTotal(100);
        
        PedidosBO bo = new PedidosBO(persistencia);
        //bo.crearPedido(pedido);
        
    }
}
