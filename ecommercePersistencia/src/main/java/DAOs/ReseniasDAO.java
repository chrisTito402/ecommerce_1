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
                "Dark Side of the Moon - Pink Floyd",
                "Uno de los mejores discos que he comprado, sonido impecable.",
                5
        ));

        listaResenas.add(new Resenias(
                2,
                "maria@hotmail.com",
                "Thriller - Michael Jackson",
                "Llegó un día tarde, pero el disco está en buen estado.",
                4
        ));

        listaResenas.add(new Resenias(
                3,
                "hector@hotmail.com",
                "Abbey Road - The Beatles",
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
    public List<Resenias> consultarResenias() {
        return listaResenas;
    }

    @Override
    public void eliminarResenia(int id) {
        listaResenas.removeIf(r -> r.getId() == id);
    }
}
