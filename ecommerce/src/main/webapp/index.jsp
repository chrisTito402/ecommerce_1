<%-- 
    Document   : index
    Created on : 11 nov 2025, 17:31:19
    Author     : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/index.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <title>Vinylia</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacion.jspf"%>
        
        <main>
            <section id="seccion-banner">
                <img src="IMGS/banner.png" alt="">
            </section>
            <section id="seccion-trending">
                <h2>Trending</h2>
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
                    
                    <!-- <div class="card-producto">
                        <img src="../IMGS/imgsProductos/porqueLaDemora.jpg" alt="">
                        <p class="nombre-album">Por que La Demora</p>
                        <p class="puntuacion">4.5 Stars</p>
                        <p class="detalles"><a href="../html/detallesProducto.html">Ver Detalles</a></p>
                        <div class="agregar-a-carrito">Añadir A Carrito</div>
                    </div>
                    <div class="card-producto">
                        <img src="../IMGS/imgsProductos/DebiTirarMasFotosAlbum.jfif" alt="">
                        <p class="nombre-album">Debi Tirar Mas Fotos</p>
                        <p class="puntuacion">4.0 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>
                        <div class="agregar-a-carrito">Añadir A Carrito</div>
                    </div>
                    <div class="card-producto">
                        <img src="../IMGS/imgsProductos/adisonAlbum.jpg" alt="">
                        <p class="nombre-album">Adison</p>
                        <p class="puntuacion">3.8 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>
                        <div class="agregar-a-carrito">Añadir A Carrito</div>
                    </div>
                    <div class="card-producto">
                        <img src="../IMGS/imgsProductos/letGoLettersAlbum.jfif" alt="">
                        <p class="nombre-album">Let Go Letters</p>
                        <p class="puntuacion">4.5 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>
                        <div class="agregar-a-carrito">Añadir A Carrito</div>
                    </div>
                    -->
                </div>
            </section>
        </main>
    </body>
</html>
