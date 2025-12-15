package com.mycompany.ecommerce;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        // se añaden las clases Resource a la lista del
        // servidor para que se consideren y se puedan invocar
        final HashSet<Class<?>> classes = new HashSet<>();
        classes.add(UsuarioResource.class);
        classes.add(ProductoResource.class);
        return classes;
    }
}
