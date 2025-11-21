package com.mycompany.ecommerce.negocio;

import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.FichaDetalladaProductoDTO;
import com.mycompany.ecommerce.mappers.FichaDetalladaMapper;
import entidades.FichaDetalladaProducto;
import java.util.logging.Logger;

/**
 *
 * @author janot
 */
public class FichaDetalladaProductoBO {
    private static final Logger LOGGER = Logger.getLogger(AutenticacionBO.class.getName());
    private final IPersistencia persistencia;
    
    public FichaDetalladaProductoBO(IPersistencia persistencia) {
        this.persistencia = persistencia;
    }
    
    
    public FichaDetalladaProductoDTO consultarFichaDetalladaProducto(int idProducto){
        FichaDetalladaMapper fichaDetalladaMapper = new FichaDetalladaMapper();
        FichaDetalladaProducto fichaDetallada = persistencia.consultarFichaDetalladaDeProducto(idProducto);
        FichaDetalladaProductoDTO fichaDetalladaProductoDTO = fichaDetalladaMapper.toDTO(fichaDetallada);
        return fichaDetalladaProductoDTO;
    }
}
