package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.filtros.AuthFilter;
import com.mycompany.ecommerce.negocio.AutenticacionBO;
import jakarta.servlet.ServletConfig;
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
@WebServlet(name = "Autenticacion", urlPatterns = {"/autenticacion"})
public class AutenticacionServlet extends HttpServlet {

    private AutenticacionBO autenticacionBO;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        IPersistencia persistencia = new PersistenciaDAO();
        this.autenticacionBO = new AutenticacionBO(persistencia);
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
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        UsuarioDTO usuarioLogueado = this.autenticacionBO.iniciarSesion(correo, password);
        if(usuarioLogueado != null){
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute(AuthFilter.SESSION_KEY_USUARIO, usuarioLogueado);
            request.getRequestDispatcher("index").forward(request, response);
            return;
        }
        else{
            request.setAttribute("mensaje", "El usuario y/o contraseña son incorrectos");
                request.getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
            return;
        }
        
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
