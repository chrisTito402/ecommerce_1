<%-- 
    Document   : carrito
    Created on : 18 nov 2025, 23:33:55
    Author     : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/carrito.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
        <title>JSP Page</title>
    </head>
    
    <%@include file="FRAGMENTOS/navegacion.jspf"%>
    
    <body>
        <!-- CONTENIDO PRINCIPAL -->
        <main id="contenedor-carrito">
          <!-- Lista de productos -->
          <section class="lista-productos">
              <c:forEach items="${sessionScope.usuario.getCarrito().obtenerCarrito()}" var="producto" begin="0" end="${sessionScope.usuario.getCarrito().obtenerCarrito().size()}">
                    <div class="producto">
                      <img src="${producto.getRutaImg()}" alt="Por que la Demora">
                      <div class="info">
                        <p class="nombre">${producto.getNombre()}</p>
                        <!--<p>Unidades: <input type="number" value="1" min="1"></p>-->
                        <p class="precio">$${producto.getPrecio()}</p>
                      </div>
                    </div>
                </c:forEach>
          </section>
          <!-- Resumen compra -->
          <aside class="resumen-compra">
            <h2>Total</h2>
                <c:forEach items="${sessionScope.usuario.getCarrito().obtenerCarrito()}" var="producto" begin="0" end="${sessionScope.usuario.getCarrito().obtenerCarrito().size()}">
                    <p>${producto.getNombre()}<strong>$${producto.getPrecio()}</strong></p>
                </c:forEach>
            <hr>
            <p>Subtotal: <strong>${sessionScope.usuario.getCarrito().getTotal()}</strong></p>
            <p>Envío: <strong>$50</strong></p>
            <p><strong>Total: ${sessionScope.usuario.getCarrito().getTotal()}</strong></p>
            <button id="btnCompra">Realizar Compra</button>
          </aside>
        </main>
    </body>
</html>
