/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import IPersistencia.IDetalleProductoDAO;
import entidades.DetalleProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DetalleProductoMokitoDAO implements IDetalleProductoDAO {

    private static DetalleProductoMokitoDAO instance = null;

    private List<DetalleProducto> listaDetalles = new ArrayList<>();

    private DetalleProductoMokitoDAO() {

        listaDetalles.add(new DetalleProducto(
                1,
                "Vinilo de alta calidad del álbum 'Por Qué La Demora'. Incluye funda protectora y arte original.",
                25,
                "Formato: Vinilo LP 12 pulgadas\n"
                + "Artista: Natanael Cano\n"
                + "Género: Trap / Regional Mexicano\n"
                + "Año de lanzamiento: 2024\n"
                + "Discográfica: Rancho Humilde"
        ));

        listaDetalles.add(new DetalleProducto(
                2,
                "Edición especial del álbum 'Debí Tirar Más Fotos', contiene libreto con letras.",
                18,
                "Formato: Vinilo LP 12 pulgadas\n"
                + "Artista: Bad Bunny\n"
                + "Género: Reguetón / Urbano\n"
                + "Año de lanzamiento: 2023\n"
                + "Discográfica: Rimas Entertainment"
        ));

        listaDetalles.add(new DetalleProducto(
                3,
                "Vinilo del álbum 'Adison', sonido remasterizado y portada exclusiva.",
                40,
                "Formato: Vinilo LP 12 pulgadas\n"
                + "Artista: Adison\n"
                + "Género: Pop\n"
                + "Año de lanzamiento: 2022\n"
                + "Discográfica: Universal Music"
        ));

        listaDetalles.add(new DetalleProducto(
                4,
                "Vinilo premium del álbum 'Let Go Letters'. Incluye edición deluxe con fotos.",
                12,
                "Formato: Vinilo LP 12 pulgadas\n"
                + "Artista: Lupita\n"
                + "Género: Pop\n"
                + "Año de lanzamiento: 2021\n"
                + "Discográfica: Sony Music"
        ));
    }

    public static DetalleProductoMokitoDAO getInstance() {
        if (instance == null) {
            instance = new DetalleProductoMokitoDAO();
        }
        return instance;
    }

    @Override
    public DetalleProducto consultarDetallePorId(int idProducto) {
        return listaDetalles.stream()
                .filter(d -> d.getIdProducto() == idProducto)
                .findFirst()
                .orElse(null);
    }
}
