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
    private String codGrupo;
    private Curso curso;
    public int numeroAlumnos;
    public boolean activo;

    //Constructor por parámetros
    public Grupo(String codGrupo, Curso curso, int numeroAlumnos, boolean activo) {
        this.codGrupo = codGrupo;
        this.curso = curso;
        this.numeroAlumnos = numeroAlumnos;
        this.activo = activo;
    }
    //Metodos get

    public String getCodGrupo() {
        return codGrupo;
    }

    public Curso getCurso() {
        return curso;
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
        return "Grupo{" + "codGrupo=" + codGrupo + ", curso=" + curso + ", numeroAlumnos=" + numeroAlumnos + ", activo=" + activo + '}';
    }
    
    
}
