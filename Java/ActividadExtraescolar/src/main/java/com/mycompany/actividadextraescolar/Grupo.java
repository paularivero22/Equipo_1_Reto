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

   /**
    * CONSTRUCTOR POR PARÁMETROS QUE PIDE IDGRUPO
    * @param idGrupo
    * @param codGrupo
    * @param idcurso
    * @param numeroAlumnos
    * @param activo 
    */
    public Grupo(int idGrupo, String codGrupo, int idcurso, int numeroAlumnos, boolean activo) {
        this.idGrupo = idGrupo;
        this.codGrupo = codGrupo;
        this.idcurso = idcurso;
        this.numeroAlumnos = numeroAlumnos;
        this.activo = activo;
    }
    
    /**
     * CONSTRUCTOR POR PARÁMETROS QUE NO PIDE IDGRUPO
     * @param codGrupo
     * @param idcurso
     * @param numeroAlumnos
     * @param activo 
     */

    public Grupo(String codGrupo, int idcurso, int numeroAlumnos, boolean activo) {
        this.codGrupo = codGrupo;
        this.idcurso = idcurso;
        this.numeroAlumnos = numeroAlumnos;
        this.activo = activo;
    }
    
    /**
     * METODOS GET Y SET
     * @return 
     */
    
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
    
    /**
     * METODO QUE DEVUELVE LA INFORMACIÓN DE UN GRUPO
     * @return 
     */
    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", codGrupo=" + codGrupo + ", idcurso=" + idcurso + ", numeroAlumnos=" + numeroAlumnos + ", activo=" + activo + '}';
    }

    

    

   
    
    
    
}
