package com.mycompany.ecommerce.negocio;

import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import entidades.Usuario;
import java.util.logging.Logger;


/**
 *
 * @author janot
 */
public class AutenticacionBO {
    private static final Logger LOGGER = Logger.getLogger(AutenticacionBO.class.getName());
    private final IPersistencia persistencia;
    
    public AutenticacionBO(IPersistencia persistencia) {
        this.persistencia = persistencia;
    }
    
    public UsuarioDTO iniciarSesion(String correo, String contraseña){
        try {
            Usuario usuario = this.persistencia.consultarUsuario(correo);
            
            if(usuario == null){
                throw new IllegalStateException("El usuario no existe");
            }
            
            if(usuario.getContraseña().equals(contraseña)){
                return  new UsuarioDTO(usuario.getCorreo(), usuario.getContraseña());
            }
            
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }
        
        return null;
    }
    
}
