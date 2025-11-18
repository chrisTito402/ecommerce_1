package com.mycompany.ecommerce.dtos;

/**
 *
 * @author janot
 */
public class UsuarioDTO {
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private String contraseña;

    public UsuarioDTO(String nombre, String telefono, String direccion, String correo, String contraseña) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contraseña = contraseña;
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
}
