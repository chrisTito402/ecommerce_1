package entidades;

/**
 *
 * @author janot
 */
public class Usuario {
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private String contraseña;

    public Usuario() {
    }
    
    public Usuario(String nombre, String telefono, String direccion, String correo, String contraseña) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contraseña = contraseña;
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

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }

    
}
