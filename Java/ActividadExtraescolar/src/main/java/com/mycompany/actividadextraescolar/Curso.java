/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.util.Objects;

/**
 *
 * @author atres
 */
public class Curso implements Comparable<Curso> {
    private int idCurso;
    private String codCurso;
    private String descripcion;
    public Etapa etapa;
    public boolean activo;
    
    /**
     * CONSTRUCTOR POR PARAMETROS CON IDCURSO 
     * @param idCurso
     * @param codCurso
     * @param descripcion
     * @param etapa
     * @param activo 
     */
    public Curso(int idCurso,String codCurso, String descripcion, Etapa etapa, boolean activo) {
        this.idCurso = idCurso;
        this.codCurso = codCurso;
        this.descripcion = descripcion;
        this.etapa = etapa;
        this.activo = activo;
    }

     /**
     * CONSTRUCTOR POR PARÁMETROS SIN IDCURSO 
     *
     * @param codCurso
     * @param descripcion
     * @param etapa
     * @param activo 
     */
    public Curso(String codCurso, String descripcion, Etapa etapa, boolean activo) {
        this.codCurso = codCurso;
        this.descripcion = descripcion;
        this.etapa = etapa;
        this.activo = activo;
    }
    
    
    /**
     * METODOS GET Y SET
     * @return 
     */
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idCurso;
        hash = 41 * hash + Objects.hashCode(this.codCurso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.idCurso != other.idCurso) {
            return false;
        }
        return Objects.equals(this.codCurso, other.codCurso);
    }
    
    
    /**
     * METODO QUE MUESTRA LOS DATOS DE CURSO
     * @return 
     */

    @Override
    public String toString() {
        return "Curso{" + "codCurso=" + codCurso + ", idCurso=" + idCurso + ", descripcion=" + descripcion + ", etapa=" + etapa + ", activo=" + activo + '}';
    }

    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Curso o) {
        return Integer.compare(this.getIdCurso(), o.getIdCurso());
    }
    
}
