/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce.servlets;

import com.google.gson.Gson;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import entidades.Carrito1;
import entidades.Producto;
import entidades.Usuario;
import implementaciones.CarritoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author janot
 */
@WebServlet(name = "CarritoServlet", urlPatterns = {"/api/carrito", "/carrito"})
public class CarritoServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CarritoDAO carritoDAO = new CarritoDAO();
        HttpSession session = request.getSession(false);

        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

        if (usuarioDTO != null) {
            Long idUsuario = usuarioDTO.getIdUsuario();
            List<Carrito1> itemsCarrito = carritoDAO.consultarArticulosCarritoPorUsuario(idUsuario);

            request.setAttribute("itemsCarrito", itemsCarrito);

        }

        request.getRequestDispatcher("/carrito.jsp").forward(request, response);
    }

    private static class ProductoRequest {

        int idProducto;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        CarritoDAO carritoDAO = new CarritoDAO();

        try {
            String jsonRequest = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            ProductoRequest data = gson.fromJson(jsonRequest, ProductoRequest.class);

            Long idProducto = (long) data.idProducto;

            HttpSession session = request.getSession(false);

            UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

            if (usuarioDTO == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(gson.toJson(new ErrorResponse("Debe iniciar sesión para agregar productos.")));
                return;
            }

            Long idUsuario = usuarioDTO.getIdUsuario();

            Carrito1 carritoExistente = carritoDAO.consultarProductoEnCarrito(idUsuario, idProducto);

            boolean agregadoConExito = false;

            if (carritoExistente != null) {
                carritoExistente.setCantidad(carritoExistente.getCantidad() + 1);
                carritoDAO.guardarOActualizarCarrito(carritoExistente);
                agregadoConExito = true;

            } else {

                Producto productoRef = new Producto();
                productoRef.setId(idProducto);

                Usuario usuarioRef = new Usuario();
                usuarioRef.setId(idUsuario);

                Carrito1 nuevoCarrito = new Carrito1();
                nuevoCarrito.setUsuario(usuarioRef);
                nuevoCarrito.setProducto(productoRef);
                nuevoCarrito.setCantidad(1);

                carritoDAO.guardarOActualizarCarrito(nuevoCarrito);
                agregadoConExito = true;
            }

            if (agregadoConExito) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(gson.toJson(new SuccessResponse("Producto agregado/actualizado en el carrito con éxito.")));
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(new ErrorResponse("Error al procesar la solicitud del carrito.")));
            }

        } catch (RuntimeException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(gson.toJson(new ErrorResponse("Error interno del servidor (JPA/DB): " + e.getMessage())));
            e.printStackTrace();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(gson.toJson(new ErrorResponse("Error inesperado: " + e.getMessage())));
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        CarritoDAO carritoDAO = new CarritoDAO();

        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;

        if (usuarioDTO == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(gson.toJson(new ErrorResponse("Debe iniciar sesión para modificar el carrito.")));
            return;
        }

        try {
            String idCarritoParam = request.getParameter("idCarrito");

            if (idCarritoParam == null || idCarritoParam.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(new ErrorResponse("ID de carrito faltante o inválido.")));
                return;
            }

            Long idCarrito = Long.parseLong(idCarritoParam);

            carritoDAO.eliminarProductoDeCarrito(idCarrito);

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(gson.toJson(new MensajeResponse("Producto eliminado del carrito con éxito.")));

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(gson.toJson(new ErrorResponse("ID de carrito debe ser un número.")));
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(gson.toJson(new ErrorResponse("Error interno al eliminar el producto: " + e.getMessage())));
        }
    }

    private static class SuccessResponse {

        String mensaje;

        public SuccessResponse(String mensaje) {
            this.mensaje = mensaje;
        }
    }

    private static class ErrorResponse {

        String error;

        public ErrorResponse(String error) {
            this.error = error;
        }
    }

    private static class MensajeResponse {

        String mensaje;

        public MensajeResponse(String mensaje) {
            this.mensaje = mensaje;
        }
    }
}
