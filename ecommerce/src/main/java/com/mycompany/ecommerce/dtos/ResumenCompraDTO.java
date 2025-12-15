package com.mycompany.ecommerce.dtos;

/**
 *
 * @author daniel
 */
public class ResumenCompraDTO {
    
    private double subTotal;
    private double total;

    public ResumenCompraDTO() {
    }

    public ResumenCompraDTO(double subTotal, double total) {
        this.subTotal = subTotal;
        this.total = total;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ResumenCompraDTO{" + "subTotal=" + subTotal + ", total=" + total + '}';
    }
    
}
