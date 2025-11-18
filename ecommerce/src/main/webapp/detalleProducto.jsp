<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Vinylya - Detalle Producto</title>
    <link rel="stylesheet" href="CSS/detalleProducto.css">
</head>
<body>

<header>
    <div class="logo">Catálogo</div>
    <div class="cuenta">
        <span>Cuenta</span>
        <span>🛒 3</span>
    </div>
</header>

<div class="contenedor">
    <div class="card">
        <img src="${producto.rutaImg}" alt="Album Cover">

        <div>
            <h2>${producto.nombre}</h2>

            <p>${detalle.descripcion}</p>

            <strong>${producto.estrellas} stars</strong>
        </div>
    </div>

    <c:forEach var="resenia" items="${resenias}">
        <div class="comentario">
            <div class="usuario">
                <span>👤</span> ${resenia.usuarioCorreo}
            </div>
            <div class="texto-coment">
                ${resenia.comentario}
            </div>
            <div class="rating">
                Puntuación: ${resenia.rating} ⭐
            </div>
        </div>
    </c:forEach>

    <form method="post" action="publicarComentario.jsp">
        <input type="text" name="opinion" class="input-opinion" placeholder="Escribe tu opinión...">
        <button class="btn-publicar">Publicar</button>
    </form>
</div>

</body>
</html>