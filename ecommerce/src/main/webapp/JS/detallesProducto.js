window.onload = () => {
    const host = "http://localhost:8080/api";
    const imgFicha = document.getElementById("img-ficha");
    const estrellasFicha = document.getElementById("estrellas-ficha");
    const nombreFicha = document.getElementById("nombre-ficha");
    const descripcionFicha = document.getElementById("descripcion-ficha");
    const tablaResenias = document.getElementById("tabla-resenias");
    const inpResenia = document.getElementById("textfield");
    const inpPublicarResenia = document.getElementById("boton");
    let fichaProductoDetallada;
    let idProducto;
    let resenias = [];

    const init = () => {
        inpPublicarResenia.onclick = publicarResenia;

        obtenerFichaDetallada();
        obtenerResenias();
    };

    const publicarResenia = () => {
        const nuevaResenia = {
            idProducto: idProducto,
            rating: 2,
            comentario: inpResenia.value
        };

        fetch(
            host + "/producto/resenias",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(nuevaResenia)
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al registrar Reseña.");
            }
            return response.json();
        }).then(reseniaDTO => {
            obtenerResenias();
        }).catch(err => {
            console.error(err);
        });
    };

    const obtenerResenias = () => {
        fetch(
            host + "/producto/resenias/" + idProducto,
            {
                method: "GET"
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al cargar Reseñas.");
            }
            return response.json();
        }).then(reseniasDTO => {
            resenias = reseniasDTO;
            cargarResenias();
        }).catch(err => {
            console.error(err);
        });
    };

    const obtenerFichaDetallada = () => {
        const params = new URLSearchParams(window.location.search);
        idProducto = params.get("idProducto");

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

    const cargarResenias = () => {
        resenias.forEach(resenia => {
            const tr1 = document.createElement("tr");
            const thIcon = document.createElement("th");
            const thNombre = document.createElement("th");
            thNombre.innerHTML = resenia.usuarioDTO.nombre;
            tr1.appendChild(thIcon);
            tr1.appendChild(thNombre);

            const tr2 = document.createElement("tr");
            const tdRating = document.createElement("td");
            const tdEstrellitas = document.createElement("td");
            tdEstrellitas.innerHTML = resenia.rating;
            tr2.appendChild(tdRating);
            tr2.appendChild(tdEstrellitas);

            const tr3 = document.createElement("tr");
            const tdC = document.createElement("td");
            const tdComentario = document.createElement("td");
            tdComentario.innerHTML = resenia.comentario;
            tr3.appendChild(tdC);
            tr3.appendChild(tdComentario);

            tablaResenias.appendChild(tr1);
            tablaResenias.appendChild(tr2);
            tablaResenias.appendChild(tr3);
        });
    };

    init();
};