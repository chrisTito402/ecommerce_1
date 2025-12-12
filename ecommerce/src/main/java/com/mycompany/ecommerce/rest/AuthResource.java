package com.mycompany.ecommerce.rest;

import entidades.Usuario;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.Map;

/**
 *
 * @author Ángel
 */
@Path("auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @PersistenceContext(unitName = "ecommerce")
    private EntityManager em;

    @Context
    private HttpServletRequest request;

    public static class LoginDTO {
        public String correo;
        public String password;
    }

    @POST
    @Path("login")
    public Response login(LoginDTO dto) {
        TypedQuery<Usuario> query = em.createQuery(
            "SELECT u FROM Usuario u WHERE u.correo = :correo",
            Usuario.class
        );
        query.setParameter("correo", dto.correo);

        Usuario usuario;
        try {
            usuario = query.getSingleResult();
        } catch (NoResultException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(Map.of("error", "Credenciales inválidas"))
                    .build();
        }

        if (!usuario.getContraseña().equals(dto.password)) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(Map.of("error", "Credenciales inválidas"))
                    .build();
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("usuarioId", usuario.getId());
        session.setAttribute("usuarioNombre", usuario.getNombre());

        return Response.ok(Map.of(
                "message", "Login exitoso",
                "nombre", usuario.getNombre()
        )).build();
    }

    @POST
    @Path("logout")
    public Response logout() {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
        return Response.ok(Map.of("message", "Sesión cerrada")).build();
    }
}
