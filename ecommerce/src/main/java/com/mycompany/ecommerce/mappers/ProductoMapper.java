package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.ProductoDTO;
import entidades.Producto;

/**
 *
 * @author janot
 */
public class ProductoMapper {
    public ProductoDTO toDTO(Producto producto){
        return new ProductoDTO(producto.getIdProducto(), producto.getNombre(), producto.getRutaImg(), producto.getPrecio(), producto.getEstrellas(), producto.getCategorias());
    }
    
    public Producto toEntity(ProductoDTO productoDTO){
        return new Producto(productoDTO.getIdProducto(), productoDTO.getNombre(), productoDTO.getRutaImg(), productoDTO.getPrecio(), productoDTO.getEstrellas(), productoDTO.getCategorias());
    }
}
