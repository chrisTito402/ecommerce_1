/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.FichaDetalladaProductoDTO;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.ReseniaDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.filtros.AuthFilter;
import com.mycompany.ecommerce.negocio.ProductoBO;
import com.mycompany.ecommerce.negocio.ReseniasBO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author janot
 */
@WebServlet(name = "PublicarComentarioServlet", urlPatterns = {"/publicarComentario"})
public class PublicarComentarioServlet extends HttpServlet {

    private ReseniasBO reseniaBO;
    private ProductoBO productoBO;
    private static int id = 30;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        IPersistencia persistencia = new PersistenciaDAO();
        this.reseniaBO = new ReseniasBO(persistencia);
        this.productoBO = new ProductoBO(persistencia);
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
        HttpSession session = request.getSession(false);
        
        if(session == null){
            request.getRequestDispatcher("/iniciarSesion").forward(request, response);
            return;
        }
        
        if(session.getAttribute(AuthFilter.SESSION_KEY_USUARIO) != null){
            UsuarioDTO usuarioDTO = (UsuarioDTO) session.getAttribute(AuthFilter.SESSION_KEY_USUARIO);
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            ProductoDTO productoDTO = productoBO.consultarProducto(idProducto);
            
            ReseniaDTO reseniaDTO = new ReseniaDTO(id , usuarioDTO, productoDTO, request.getParameter("comentario"), 0);
            id +=1;
            
            System.out.println(usuarioDTO.getNombre());
            System.out.println(reseniaDTO.getComentario());
            
            reseniaBO.agregarResenia(reseniaDTO);
            response.sendRedirect("detallesProducto?idProducto=" + productoDTO.getIdProducto());

        }
    }

}
