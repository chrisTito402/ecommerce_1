<%-- 
    Document   : catalogo
    Created on : 19 nov 2025, 03:20:02
    Author     : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/index.css">
        <link rel="stylesheet" href="CSS/catalogo.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <script src="./JS/catalogo.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacion.jspf" %> 
        <main>
            <!-- Categorías -->
            <section id="seccion-categorias">
                <div class="categorias">
                    <button name="btn-categoria">ROCK</button>
                    <button name="btn-categoria">BACHATA</button>
                    <button name="btn-categoria">ELECTRÓNICA</button>
                    <button name="btn-categoria">CORRIDOS</button>
                    <button name="btn-categoria">POP</button>
                    <button name="btn-categoria">METAL</button>
                    <button name="btn-categoria">JAZZ</button>
                    <button name="btn-categoria">COUNTRY</button>
                    <button name="btn-categoria">SALSA</button>
                </div>
            </section>

            <!-- Buscador -->
            <section id="seccion-busqueda">
                <div class="buscador">
                    <input type="text" placeholder="Buscar álbum o artista..." id="inp-buscarProducto-nombre">
                    <button><i class="fa-solid fa-magnifying-glass" id="btn-buscarProducto-nombre"></i></button>
                </div>
            </section>

            <section id="seccion-trending">
                <div class="container-productos" id="container-productos">
                </div>
            </section>
        </main>
    </body>
</html>
