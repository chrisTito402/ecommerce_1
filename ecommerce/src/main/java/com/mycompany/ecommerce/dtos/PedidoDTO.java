package com.mycompany.ecommerce.dtos;

import java.util.List;

/**
 *
 * @author daniel
 */
public class PedidoDTO {
    
    private List<DetallesPedidosDTO> detallesPedido;
    private String fecha;
    private String estado;
    private double total;
    private UsuarioDTO usuario;

    public PedidoDTO() {
    }

    public PedidoDTO(List<DetallesPedidosDTO> detallesPedido, String fecha, String estado) {
        this.detallesPedido = detallesPedido;
        this.fecha = fecha;
        this.estado = estado;
    }

    public List<DetallesPedidosDTO> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallesPedidosDTO> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "detallesPedido=" + detallesPedido + ", fecha=" + fecha + ", estado=" + estado + '}';
    }
    
}
