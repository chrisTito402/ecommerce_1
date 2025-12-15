window.onload = () => {
    const carritoApiUrl = "/api/carrito";
    const compraApiUrl = "/api/pedidos/comprar"; 

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

    /**
     * Maneja la eliminación de una línea de carrito (entidad Carrito1)
     * Llama a DELETE /api/carrito?idCarrito={id}
     */
    const eliminarProducto = async (e) => {
        e.preventDefault();

        const idCarrito = e.currentTarget.dataset.idCarrito;

        if (!idCarrito) {
            console.error("Error: Botón de eliminar no tiene data-id-carrito.");
            alert("No se pudo obtener el ID del producto.");
            return;
        }

        if (!confirm("¿Estás seguro de que quieres eliminar este producto del carrito?")) {
            return;
        }

        try {
            const res = await fetch(`${carritoApiUrl}?idCarrito=${idCarrito}`, {
                method: "DELETE",
                credentials: "include"
            });

            if (!res.ok) {
                const errorData = await res.json();
                throw new Error(errorData.error || `Error ${res.status}: Fallo al eliminar.`);
            }

            const successData = await res.json();
            alert(successData.mensaje);

            location.reload();


        } catch (err) {
            console.error("Error al eliminar producto:", err);
            alert("Ocurrió un error: " + err.message);
        }
    };

    /**
     * Realiza la compra transaccional
     * Llama a POST /api/pedidos/comprar
     */
    const realizarCompra = async () => {
        if (!confirm("¿Desea confirmar y pagar el pedido?")) {
            return;
        }

        try {
            const response = await fetch(compraApiUrl, {
                method: 'POST',
                credentials: 'include',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            if (response.ok || response.status === 201) { 
                const data = await response.json();
                alert(data.mensaje);

                location.reload();

            } else {
                const errorData = await response.json();
                alert("Error al realizar la compra: " + errorData.error);
            }

        } catch (err) {
            console.error("Fallo de conexión o inesperado:", err);
            alert("Fallo de conexión o inesperado.");
        }
    };

    init();
};