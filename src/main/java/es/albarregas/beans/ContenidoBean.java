package es.albarregas.beans;

import java.io.Serializable;

/**
 *
 * @author alberto
 */
public class ContenidoBean implements Serializable{
    private boolean accidentes;
    private int cantAsegurada;
    private short franquicia;

    public boolean isAccidentes() {
        return accidentes;
    }

    public void setAccidentes(boolean accidentes) {
        this.accidentes = accidentes;
    }

    public int getCantAsegurada() {
        return cantAsegurada;
    }

    public void setCantAsegurada(int cantAsegurada) {
        this.cantAsegurada = cantAsegurada;
    }

    public short getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(short franquicia) {
        this.franquicia = franquicia;
    }

}
