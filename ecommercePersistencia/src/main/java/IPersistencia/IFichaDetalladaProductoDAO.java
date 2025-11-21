package IPersistencia;

import entidades.FichaDetalladaProducto;

/**
 *
 * @author janot
 */
public interface IFichaDetalladaProductoDAO {
    
    public FichaDetalladaProducto consultarFichaDetalladaDeProducto(int idProducto);
    
}
