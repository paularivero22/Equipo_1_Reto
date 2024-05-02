/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

/**
 *
 * @author Usuario
 */
public class MedioTransporte {
    private int idTransporte;
    private String comentario;
    private double importe;
    private String empresa;
    
    public MedioTransporte(int idTransporte, String comentario, double importe, String empresa) {
        this.idTransporte = idTransporte;
        this.comentario = comentario;
        this.importe = importe;
        this.empresa = empresa;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Medio de Transporte{" + "Identificador=" + idTransporte + ", Descripción=" + comentario + ", Importe=" + importe + ", Empresa=" + empresa + '}';
    }
     
           
}
