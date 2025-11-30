package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.FichaDetalladaProductoDTO;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import entidades.FichaDetalladaProducto;

/**
 *
 * @author janot
 */
public class FichaDetalladaMapper {

    public FichaDetalladaProductoDTO toDTO(FichaDetalladaProducto ficha) {
        if (ficha == null) {
            return null;
        }

        ProductoMapper productoMapper = new ProductoMapper();
        ProductoDTO productoDTO = productoMapper.toDTO(ficha.getProducto());

        return new FichaDetalladaProductoDTO(
                ficha.getId().intValue(),
                productoDTO,
                ficha.getExistencias(),
                ficha.getDescripcion()
        );
    }
}
