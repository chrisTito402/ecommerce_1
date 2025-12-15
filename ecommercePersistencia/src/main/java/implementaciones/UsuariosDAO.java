/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Conexion.Conexion;
import entidades.Usuario;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author chris
 */
public class UsuariosDAO implements IPersistencia.IUsuarioDAO {

    @Override
    public Usuario consultarUsuario(String correo) {
        EntityManager em = Conexion.crearConexion();
        Usuario usuario = null;

        try {
            usuario = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.correo = :correo",
                    Usuario.class
            )
                    .setParameter("correo", correo)
                    .getSingleResult();
        } catch (Exception e) {
            usuario = null; // si no existe retorna null como tu mock
        } finally {
            em.close();
        }

        return usuario;
    }

    @Override
    public List<Usuario> consultarTodosLosUsuarios() {
        EntityManager em = Conexion.crearConexion();

        List<Usuario> lista = em
                .createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();

        em.close();
        return lista;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();

            return usuario;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al registrar usuario: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario editarUsuario(Usuario usuario) {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();

            return usuario;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al editar usuario: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Método que consulta a los usuarios pero por su ID exclusivo a la base de
     * datos
     *
     * @param id del usuario
     * @return Usuario encontrado
     */
    @Override
    public Usuario consultarUsuarioPorId(Long id) {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Metodo para actualizar un usuario
     *
     * @param usuario
     * @return usuario actualizado
     */
    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Usuario usuarioActualizado = em.merge(usuario);
            em.getTransaction().commit();
            return usuarioActualizado;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al actualizar el usuario.");
        } finally {
            em.close();
        }

    }

}
