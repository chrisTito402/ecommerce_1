<%-- 
    Document   : registrarte
    Created on : 17 nov 2025, 18:04:23
    Author     : janot
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/registrarte.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <main>
            <section id="seccion-formulario">
                <a href="../html/index.html"><img src="IMGS/Vinylia.png" alt=""></a>
                <h2>Registrarte</h2>
                <form action="/registrarte" method="post">
                    <div class="nombre">
                        <label for="">
                            Nombre Completo                         
                            <c:if test="${mensajeNombre != null}">
                                <span id="mensaje">${mensajeNombre}</span>
                            </c:if>
                        </label>
                        <input type="text" name="nombre" value="${nombre}">
                    </div>
                    <div class="telefono">
                        <label for="">
                            Telefono
                            <c:if test="${mensajeTelefono != null}">
                                <span id="mensaje">${mensajeTelefono}</span>
                            </c:if>
                        </label>
                        <input type="tel" name="telefono" value="${telefono}">
                    </div>
                    <div class="direccion">
                        <label for="">
                            Direccion
                            <c:if test="${mensajeDireccion != null}">
                                <span id="mensaje">${mensajeDireccion}</span>
                            </c:if>
                        </label>
                        <input type="text" name="direccion" value="${direccion}">
                    </div>
                    <div class="correo">
                        <label for="">
                            Correo Electronico
                            <c:if test="${mensajeCorreo != null}">
                                <span id="mensaje">${mensajeCorreo}</span>
                            </c:if>
                        </label>
                        <input type="email" name="correo" value="${correo}">
                    </div>
                    <div class="contraseña">
                        <label for="">
                            Contraseña
                            <c:if test="${mensajePassword != null}">
                                <span id="mensaje">${mensajePassword}</span>
                            </c:if>
                        </label>
                        <input type="password" name="password" value="${password}">
                    </div>
                    <div class="registrarte">
                        <input type="submit" value="Registrarte">
                    </div>
                </form>
                <a href="/iniciarSesion">Iniciar Sesion</a>
            </section>
        </main>
    </body>
</html>
