package com.mycompany.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


/**
 *
 * @author janot
 */
@WebServlet(name = "IniciarSesionAdminServlet", urlPatterns = {"/admin"})
public class IniciarSesionAdminServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("admin") != null){
            request.getRequestDispatcher("/panelAdministrador.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/inicioSesionAdmin.jsp").forward(request, response);
        }
             
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correoAdmin = "admin@gmail.com";
        String passwordAdmin = "admin";
        
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        if(correoAdmin.equals(correo) && passwordAdmin.equals(password)){
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("admin", correoAdmin);
            request.getRequestDispatcher("/panelAdministrador.jsp").forward(request, response);
            return;
        }
        else{
            request.getRequestDispatcher("/inicioSesionAdmin.jsp").forward(request, response);
            return;
        }
    }

    

}
