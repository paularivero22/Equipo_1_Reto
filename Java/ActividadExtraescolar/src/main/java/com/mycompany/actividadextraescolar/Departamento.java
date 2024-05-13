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
public class Departamento implements Comparable<Departamento> {
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
     * METODO EQUALS Y HASHCODE
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idDepartamento;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final Departamento other = (Departamento) obj;
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
    
/**
 * METODO TO STRING PARA MOSTRAR DATOS
 * @return 
 */
    @Override
    public String toString() {
        return "Departamento{" + "idDepartamento=" + idDepartamento + ", codigoDepartamento=" + codigoDepartamento + ", nombre=" + nombre + ", idJefe=" + idJefe + '}';
    }

    @Override
    public int compareTo(Departamento o) {
        return Integer.compare(this.getIdDepartamento(), o.getIdDepartamento());
    }
    
    
}
