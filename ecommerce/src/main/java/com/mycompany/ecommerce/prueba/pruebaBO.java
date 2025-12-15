package com.mycompany.ecommerce.prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.negocio.AutenticacionBO;
import com.mycompany.ecommerce.negocio.ProductoBO;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author daniel
 */
public class pruebaBO {
    public static void main(String[] args) {
        IPersistencia persistencia = new PersistenciaDAO();
        ProductoBO productosBO = new ProductoBO(persistencia);
        
        ProductoDTO producto = new ProductoDTO();
        producto.setNombre("My Way");
        producto.setPrecio(100.00);
        producto.setRutaImg("");
        producto.setEstrellas(5.0);
        producto.setCategorias(Arrays.asList("JAZZ"));
        
        List<ProductoDTO> productosDTO = productosBO.consultarProductosPorCategoria("POP");
        System.out.println(productosDTO);
        
    }
}
