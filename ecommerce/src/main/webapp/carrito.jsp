<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Carrito - Vinylia</title>

        <!-- Estilos -->
        <link rel="stylesheet" href="../css/index.css" />
        <link rel="stylesheet" href="../css/carrito.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
    </head>
    <body>
        <!-- NAVBAR -->
        <header>
            <nav>
                <ul>
                    <li class="nav-item"><a href="index.html">Catalogo</a></li>
                    <li class="nav-item"><a href="index.html"><img src="../imgs/Vinylia.png" alt="Vinylia"></a></li>
                    <div class="nav-item-container nav-item">
                        <li class="nav-item">
                            <a href="carrito.html" class="carrito-link">
                                <i class="fa-solid fa-cart-shopping"></i>
                                <span id="cart-count">3</span>
                            </a>
                        </li>
                        <li class="nav-item"><a href="iniciarSesion.html" id="iniciarSesion">Iniciar Sesión</a></li>
                    </div>
                </ul>
            </nav>
        </header>

        <!-- CONTENIDO PRINCIPAL -->
        <main id="contenedor-carrito">
            <!-- Lista de productos -->
            <section class="lista-productos">
                <div class="producto">
                    <img src="../imgs/imgsProductos/porqueLaDemora.jpg" alt="Por que la Demora">
                    <div class="info">
                        <p class="nombre">Por que la Demora</p>
                        <p>Unidades: <input type="number" value="1" min="1"></p>
                        <p class="precio">$150</p>
                    </div>
                </div>

                <div class="producto">
                    <img src="../imgs/imgsProductos/DebiTirarMasFotosAlbum.jfif" alt="Debi Tirar Mas Fotos">
                    <div class="info">
                        <p class="nombre">Debi Tirar Mas Fotos</p>
                        <p>Unidades: <input type="number" value="2" min="1"></p>
                        <p class="precio">$475</p>
                    </div>
                </div>

                <div class="producto">
                    <img src="../imgs/imgsProductos/adisonAlbum.jpg" alt="Adison">
                    <div class="info">
                        <p class="nombre">Adison</p>
                        <p>Unidades: <input type="number" value="1" min="1"></p>
                        <p class="precio">$300</p>
                    </div>
                </div>
            </section>

            <!-- Resumen compra -->
            <aside class="resumen-compra">
                <h2>Total</h2>
                <p>Por que la Demora: <strong>$150</strong></p>
                <p>Debi Tirar Mas Fotos: <strong>$475</strong></p>
                <p>Adison: <strong>$300</strong></p>
                <hr>
                <p>Subtotal: <strong>$925</strong></p>
                <p>Enví­o: <strong>$5</strong></p>
                <p><strong>Total: $930</strong></p>
                <button id="btnCompra">Realizar Compra</button>
            </aside>
        </main>
        <script>
            document.getElementById("btnCompra").addEventListener("click", () => {
                // Checamos si el usuario está logueado
                let usuarioRegistrado = localStorage.getItem("usuarioRegistrado") === "true";

                if (!usuarioRegistrado) {
                    // si NO está logueado lo manda a login
                    alert("Debes iniciar sesión para completar la compra.");
                    window.location.href = "iniciarSesion.html";
                } else {
                    // si SÍ está logueado, procesa la compra
                    alert("Compra realizada con Éxito");
                    // Aquí­ puedes limpiar el carrito o registrar el pedido
                    localStorage.removeItem("carrito"); // opcional: vaciar carrito
                }
            });
        </script>

    </body>
</html>
