/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import DAOs.UsuarioMokitoDAO;

/**
 *
 * @author janot
 */
public class main {
    public static void main(String[] args) {
        UsuarioMokitoDAO dao = UsuarioMokitoDAO.getInstance();
        
        System.out.println(dao.consultarUsuario("hecVal75@gmail.com").toString());
    }
    
}
