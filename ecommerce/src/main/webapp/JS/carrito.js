window.onload = () => {
    const host = "http://localhost:8080/api/carrito";
    
    const botonesEliminar = document.querySelectorAll(".btn-eliminar");
    const btnCompra = document.getElementById("btnCompra");

    const init = () => {
        botonesEliminar.forEach(btn => {
            btn.onclick = eliminarProducto;
        });

        if (btnCompra) {
            btnCompra.onclick = realizarCompra;
        }
    };

    // Eliminar producto
    const eliminarProducto = (e) => {
        const idProducto = e.currentTarget.dataset.id;

        fetch(`${host}/${idProducto}`, {
            method: "DELETE",
            credentials: "include"
        })
        .then(res => {
            if (!res.ok) throw new Error("Error al eliminar producto");
            location.reload();
        })
        .catch(err => console.error(err));
    };

    // Realizar compra
    const realizarCompra = () => {
        alert("Todavia no XDDDD");
    };

    init();
};
