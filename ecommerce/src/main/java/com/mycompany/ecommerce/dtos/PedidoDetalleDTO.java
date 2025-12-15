package com.mycompany.ecommerce.dtos;

public class PedidoDetalleDTO {
    
    private String nombreProducto;
    private int cantidad;
    private Double precioUnitario;
    private String rutaImg; // Para la visualización en el frontend

    public PedidoDetalleDTO(String nombreProducto, int cantidad, Double precioUnitario, String rutaImg) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.rutaImg = rutaImg;
    }
    

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }
}