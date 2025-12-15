package com.mycompany.ecommerce;

import com.mycompany.ecommerce.rest.CarritoResource;
import com.mycompany.ecommerce.rest.PedidoResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api") 
public class JakartaRestConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final HashSet<Class<?>> classes = new HashSet<>();
        
        classes.add(UsuarioResource.class);
        classes.add(ProductoResource.class);
        classes.add(CarritoResource.class); 
        classes.add(PedidoResource.class); 
        
        return classes;
    }
}
