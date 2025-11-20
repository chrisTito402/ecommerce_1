/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.negocio.UsuarioBO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 *
 * @author janot
 */
@WebServlet(name = "GestionarUsuariosServlet", urlPatterns = {"/gestionarUsuarios"})
public class GestionarUsuariosServlet extends HttpServlet {
    private UsuarioBO usuarioBO;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        IPersistencia persistencia = new PersistenciaDAO();
        this.usuarioBO = new UsuarioBO(persistencia);
    }
    
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
            List<UsuarioDTO> listaUsuarios = usuarioBO.mostrarTodosLosUsuarios();
            request.setAttribute("usuarios", listaUsuarios);
            request.getRequestDispatcher("/gestionarUsuarios.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/inicioSesionAdmin.jsp").forward(request, response);
        }
    }

}
