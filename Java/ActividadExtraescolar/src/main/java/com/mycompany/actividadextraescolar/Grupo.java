/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

/**
 *
 * @author atres
 */
public class Grupo {
    private int idGrupo;
    private String codGrupo;
    private int idcurso;
    public int numeroAlumnos;
    public boolean activo;

    //Constructor por parámetros

    public Grupo(int idGrupo, String codGrupo, int idcurso, int numeroAlumnos, boolean activo) {
        this.idGrupo = idGrupo;
        this.codGrupo = codGrupo;
        this.idcurso = idcurso;
        this.numeroAlumnos = numeroAlumnos;
        this.activo = activo;
    }
    
    //Metodos get
    
    public int getIdGrupo() {
        return idGrupo;
    }

    public String getCodGrupo() {
        return codGrupo;
    }

    public int getIdcurso() {
        return idcurso;
    }

   

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public boolean isActivo() {
        return activo;
    }
    
    //Metodo que muestra datos

    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", codGrupo=" + codGrupo + ", idcurso=" + idcurso + ", numeroAlumnos=" + numeroAlumnos + ", activo=" + activo + '}';
    }

    

    

   
    
    
    
}
