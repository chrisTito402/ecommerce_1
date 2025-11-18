/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.negocio.ReseniasBO;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author chris
 */
@WebServlet(name = "EliminarReseniaServlet", urlPatterns = {"/EliminarReseniaServlet"})
public class EliminarReseniaServlet extends HttpServlet {

    private ReseniasBO reseniasBO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        IPersistencia persistencia = new PersistenciaDAO();
        this.reseniasBO = new ReseniasBO(persistencia);
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
        int id = Integer.parseInt(request.getParameter("id"));

        reseniasBO.eliminarResenia(id);

        response.sendRedirect("resenias");
    }

}
