/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

/**
 *
 * @author Usuario
 */
public class ActicvidadProgramada {

    private int idActividad;
    private String comentario;
    public enum Estado {
    }

    public ActicvidadProgramada(int idActividad, String comentario) {
        this.idActividad = idActividad;
        this.comentario = comentario;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Acticvidad Programada{" + "Identificador=" + idActividad + ", Descripción=" + comentario + '}';
    }
    
    
}
