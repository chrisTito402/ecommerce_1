package com.mycompany.ecommerce.prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.FichaDetalladaProductoDTO;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.negocio.AutenticacionBO;
import com.mycompany.ecommerce.negocio.FichaDetalladaProductoBO;
import com.mycompany.ecommerce.negocio.ProductoBO;
import java.util.List;

/**
 *
 * @author daniel
 */
public class pruebaBO {
    public static void main(String[] args) {
        IPersistencia persistencia = new PersistenciaDAO();
        FichaDetalladaProductoBO fichaBO = new FichaDetalladaProductoBO(persistencia);
        FichaDetalladaProductoDTO ficha = fichaBO.consultarFichaDetalladaProducto(1);
        System.out.println(ficha);
        
    }
}
