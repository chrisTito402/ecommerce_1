<%-- 
    Document   : pago
    Created on : 15 dic 2025, 11:38:20 a.m.
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vinylia - Pago</title>

    <link rel="stylesheet" href="CSS/pago.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <script defer src="JS/pago.js"></script>
</head>

<body>
    <%@include file="FRAGMENTOS/navegacion.jspf"%>

    <main class="contenedor-pago">

        <!-- RESUMEN -->
        <section class="resumen-pedido">
            <h2>Resumen del pedido</h2>

            <c:forEach items="${sessionScope.usuario.getCarrito().obtenerCarrito()}" var="producto">
                <div class="item">
                    <span>${producto.nombre}</span>
                    <strong>$${producto.precio}</strong>
                </div>
            </c:forEach>

            <hr>

            <p>Subtotal: <strong>$${sessionScope.usuario.getCarrito().getTotal()}</strong></p>
            <p>Envío: <strong>$50</strong></p>
            <p class="total">Total:
                <strong>$${sessionScope.usuario.getCarrito().getTotal() + 50}</strong>
            </p>
        </section>

        <!-- FORMULARIO DE PAGO -->
        <section class="formulario-pago">
            <h2>Método de pago</h2>

            <form id="formPago">

                <label>
                    <input type="radio" name="metodoPago" value="TARJETA" checked>
                    Tarjeta de crédito / débito
                </label>

                <div class="tarjeta">
                    <input type="text" name="numeroTarjeta" placeholder="Número de tarjeta" required>
                    <input type="text" name="nombreTitular" placeholder="Nombre del titular" required>

                    <div class="fila">
                        <input type="text" name="fecha" placeholder="MM/AA" required>
                        <input type="text" name="cvv" placeholder="CVV" required>
                    </div>
                </div>

                <label>
                    <input type="radio" name="metodoPago" value="EFECTIVO">
                    Pago contra entrega
                </label>

                <button type="submit" class="btn-pagar">
                    Confirmar compra
                </button>

                <p id="mensaje-error" class="error"></p>

            </form>
        </section>

    </main>

</body>
</html>
