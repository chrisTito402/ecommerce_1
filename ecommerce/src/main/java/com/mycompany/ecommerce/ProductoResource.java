package com.mycompany.ecommerce;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.FichaDetalladaProductoDTO;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.ReseniaDTO;
import com.mycompany.ecommerce.negocio.FichaDetalladaProductoBO;
import com.mycompany.ecommerce.negocio.ProductoBO;
import com.mycompany.ecommerce.negocio.ReseniasBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.PathParam;
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
    private static final FichaDetalladaProductoBO fichaBO;
    private static final ReseniasBO reseniasBO;
    
    static {
        IPersistencia persistencia = new PersistenciaDAO();
        productoBO = new ProductoBO(persistencia);
        fichaBO = new FichaDetalladaProductoBO(persistencia);
        reseniasBO = new ReseniasBO(persistencia);
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
    
    @GET
    @Path("nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ProductoDTO> getNameJson(
            @PathParam("nombre") String nombre
    ) {
        List<ProductoDTO> productosDTO = productoBO.consultarProductos(nombre);
        return productosDTO;
    }
    
    @GET
    @Path("categoria/{categoria}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ProductoDTO> getCategoriaJson(
            @PathParam("categoria") String categoria
    ) {
        List<ProductoDTO> productosDTO = productoBO.consultarProductosPorCategoria(categoria);
        return productosDTO;
    }
    
    @GET
    @Path("fichaProducto/{idProducto}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FichaDetalladaProductoDTO getFichaDetalladaJson(
            @PathParam("idProducto") int idProducto
    ) {
        FichaDetalladaProductoDTO fichaDTO = fichaBO.consultarFichaDetalladaProducto(idProducto);
        return fichaDTO;
    }
    
    @GET
    @Path("resenias/{idProducto}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ReseniaDTO> getReseniasJson(
            @PathParam("idProducto") int idProducto
    ) {
        List<ReseniaDTO> reseniasDTO = reseniasBO.consultarReseniasPorProducto(idProducto);
        return reseniasDTO;
    }
    
}
