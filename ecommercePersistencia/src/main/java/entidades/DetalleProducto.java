/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Usuario
 */
public class DetalleProducto {

    private int idProducto;
    private String descripcion;
    private int existencias;
    private String especificacionesTecnicas;

    public DetalleProducto(int idProducto, String descripcion, int existencias, String especificacionesTecnicas) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getExistencias() {
        return existencias;
    }

    public String getEspecificacionesTecnicas() {
        return especificacionesTecnicas;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public void setEspecificacionesTecnicas(String especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }
}
