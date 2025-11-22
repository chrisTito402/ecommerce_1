/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.negocio.ProductoBO;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author chris
 */
@WebServlet(name = "EditarProductoServlet", urlPatterns = {"/editarProducto"})
public class EditarProductoServlet extends HttpServlet {

    private ProductoBO productoBO;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        IPersistencia persistencia = new PersistenciaDAO();
        this.productoBO = new ProductoBO(persistencia);
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
            //captura el parametro del id del producto que se selecciono
            int id = Integer.parseInt(request.getParameter("id"));
            //consultamos la BO para obtener el producto y almacenarlo
            ProductoDTO productoDTO = productoBO.consultarProducto(id);
            
            request.setAttribute("producto", productoDTO);
            request.getRequestDispatcher("/editarProducto.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("idProducto"));
        String nombre = request.getParameter("nombre");
        String rutaImg = request.getParameter("rutaImg");
        Double precio = Double.parseDouble(request.getParameter("precio"));
        String cats = request.getParameter("categorias");
        
        List<String> categorias = Arrays.asList(cats.split(","));
        
        ProductoDTO original = productoBO.consultarProducto(id);
        
        ProductoDTO dto = new ProductoDTO();
        dto.setIdProducto(id);
        dto.setNombre(nombre);
        dto.setRutaImg(rutaImg);
        dto.setPrecio(precio);
        dto.setCategorias(categorias);
        dto.setEstrellas(original.getEstrellas());
        
        productoBO.editarProducto(dto);
        
        response.sendRedirect("adminProductos");

    }

}
