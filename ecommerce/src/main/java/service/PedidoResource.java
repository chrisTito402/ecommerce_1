package com.mycompany.ecommerce.rest;

import implementaciones.PedidosDAO;
import IPersistencia.IPedidosDAO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import entidades.Pedido;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("pedidos")    
public class PedidoResource {
    
    private final IPedidosDAO pedidosDAO = new PedidosDAO();

    @POST
    @Path("comprar")    
    @Produces(MediaType.APPLICATION_JSON)
    public Response realizarCompra(@Context HttpServletRequest request) {
        
        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

        if (usuarioDTO == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                           .entity("{\"error\": \"Debe iniciar sesión para realizar la compra.\"}")
                           .build();
        }
        
        try {
            Pedido pedidoCreado = pedidosDAO.realizarTransaccionCompra(usuarioDTO.getIdUsuario());
            
            return Response.status(Response.Status.CREATED)
                           .entity("{\"mensaje\": \"Compra realizada con éxito. Pedido #" + pedidoCreado.getId() + "\"}")
                           .build();

        } catch (Exception e) {
            System.err.println("Error durante la compra: " + e.getMessage());
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("{\"error\": \"" + e.getMessage() + "\"}")
                           .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarHistorialPedidos(@Context HttpServletRequest request) {
        
        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

        if (usuarioDTO == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                           .entity("{\"error\": \"Debe iniciar sesión para ver sus pedidos.\"}")
                           .build();
        }
        
        try {
            List<Pedido> pedidos = pedidosDAO.consultarPedidosPorUsuario(usuarioDTO.getIdUsuario());
            
            return Response.ok(pedidos).build();

        } catch (Exception e) {
            System.err.println("Error al consultar historial: " + e.getMessage());
            return Response.serverError()
                           .entity("{\"error\": \"Error al consultar el historial de pedidos.\"}")
                           .build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarDetallePedido(@PathParam("id") Long idPedido, @Context HttpServletRequest request) { 
        
        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;
        
        if (usuarioDTO == null) {
             return Response.status(Response.Status.UNAUTHORIZED)
                           .entity("{\"error\": \"Debe iniciar sesión para ver los detalles de su pedido.\"}")
                           .build();
        }
        
        try {
            Pedido pedido = pedidosDAO.consultarPedido(idPedido);
            
            if (pedido == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("{\"error\": \"Pedido no encontrado.\"}")
                               .build();
            }
            
            if (!pedido.getUsuario().getId().equals(usuarioDTO.getIdUsuario())) {
                return Response.status(Response.Status.FORBIDDEN)
                               .entity("{\"error\": \"Acceso denegado. Este no es su pedido.\"}")
                               .build();
            }

            return Response.ok(pedido).build();

        } catch (Exception e) {
            System.err.println("Error al consultar detalle del pedido: " + e.getMessage());
            return Response.serverError()
                           .entity("{\"error\": \"Error al consultar detalle del pedido.\"}")
                           .build();
        }
    }
}