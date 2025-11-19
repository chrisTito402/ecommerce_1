package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.negocio.ProductoBO;
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
@WebServlet(name = "CatalogoServlet", urlPatterns = {"/catalogo"})
public class CatalogoServlet extends HttpServlet {

    ProductoBO productoBO;
    
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
        List<ProductoDTO> listaProductosDTO = productoBO.consultarProductos();
        request.setAttribute("productos", listaProductosDTO);
        request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
    }
    
}
