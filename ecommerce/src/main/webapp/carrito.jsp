<%--
    Document : carrito
    Created on : 18 nov 2025, 23:33:55
    Author : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/carrito.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
        <script src="./JS/carrito.js"></script>
        <title>Vinylia - Carrito</title>
    </head>

    <%@include file="FRAGMENTOS/navegacion.jspf"%>

    <body>
        <main id="contenedor-carrito">
            
            <%-- Variable para calcular el Subtotal total a lo largo del JSP --%>
            <c:set var="subtotal" value="${0}" />
            <c:set var="costoEnvio" value="${50.00}" /> <%-- Envío fijo --%>

            <section class="lista-productos">
                
                <c:choose>
                    <c:when test="${empty itemsCarrito}">
                        <div class="mensaje-vacio">
                            <p>¡Tu carrito está vacío!</p>
                            <p>Explora nuestro <a href="${pageContext.request.contextPath}/catalogo">catálogo</a> para agregar productos.</p>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <%-- Iteramos sobre la lista de entidades Carrito1 adjuntada por el Servlet --%>
                        <c:forEach items="${itemsCarrito}" var="item">
                            <c:set var="precioItem" value="${item.producto.precio * item.cantidad}" />
                            
                            <div class="producto">
                                <%-- NOTA: Asumimos que la entidad Producto tiene getRutaImg() --%>
                                <img src="${item.producto.rutaImg}" alt="${item.producto.nombre}">
                                
                                <div class="info">
                                    <p class="nombre">${item.producto.nombre}</p>
                                    <p>Unidades: 
                                        <input type="number" value="${item.cantidad}" min="1" disabled style="width: 50px;">
                                    </p>
                                    <p class="precio">Precio Unitario: **$${item.producto.precio}**</p>
                                    <p class="subtotal-item">Subtotal: **$${precioItem}**</p>
                                </div>
                                
                                <button class="btn-eliminar" data-id-carrito="${item.id}"> 
                                    <i class="fa fa-trash"></i>
                                </button>
                                </div>
                            
                            <%-- Acumulamos el subtotal --%>
                            <c:set var="subtotal" value="${subtotal + precioItem}" />
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </section>
            
            <aside class="resumen-compra">
                <h2>Total</h2>
                
                <hr>
                
                <%-- Iteramos de nuevo para la lista detallada del resumen --%>
                <c:forEach items="${itemsCarrito}" var="item">
                    <c:set var="precioItem" value="${item.producto.precio * item.cantidad}" />
                    <p>${item.producto.nombre} (${item.cantidad}u) 
                        <strong>$${precioItem}</strong>
                    </p>
                </c:forEach>
                
                <hr>
                
                <p>Subtotal: <strong>$${subtotal}</strong></p>
                <p>Envío: <strong>$${costoEnvio}</strong></p>
                
                <c:set var="totalFinal" value="${subtotal + costoEnvio}" />
                <p><strong>Total: $${totalFinal}</strong></p>
                
                <c:choose>
                    <%-- Solo mostramos el botón si hay items en el carrito --%>
                    <c:when test="${not empty itemsCarrito}">
                        <button id="btnCompra">Realizar Compra</button>
                    </c:when>
                    <c:otherwise>
                        <button id="btnCompra" disabled>Carrito Vacío</button>
                    </c:otherwise>
                </c:choose>
            </aside>
        </main>
    </body>
</html>