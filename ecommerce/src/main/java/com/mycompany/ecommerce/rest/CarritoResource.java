package com.mycompany.ecommerce.rest;

import com.mycompany.ecommerce.dtos.CarritoDTO;
import com.mycompany.ecommerce.dtos.ProductoDTO;
import entidades.Carrito1;
import entidades.Producto;
import entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

/**
 *
 * @author Ángel
 */
@Path("carrito")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarritoResource {

    @PersistenceContext(unitName = "ecommerce")
    private EntityManager em;

    @Context
    private HttpServletRequest request;

    // Obtener carrito del usuario
    @GET
    public List<CarritoDTO> obtenerCarrito() {

        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        Long usuarioId = (Long) session.getAttribute("id_usuario");

        TypedQuery<Carrito1> query = em.createQuery(
            "SELECT c FROM Carrito c WHERE c.usuario.id = :id_usuario",
            Carrito1.class
        );
        query.setParameter("id_usuario", usuarioId);

        return query.getResultList().stream().map(c -> {
            CarritoDTO dto = new CarritoDTO();
            dto.setIdProducto(c.getProducto().getId());
            dto.setNombre(c.getProducto().getNombre());
            dto.setRutaImg(c.getProducto().getRutaImg());
            dto.setPrecio(c.getProducto().getPrecio());
            dto.setCantidad(c.getCantidad());
            return dto;
        }).toList();
    }

    // Agregar producto
    @POST
    public Response agregarProducto(ProductoDTO dto) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        Long usuarioId = (Long) session.getAttribute("id_usuario");

        Usuario usuario = em.find(Usuario.class, usuarioId);
        Producto producto = em.find(Producto.class, dto.getIdProducto());

        // Validar si ya existe
        TypedQuery<Carrito1> query = em.createQuery(
            "SELECT c FROM Carrito c WHERE c.usuario.id = :id_usuario AND c.producto.id = :id_producto",
            Carrito1.class
        );
        query.setParameter("id_usuario", usuarioId);
        query.setParameter("id_producto", dto.getIdProducto());

        Carrito1 carrito;
        try {
            carrito = query.getSingleResult();
            carrito.setCantidad(carrito.getCantidad() + 1);
            em.merge(carrito);
        } catch (NoResultException e) {
            carrito = new Carrito1();
            carrito.setUsuario(usuario);
            carrito.setProducto(producto);
            carrito.setCantidad(1);
            em.persist(carrito);
        }

        return Response.ok().build();
    }

    // Eliminar producto
    @DELETE
    @Path("{idProducto}")
    public Response eliminarProducto(@PathParam("idProducto") int idProducto) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        Long usuarioId = (Long) session.getAttribute("id_usuario");

        TypedQuery<Carrito1> query = em.createQuery(
            "SELECT c FROM Carrito c WHERE c.usuario.id = :id_usuario AND c.producto.id = :id_producto",
            Carrito1.class
        );
        query.setParameter("id_usuario", usuarioId);
        query.setParameter("id_producto", idProducto);

        Carrito1 carrito = query.getSingleResult();
        em.remove(carrito);

        return Response.ok().build();
    }
}
