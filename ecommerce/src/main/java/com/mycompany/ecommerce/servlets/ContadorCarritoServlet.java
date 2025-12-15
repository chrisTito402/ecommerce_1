/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce.servlets;

import com.google.gson.Gson;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import implementaciones.CarritoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eclipse.persistence.jpa.rs.exceptions.ErrorResponse;
import com.mycompany.ecommerce.respuestas.RespuestaAPI.ContadorResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ContadorCarritoServlet", urlPatterns = {"/api/carrito/contador"})
public class ContadorCarritoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorCarritoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContadorCarritoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        CarritoDAO carritoDAO = new CarritoDAO();
        long cantidad = 0; // Cantidad por defecto si no hay usuario o carrito

        try {
            HttpSession session = request.getSession(false);
            UsuarioDTO usuarioDTO = (session != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;
            
            if (usuarioDTO != null) {
                Long idUsuario = usuarioDTO.getIdUsuario();
                
                // Llama al método del DAO que implementaste
                cantidad = carritoDAO.contarArticulosCarrito(idUsuario);
            }

            // 200 OK: Enviamos la cantidad al frontend
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(gson.toJson(new ContadorResponse(cantidad)));

        } catch (Exception e) {
            // 500 Internal Server Error si hay un fallo de JPA/DB
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(gson.toJson(new com.mycompany.ecommerce.respuestas.RespuestaAPI.ErrorResponse("Error al consultar el contador.")));
            e.printStackTrace();
        }
    }



    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
