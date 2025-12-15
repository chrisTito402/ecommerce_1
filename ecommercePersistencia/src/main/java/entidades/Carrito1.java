package entidades;

import jakarta.persistence.*;

/**
 *
 * @author janot
 */
@Entity
@Table(name = "carrito")
@NamedQueries({
    @NamedQuery(
        name = "Carrito.findByUsuario",
        query = "SELECT c FROM Carrito c WHERE c.usuario.id = :id_usuario"
    )
})
public class Carrito1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private int cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

