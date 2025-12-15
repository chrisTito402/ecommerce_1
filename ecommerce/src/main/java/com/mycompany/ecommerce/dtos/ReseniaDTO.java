package com.mycompany.ecommerce.dtos;

/**
 *
 * @author janot
 */
public class ReseniaDTO {
 private int idResenia;
    private UsuarioDTO usuarioDTO;
    private ProductoDTO productoDTO;
    private String comentario;
    private int rating;

    public ReseniaDTO() {
    }

    public ReseniaDTO(int idResenia, UsuarioDTO usuarioDTO, ProductoDTO productoDTO, String comentario, int rating) {
        this.idResenia = idResenia;
        this.usuarioDTO = usuarioDTO;
        this.productoDTO = productoDTO;
        this.comentario = comentario;
        this.rating = rating;
    }

    public int getIdResenia() {
        return idResenia;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    public String getComentario() {
        return comentario;
    }

    public int getRating() {
        return rating;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ReseniaDTO{" + "idResenia=" + idResenia + ", usuarioDTO=" + usuarioDTO + ", productoDTO=" + productoDTO + ", comentario=" + comentario + ", rating=" + rating + '}';
    }
    
}
