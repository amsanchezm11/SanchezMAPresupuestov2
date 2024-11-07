/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.albarregas.beans;

import java.io.Serializable;

/**
 *
 * @author alberto
 */
public class EleccionBean implements Serializable{
    private boolean edificio=false;
    private boolean contenido=false;

    public boolean isEdificio() {
        return edificio;
    }

    public void setEdificio(boolean edificio) {
        this.edificio = edificio;
    }

    public boolean isContenido() {
        return contenido;
    }

    public void setContenido(boolean contenido) {
        this.contenido = contenido;
    }
    
    
}
