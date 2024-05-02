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
    private int codJefe;

    //Constructor por parámetros
    public Departamento(int idDepartamento, String codigoDepartamento, String nombre, int idJefe, int codJefe) {
        this.idDepartamento = idDepartamento;
        this.codigoDepartamento = codigoDepartamento;
        this.nombre = nombre;
        this.idJefe = idJefe;
        this.codJefe = codJefe;
    }
    
    //Métodos get

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

    public int getCodJefe() {
        return codJefe;
    }
//Mostrar datos
    @Override
    public String toString() {
        return "Departamento{" + "idDepartamento=" + idDepartamento + ", codigoDepartamento=" + codigoDepartamento + ", nombre=" + nombre + ", idJefe=" + idJefe + ", codJefe=" + codJefe + '}';
    }
    
    
}
