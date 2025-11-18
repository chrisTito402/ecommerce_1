package DAOs;

import IPersistencia.IReseniasDAO;
import entidades.Resenias;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class ReseniasDAO implements IReseniasDAO {

    private static ReseniasDAO instance = null;

    private List<Resenias> listaResenas = new ArrayList<>();

    ;
    private ReseniasDAO() {
        listaResenas.add(new Resenias(
                1,
                "juan@gmail.com",
                1,
                "Uno de los mejores discos que he comprado, sonido impecable.",
                5
        ));

        listaResenas.add(new Resenias(
                2,
                "maria@hotmail.com",
                2,
                "Llegó un día tarde, pero el disco está en buen estado.",
                4
        ));

        listaResenas.add(new Resenias(
                3,
                "hector@hotmail.com",
                3,
                "La calidad está normalita, esperaba mejor la edición.",
                3
        ));
        listaResenas.add(new Resenias(
                4,
                "lucia@gmail.com",
                1,
                "Me encantó la calidad del vinilo y el arte del álbum es increíble.",
                5
        ));

        listaResenas.add(new Resenias(
                5,
                "pedro@hotmail.com",
                2,
                "Muy buena edición, aunque llegó un poco arrugada la portada.",
                4
        ));

        listaResenas.add(new Resenias(
                6,
                "sofia@gmail.com",
                3,
                "El sonido es excelente, pero el libreto podría tener más información.",
                4
        ));

        listaResenas.add(new Resenias(
                7,
                "carlos@yahoo.com",
                4,
                "Muy buena edición deluxe, fotos y packaging de calidad.",
                5
        ));

        listaResenas.add(new Resenias(
                8,
                "ana@hotmail.com",
                1,
                "Vinilo de gran calidad, la recomiendo mucho.",
                5
        ));

        listaResenas.add(new Resenias(
                9,
                "mario@gmail.com",
                2,
                "El álbum está genial, buena calidad de sonido.",
                5
        ));

        listaResenas.add(new Resenias(
                10,
                "laura@yahoo.com",
                3,
                "Buen vinilo, aunque esperaba mejor presentación del empaque.",
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
    public List<Resenias> consultarResenias() {
        return listaResenas;
    }

    @Override
    public void eliminarResenia(int id) {
        listaResenas.removeIf(r -> r.getId() == id);
    }

    @Override
    public List<Resenias> consultarReseniasPorProducto(int idProducto) {
        return listaResenas.stream()
                .filter(r -> r.getIdProducto() == idProducto)
                .toList();
    }
}
