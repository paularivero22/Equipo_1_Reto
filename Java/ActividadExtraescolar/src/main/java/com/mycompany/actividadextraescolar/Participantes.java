/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

/**
 *
 * @author atres
 */
public class Participantes {
    public int idActividad;
    public int idCurso;
    public int idGrupo;
    public int participantes;
    
    //Constructor por parámetros

    public Participantes(int idActividad, int idCurso, int idGrupo, int participantes) {
        this.idActividad = idActividad;
        this.idCurso = idCurso;
        this.idGrupo = idGrupo;
        this.participantes = participantes;
    }
    
    //Metodos get

    public int getIdActividad() {
        return idActividad;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public int getParticipantes() {
        return participantes;
    }
    
    //Metodo que muestra datos

    @Override
    public String toString() {
        return "Participantes{" + "idActividad=" + idActividad + ", idCurso=" + idCurso + ", idGrupo=" + idGrupo + ", participantes=" + participantes + '}';
    }
    
}
