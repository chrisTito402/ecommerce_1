package entidades;

import java.util.List;

/**
 *
 * @author janot
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private String rutaImg;
    private Double precio;
    private Double estrellas;
    private List<String> categorias;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String rutaImg, Double precio, Double estrellas, List<String> categorias) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.rutaImg = rutaImg;
        this.precio = precio;
        this.estrellas = estrellas;
        this.categorias = categorias;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Double estrellas) {
        this.estrellas = estrellas;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
    
}
