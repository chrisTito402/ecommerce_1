/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import entidades.DetalleProducto;

/**
 *
 * @author Usuario
 */
public interface IDetalleProductoDAO {

    public DetalleProducto consultarDetallePorId(int idProducto);
}
