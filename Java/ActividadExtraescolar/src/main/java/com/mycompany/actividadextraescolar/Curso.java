/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

/**
 *
 * @author atres
 */
public class Curso {
    private int codCurso;
    private int idCurso;
    private String descripcion;
    public Etapa etapa;
    public boolean activo;
    
    //Constructor por parámetros

    public Curso(int codCurso, int idCurso, String descripcion, Etapa etapa, boolean activo) {
        this.codCurso = codCurso;
        this.idCurso = idCurso;
        this.descripcion = descripcion;
        this.etapa = etapa;
        this.activo = activo;
    }
    //Metodos get

    public int getCodCurso() {
        return codCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public boolean isActivo() {
        return activo;
    }
    
    //Metodo que muestra datos

    @Override
    public String toString() {
        return "Curso{" + "codCurso=" + codCurso + ", idCurso=" + idCurso + ", descripcion=" + descripcion + ", etapa=" + etapa + ", activo=" + activo + '}';
    }
    
}
