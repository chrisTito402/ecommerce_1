package com.mycompany.ecommerce;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.ResumenCompraDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.filtros.AuthFilter;
import com.mycompany.ecommerce.negocio.ProductoBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.security.auth.message.config.AuthConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * REST Web Service
 *
 * @author daniel
 */
@Path("carrito1")
@RequestScoped
public class Carrito1Resource {
    
    private static final ProductoBO productoBO;
    
    static {
        IPersistencia persistencia = new PersistenciaDAO();
        productoBO = new ProductoBO(persistencia);
    }
    
    @Context
    private UriInfo context;

    public Carrito1Resource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoDTO> getJson(@Context HttpServletRequest request) {
        UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AuthFilter.SESSION_KEY_USUARIO);
        return usuario.getCarrito().obtenerCarrito();
    }
    
    @GET
    @Path("resumen")
    @Produces(MediaType.APPLICATION_JSON)
    public ResumenCompraDTO getResumenJson(@Context HttpServletRequest request) {
        UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AuthFilter.SESSION_KEY_USUARIO);
        ResumenCompraDTO resumenDTO = new ResumenCompraDTO(
                usuario.getCarrito().getTotal(), 
                usuario.getCarrito().getTotal() + 50
        );
        
        return resumenDTO;
    }
    
    @POST
    @Path("{idProducto}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(
            @PathParam("idProducto") int idProducto,
            @Context HttpServletRequest request) {
        UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute(AuthFilter.SESSION_KEY_USUARIO);
        
        ProductoDTO producto = productoBO.consultarProducto(idProducto);
        usuario.getCarrito().agregarProducto(producto);
    }
}
