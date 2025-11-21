/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.FichaDetalladaProductoDTO;
import com.mycompany.ecommerce.dtos.ReseniaDTO;
import com.mycompany.ecommerce.negocio.FichaDetalladaProductoBO;
import com.mycompany.ecommerce.negocio.ReseniasBO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author janot
 */
@WebServlet(name = "DetallesProductoServlet", urlPatterns = {"/detallesProducto"})
public class DetallesProductoServlet extends HttpServlet {

    private ReseniasBO reseniaBO;
    private FichaDetalladaProductoBO fichaDetalladaBO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        IPersistencia persistencia = new PersistenciaDAO();
        this.reseniaBO = new ReseniasBO(persistencia);
        this.fichaDetalladaBO = new FichaDetalladaProductoBO(persistencia);
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
        
        if(request.getParameter("idProducto") != null){
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            FichaDetalladaProductoDTO fichaDetallada = fichaDetalladaBO.consultarFichaDetalladaProducto(idProducto);
            List<ReseniaDTO> listaReseniasDTO = reseniaBO.consultarReseniasPorProducto(idProducto);
            request.setAttribute("fichaDetallada", fichaDetallada);
            request.setAttribute("resenias", listaReseniasDTO);
            request.getRequestDispatcher("/detallesProducto.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/index").forward(request, response);
        }
    }

}
