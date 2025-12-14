const app = () => {

    const logout = async () => {
        try {
            const res = await fetch('/ecommerce-1.0-SNAPSHOT/api/auth/logout', {
                method: 'POST',
                credentials: 'include'
            });

            if(res.ok){
                window.location.href = '/index';
            } else {
                alert('Error al cerrar sesión');
            }
        } catch(err) {
            console.error(err);
            alert('Error de conexión');
        }
    };

    const init = () => {
        const perfilForm = document.getElementById("perfilForm");
        perfilForm.addEventListener("click", (e) => {
            e.preventDefault();
            logout();
        });
    };

    init();
};

//app();
