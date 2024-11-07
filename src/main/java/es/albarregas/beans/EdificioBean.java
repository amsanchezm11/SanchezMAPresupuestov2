package es.albarregas.beans;

import java.io.Serializable;

/**
 *
 * @author alberto
 */
public class EdificioBean implements Serializable{
    
    private TipoEdificio tipoEdificio;
    private byte numHabitaciones;
    private short fechaConstruccion;
    private TipoConstruccion tipoConstruccion;
    private int valorMercado;

    public TipoEdificio getTipoEdificio() {
        return tipoEdificio;
    }

    public void setTipoEdificio(TipoEdificio tipoEdificio) {
        this.tipoEdificio = tipoEdificio;
    }

    public byte getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(byte numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public short getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(short fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
    }

    public TipoConstruccion getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(TipoConstruccion tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public int getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(int valorMercado) {
        this.valorMercado = valorMercado;
    }
   
}
