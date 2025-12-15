/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Conexion.Conexion;
import IPersistencia.IFichaDetalladaProductoDAO;
import entidades.FichaDetalladaProducto;
import jakarta.persistence.EntityManager;

/**
 *
 * @author chris
 */
public class FichaDetalladaDAO implements IFichaDetalladaProductoDAO {

    @Override
    public FichaDetalladaProducto consultarFichaDetalladaDeProducto(long idProducto) {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery(
                    "SELECT f FROM FichaDetalladaProducto f WHERE f.producto.id = :id",
                    FichaDetalladaProducto.class
            )
                    .setParameter("id", idProducto)
                    .getSingleResult();

        } catch (Exception ex) {
            // Si no existe ficha → null
            return null;
        } finally {
            em.close();
        }

    }

}
