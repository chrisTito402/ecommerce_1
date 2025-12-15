window.onload = () => {
    const host = "http://localhost:8080/api";
    const hTotal = document.getElementById("total");
    const sectionProductos = document.getElementById("lista-productos");
    const stgSubtotal = document.getElementById("stg-subtotal");
    const stgEnvio = document.getElementById("stg-envio");
    const stgTotal = document.getElementById("stg-total");
    const btnCompra = document.getElementById("btnCompra");
    const idProducto = new URLSearchParams(window.location.search).get("idProducto");
    let productos = [];
    let resumenCompra;

    const init = () => {
        btnCompra.onclick = realizarCompra;

        añadirProducto();
        obtenerProductosCarrito();
        obtenerResumenCompra();
    };

    const realizarCompra = () => {
        let productosCompra = [];
        productos.forEach(p => {
            let detalle = {
                producto: p,
                cantidad: 1
            };
            productosCompra.push(detalle);
        });

        const pedidoNuevo = {
            detallesPedido: productosCompra,
            total: resumenCompra.total
        };
        
        console.log(pedidoNuevo);

        fetch(
            host + "/pedidos",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(pedidoNuevo)
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al registrar compra.");
            }

            window.location.replace("/index.jsp");
        }).catch(err => {
            console.error(err);
        });
    };

    const eliminarProductoCarrito = (producto) => {
        fetch(
            host + "/carrito1",
            {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(producto)
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al eliminar Producto de Carrito.");
            }
            obtenerProductosCarrito();
            obtenerResumenCompra();
        }).catch(err => {
            console.error(err);
        });
    };

    const añadirProducto = () => {
        fetch(
            host + "/carrito1/" + idProducto,
            {
                method: "POST"
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al añadir el Producto al Carrito.");
            }
        }).catch(err => {
            console.error(err);
        });
    };

    const obtenerResumenCompra = () => {
        fetch(
            host + "/carrito1/resumen",
            {
                method: "GET"
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al obtener Resumen de Compra.");
            }
            return response.json();
        }).then(resumenDTO => {
            resumenCompra = resumenDTO;
            cargarResumenCompra();
        }).catch(err => {
            console.error(err);
        })
    };

    const obtenerProductosCarrito = () => {
        fetch(
            host + "/carrito1",
            {
                method: "GET"
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al obtener Productos del Carrito.");
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
        sectionProductos.innerHTML = "";
        productos.forEach(producto => {
            const divProducto = document.createElement("div");
            const img = document.createElement("img");
            const divInfo = document.createElement("div");
            const pNombre = document.createElement("p");
            const pPrecio = document.createElement("p");
            const btnEliminar = document.createElement("button");
            const iTrash = document.createElement("i");

            divProducto.setAttribute("class", "producto");
            img.setAttribute("src", producto.rutaImg);
            img.setAttribute("alt", producto.nombre);
            divInfo.setAttribute("class", "info");
            pNombre.setAttribute("class", "nombre");
            pPrecio.setAttribute("class", "precio");
            btnEliminar.setAttribute("class", "btn-eliminar");
            btnEliminar.setAttribute("data-id", producto.idProducto);
            iTrash.setAttribute("class", "fa fa-trash");

            pNombre.innerHTML = producto.nombre;
            pPrecio.innerHTML = producto.precio;

            divInfo.appendChild(pNombre);
            divInfo.appendChild(pPrecio);
            btnEliminar.appendChild(iTrash);
            divProducto.appendChild(img);
            divProducto.appendChild(divInfo);
            divProducto.appendChild(btnEliminar);

            btnEliminar.onclick = () => {
                eliminarProductoCarrito(producto);
            };

            sectionProductos.appendChild(divProducto);
        });
    };

    const cargarResumenCompra = () => {
        hTotal.innerHTML = "";
        productos.forEach(producto => {
            const p = document.createElement("p");
            const strong = document.createElement("strong");
            p.innerHTML = producto.nombre;
            strong.innerHTML = producto.precio;

            p.appendChild(strong);

            hTotal.appendChild(p);
        });

        stgSubtotal.innerHTML = resumenCompra.subTotal;
        stgTotal.innerHTML = resumenCompra.total;
    };

    init();
};