<%-- 
    Document   : gestionarUsuarios
    Created on : 19 nov 2025, 18:54:38
    Author     : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/gestionarUsuarios.css"/>
        <link rel="stylesheet" href="CSS/navegacionAdmin.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacionAdmin.jspf"%>
        <main>
            <section id="seccion-usuarios">
                <h2>Gestionar Cuentas</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Nombre Completo</th>
                            <th>Correo Electronico</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.usuarios}" var="usuario" begin="0" end="${requestScope.usuarios.size()}">
                            <tr>
                                <td>${usuario.getNombre()}</td>
                                <td>${usuario.getCorreo()}</td>
                                <td>${usuario.getTelefono()}</td>
                                <td>${usuario.getDireccion()}</td>
                                <td><i class="fa-solid fa-trash"></i></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        </main>

    </body>
</html>
