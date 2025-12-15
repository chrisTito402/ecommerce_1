<%-- 
    Document   : historialPedidos
    Created on : 14 dic 2025, 10:52:49 p.m.
    Author     : Angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./CSS/historialPedidos.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
        <script src="./JS/historialPedidos.js"></script>
        <title>Vinylia - Historial de Pedidos</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacion.jspf"%>
        <main>
            <section>
                <div class="rectangulo-centro" id="rectangulo-centro">
                    <h1>Historial de Pedidos</h1>
                    <section class="lista-productos">
                        <c:forEach items="${sessionScope.usuario.getCarrito().obtenerCarrito()}" var="producto" begin="0" end="${sessionScope.usuario.getCarrito().obtenerCarrito().size()}">
                            <div class="producto">
                                <img src="${producto.getRutaImg()}" alt="${producto.getNombre()}">
                                <div class="info">
                                    <p class="nombre">${producto.getNombre()}</p>
                                    <p class="cantidad">Unidades: #</p>
                                    <p class="fecha">Fecha de Compra: DD/MM/YYYY</p>
                                    <p class="estado">Pendiente</p>
                                    <p class="precio">$${producto.getPrecio()}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </section>
                </div> 
            </section>
        </main>
    </body>
</html>
