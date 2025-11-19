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
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacion.jspf" %> 
        <main>
            <!-- Categorías -->
            <section id="seccion-categorias">
                <div class="categorias">
                    <button>ROCK</button>
                    <button>BACHATA</button>
                    <button>ELECTRÓNICA</button>
                    <button>CORRIDOS</button>
                    <button>POP</button>
                    <button>METAL</button>
                    <button>JAZZ</button>
                    <button>COUNTRY</button>
                    <button>SALSA</button>
                </div>
            </section>

            <!-- Buscador -->
            <section id="seccion-busqueda">
                <div class="buscador">
                    <input type="text" placeholder="Buscar álbum o artista...">
                    <button><i class="fa-solid fa-magnifying-glass"></i></button>
                </div>
            </section>

            <section id="seccion-trending">
                <div class="container-productos">
                    <c:forEach items="${requestScope.productos}" var="producto" begin="0" end="${requestScope.productos.size()}">
                        <div class="card-producto">
                            <img src="${producto.getRutaImg()}" alt="">
                            <p class="nombre-album">${producto.getNombre()}</p>
                            <p class="puntuacion">${producto.getEstrellas()}</p>
                            <p class="detalles"><a href="../html/detallesProducto.html">Ver Detalles</a></p>
                            <div class="agregar-a-carrito"><a href="/agregarProducto?idProducto=${producto.getIdProducto()}">Añadir A Carrito</a></div>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </main>
    </body>
</html>
