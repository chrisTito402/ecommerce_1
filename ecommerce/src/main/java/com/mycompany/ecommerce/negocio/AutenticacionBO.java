package com.mycompany.ecommerce.negocio;

import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.Carrito;
import com.mycompany.ecommerce.dtos.EditarPerfilDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.mappers.UsuarioMapper;
import entidades.Usuario;
import java.security.MessageDigest;
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

    public UsuarioDTO iniciarSesion(String correo, String contraseña) {
        try {
            Usuario usuario = this.persistencia.consultarUsuario(correo);

            if (usuario == null) {
                throw new IllegalStateException("El usuario no existe");
            }

            if (usuario.getContraseña().equals(this.hashPassword(contraseña))) {
                UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getTelefono(), usuario.getDireccion(), usuario.getCorreo(), usuario.getContraseña());
                usuarioDTO.setCarrito(new Carrito());
                return usuarioDTO;
            }

        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }

        return null;
    }

    public UsuarioDTO registrarte(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            throw new IllegalStateException("Los datos estan vacios");
        }

        UsuarioMapper usuarioMapper = new UsuarioMapper();
        Usuario usuarioNuevo = usuarioMapper.toEntity(usuarioDTO);

        Usuario usuario = persistencia.registrarUsuario(usuarioNuevo);
        return usuarioMapper.toDTO(usuario);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UsuarioDTO editarPerfil(Long idUsuario, EditarPerfilDTO dto) {

        Usuario usuario = persistencia.buscarUsuarioPorId(idUsuario);

        if (usuario == null) {
            throw new IllegalStateException("Usuario no encontrado");
        }

        if (dto.getNombre() != null && !dto.getNombre().isBlank()) {
            usuario.setNombre(dto.getNombre());
        }

        if (dto.getTelefono() != null && !dto.getTelefono().isBlank()) {
            usuario.setTelefono(dto.getTelefono());
        }

        if (dto.getDireccion() != null && !dto.getDireccion().isBlank()) {
            usuario.setDireccion(dto.getDireccion());
        }

        if (dto.getCorreo() != null && !dto.getCorreo().isBlank()) {
            usuario.setCorreo(dto.getCorreo());
        }

        if (dto.getContrasenia() != null && !dto.getContrasenia().isBlank()) {
            usuario.setContraseña(hashPassword(dto.getContrasenia()));
        }

        persistencia.actualizarUsuario(usuario);

        return new UsuarioMapper().toDTO(usuario);
    }

}
