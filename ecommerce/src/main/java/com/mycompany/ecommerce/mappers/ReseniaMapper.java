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

    public ReseniaDTO toDTO(Resenia resenia) {
        UsuarioMapper usuarioMapper = new UsuarioMapper();
        ProductoMapper productoMapper = new ProductoMapper();

        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(resenia.getUsuario());
        ProductoDTO productoDTO = productoMapper.toDTO(resenia.getProducto());

        return new ReseniaDTO(
                resenia.getId().intValue(),
                usuarioDTO,
                productoDTO,
                resenia.getComentario(),
                resenia.getRating()
        );
    }

    public Resenia toEntity(ReseniaDTO dto) {
        UsuarioMapper usuarioMapper = new UsuarioMapper();
        ProductoMapper productoMapper = new ProductoMapper();

        Usuario usuario = usuarioMapper.toEntity(dto.getUsuarioDTO());
        Producto producto = productoMapper.toEntity(dto.getProductoDTO());

        Resenia entidad = new Resenia();
        entidad.setId((long)dto.getIdResenia());   
        entidad.setUsario(usuario);
        entidad.setProducto(producto);
        entidad.setComentario(dto.getComentario());
        entidad.setRating(dto.getRating());

        return entidad;
    }
}
