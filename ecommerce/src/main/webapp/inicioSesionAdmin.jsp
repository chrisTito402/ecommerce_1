<%-- 
    Document   : inicioSesionAdmin
    Created on : 19 nov 2025, 16:43:27
    Author     : janot
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="CSS/iniciarSesionAdmin.css">
        <title>JSP Page</title>
    </head>
    <body>
        <main>
            <section id="seccion-formulario">
                <a href="/index"><img src="IMGS/Vinylia.png" alt=""></a>
                <h2>Administrador</h2>
                <form action="/admin" method="post">
                    <div class="correo">
                        <label for="">Correo Electronico</label>
                        <input type="email"name="correo">
                    </div>
                    <div class="contraseña">
                        <label for="">Contraseña</label>
                        <input type="password" name="password">
                    </div>
                    <div class="iniciar-sesion">
                        <input type="submit" value="Iniciar Sesion">
                    </div>
                </form>
            </section>
        </main>
    </body>
</html>
