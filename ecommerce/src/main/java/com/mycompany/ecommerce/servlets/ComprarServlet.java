package com.mycompany.ecommerce.servlets;

import com.google.gson.Gson;
import entidades.Pedido;
import implementaciones.PedidosDAO; 
import IPersistencia.IPedidosDAO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/comprar")
public class ComprarServlet extends HttpServlet {
    
    private final IPedidosDAO pedidosDAO = new PedidosDAO();
    private final Gson gson = new Gson();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

        if (usuarioDTO == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(gson.toJson(new ErrorResponse("Debe iniciar sesión para realizar la compra.")));
            return;
        }

        try {
            Long idUsuario = usuarioDTO.getIdUsuario();
            
            Pedido pedido = pedidosDAO.realizarTransaccionCompra(idUsuario);
            
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(gson.toJson(new MensajeResponse("¡Compra realizada con éxito! Pedido #" + pedido.getId())));

        } catch (Exception e) {
            System.err.println("Error durante la compra: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            
            response.getWriter().write(gson.toJson(new ErrorResponse(e.getMessage())));
        }
    }

    private static class MensajeResponse {
        String mensaje;
        public MensajeResponse(String mensaje) { this.mensaje = mensaje; }
    }
    private static class ErrorResponse {
        String error;
        public ErrorResponse(String error) { this.error = error; }
    }
}