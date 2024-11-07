<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h2>Poliza de Contenido</h2>
        </div>

        <form action="${contexto}/ContenidoController" method="post" class="container-vista">
            <div class="container-inputs">
                <div>
                    <label for="accidentes">Cubrir daños accidentales:</label>
                    <input type="checkbox" name="accidentes">
                </div>
                <div>
                    <label for="cantAsegurada">Cantidad que quiere asegurar:</label>
                    <select name="cantAsegurada">
                        <option value="10000">10.000</option>
                        <option value="20000">20.000</option>
                        <option value="30000">30.000</option>
                        <option value="50000">50.000</option>
                        <option value="100000">100.000</option>
                    </select>
                </div>
                <div class="input-franquicia">
                    <div>
                        <label for="franquicia">Franquicia:</label> 
                    </div>
                   
                    <div class="container-franquicia">
                        <div>
                            <input type="radio" name="franquicia" value="0" checked="">Ninguna
                        </div>
                        <div>
                            <input type="radio" name="franquicia" value="500">500
                        </div>
                        <div>
                            <input type="radio" name="franquicia" value="1000">1.000
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-botones">
                <input type="submit" name="enviar" value="Enviar" class="boton">
            </div>
        </form>       
        <c:import url="/INC/pie.inc"/>
    </body>
</html>
