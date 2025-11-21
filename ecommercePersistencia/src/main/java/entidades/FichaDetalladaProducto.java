package entidades;

/**
 *
 * @author janot
 */
public class FichaDetalladaProducto {
    int idFichaDetalladaProducto;
    Producto producto;
    int existencias;
    String descripcion;

    public FichaDetalladaProducto() {
    }

    public FichaDetalladaProducto(int idFichaDetalladaProducto, Producto producto, int existencias, String descripcion) {
        this.idFichaDetalladaProducto = idFichaDetalladaProducto;
        this.producto = producto;
        this.existencias = existencias;
        this.descripcion = descripcion;
    }
    
    public int getIdFichaDetalladaProducto() {
        return idFichaDetalladaProducto;
    }

    public void setIdFichaDetalladaProducto(int idFichaDetalladaProducto) {
        this.idFichaDetalladaProducto = idFichaDetalladaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
