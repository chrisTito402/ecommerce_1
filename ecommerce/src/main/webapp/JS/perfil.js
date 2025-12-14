window.onload = () => {
    const host = "http://localhost:8080/api";
    const btnCerrarSesion = document.getElementById("btn-cerrarSesion");
    const spnError = document.getElementById("mensaje-error");

    const init = () => {
        btnCerrarSesion.onclick = cerrarSesion;
    };

    const cerrarSesion = () => {
        fetch(
            host + "/auth/logout",
            {
                method: "POST",
                credentials: "include"
            }
        )
        .then(response => {
            if (!response.ok) {
                throw new Error("Error al cerrar sesión.");
            }
            return response.json();
        })
        .then(data => {
            console.log("Sesión cerrada");
            window.location.replace("/index");
        })
        .catch(err => {
            spnError.innerHTML = "Error al cerrar sesión";
            console.error(err);
        });
    };

    init();
};