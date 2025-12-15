package com.mycompany.ecommerce;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.EditarPerfilDTO;
import com.mycompany.ecommerce.dtos.IniciarSesionDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.filtros.AuthFilter;
import com.mycompany.ecommerce.negocio.AutenticacionBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(@Context HttpServletRequest request) {
        request.getSession().setAttribute(AuthFilter.SESSION_KEY_USUARIO, null);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UsuarioDTO postJson(IniciarSesionDTO usuarioRegistrado, @Context HttpServletRequest request) {
        UsuarioDTO usuarioDTO = autenticacionBO.iniciarSesion(
                usuarioRegistrado.getCorreo(),
                usuarioRegistrado.getContrasenia()
        );

        if (usuarioDTO != null) {
            request.getSession(true).setAttribute(AuthFilter.SESSION_KEY_USUARIO, usuarioDTO);
        }

        return usuarioDTO;
    }

    @PUT
    @Path("perfil")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editarPerfil(
            EditarPerfilDTO dto,
            @Context HttpServletRequest request) {

        UsuarioDTO usuarioSesion
                = (UsuarioDTO) request.getSession()
                        .getAttribute(AuthFilter.SESSION_KEY_USUARIO);

        if (usuarioSesion == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        UsuarioDTO actualizado = autenticacionBO.editarPerfil(
                usuarioSesion.getIdUsuario(), dto);

        request.getSession().setAttribute(
                AuthFilter.SESSION_KEY_USUARIO, actualizado);

        return Response.ok(actualizado).build();
    }
    
    @POST
    @Path("cerrarSesion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cerrarSesion(@Context HttpServletRequest request) {
        
        var sesion = request.getSession(false);

        if (sesion != null) {
            sesion.invalidate();
        }

        return Response.ok().build();
    }

}
