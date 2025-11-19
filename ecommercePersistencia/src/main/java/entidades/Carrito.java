package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janot
 */
public class Carrito {
    private List<Producto> listaProductos;
    private double total;

    public Carrito() {
        listaProductos = new ArrayList<>();
        total = 0.0;
    }
    
    public void agregarProducto(Producto producto){
        total += producto.getPrecio();
        listaProductos.add(producto);
    }
    
    public void eliminarProducto(int idProducto){
        for (int i = 0; i < listaProductos.size(); i++) {
            if(listaProductos.get(i).getIdProducto() == idProducto){
                listaProductos.remove(i);
            }
        }
    }
    
    public List<Producto> obtenerCarrito(){
        return listaProductos;
    }

    public double getTotal() {
        return total;
    }

}
