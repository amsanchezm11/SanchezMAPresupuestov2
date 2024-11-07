package es.albarregas.models;

import es.albarregas.beans.ContenidoBean;
import es.albarregas.beans.EdificioBean;
import java.text.NumberFormat;

/**
 *
 * @author alberto
 */
public class CalcularCuota {

    private double totalEdificio;
    private double totalContenido;

    public double getTotalEdificio() {
        return totalEdificio;
    }

    public void setTotalEdificio(double totalEdificio) {
        this.totalEdificio = totalEdificio;
    }

    public double getTotalContenido() {
        return totalContenido;
    }

    public void setTotalContenido(double totalContenido) {
        this.totalContenido = totalContenido;
    }

    // CREAMOS UN METODO PERSONALIZADO PARA OBTENER EL TOTAL DEL SEGURO DE EDIFICIO YA FORMATEADO
    public String getTotalEdificioFormateado() {
        NumberFormat formatoImporte = NumberFormat.getNumberInstance();
        formatoImporte.setMaximumFractionDigits(2);
        formatoImporte.setMinimumFractionDigits(2);

        return formatoImporte.format(this.totalEdificio);
    }

    // CREAMOS UN METODO PERSONALIZADO PARA OBTENER EL TOTAL DEL SEGURO DE CONTENIDO YA FORMATEADO
    public String getTotalContenidoFormateado() {
        NumberFormat formatoImporte = NumberFormat.getNumberInstance();
        formatoImporte.setMaximumFractionDigits(2);
        formatoImporte.setMinimumFractionDigits(2);

        return formatoImporte.format(this.totalContenido);
    }

    // CREAMOS UN METODO PERSONALIZADO PARA OBTENER EL TOTAL YA FORMATEADO
    public String getTotalConjuntoFormateado() {

        NumberFormat formatoImporte = NumberFormat.getNumberInstance();
        formatoImporte.setMaximumFractionDigits(2);
        formatoImporte.setMinimumFractionDigits(2);
        
        return formatoImporte.format(this.totalEdificio + this.totalContenido);
    }

    public void calcularCuotaEdificio(EdificioBean edificio) {
        double prima;
        double tipoEdificio = 0;
        double tipoConstruccion = 0;
        double fechaConstruccion = 0;

        // CALCULAMOS LA CUOTA BÁSICA
        double cuotaBasica = edificio.getValorMercado() * 0.005;

        // DEPENDIENDO DEL TIPO DE EDIFICIO MULTIPLICAREMOS LA CUOTA BASICA POR UNO DE LOS SIGUIENTES VALORES PARA OBTENER LA PRIMA
        switch (edificio.getTipoEdificio()) {
            case PISO:
                tipoEdificio = 0.95;
                break;
            case CASA:
                tipoEdificio = 1.00;
                break;
            case ADOSADO:
                tipoEdificio = 1.05;
                break;
            case DUPLEX:
                tipoEdificio = 1.10;
                break;
            case CHALET:
                tipoEdificio = 1.20;
                break;
            default:
                throw new AssertionError();
        }
        // CALCULO INICIAL DE LA PRIMA POR TIPO DE EDIFICIO 
        prima = cuotaBasica * tipoEdificio;
        // CALCULO POR EL NUMERO DE HABITACIONES
        prima += edificio.getNumHabitaciones() * (prima / 100);
        switch (edificio.getFechaConstruccion()) {
            case 1949:
                fechaConstruccion = 0.09;
                break;
            case 1950:
                fechaConstruccion = 0.06;
                break;
            case 1991:
                fechaConstruccion = 0.04;
                break;
            case 2006:
                fechaConstruccion = 0.02;
                break;
            case 2016:
                fechaConstruccion = 0.01;
                break;
            default:
                throw new AssertionError();
        }
        // CALCULO POR FECHA DE CONSTRUCCION
        prima += fechaConstruccion * prima;
        // DEPENDIENDO DEL TIPO DE CONSTRUCCION MULTIPLICAREMOS LA PRIMA POR UNO DE LOS SIGUIENTES VALORES
        switch (edificio.getTipoConstruccion()) {
            case MADERA:
                tipoConstruccion = 0.1;
                break;
            case HORMIGON:
                tipoConstruccion = 0;
                break;
            default:
                throw new AssertionError();
        }
        //CALCULO POR TIPO DE CONSTRUCCION
        prima += prima * tipoConstruccion;
        // FINALMENTE AÑADIMOS EL RESULTADO AL ATRIBUTO TOTAL EDIFICIO
        totalEdificio = prima;
    }

    public void calcularCuotaContenido(ContenidoBean contenido) {
        //ContenidoBean contenido = new ContenidoBean();
        // CALCULAMOS LA PRIMA POR EL CAPITAL ASEGURADO
        double primaContenido = contenido.getCantAsegurada() * 0.008;
        // CALCULAMOS SI HA MARCADO QUE SI QUIERE QUE LE CUBRAN DAÑOS ACCIDENTALES        
        if (contenido.isAccidentes()) {
            primaContenido = primaContenido * 1.25;
        }
        // CACULAMOS LA PRIMA CON FRANQUICIA

        if (contenido.getFranquicia() == 500) {
            primaContenido -= primaContenido * 0.1;
        } else if (contenido.getFranquicia() == 1000) {
            primaContenido -= primaContenido * 0.2;
        }

        totalContenido = primaContenido;
    }

}
