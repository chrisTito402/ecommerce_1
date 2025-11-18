package com.mycompany.ecommerce.negocio;

import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.mappers.ProductoMapper;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author janot
 */
public class ProductoBO {
    private static final Logger LOGGER = Logger.getLogger(AutenticacionBO.class.getName());
    private final IPersistencia persistencia;
    
    public ProductoBO(IPersistencia persistencia) {
        this.persistencia = persistencia;
    }
    
    public List<ProductoDTO> consultarProductos(){
        ProductoMapper productoMapper = new ProductoMapper();
        List<Producto> listaProducto = persistencia.consultarProductos();
        List<ProductoDTO> listaProductoDTO = new ArrayList<>();
        for (Producto producto : listaProducto) {
            listaProductoDTO.add(productoMapper.toDTO(producto));
        }
        return listaProductoDTO;
    }
}
