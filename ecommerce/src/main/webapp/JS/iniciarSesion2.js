window.onload = () => {
    const host = "http://localhost:8080/api";
    const inpCorreo = document.getElementById("correo");
    const inpPassword = document.getElementById("password");
    const btnIniciarSesion = document.getElementById("btn-iniciarSesion");

    const init = () => {
        btnIniciarSesion.onclick = iniciarSesion;
    };

    const iniciarSesion = () => {
        const correo = inpCorreo.value;
        const contrasenia = inpPassword.value;
        const usuario = {
            correo: correo,
            contrasenia: contrasenia
        };

        fetch(
            host + "/usuario",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(usuario)
            }
        ).then(response => {
            if (!response.ok) {
                throw new Error("Error al iniciar sesión.");
            }
            return response.json();
        }).then(usuarioDTO => {
            console.log("El usuario inicio sesión.");
            window.location.replace("/index");
        }).catch(err => {
            console.error(err);
        });
    };

    init();
};