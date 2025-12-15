package com.mycompany.ecommerce.dtos;

import java.time.LocalDateTime;

public class PedidoResumenDTO {
    
    private Long id;
    private LocalDateTime fechaPedido;
    private String estado;
    private Double total;
    
    public PedidoResumenDTO(Long id, LocalDateTime fechaPedido, String estado, Double total) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.total = total;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}