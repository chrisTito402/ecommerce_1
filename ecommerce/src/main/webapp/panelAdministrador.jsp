<%-- 
    Document   : panelAdministrador
    Created on : 19 nov 2025, 16:57:19
    Author     : janot
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/panelAdministrador.css">
        <link rel="stylesheet" href="CSS/navegacionAdmin.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacionAdmin.jspf"%>
        <main>
            <section id="seccion-banner">
                    <i class="fa-solid fa-pen-to-square edit"></i>
                    <img src="IMGS/banner.png" alt="">
            </section>
            <section id="seccion-trending">
                <h2>Trending</h2>
                <div class="container-productos">
                    <div class="card-producto">
                        <img src="IMGS/imgsProductos/porqueLaDemora.jpg" alt="">
                        <i class="fa-solid fa-pen-to-square"></i>
                        <p class="nombre-album">Por que La Demora</p>
                        <p class="puntuacion">4.5 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>
                    </div>
                    <div class="card-producto">
                        <img src="IMGS/imgsProductos/DebiTirarMasFotosAlbum.jfif" alt="">
                        <i class="fa-solid fa-pen-to-square"></i>
                        <p class="nombre-album">Debi Tirar Mas Fotos</p>
                        <p class="puntuacion">4.0 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>
                    </div>
                    <div class="card-producto">
                        <img src="IMGS/imgsProductos/adisonAlbum.jpg" alt="">
                        <i class="fa-solid fa-pen-to-square"></i>
                        <p class="nombre-album">Adison</p>
                        <p class="puntuacion">3.8 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>
                    </div>
                    <div class="card-producto">
                        <img src="IMGS/imgsProductos/letGoLettersAlbum.jfif" alt="">
                        <i class="fa-solid fa-pen-to-square"></i>
                        <p class="nombre-album">Let Go Letters</p>
                        <p class="puntuacion">4.5 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>
                    </div>
                </div>
            </section>
        </main>
    </body>
</html>
