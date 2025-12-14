window.onload = () => {
    const host = "http://localhost:8080/api";
    let productos = [];
    const divProductos = document.getElementById("container-productos");

    const init = () => {
        obtenerProductos();
    };

    const obtenerProductos = () => {
        fetch(
            host + "/producto",
            {
                method: "GET"
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al cargar catalogo.");
            }
            return response.json();
        }).then(productosDTO => {
            productos = productosDTO;
            cargarProductos();
        }).catch(err => {
            console.error(err);
        });
    };

    const cargarProductos = () => {
        productos.forEach(producto => {
            const div = document.createElement("div");
            const img = document.createElement("img");
            const pNombreAlbum = document.createElement("p");
            const pPuntuacion = document.createElement("p");
            const pDetalles = document.createElement("p");
            const divAgregarCarrito = document.createElement("div");

            div.setAttribute("class", "card-producto");
            img.setAttribute("src", producto.rutaImg);
            img.setAttribute("alt", "");
            pNombreAlbum.setAttribute("class", "nombre-album");
            pPuntuacion.setAttribute("class", "puntuacion");
            pDetalles.setAttribute("class", "detalles");
            divAgregarCarrito.setAttribute("class", "agregar-a-carrito");

            pNombreAlbum.innerHTML = producto.nombre;
            pPuntuacion.innerHTML = producto.estrellas;

            const aDetalles = document.createElement("a");
            aDetalles.setAttribute("href", "/detallesProducto?idProducto=" + producto.idProducto);
            aDetalles.innerHTML = "Ver Detalles";

            const aAgregarCarrito = document.createElement("a");
            aAgregarCarrito.setAttribute("href", "/agregarProducto?idProducto=" + producto.idProducto);
            aAgregarCarrito.innerHTML = "Agregar A Carrito";

            pDetalles.appendChild(aDetalles);
            divAgregarCarrito.appendChild(aAgregarCarrito);

            div.appendChild(img);
            div.appendChild(pNombreAlbum);
            div.appendChild(pPuntuacion);
            div.appendChild(pDetalles);
            div.appendChild(divAgregarCarrito);
            divProductos.appendChild(div);
        });
    };

    init();
};