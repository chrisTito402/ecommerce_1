package DAOs;

import IPersistencia.IFichaDetalladaProductoDAO;
import entidades.FichaDetalladaProducto;
import entidades.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author janot
 */
public class FichaDetalladaProductoMokitoDAO implements IFichaDetalladaProductoDAO{
    private static FichaDetalladaProductoMokitoDAO instance = null;
    private List<FichaDetalladaProducto> listaFichasDetalladasProductos = new ArrayList<>();;

    private FichaDetalladaProductoMokitoDAO() {
        Producto producto1 = new Producto(1, "Por Que La Demora", "IMGS/imgsProductos/porqueLaDemora.jpg", 500.0, 4.5, Arrays.asList("trap","regional mexicano", "Natanael Cano"));
        Producto producto2 = new Producto(2, "Debi Tirar Mas Fotos", "IMGS/imgsProductos/DebiTirarMasFotosAlbum.jfif", 750.0, 4.0, Arrays.asList("regueton","colombia", "Bad Bunny"));
        Producto producto3 = new Producto(3, "Adison", "IMGS/imgsProductos/adisonAlbum.jpg", 350.0, 3.8, Arrays.asList("pop","EUA", "Adison"));
        Producto producto4 = new Producto(4, "Let Go Letters", "IMGS/imgsProductos/letGoLettersAlbum.jfif", 850.0, 4.5, Arrays.asList("pop","EUA", "Lupita"));
        
        FichaDetalladaProducto fichaDetallada1 = new FichaDetalladaProducto(1, producto1, 10, "La superestrella mundial de la música mexicana nominada al GRAMMY® Natanael Cano rompe las fronteras\n" +
            "musicales e inicia una rica exploración que mezcla géneros con Porque La Demora, su proyecto más ambicioso\n" +
            "hasta la fecha. El álbum ya está disponible a través de Rancho Humilde/Warner Music Latina a partir de hoy.\n" +
            "Los anuncios de la producción incluyeron la revelación de la portada del playlist New Music Daily de Apple\n" +
            "Music, así como la publicación del tracklist a través de Spotify y un livestream en Twitch.");
        
        FichaDetalladaProducto fichaDetallada2 = new FichaDetalladaProducto(2,producto2,10,
            "\"La superestrella global del género urbano y ganador del GRAMMY® Bad Bunny continúa expandiendo los límites de su propuesta artística con \\\"Debí tirar más fotos\\\", un lanzamiento que captura una profunda mezcla de nostalgia, emoción y evolución musical.\n"
            + "Este nuevo sencillo representa una etapa más íntima y reflexiva en la carrera del artista, consolidándolo como una de las figuras más influyentes de la música contemporánea.\n\n"
            + "La canción ya está disponible a través de Rimas Entertainment a partir de hoy.\n"
            + "El estreno estuvo acompañado por la revelación de la portada destacada en New Music Daily de Apple Music, además de la publicación del visualizer oficial y contenido exclusivo en Spotify.\n"
            + "Bad Bunny también sorprendió a sus fans con un livestream especial donde habló del proceso creativo detrás del tema y compartió memorias personales que inspiraron su composición.");

        
        FichaDetalladaProducto fichaDetallada3 = new FichaDetalladaProducto(3,producto3,10,"La destacada figura emergente de la escena urbana Adison eleva su propuesta musical con el lanzamiento de su nuevo álbum \"Adison\", un proyecto que fusiona estilos modernos con una narrativa emocional y auténtica.\n"
            + "Este trabajo marca una evolución significativa en la carrera del artista, consolidándolo como una promesa sólida dentro del panorama musical contemporáneo.\n\n"
            + "El álbum ya está disponible a través de su sello discográfico a partir de hoy.\n"
            + "El anuncio incluyó la revelación de la portada en New Music Daily de Apple Music, así como la publicación del tracklist oficial en Spotify.\n"
            + "Además, Adison realizó un livestream especial donde compartió detalles del proceso creativo y la inspiración detrás de cada una de las canciones que conforman el proyecto.");
        
        FichaDetalladaProducto fichaDetallada4 = new FichaDetalladaProducto(4, producto4, 0, "La talentosa artista internacional presenta su proyecto más personal hasta la fecha con el lanzamiento de \"Let Go Letters\", un álbum que combina vulnerabilidad, introspección y una producción sonora cautivadora.\n"
            + "Este nuevo trabajo marca una evolución artística significativa, mostrando una faceta más emocional y madura que consolida su identidad dentro de la música contemporánea.\n\n"
            + "El álbum ya está disponible a través de su sello discográfico a partir de hoy.\n"
            + "El anuncio estuvo acompañado por la presentación de la portada en New Music Daily de Apple Music, además de la publicación del tracklist oficial en Spotify.\n"
            + "La artista también sorprendió a su audiencia con un livestream especial donde compartió el proceso creativo y las historias que inspiraron las canciones de \"Let Go Letters\".");
        
        listaFichasDetalladasProductos.add(fichaDetallada1);
        listaFichasDetalladasProductos.add(fichaDetallada2);
        listaFichasDetalladasProductos.add(fichaDetallada3);
        listaFichasDetalladasProductos.add(fichaDetallada4);
    }
    
    public static FichaDetalladaProductoMokitoDAO getInstance() {
        if (instance == null) {
            instance = new FichaDetalladaProductoMokitoDAO();
        }
        return instance;
    }
    
    
    @Override
    public FichaDetalladaProducto consultarFichaDetalladaDeProducto(int idProducto) {
        for (FichaDetalladaProducto fichaDetalladaProducto : listaFichasDetalladasProductos) {
            if (fichaDetalladaProducto.getProducto().getIdProducto() == idProducto) {
                return fichaDetalladaProducto;
            }
        }
        
        return null;
    }
    
}
