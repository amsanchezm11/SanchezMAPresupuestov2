<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="/INC/metas.inc"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
    </head>
    <body>
        <c:import url="/INC/cabecera.inc"/>
        <div class="container-resumen">
            <div class="resumen-h2">
                <h2>Resumen de la p&oacute;liza:</h2>
            </div>
            <div class="resumen-seguro">
                 <div ${sessionScope.edificio == null? "hidden":""}>
                    <h2>Seguro Edificio:</h2>
                    <ul>
                        <li>Tipo Edificio:  ${sessionScope.edificio.tipoEdificio}</li>
                        <li>N&uacute;mero de habitaciones: ${sessionScope.edificio.numHabitaciones}</li>
                        <li>Fecha de Construcci&oacute;n: ${sessionScope.edificio.fechaConstruccion}</li>
                        <li>Tipo de Construcci&oacute;n: ${sessionScope.edificio.tipoConstruccion}</li>
                        <li>Valor del Mercado: <fmt:formatNumber type="currency" value="${sessionScope.edificio.valorMercado}"/></li>
                        <li>Total Prima Edificio: <fmt:formatNumber type="currency" value="${sessionScope.calcularEdificio.totalEdificio}"/></li>
                    </ul>
                </div> 
                               
                <div ${sessionScope.contenido == null? "hidden":""}>
                    <h2>Seguro Contenido:</h2>
                    <ul>
                        <li>Tipo Edificio: ${sessionScope.contenido.accidentes == true? "S&iacute;":"No"}</li>
                        <li>Cantidad Asegurada: <fmt:formatNumber type="currency" value="${sessionScope.contenido.cantAsegurada}"/></li>
                        <li>Franquicia: ${sessionScope.contenido.franquicia == 0? "Ninguna": sessionScope.contenido.franquicia}</li>
                        <li>Total Prima Contenido: <fmt:formatNumber type="currency" value="${sessionScope.calcularContenido.totalContenido}"/></li>
                    </ul>
                </div>               
            </div>

            <div>
                <h2>Total Seguro: <fmt:formatNumber type="currency" value="${sessionScope.calcularEdificio.totalEdificio+sessionScope.calcularContenido.totalContenido}"/></h2>
            </div>
            <div>
                <form action="${contexto}/EleccionController" method="post">
                    <input type="submit" name="volver" value="Volver" class="boton">
                </form>
            </div>
        </div>
        <c:import url="/INC/pie.inc"/>
    </body>
</html>
