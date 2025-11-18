<%-- 
    Document   : perfil
    Created on : 18 nov 2025, 02:08:16
    Author     : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <link rel="stylesheet" href="CSS/perfil.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacion.jspf" %>
        <main>
            <section>
                <div class="rectangulo-centro">
                    <h1>Tu Perfil</h1>
                    <h3 class="perfil">Nombre Completo</h3>
                    <input type="text" placeholder=${sessionScope.usuario.getNombre()}>
                    <h3 class="perfil">Teléfono</h3>
                    <input type="text" placeholder=${sessionScope.usuario.getTelefono()}>
                    <h3 class="perfil">Dirección</h3>
                    <input type="text" placeholder=${sessionScope.usuario.getDireccion()}>
                    <h3 class="perfil">Correo Electrónico</h3>
                    <input type="email" placeholder=${sessionScope.usuario.getCorreo()}>
                    <h3 class="perfil">Password</h3>
                    <input type="password" placeholder=${sessionScope.usuario.getContraseña()}>
                    <div class="centro-botton">
                        <button href="../html/historialPedidos.html">Ver Historial</button>
                        <button href="../html/editarPerfil.html">Modificar</button>
                        <a class="cerrar-sesion" href="/cerrarSesion">Cerrar Sesión</a>
                    </div>
                </div>
            </section>
        </main>
    </body>
</html>
