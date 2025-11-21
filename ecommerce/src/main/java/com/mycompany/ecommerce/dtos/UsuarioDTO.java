package com.mycompany.ecommerce.dtos;

import entidades.Carrito;
import entidades.Producto;

/**
 *
 * @author janot
 */
public class UsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private String contraseña;
    private Carrito carrito;

    public UsuarioDTO(int idUsuario, String nombre, String telefono, String direccion, String correo, String contraseña) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contraseña = contraseña;
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
    
    public void agregarProductoAlCarrito(Producto producto){
        carrito.agregarProducto(producto);
    }
}
