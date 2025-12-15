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

        <title>Perfil</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacion.jspf" %>
        <main>
            <section>
                <div class="rectangulo-centro">
                    <form id="perfilForm">
                        <h1>Tu Perfil</h1>
                        <h3 class="perfil">
                            Nombre Completo
                            <c:if test="${mensajeNombre != null}">
                                <span class="mensaje">${mensajeNombre}</span>
                            </c:if>
                        </h3>
                        <input type="text" name="nombre" value="${nombre}" placeholder="${sessionScope.usuario.getNombre()}">
                        <h3 class="perfil">
                            Teléfono
                            <c:if test="${mensajeTelefono != null}">
                                <span class="mensaje">${mensajeTelefono}</span>
                            </c:if>
                        </h3>
                        <input type="text" name="telefono" value="${telefono}" placeholder="${sessionScope.usuario.getTelefono()}">
                        <h3 class="perfil">
                            Dirección
                            <c:if test="${mensajeDireccion != null}">
                                <span class="mensaje">${mensajeDireccion}</span>
                            </c:if>
                        </h3>
                        <input type="text" name="direccion" value="${direccion}" placeholder="${sessionScope.usuario.getDireccion()}">
                        <h3 class="perfil">
                            Correo Electrónico
                            <c:if test="${mensajeCorreo != null}">
                                <span class="mensaje">${mensajeCorreo}</span>
                            </c:if>
                        </h3>
                        <input type="email" name="correo" value="${correo}" placeholder="${sessionScope.usuario.getCorreo()}">
                        <h3 class="perfil">
                            Password
                            <c:if test="${mensajePassword != null}">
                                <span class="mensaje">${mensajePassword}</span>
                            </c:if>
                        </h3>
                        <h3 class="perfil">Nueva Contraseña</h3>
                        <input type="password"
                               name="password"
                               placeholder="Nueva contraseña (opcional)">

                        <h3 class="perfil">Confirmar Contraseña</h3>
                        <input type="password"
                               name="confirmPassword"
                               placeholder="Repite la nueva contraseña">

                        <div class="centro-botton">
                            <a href="#">Ver Historial</a>
                            <input type="submit" value="Modificar">
                            <button type="button" id="btn-cerrarSesion" class="cerrar-sesion">
                                Cerrar Sesión
                            </button>
                            <span id="mensaje-error"></span>
                        </div>
                    </form>
                </div> 
            </section>
        </main>
        <script src="JS/perfil.js"></script>
    </body>
</html>
