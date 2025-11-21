package com.mycompany.ecommerce.dtos;

/**
 *
 * @author janot
 */
public class FichaDetalladaProductoDTO {
    int idFichaDetalladaProducto;
    ProductoDTO productoDTO;
    int existencias;
    String descripcion;

    public FichaDetalladaProductoDTO(int idFichaDetalladaProducto, ProductoDTO producto, int existencias, String descripcion) {
        this.idFichaDetalladaProducto = idFichaDetalladaProducto;
        this.productoDTO = producto;
        this.existencias = existencias;
        this.descripcion = descripcion;
    }

    public int getIdFichaDetalladaProducto() {
        return idFichaDetalladaProducto;
    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    public int getExistencias() {
        return existencias;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
