<%-- 
    Document   : iniciarSesion
    Created on : 11 nov 2025, 02:04:56
    Author     : janot
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/iniciarSesion.css">
    <script src="./JS/iniciarSesion.js"></script>
    <title>Iniciar Sesión</title>
</head>
<body>
    <main>
        <section id="seccion-formulario">
            <a href="/index"><img src="../IMGS/Vinylia.png" alt=""></a>
            <h2>Inicio de Sesión</h2>
            <form id="loginForm">
                <div class="correo">
                    <label for="">Correo Electronico</label>
                    <input type="email" name="correo" id="correo">
                </div>
                <div class="contraseña">
                    <label for="">Contraseña</label>
                    <input type="password" name="password" id="password">
                </div>
                <div class="iniciar-sesion">
                    <input type="button" value="Iniciar Sesion" id="btn-iniciarSesion">
                </div>
            </form>
            <span id="mensaje-error"></span>
            <a href="/registrarte">Registrarte</a>
        </section>
    </main>
</body>
</html>
