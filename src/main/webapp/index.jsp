<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contexto" value="${pageContext.request.contextPath}" scope="application" />
<c:url var="estilo" value="/CSS/style.css" scope="application" />
<fmt:setLocale value="es_ES" scope="application" />
<!DOCTYPE html>
<html>
    <head>
        <c:import url="/INC/metas.inc"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${estilo}"/>
    </head>
    <body>
        <c:import url="/INC/cabecera.inc"/>

        <div>
            <h2>Seleccione su p&oacute;liza de seguro</h2>
        </div>
        <div class="contenedor-inicial">

            <form action="${contexto}/EleccionController" method="post" class="formulario-inicial">
                <div class="container-inputs">
                    <div>
                        <label class="label-inicio">¿Que tipo de seguro quiere?</label>
                    </div>
                    <div class="check-inicial">
                        <div><input type="checkbox" name="edificio" value="edificio" checked> Seguro de Edificio</div>
                        <div><input type="checkbox" name="contenido" value="contenido" checked> Seguro de Contenido</div>                      
                    </div>

                </div>
                <div class="container-botones">
                    <input type="submit" name="enviar" value="Enviar" class="boton">
                </div>
            </form>  
        </div>
        <c:import url="/INC/pie.inc"/>
    </body>
</html>
