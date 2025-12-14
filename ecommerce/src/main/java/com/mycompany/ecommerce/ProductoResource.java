package com.mycompany.ecommerce;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.negocio.ProductoBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * REST Web Service
 *
 * @author daniel
 */
@Path("producto")
@RequestScoped
public class ProductoResource {

    private static final ProductoBO productoBO;
    
    static {
        IPersistencia persistencia = new PersistenciaDAO();
        productoBO = new ProductoBO(persistencia);
    }
    
    @Context
    private UriInfo context;

    public ProductoResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoDTO> getJson() {
        List<ProductoDTO> productosDTO = productoBO.consultarProductos();
        return productosDTO;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
