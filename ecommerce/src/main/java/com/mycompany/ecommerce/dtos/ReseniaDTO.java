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
}
