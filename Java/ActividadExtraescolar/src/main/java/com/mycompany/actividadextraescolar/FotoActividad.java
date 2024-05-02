/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

/**
 *
 * @author Usuario
 */
public class FotoActividad {
    private Actividad actvidad;
    private String URL;
    private String descripcion;

    public FotoActividad(Actividad actvidad, String URL, String descripcion) {
        this.actvidad = actvidad;
        this.URL = URL;
        this.descripcion = descripcion;
    }

    public Actividad getActvidad() {
        return actvidad;
    }

    public void setActvidad(Actividad actvidad) {
        this.actvidad = actvidad;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Foto Actividad{" + "Actvidad=" + actvidad + ", URL=" + URL + ", Descripción=" + descripcion + '}';
    }
    
    
    
}
