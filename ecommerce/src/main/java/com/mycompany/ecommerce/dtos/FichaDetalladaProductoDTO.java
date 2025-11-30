package com.mycompany.ecommerce.dtos;

/**
 *
 * @author janot
 */
public class FichaDetalladaProductoDTO {
    private int idFichaDetalladaProducto;
    private ProductoDTO productoDTO;
    private int existencias;
    private String descripcion;

    public FichaDetalladaProductoDTO(int id, ProductoDTO productoDTO, int existencias, String descripcion) {
        this.idFichaDetalladaProducto = id;
        this.productoDTO = productoDTO;
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
