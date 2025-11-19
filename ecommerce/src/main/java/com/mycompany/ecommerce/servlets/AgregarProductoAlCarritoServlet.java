package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.filtros.AuthFilter;
import com.mycompany.ecommerce.mappers.ProductoMapper;
import com.mycompany.ecommerce.negocio.ProductoBO;
import entidades.Producto;
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
@WebServlet(name = "AgregarProductoAlCarritoServlet", urlPatterns = {"/agregarProducto"})
public class AgregarProductoAlCarritoServlet extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        
        if(session != null){
            if(request.getParameter("idProducto") != null){
                ProductoMapper productoMapper = new ProductoMapper();
                UsuarioDTO usuarioDTO = (UsuarioDTO) session.getAttribute(AuthFilter.SESSION_KEY);
                String id = request.getParameter("idProducto");
                ProductoDTO productoDTO = productoBO.consultarProducto(Integer.parseInt(id));
                Producto producto = productoMapper.toEntity(productoDTO);
                usuarioDTO.agregarProductoAlCarrito(producto);
                session.setAttribute(AuthFilter.SESSION_KEY, usuarioDTO);
            }
            
            
            request.getRequestDispatcher("/index").forward(request, response);
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
