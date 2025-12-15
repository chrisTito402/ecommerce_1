window.onload = () => {
    const host = "http://localhost:8080/api";
    const imgFicha = document.getElementById("img-ficha");
    const estrellasFicha = document.getElementById("estrellas-ficha");
    const nombreFicha = document.getElementById("nombre-ficha");
    const descripcionFicha = document.getElementById("descripcion-ficha");
    let fichaProductoDetallada;

    const init = () => {
        obtenerFichaDetallada();
    };

    const obtenerFichaDetallada = () => {
        const params = new URLSearchParams(window.location.search);
        const idProducto = params.get("idProducto");

        fetch(
            host + "/producto/fichaProducto/" + idProducto,
            {
                method: "GET"
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al obtener Ficha Detallada.");
            }
            return response.json();
        }).then(fichaDTO => {
            fichaProductoDetallada = fichaDTO;
            cargarFichaDetallada();
        }).catch(err => {
            console.error(err);
        });
    };

    const cargarFichaDetallada = () => {
        imgFicha.innerHTML = fichaProductoDetallada.productoDTO.rutaImg;
        estrellasFicha.innerHTML = fichaProductoDetallada.productoDTO.estrellas + " Estrellas";
        nombreFicha.innerHTML = fichaProductoDetallada.productoDTO.nombre;
        descripcionFicha.innerHTML = fichaProductoDetallada.descripcion;
    };

    init();
};