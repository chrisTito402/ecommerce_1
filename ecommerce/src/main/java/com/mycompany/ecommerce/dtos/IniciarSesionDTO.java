package com.mycompany.ecommerce.dtos;

/**
 *
 * @author daniel
 */
public class IniciarSesionDTO {
    
    private String correo;
    private String contrasenia;

    public IniciarSesionDTO() {
    }

    public IniciarSesionDTO(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "IniciarSesionDTO{" + "correo=" + correo + ", contrasenia=" + contrasenia + '}';
    }
    
}
