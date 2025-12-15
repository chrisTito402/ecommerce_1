package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.DetallesPedidosDTO;
import entidades.DetallesPedido;

/**
 *
 * @author daniel
 */
public class DetallesPedidoMapper {
    
    public static DetallesPedidosDTO toDto(DetallesPedido detalles) {
        DetallesPedidosDTO dto = new DetallesPedidosDTO();
        ProductoMapper pM = new ProductoMapper();
        dto.setProducto(pM.toDTO(detalles.getProducto()));
        dto.setCantidad(detalles.getCantidad());
        return dto;
    }
    
    public static DetallesPedido toEntity(DetallesPedidosDTO dto) {
        DetallesPedido detalles = new DetallesPedido();
        detalles.setCantidad(dto.getCantidad());
        ProductoMapper productoMapper = new ProductoMapper();
        detalles.setProducto(productoMapper.toEntity(dto.getProducto()));
        detalles.setPrecioUnitario(dto.getProducto().getPrecio());
        return detalles;
    }
}
