<%-- 
    Document   : crearProducto
    Created on : 22 nov 2025, 12:49:20 p.m.
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/crearProducto.css"/>
        <title>Crear Producto</title>
    </head>
    <body>
        <div class="rectangulo-centro">
            <h2>Agregar nuevo producto</h2>
            <form action="crearProducto" method="post">
                
                <div class="ordenar">
                    <label>Nombre:</label>
                    <input type="text" name="nombre" required>

                    <label>Ruta imagen:</label>
                    <input type="text" name="rutaImg" required>

                    <label>Precio:</label>
                    <input type="number" name="precio" step="0.01" required>

                    <label>Categorías (separadas por comas):</label>
                    <input type="text" name="categorias" placeholder="trap, regional, natanael" required>
                </div>

                <button type="submit">Crear</button>

            </form>

            <br>
            <a href="adminProductos">Volver</a>
        </div>
    </body>
</html>
