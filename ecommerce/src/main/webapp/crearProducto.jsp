<%-- 
    Document   : crearProducto
    Created on : 22 nov 2025, 12:49:20 p.m.
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Producto</title>
</head>
<body>

<h2>Agregar nuevo producto</h2>

<form action="crearProducto" method="post">

    <label>Nombre:</label>
    <input type="text" name="nombre" required>

    <br>

    <label>Ruta imagen:</label>
    <input type="text" name="rutaImg" required>

    <br>

    <label>Precio:</label>
    <input type="number" name="precio" step="0.01" required>

    <br>


    <label>Categorías (separadas por comas):</label>
    <input type="text" name="categorias" placeholder="trap, regional, natanael" required>

    <br><br>

    <button type="submit">Crear</button>

</form>

<br>
<a href="productos">Volver</a>

</body>
</html>
