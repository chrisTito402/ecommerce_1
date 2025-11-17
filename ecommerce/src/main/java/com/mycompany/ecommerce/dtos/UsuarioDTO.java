package com.mycompany.ecommerce.dtos;

/**
 *
 * @author janot
 */
public class UsuarioDTO {
    private String correo;
    private String contraseña;

    public UsuarioDTO(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
}
