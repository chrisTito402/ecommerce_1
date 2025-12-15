package com.mycompany.ecommerce;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.PedidoDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.filtros.AuthFilter;
import com.mycompany.ecommerce.negocio.PedidosBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * REST Web Service
 *
 * @author daniel
 */
@Path("pedidos")
@RequestScoped
public class PedidosResource {

    private static final PedidosBO pedidosBO;
    
    static {
        IPersistencia persistencia = new PersistenciaDAO();
        pedidosBO = new PedidosBO(persistencia);
    }
    
    @Context
    private UriInfo context;

    public PedidosResource() {
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoDTO> getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(PedidoDTO pedido, @Context HttpServletRequest request) throws Exception {
        UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AuthFilter.SESSION_KEY_USUARIO);
        pedido.setUsuario(usuario);
        
        pedidosBO.crearPedido(pedido);
        usuario.getCarrito().obtenerCarrito().clear();
        usuario.getCarrito().setTotal(0);
    }

}
