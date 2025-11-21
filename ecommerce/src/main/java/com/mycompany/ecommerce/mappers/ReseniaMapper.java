package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.ReseniaDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import entidades.Producto;
import entidades.Resenia;
import entidades.Usuario;

/**
 *
 * @author janot
 */
public class ReseniaMapper {
    public ReseniaDTO toDTO(Resenia resenia){
        UsuarioMapper usuarioMapper = new UsuarioMapper();
        ProductoMapper productoMapper = new ProductoMapper();
        
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(resenia.getUsuario());
        ProductoDTO productoDTO = productoMapper.toDTO(resenia.getProducto());
        
        return new ReseniaDTO(0, usuarioDTO, productoDTO, resenia.getComentario(), resenia.getRating());
    }
    
    public Resenia toEntity(ReseniaDTO reseniaDTO){
        UsuarioMapper usuarioMapper = new UsuarioMapper();
        ProductoMapper productoMapper = new ProductoMapper();
        
        Usuario usuario = usuarioMapper.toEntity(reseniaDTO.getUsuarioDTO());
        Producto producto = productoMapper.toEntity(reseniaDTO.getProductoDTO());
        
        return new Resenia(0, usuario, producto, reseniaDTO.getComentario(), reseniaDTO.getRating());
    }
}
