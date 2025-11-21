<%-- 
    Document   : detallesProducto
    Created on : 19 nov 2025, 23:02:18
    Author     : janot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/detallesProducto.css"/>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="FRAGMENTOS/navegacion.jspf"%>
        <main>
            <section id="seccion-producto" class="ordenar">
                <div class="rectangulo-centro">
                    <img src="${requestScope.fichaDetallada.getProductoDTO().getRutaImg()}" alt="Portada">
                    <h2>${requestScope.fichaDetallada.getProductoDTO().getEstrellas()} Stars</h2>
                    <div>
                        <h1>${requestScope.fichaDetallada.getProductoDTO().getNombre()}</h1>
                        <p>${requestScope.fichaDetallada.getDescripcion()}</p>
                    </div>
                </div>
            </section>
            <section id="seccion-comentarios" class="ordenar">
                <div class="comentarios">
                    <table>
                        <c:forEach items="${requestScope.resenias}" var="resenia" begin="0" end="${requestScope.resenias.size()}">
                            <tr>
                                <th>Icon</th>
                                <th>${resenia.getUsuarioDTO().getNombre()}</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td>${resenia.getRating()} Estrellitas</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>${resenia.getComentario()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="tuComentario">
                    <form action="/publicarComentario?idProducto=${requestScope.fichaDetallada.getProductoDTO().getIdProducto()}" method="post">
                        <input id="textfield" type="text" placeholder="Escribe tu opinión..." name="comentario">
                        <input id="boton" type="submit" value="Publicar"></input>
                    </form>
                </div>
            </section>
        </main>
    </body>
</html>
