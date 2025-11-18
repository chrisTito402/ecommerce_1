package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.UsuarioDTO;
import entidades.Usuario;

/**
 *
 * @author janot
 */
public class UsuarioMapper {
    public Usuario toDTO(UsuarioDTO usuarioDTO){
        return new Usuario(
                usuarioDTO.getNombre(), 
                usuarioDTO.getTelefono(), 
                usuarioDTO.getDireccion(), 
                usuarioDTO.getCorreo(), 
                usuarioDTO.getContraseña());
    }
}
