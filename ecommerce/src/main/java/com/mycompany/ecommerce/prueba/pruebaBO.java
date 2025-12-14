package com.mycompany.ecommerce.prueba;

import DAOs.PersistenciaDAO;
import IPersistencia.IPersistencia;
import com.mycompany.ecommerce.dtos.UsuarioDTO;
import com.mycompany.ecommerce.negocio.AutenticacionBO;

/**
 *
 * @author daniel
 */
public class pruebaBO {
    public static void main(String[] args) {
        IPersistencia persistencia = new PersistenciaDAO();
        AutenticacionBO aBo = new AutenticacionBO(persistencia);
        UsuarioDTO usuario = aBo.iniciarSesion("a@gmail.com", "a");
        System.out.println(usuario.getNombre());
    }
}
