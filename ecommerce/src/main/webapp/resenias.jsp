<%-- 
    Document   : resenias
    Created on : 18 nov 2025, 1:52:27 a.m.
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reseñas - Admin</title>
    <link rel="stylesheet" href="../CSS/adminResenias.css">
</head>
<body>

    <main>
        <section id="contenedor-reseñas">
            <h2>Reseñas de Productos</h2>

            

            <table border="1" cellpadding="10">
                <tr>
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>Producto</th>
                    <th>Comentario</th>
                    <th>Rating</th>
                    <th>Acciones</th>
                </tr>

                <c:forEach var="r" items="${listaResenias}">
                    <tr>
                        <td>${r.id}</td>
                        <td>${r.usuarioCorreo}</td>
                        <td>${r.productoNombre}</td>
                        <td>${r.comentario}</td>
                        <td>${r.rating}</td>

                        <td>
                            <form action="eliminarResenia" method="POST">
                                <input type="hidden" name="id" value="${r.id}">
                                <button type="submit">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </section>
    </main>

</body>
</html>

