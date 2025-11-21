package IPersistencia;

import entidades.Resenia;
import java.util.List;

/**
 *
 * @author chris
 */
public interface IReseniasDAO {

    public void agregarResenia(Resenia resenia);
    List<Resenia> consultarResenias();
    List<Resenia> consultarReseniasPorProducto(int idProducto);
    void eliminarResenia(int id);

}
