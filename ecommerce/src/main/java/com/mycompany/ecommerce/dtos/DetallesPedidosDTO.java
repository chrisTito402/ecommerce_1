package com.mycompany.ecommerce.dtos;

/**
 *
 * @author daniel
 */
public class DetallesPedidosDTO {
    
    private ProductoDTO producto;
    private int cantidad;

    public DetallesPedidosDTO() {
    }

    public DetallesPedidosDTO(ProductoDTO producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetallesPedidosDTO{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }
    
}
