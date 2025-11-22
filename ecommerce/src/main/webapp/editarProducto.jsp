<%-- 
    Document   : editarProducto
    Created on : 22 nov 2025, 12:58:33 p.m.
    Author     : chris
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Editar Producto</title>
    </head>
    <body>

        <h2>Editar Producto</h2>

        <form action="editarProducto" method="post">

            <input type="hidden" name="idProducto" value="${producto.idProducto}">

            <label>Nombre:</label>
            <input type="text" name="nombre" value="${producto.nombre}" required>
            <br>

            <label>Ruta imagen:</label>
            <input type="text" name="rutaImg" value="${producto.rutaImg}" required>
            <br>

            <label>Precio:</label>
            <input type="number" name="precio" value="${producto.precio}" step="0.01" required>
            <br>

            <label>Categorías:</label>

            <c:set var="cats" value="" />

            <c:forEach var="c" items="${producto.categorias}" varStatus="st">
                <c:choose>
                    <c:when test="${st.first}">
                        <!-- Primera categoría: se coloca sin coma -->
                        <c:set var="cats" value="${c}" />
                    </c:when>
                    <c:otherwise>
                        <!-- Siguientes categorías: se agrega coma y espacio -->
                        <c:set var="cats" value="${cats}, ${c}" />
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <input type="text" name="categorias" value="${cats}" required>


            <br><br>

            <button type="submit">Guardar Cambios</button>
        </form>

        <br>
        <a href="adminProductos">Volver</a>

    </body>
</html>>