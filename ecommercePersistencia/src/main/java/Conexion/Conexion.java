/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


/**
 *
 * @author chris
 */
public class Conexion {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    public static EntityManager crearConexion() {
        return emf.createEntityManager();
    }

    public static void cerrarConexion(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    public static void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
