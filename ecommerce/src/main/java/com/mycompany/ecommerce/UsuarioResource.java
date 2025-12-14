package com.mycompany.ecommerce;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.IniciarSesionDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.negocio.AutenticacionBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author daniel
 */
@Path("usuario")
@RequestScoped
public class UsuarioResource {

    private static final AutenticacionBO autenticacionBO;
    
    static {
        IPersistencia persistencia = new PersistenciaDAO();
        autenticacionBO = new AutenticacionBO(persistencia);
    }
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UsuarioDTO postJson(IniciarSesionDTO usuarioRegistrado) {
        UsuarioDTO usuarioDTO = autenticacionBO.iniciarSesion(
                usuarioRegistrado.getCorreo(), 
                usuarioRegistrado.getContrasenia()
        );
        
        return usuarioDTO;
    }
    
}
