package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.ProductoDTO;
import entidades.Producto;

/**
 *
 * @author janot
 */
public class ProductoMapper {

    public ProductoDTO toDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        
        dto.setIdProducto(producto.getId().intValue());
        dto.setNombre(producto.getNombre());
        dto.setRutaImg(producto.getRutaImg());
        dto.setPrecio(producto.getPrecio());
        dto.setEstrellas(producto.getEstrellas());
        dto.setCategorias(producto.getCategorias());

        return dto;
    }

    public Producto toEntity(ProductoDTO dto) {
        Producto producto = new Producto();
        
        producto.setId((long) dto.getIdProducto());
        producto.setNombre(dto.getNombre());
        producto.setRutaImg(dto.getRutaImg());
        producto.setPrecio(dto.getPrecio());
        producto.setEstrellas(dto.getEstrellas());
        producto.setCategorias(dto.getCategorias());

        return producto;
    }
}
