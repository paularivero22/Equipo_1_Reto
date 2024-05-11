/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

/**
 *
 * @author atres
 */
public class Departamento {
    public int idDepartamento;
    private String codigoDepartamento;
    private String nombre;
    public int idJefe;

    /**
     * CONSTRUCTOR POR PARÁMETROS PASANDO EL IDDEPARTAMENTO
     * @param idDepartamento
     * @param codigoDepartamento
     * @param nombre
     * @param idJefe 
     */
    public Departamento(int idDepartamento, String codigoDepartamento, String nombre, int idJefe) {
        this.idDepartamento = idDepartamento;
        this.codigoDepartamento = codigoDepartamento;
        this.nombre = nombre;
        this.idJefe = idJefe;
    }

    /**
     * CONSTRUCTOR POR PARÁMETROS SIN PASAR EL IDDEPARTAMENTO
     * @param codigoDepartamento
     * @param nombre
     * @param idJefe 
     */
    public Departamento(String codigoDepartamento, String nombre, int idJefe) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombre = nombre;
        this.idJefe = idJefe;
    }
    
    
    
 /**
  * METODOS GET Y SET
  * @return 
  */

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdJefe() {
        return idJefe;
    }
    
    //Metodos Set
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }
    
    
/**
 * METODO TO STRING PARA MOSTRAR DATOS
 * @return 
 */
    @Override
    public String toString() {
        return "Departamento{" + "idDepartamento=" + idDepartamento + ", codigoDepartamento=" + codigoDepartamento + ", nombre=" + nombre + ", idJefe=" + idJefe + '}';
    }
    
    
}
