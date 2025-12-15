window.onload = () => {
    const host = "/api/carrito";
    const contadorHost = "/api/carrito/contador";
    
    const botonesAgregar = document.querySelectorAll(".btn-agregar");

    const actualizarContadorCarrito = async () => {
        const contadorElemento = document.getElementById('contador-carrito');

        if (!contadorElemento) return;

        try {
            const response = await fetch(contadorHost);
            
            if (response.ok) {
                const data = await response.json();
                const cantidad = data.cantidad;
                
                contadorElemento.textContent = cantidad > 0 ? cantidad : '';
            } else {
                contadorElemento.textContent = '';
            }
        } catch (error) {
            console.error("Error de red al obtener el contador:", error);
            contadorElemento.textContent = '';
        }
    };

    const agregarProducto = async (e) => {
        e.preventDefault();
        const idProducto = e.currentTarget.dataset.id;
        
        try {
            const res = await fetch(host, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                credentials: "include",
                body: JSON.stringify({ idProducto: parseInt(idProducto) })
            });
            
            if (res.status === 401) {
                alert("Debe iniciar sesión para agregar productos al carrito.");
                window.location.href = "iniciarSesion.jsp";
                return;
            }
            
            if (!res.ok) {
                const errorData = await res.json();
                throw new Error(`Error ${res.status}: ${errorData.error || 'Error desconocido al agregar.'}`);
            }
            
            alert("¡Producto agregado al carrito con éxito!");
            
            // Actualiza el contador después de la operación exitosa
            await actualizarContadorCarrito(); 

        } catch (err) {
            console.error("Error al procesar la solicitud:", err);
            alert("Ocurrió un error: " + err.message);
        }
    };

    const init = () => {
        botonesAgregar.forEach(btn => {
            btn.onclick = agregarProducto;
        });
        
        actualizarContadorCarrito(); 
    };

    init();
};