package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.UsuarioDTO;
import entidades.Usuario;

/**
 *
 * @author janot
 */
public class UsuarioMapper {

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();

        dto.setIdUsuario(usuario.getId().intValue());
        dto.setNombre(usuario.getNombre());
        dto.setTelefono(usuario.getTelefono());
        dto.setDireccion(usuario.getDireccion());
        dto.setCorreo(usuario.getCorreo());
        dto.setContraseña(usuario.getContraseña());

        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setId((long) dto.getIdUsuario());
        usuario.setNombre(dto.getNombre());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDireccion(dto.getDireccion());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContraseña(dto.getContraseña());

        return usuario;
    }

}
