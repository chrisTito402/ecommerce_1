package com.mycompany.ecommerce.dtos;

/**
 *
 * @author janot
 */
public class UsuarioDTO {

    private Long idUsuario;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private String contraseña;
    private Carrito carrito;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long idUsuario, String nombre, String telefono, String direccion, String correo, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contraseña = contraseña;
        this.carrito = new Carrito(); // <- INICIALÍZALO
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public void agregarProductoAlCarrito(ProductoDTO producto) {
        carrito.agregarProducto(producto);
    }
}
