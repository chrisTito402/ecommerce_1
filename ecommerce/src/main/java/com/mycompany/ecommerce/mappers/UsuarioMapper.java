package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.UsuarioDTO;
import entidades.Usuario;

/**
 *
 * @author janot
 */
public class UsuarioMapper {
    public Usuario toEntity(UsuarioDTO usuarioDTO){
        return new Usuario(
                usuarioDTO.getIdUsuario(),
                usuarioDTO.getNombre(), 
                usuarioDTO.getTelefono(), 
                usuarioDTO.getDireccion(), 
                usuarioDTO.getCorreo(), 
                usuarioDTO.getContraseña());
    }
    
    public UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNombre(), 
                usuario.getTelefono(), 
                usuario.getDireccion(), 
                usuario.getCorreo(), 
                usuario.getContraseña());
        
        usuarioDTO.setCarrito(usuario.getCarrito());
        
        return usuarioDTO;
    }
    
}
