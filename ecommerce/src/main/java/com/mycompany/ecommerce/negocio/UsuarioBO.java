package com.mycompany.ecommerce.negocio;

import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.mappers.UsuarioMapper;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author janot
 */
public class UsuarioBO {
    private static final Logger LOGGER = Logger.getLogger(AutenticacionBO.class.getName());
    private final IPersistencia persistencia;
    
    public UsuarioBO(IPersistencia persistencia) {
        this.persistencia = persistencia;
    }
    
    public List<UsuarioDTO> mostrarTodosLosUsuarios(){
        List<Usuario> listaUsuario = persistencia.consultarTodosLosUsuarios();
        List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
        UsuarioMapper usuarioMapper = new UsuarioMapper();
        
        for (Usuario usuario : listaUsuario) {
            UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuario);
            listaUsuarioDTO.add(usuarioDTO);
        }
        return listaUsuarioDTO;
    }
    
    public void modificarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new UsuarioMapper().toEntity(usuarioDTO);
        persistencia.editarUsuario(usuario);
    }
}
