package com.mycompany.ecommerce.prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.negocio.AutenticacionBO;
import com.mycompany.ecommerce.negocio.ProductoBO;
import java.util.List;

/**
 *
 * @author daniel
 */
public class pruebaBO {
    public static void main(String[] args) {
        IPersistencia persistencia = new PersistenciaDAO();
        ProductoBO productosBO = new ProductoBO(persistencia);
        List<ProductoDTO> productosDTO = productosBO.consultarProductos();
        System.out.println(productosDTO);
        
    }
}
