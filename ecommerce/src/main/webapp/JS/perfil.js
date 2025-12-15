const app = () => {

    /* ===============================
     EDITAR PERFIL
     ================================ */
    const editarPerfil = async (e) => {
        console.log("SI ENTRO A EDITAR PERFIL");

        e.preventDefault();

        const form = document.getElementById("perfilForm");
        const spnError = document.getElementById("mensaje-error");

        const data = {
            nombre: form.nombre.value,
            telefono: form.telefono.value,
            direccion: form.direccion.value,
            correo: form.correo.value,
            contrasenia: form.password.value || null
        };

        const password = form.password.value;
        const confirmPassword = form.confirmPassword.value;

    // Si uno está lleno, ambos deben coincidir
        if (password || confirmPassword) {
            if (password !== confirmPassword) {
                spnError.textContent = "Las contraseñas no coinciden";
                return;
            }
        }

        try {
            const res = await fetch(
                    "/api/usuario/perfil",
                    {
                        method: "PUT",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        credentials: "include",
                        body: JSON.stringify(data)
                    }
            );



            if (!res.ok) {
                throw new Error("Error al actualizar perfil");
            }

            const actualizado = await res.json();
            alert("Perfil actualizado correctamente");

        } catch (error) {
            console.error(error);
            spnError.textContent = "No se pudo actualizar el perfil";
        }
    };

    /* ===============================
     CERRAR SESIÓN
     ================================ */
    const cerrarSesion = async () => {
        const spnError = document.getElementById("mensaje-error");

        try {
            fetch("/api/auth/logout", {
                method: "POST",
                credentials: "include"
            });


            if (!res.ok) {
                throw new Error("Error al cerrar sesión");
            }

            window.location.replace("/index");

        } catch (error) {
            console.error(error);
            spnError.textContent = "No se pudo cerrar la sesión";
        }
    };

    /* ===============================
     INIT
     ================================ */
    const init = () => {
        const formPerfil = document.getElementById("perfilForm");
        const btnCerrarSesion = document.getElementById("btn-cerrarSesion");

        if (formPerfil) {
            formPerfil.addEventListener("submit", editarPerfil);
        }

        if (btnCerrarSesion) {
            btnCerrarSesion.addEventListener("click", cerrarSesion);
        }
    };

    init();
};

app();
