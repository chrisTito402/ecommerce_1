package prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import entidades.Usuario;

/**
 *
 * @author janot
 */
public class main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Daniel", "6441223344", "MiCasa", "correo@gmail.com", "1234");
        IPersistencia persistencia =  new PersistenciaDAO();
        //persistencia.registrarUsuario(usuario);
        
        usuario = persistencia.consultarUsuario("a@gmail.com");
        System.out.println(usuario);
    }
    
}
