package com.mycompany.ecommerce.mappers;

import com.mycompany.ecommerce.dtos.FichaDetalladaProductoDTO;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import entidades.FichaDetalladaProducto;

/**
 *
 * @author janot
 */
public class FichaDetalladaMapper {
    
    public FichaDetalladaProductoDTO toDTO(FichaDetalladaProducto fichaDetalladaProducto){
        ProductoDTO productoDTO = new ProductoMapper().toDTO(fichaDetalladaProducto.getProducto());
        
        return new FichaDetalladaProductoDTO(fichaDetalladaProducto.getIdFichaDetalladaProducto(), 
                productoDTO, 
                fichaDetalladaProducto.getExistencias(),
                fichaDetalladaProducto.getDescripcion());
        
    }
}
