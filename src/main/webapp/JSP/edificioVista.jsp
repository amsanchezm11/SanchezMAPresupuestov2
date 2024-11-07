<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <div>
            <h2>Poliza de Edificio</h2>
        </div>

        <form action="${contexto}/EdificioController" method="post" class="container-vista">
            <div class="container-inputs">
                <div>
                    <label for="tipoEdificio">Tipo de edificio:</label>
                    <select name="tipoEdificio">
                        <option value="PISO">Piso</option>
                        <option value="CASA">Casa</option>
                        <option value="ADOSADO">Adosado</option>
                        <option value="DUPLEX">Duplex</option>
                        <option value="CHALET">Chalet</option>
                    </select>
                </div>
                <div>
                    <label for="numHabitaciones">Numero de habitaciones:</label>
                    <select name="numHabitaciones">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">Más de 4</option>
                    </select>
                </div>
                <div class="container-construccion">
                    <label for="tipoConstruccion">Tipo Construcci&oacute;n:</label>
                    <div>
                        <input type="radio" name="tipoConstruccion" value="MADERA"> Madera
                    </div>
                    <div>
                        <input type="radio" name="tipoConstruccion" value="HORMIGON" checked> Hormig&oacute;n
                    </div>
                </div>
                <div>
                    <label>Año de construcci&oacute;n:</label>
                    <select name="fechaConstruccion">
                        <option value="1949">Anterior a 1950</option>
                        <option value="1950">Entre 1950 y 1990</option>
                        <option value="1991">Entre 1991 y 2005</option>
                        <option value="2006">Entre 2006 y 2015</option>
                        <option value="2016">Posterior a 2015</option>
                    </select>
                </div>
                <div>
                    <label for="valorMercado">Valor estimado del mercado:</label>
                    <select name="valorMercado">
                        <option value="25000">Menos de 50.000</option>
                        <option value="50001">Entre 50.001 y 80.000</option>
                        <option value="80001">Entre 80.001 y 100.000</option>
                        <option value="100001">Entre 100.001 y 150.000</option>
                        <option value="125000">Más de 150.000</option>
                    </select>
                </div>
            </div>
            <div class="container-botones">
                <input type="submit" name="enviar" value="Enviar" class="boton">
            </div>
        </form>
        <c:import url="/INC/pie.inc"/>
    </body>
</html>
