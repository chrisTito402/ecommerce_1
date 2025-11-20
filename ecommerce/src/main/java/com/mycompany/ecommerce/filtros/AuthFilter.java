package com.mycompany.ecommerce.filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author janot
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    
    private static final boolean debug = true;
    public static final String SESSION_KEY_USUARIO = "usuario";
    private final List<String> PATH_PUBLICOS;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AuthFilter() {
        PATH_PUBLICOS = new LinkedList<>();
        PATH_PUBLICOS.add("autenticacion");
        PATH_PUBLICOS.add("iniciarSesion");
        PATH_PUBLICOS.add("registrarte");
        PATH_PUBLICOS.add("index");
        PATH_PUBLICOS.add("catalogo");
        PATH_PUBLICOS.add("admin");
        PATH_PUBLICOS.add("panelAdministrador");
        PATH_PUBLICOS.add("gestionarUsuarios");
        PATH_PUBLICOS.add("cerrarSesionAdmin");
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        
    }

    private String getPathSolicitado(HttpServletRequest request){
        String uriSolicitada = request.getRequestURI();
        String path = uriSolicitada.substring(request.getContextPath().length());
        
        return path;
    }
    
    private boolean isPathPublico(String path){
        // Archivos estáticos que NO deben pasar por el filtro
        if (path.endsWith(".css") ||
            path.endsWith(".js")  ||
            path.endsWith(".png") ||
            path.endsWith(".jpg") ||
            path.endsWith(".jpeg")||
            path.endsWith(".gif") ||
            path.endsWith(".ico")) {
            return true;
        }
        
        for(String pathPublico: PATH_PUBLICOS){
            if(path.startsWith("/" + pathPublico)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isUsuarioLogueado(HttpServletRequest request){
        HttpSession sesion = request.getSession(false);
        boolean estaLogueado = (sesion != null && sesion.getAttribute(SESSION_KEY_USUARIO) != null);
        return estaLogueado;
    }
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        if (debug) {
            log("AuthFilter:doFilter()");
        }
        
        doBeforeProcessing(request, response);
        
        Throwable problem = null;
        try {
            //Se obtiene la peticion del cliente
            HttpServletRequest requestOriginal = (HttpServletRequest) request;
            //Se obtiene el path que solicita el cliente
            String path = this.getPathSolicitado(requestOriginal);
            //Se verifica si la url es publica
            boolean isUrlPublica = this.isPathPublico(path);
            //Se verifica si el usuario esta logueado
            boolean isUsuarioLogueado = this.isUsuarioLogueado(requestOriginal);    
            //Si la url es publica y el usuario no esta logueado, se redireccionara a iniciarSesion.jsp
            if(!isUrlPublica && !isUsuarioLogueado){
                request.getRequestDispatcher("iniciarSesion").forward(request, response);
                return;
            }
            
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }
        
        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("AuthFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
