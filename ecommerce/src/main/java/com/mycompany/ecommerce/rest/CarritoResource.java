package com.mycompany.ecommerce.rest;

import IPersistencia.ICarritoDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import implementaciones.CarritoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("carrito")
public class CarritoResource {

    private final ICarritoDAO carritoDAO = new CarritoDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarCarrito(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

        if (usuarioDTO == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"Debe iniciar sesión.\"}")
                    .build();
        }
        try {
            List items = carritoDAO.consultarArticulosCarritoPorUsuario(usuarioDTO.getIdUsuario());
            return Response.ok(items).build();
        } catch (Exception e) {
            System.err.println("Error al consultar carrito: " + e.getMessage());
            return Response.serverError()
                    .entity("{\"error\": \"Error interno al consultar: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @GET
    @Path("contador")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerContador(@Context HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

        if (usuarioDTO == null) {
            return Response.ok("{\"cantidad\": 0}").build();
        }

        try {
            Long cantidadTotal = carritoDAO.contarArticulosCarrito(usuarioDTO.getIdUsuario());

            return Response.ok("{\"cantidad\": " + cantidadTotal + "}").build();
        } catch (Exception e) {
            System.err.println("Error al obtener contador: " + e.getMessage());
            return Response.serverError().entity("{\"error\": \"Error interno al obtener contador.\"}").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarProducto(String jsonPayload, @Context HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

        if (usuarioDTO == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"Debe iniciar sesión para agregar productos.\"}")
                    .build();
        }

        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonPayload, JsonObject.class);

            long idProducto = jsonObject.get("idProducto").getAsLong();

            int cantidad = jsonObject.has("cantidad") ? jsonObject.get("cantidad").getAsInt() : 1;

            carritoDAO.agregarOActualizarProducto(usuarioDTO.getIdUsuario(), idProducto, cantidad);

            return Response.ok("{\"mensaje\": \"Producto añadido o actualizado con éxito\"}").build();

        } catch (Exception e) {
            System.err.println("Error al procesar solicitud POST /api/carrito: " + e.getMessage());

            if (e instanceof com.google.gson.JsonSyntaxException || e.getMessage().contains("idProducto")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\": \"Faltan datos de producto o JSON mal formado.\"}")
                        .build();
            }

            return Response.serverError()
                    .entity("{\"error\": \"Fallo al añadir producto: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarItem(@QueryParam("idCarrito") Long idCarrito) {
        if (idCarrito == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"ID de carrito faltante.\"}")
                    .build();
        }
        try {
            carritoDAO.eliminarProductoDeCarrito(idCarrito);
            return Response.ok("{\"mensaje\": \"Item eliminado con éxito\"}").build();
        } catch (Exception e) {
            System.err.println("Error al eliminar item: " + e.getMessage());
            return Response.serverError()
                    .entity("{\"error\": \"Error al eliminar: " + e.getMessage() + "\"}")
                    .build();
        }
    }
}
