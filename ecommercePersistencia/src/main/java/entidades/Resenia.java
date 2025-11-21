package entidades;

/**
 *
 * @author chris
 */
public class Resenia {
    private int idResenia;
    private Usuario usuario;
    private Producto producto;
    private String comentario;
    private int rating;

    public Resenia() {
    }

    public Resenia(int idResenia, Usuario usuario, Producto producto, String comentario, int rating) {
        this.idResenia = idResenia;
        this.usuario = usuario;
        this.producto = producto;
        this.comentario = comentario;
        this.rating = rating;
    }

    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    

}
