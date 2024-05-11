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
    
    /**
     * METODO QUE MUESTRA LOS DATOS DE CURSO
     * @return 
     */

    @Override
    public String toString() {
        return "Curso{" + "codCurso=" + codCurso + ", idCurso=" + idCurso + ", descripcion=" + descripcion + ", etapa=" + etapa + ", activo=" + activo + '}';
    }
    
}
