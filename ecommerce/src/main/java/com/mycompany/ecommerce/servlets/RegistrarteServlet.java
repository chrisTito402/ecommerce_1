package com.mycompany.ecommerce.servlets;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.negocio.AutenticacionBO;
import entidades.Carrito;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author janot
 */
@WebServlet(name = "RegistrarteServlet", urlPatterns = {"/registrarte"})
public class RegistrarteServlet extends HttpServlet {

    private AutenticacionBO autenticacionBO;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        IPersistencia persistencia = new PersistenciaDAO();
        this.autenticacionBO = new AutenticacionBO(persistencia);
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
        request.getRequestDispatcher("/registrarte.jsp").forward(request, response);
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
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        //Esto es por si se refresca la pagina por que faltaron datos vacios, no se borren los datos que ya estan llenados
        request.setAttribute("nombre", nombre);
        request.setAttribute("telefono", telefono);
        request.setAttribute("direccion", direccion);
        request.setAttribute("correo", correo);
        request.setAttribute("password", password);

        
        boolean esValido = validacionDatos(request);
        if(esValido){
            UsuarioDTO usuarioDTO = new UsuarioDTO(100,nombre, telefono, direccion, correo, password);
            autenticacionBO.registrarte(usuarioDTO);
            request.getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/registrarte.jsp").forward(request, response);
        }
        
    }

    private boolean validacionDatos(HttpServletRequest request) {
       boolean esValidado = true;

       String nombre = request.getParameter("nombre");
       String telefono = request.getParameter("telefono");
       String direccion = request.getParameter("direccion");
       String correo = request.getParameter("correo");
       String password = request.getParameter("password");

       if (nombre == null || nombre.trim().isEmpty()) {
           request.setAttribute("mensajeNombre", "*El nombre está vacío");
           esValidado = false;
       }
       if (telefono == null || telefono.trim().isEmpty()) {
           request.setAttribute("mensajeTelefono", "*El teléfono está vacío");
           esValidado = false;
       }
       if (direccion == null || direccion.trim().isEmpty()) {
           request.setAttribute("mensajeDireccion", "*La dirección está vacía");
           esValidado = false;
       }
       if (correo == null || correo.trim().isEmpty()) {
           request.setAttribute("mensajeCorreo", "*El correo está vacío");
           esValidado = false;
       }
       if (password == null || password.trim().isEmpty()) {
           request.setAttribute("mensajePassword", "*La contraseña está vacía");
           esValidado = false;
       }

       return esValidado;
   }

}

