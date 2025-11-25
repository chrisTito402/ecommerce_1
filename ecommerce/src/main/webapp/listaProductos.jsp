<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/listaProductos.css"/>
        <title>Catálogo de Productos (Admin)</title>
    </head>
    <body>
        <div class="rectangulo-centro">
            <div class="ordenar">
                <h1>Catálogo de Productos</h1>
                <div class="table-responsive">
                    <table border="1" cellpadding="10">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Imagen</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Estrellas</th>
                                <th>Categorías</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="p" items="${productos}">
                                <tr>
                                    <td>${p.idProducto}</td>

                                    <td>
                                        <img src="${p.rutaImg}" alt="Imagen" width="80" height="80">
                                    </td>

                                    <td>${p.nombre}</td>
                                    <td>$ ${p.precio}</td>
                                    <td>${p.estrellas}</td>

                                    <td>
                                        <c:forEach var="cat" items="${p.categorias}">
                                            • ${cat}<br>
                                        </c:forEach>
                                    </td>

                                    <td>
                                        <a href="editarProducto?id=${p.idProducto}">Editar</a> |
                                        <form action="eliminarProducto" method="post" style="display:inline;">
                                            <input type="hidden" name="id" value="${p.idProducto}">
                                            <button type="submit">Eliminar</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="opcionesAbajo">
                    <a href="crearProducto">Agregar Nuevo Producto</a>
                    <a href="panelAdministrador">Regresar</a>
                </div>
            </div>
        </div>
    </body>
</html>
