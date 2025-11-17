<%-- 
    Document   : iniciarSesion
    Created on : 11 nov 2025, 02:04:56
    Author     : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/iniciarSesion.css">
    <title>Iniciar Sesion</title>
</head>
<body>
    <main>
        <section id="seccion-formulario">
            <a href="#"><img src="../IMGS/Vinylia.png" alt=""></a>
            <h2>Inicio de Sesion</h2>
            <form action="/autenticacion" method="post">
                <div class="correo">
                    <label for="">Correo Electronico</label>
                    <input type="email" name="correo">
                </div>
                <div class="contraseña">
                    <label for="">Contraseña</label>
                    <input type="password" name="password">
                </div>
                <div class="iniciar-sesion">
                    <input type="submit" value="Iniciar Sesion">
                </div>
            </form>
            <a href="../html/registrarte.html">Registrarte</a>
        </section>
    </main>
</body>
</html>
