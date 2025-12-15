window.onload = () => {
    const host = "http://localhost:8080/api";
    let productos = [];
    const divProductos = document.getElementById("container-productos");
    const inpBuscarProductoNombre = document.getElementById("inp-buscarProducto-nombre");
    const btnBuscarProductoNombre = document.getElementById("btn-buscarProducto-nombre");
    const btnsCategoria = document.getElementsByName("btn-categoria");

    const init = () => {
        for (let i = 0; i < btnsCategoria.length; i++) {
            let btn = btnsCategoria[i];
            btn.onclick = buscarProductosCategoria;
        }
        btnBuscarProductoNombre.onclick = buscarProductosNombre;
        obtenerProductos();
    };


    const buscarProductosCategoria = (event) => {
        const btn = event.target;

        fetch(
            host + "/producto/categoria/" + btn.innerHTML,
            {
                method: "GET"
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al obtener productos por Categoría.");
            }
            return response.json();
        }).then(productosDTO => {
            productos = productosDTO;
            cargarProductos();
        }).catch(err => {
            console.error(err);
        });
    };

    const buscarProductosNombre = () => {
        const productoBuscar = {
            nombre: inpBuscarProductoNombre.value
        };

        fetch(
            host + "/producto/nombre/" + productoBuscar.nombre,
            {
                method: "GET"
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al consultar Productos por Nombre.");
            }
            return response.json();
        }).then(productosDTO => {
            productos = productosDTO;
            cargarProductos();
        }).catch(err => {
            console.error(err);
        });
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

    const clearDivList = () => {
        divProductos.innerHTML = "";
    };

    const cargarProductos = () => {
        clearDivList();
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