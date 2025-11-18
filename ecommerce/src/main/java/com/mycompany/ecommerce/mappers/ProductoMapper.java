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
}
