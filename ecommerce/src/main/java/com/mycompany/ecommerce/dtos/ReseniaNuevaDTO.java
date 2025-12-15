package com.mycompany.ecommerce.dtos;

/**
 *
 * @author daniel
 */
public class ReseniaNuevaDTO {
    
    private int idProducto;
    private int rating;
    private String comentario;

    public ReseniaNuevaDTO() {
    }

    public ReseniaNuevaDTO(int idProducto, int rating, String comentario) {
        this.idProducto = idProducto;
        this.rating = rating;
        this.comentario = comentario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "ReseniaNuevaDTO{" + "idProducto=" + idProducto + ", rating=" + rating + ", comentario=" + comentario + '}';
    }
    
}
