package DAOs;

import IPersistencia.IUsuarioDAO;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janot
 */
public class UsuarioMokitoDAO implements IUsuarioDAO{
    private static UsuarioMokitoDAO instance = null;
    private List<Usuario> listaUsuarios = new ArrayList<>();
    

    private UsuarioMokitoDAO() {
        Usuario usuario1 = new Usuario("Hector Valenzuela Ruiz", "6442484832", "Calle chalito 2023", "hecVal75@gmail.com", "eskeler");
        Usuario usuario2 = new Usuario("Luisa Lopez Murillo","6442839210","Calle Marcelin 1023", "luisalomu32@gmail.com","juniorh");
        Usuario usuario3 = new Usuario("Romina Castillo Gonzalez", "6441029320", "Calle Tupu 4563", "romiGal9430@gmail.com", "teito123");
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
    }
    
    public static UsuarioMokitoDAO getInstance(){
        if(instance == null){
            instance = new UsuarioMokitoDAO();
        }
        return instance;
    }

    @Override
    public Usuario consultarUsuario(String correo) {
        Usuario user = null;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equals(correo)) {
                user = usuario;
                break;
            }
        }
        return user;
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
    
}
