package DAOs;

import IPersistencia.IReseniasDAO;
import entidades.Producto;
import entidades.Resenia;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author chris
 */
public class ReseniasDAO implements IReseniasDAO {

    private static ReseniasDAO instance = null;

    private List<Resenia> listaResenas = new ArrayList<>();

    ;
    private ReseniasDAO() {
        listaResenas.add(new Resenia(
                1,
                new Usuario(1,"Hector Valenzuela Ruiz", "6442484832", "Calle chalito 2023", "hecVal75@gmail.com", "eskeler"),
                new Producto(1, "Por Que La Demora", "IMGS/imgsProductos/porqueLaDemora.jpg", 500.0, 4.5, Arrays.asList("trap","regional mexicano", "Natanael Cano")),
                "Uno de los mejores discos que he comprado, sonido impecable.",
                5
        ));

        listaResenas.add(new Resenia(
                2,
                new Usuario(2,"Luisa Lopez Murillo","6442839210","Calle Marcelin 1023", "luisalomu32@gmail.com","juniorh"),
                new Producto(2, "Debi Tirar Mas Fotos", "IMGS/imgsProductos/DebiTirarMasFotosAlbum.jfif", 750.0, 4.0, Arrays.asList("regueton","colombia", "Bad Bunny")),
                "Llegó un día tarde, pero el disco está en buen estado.",
                4
        ));

           listaResenas.add(new Resenia(
                3,
                new Usuario(3,"Romina Castillo Gonzalez", "6441029320", "Calle Tupu 4563", "romiGal9430@gmail.com", "teito123"),
                new Producto(3, "Adison", "IMGS/imgsProductos/adisonAlbum.jpg", 350.0, 3.8, Arrays.asList("pop","EUA", "Adison")),
                "La calidad está normalita, esperaba mejor la edición.",
                3
        ));

    }

    public static ReseniasDAO getInstance() {
        if (instance == null) {
            instance = new ReseniasDAO();
        }
        return instance;
    }

    @Override
    public List<Resenia> consultarResenias() {
        return listaResenas;
    }

    @Override
    public void eliminarResenia(int id) {
        listaResenas.removeIf(r -> r.getIdResenia()== id);
    }

    @Override
    public List<Resenia> consultarReseniasPorProducto(int idProducto) {
        List<Resenia> reseñasDeProducto = new ArrayList<>();
        for (Resenia resenia : listaResenas) {
            if(resenia.getProducto().getIdProducto() == idProducto){
                reseñasDeProducto.add(resenia);
            }
        }
        
        return reseñasDeProducto;
    }

    @Override
    public void agregarResenia(Resenia resenia) {
        listaResenas.add(resenia);
    }
}
