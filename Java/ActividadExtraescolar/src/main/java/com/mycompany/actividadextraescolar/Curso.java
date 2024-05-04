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
    private int idCurso;
    private String codCurso;
    private String descripcion;
    public Etapa etapa;
    public boolean activo;
    
    //Constructor por parámetros

    public Curso(int idCurso, String codCurso, String descripcion, Etapa etapa, boolean activo) {
        this.idCurso = idCurso;
        this.codCurso = codCurso;
        this.descripcion = descripcion;
        this.etapa = etapa;
        this.activo = activo;
    }

    
    //Metodos get

    public String getCodCurso() {
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
