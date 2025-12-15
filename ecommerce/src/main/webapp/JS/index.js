window.onload = () => {
    const host = "http://localhost:8080/api/carrito";
    
    const botonesAgregar = document.querySelectorAll(".btn-agregar");

    const init = () => {
        botonesAgregar.forEach(btn => {
            btn.onclick = agregarProducto;
        });
    };

    // Agregar producto
    const agregarProducto = (e) => {
        e.preventDefault();
        const idProducto = e.currentTarget.dataset.id;

        fetch(host, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            credentials: "include",
            body: JSON.stringify({ idProducto: parseInt(idProducto) })
        })
        .then(res => {
            if (!res.ok) throw new Error("Error al agregar producto");
            alert("Producto agregado al carrito");
        })
        .then(productoDTO => {
            console.log("El usuario ve los detalles del producto.");
            window.location.replace("/detallesProducto");
        })
        .catch(err => console.error(err));
    };

    init();
};
