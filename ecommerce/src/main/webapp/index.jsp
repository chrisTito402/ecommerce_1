<%-- 
    Document   : index
    Created on : 11 nov 2025, 17:31:19
    Author     : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <header>
            <nav>
                <ul>
                    <li class="nav-item"><a href="../html/catalogo.html">Catalogo</a></li>
                    <li class="nav-item"><a href="../html/index.html"><img src="IMGS/Vinylia.png" alt=""></a></li>
                    <div class="nav-item-container nav-item">
                    <li class="nav-item"><a href="../html/carrito.html"><i class="fa-solid fa-cart-shopping"> 3</a></i></li>
                    <li class="nav-item"><a href="../html/iniciarSesion.html" id="iniciarSesion">Iniciar Sesion</a></li>
                    </div>
                </ul>
            </nav>
        </header>
        <main>
            <section id="seccion-banner">
                <img src="IMGS/banner.png" alt="">
            </section>
            <section id="seccion-trending">
                <h2>Trending</h2>
                <div class="container-productos">
                    <div class="card-producto">
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
                </div>
            </section>
        </main>
    </body>
</html>
