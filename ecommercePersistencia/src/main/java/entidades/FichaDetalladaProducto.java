package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "FichaDetalladaProductos")
public class FichaDetalladaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @Column(name = "existencias", nullable = false)
    private Integer existencias;
    @Column(name = "especificaciones", length = 200)
    private String especificacionesTecnicas;
    @OneToOne(mappedBy = "ficha")
    private Producto producto;
    
    
    public FichaDetalladaProducto() {
    }

    public FichaDetalladaProducto(Long id, String descripcion, Integer existencias, String especificacionesTecnicas, Producto producto) {
        this.id = id;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.producto = producto;
    }

    public FichaDetalladaProducto(String descripcion, Integer existencias, String especificacionesTecnicas, Producto producto) {
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public String getEspecificacionesTecnicas() {
        return especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(String especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaDetalladaProducto)) {
            return false;
        }
        FichaDetalladaProducto other = (FichaDetalladaProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FichaDetalladaProducto[ id=" + id + " ]";
    }
    
}
