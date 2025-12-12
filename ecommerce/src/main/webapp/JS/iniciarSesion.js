const app = () => {

    const mostrarError = (mensaje) => {
        document.getElementById("mensaje-error").textContent = mensaje;
    };

    const login = async (correo, password) => {
        try {
            const res = await fetch('/ecommerce-1.0-SNAPSHOT/api/auth/login', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                credentials: 'include',
                body: JSON.stringify({ correo, password })
            });

            const data = await res.json();

            if (!res.ok) {
                mostrarError(data.error);
                return false;
            }

            return true; // Login correcto
        } catch(err) {
            mostrarError("Error de conexión");
            console.error(err);
            return false;
        }
    };

    const init = () => {
        const loginForm = document.getElementById("loginForm");

        loginForm.addEventListener("submit", async (e) => {
            e.preventDefault();

            const correo = document.getElementById("correo").value;
            const password = document.getElementById("password").value;

            const exito = await login(correo, password);
            if(exito){
                window.location.href = '/perfil.jsp';
            }
        });
    };

    init();
};

app();
