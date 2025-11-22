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
@WebServlet(name = "CrearProductoServlet", urlPatterns = {"/crearProducto"})
public class CrearProductoServlet extends HttpServlet {

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
            request.getRequestDispatcher("/crearProducto.jsp").forward(request, response);
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
        String nombre = request.getParameter("nombre");
        String rutaImg = request.getParameter("rutaImg");
        Double precio = Double.parseDouble(request.getParameter("precio"));

        // Convertir categorías separadas por coma a List<String>
        String catsRaw = request.getParameter("categorias");
        List<String> categorias = Arrays.asList(catsRaw.split(","));

        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(nombre);
        dto.setRutaImg(rutaImg);
        dto.setPrecio(precio);
        dto.setCategorias(categorias);
        dto.setEstrellas(0.0);
        
        productoBO.crearProducto(dto);

        response.sendRedirect("adminProductos");
    }

}
