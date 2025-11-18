<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/index.css">
        <link rel="stylesheet" href="../css/catalogo.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <title>Vinylia</title>
    </head>

    <body>
        <header>
            <nav>
                <ul>
                    <li class="nav-item"><a href="../html/catalogo.html">Catalogo</a></li>
                    <li class="nav-item"><a href="../html/index.html"><img src="../imgs/Vinylia.png" alt=""></a></li>
                    <div class="nav-item-container nav-item">
                        <li class="nav-item"><a href="../html/carrito.html"><i class="fa-solid fa-cart-shopping"> 0</a></i>
                        </li>
                        <li class="nav-item"><a href="../html/iniciarSesion.html" id="iniciarSesion">Iniciar Sesión</a></li>
                    </div>
                </ul>
            </nav>
        </header>

        <main>


            <!-- CategorÃ­as -->
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
                    <div class="card-producto">
                        <img src="../imgs/imgsProductos/porqueLaDemora.jpg" alt="">
                        <p class="nombre-album">Por que La Demora</p>
                        <p class="puntuacion">4.5 Stars</p>
                        <p class="detalles"><a href="../html/detallesProducto.html">Ver Detalles</a></p>

                    </div>
                    <div class="card-producto">
                        <img src="../imgs/imgsProductos/DebiTirarMasFotosAlbum.jfif" alt="">
                        <p class="nombre-album">Debi Tirar Mas Fotos</p>
                        <p class="puntuacion">4.0 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>

                    </div>
                    <div class="card-producto">
                        <img src="../imgs/imgsProductos/adisonAlbum.jpg" alt="">
                        <p class="nombre-album">Adison</p>
                        <p class="puntuacion">3.8 Stars</p>
                        <p class="detalles"><a href="detallesProducto.html">Ver Detalles</a></p>

                    </div>
                    <div class="card-producto">
                        <img src="../imgs/imgsProductos/letGoLettersAlbum.jfif" alt="">
                        <p class="nombre-album">Let Go Letters</p>
                        <p class="puntuacion">4.5 Stars</p>
                        <p class="detalles"><a href="#">Ver Detalles</a></p>

                    </div>
                </div>
            </section>
        </main>
    </body>

</html>