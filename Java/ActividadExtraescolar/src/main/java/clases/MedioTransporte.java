/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Enumerados.TipoTransporte;

/**
 *
 * @author Usuario
 */
public class MedioTransporte implements Comparable<MedioTransporte>{
    private int idTransporte;
    private int idActividad;
    private TipoTransporte tipo;
    private String comentario;
    private double importe;
    private double kilometros;
    
    /**
     * CONSTRUCTOR POR PARÁMETROS CON IDMEDIOTRANSPORTE
     * @param idTransporte
     * @param idActividad
     * @param tipo
     * @param comentario
     * @param importe
     * @param kilometros 
     */

  
    public MedioTransporte(int idTransporte, int idActividad, TipoTransporte tipo, String comentario, double importe, double kilometros) {
        this.idTransporte = idTransporte;
        this.idActividad = idActividad;
        this.tipo = tipo;
        this.comentario = comentario;
        this.importe = importe;
        this.kilometros = kilometros;
    }
/**
 * CONSTRUCTOR POR PARÁMETROS QUE NO PASA LA IDMEDIOTRANSPORTE
 * @param idActividad
 * @param tipo
 * @param comentario
 * @param importe
 * @param kilometros 
 */
    public MedioTransporte(int idActividad, TipoTransporte tipo, String comentario, double importe, double kilometros) {
        this.idActividad = idActividad;
        this.tipo = tipo;
        this.comentario = comentario;
        this.importe = importe;
        this.kilometros = kilometros;
    }

    /**
     * METODOS GET Y SET
     * @return 
     */
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

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * METODO QUE MUESTRA INFORMACIÓN DEL SERVIDOR
     * @return 
     */
    @Override
    public String toString() {
        return "MedioTransporte{" + "idTransporte=" + idTransporte + ", idActividad=" + idActividad + ", tipo=" + tipo + ", comentario=" + comentario + ", importe=" + importe + ", kilometros=" + kilometros + '}';
    }

   /**
    * METODO QUE ORDENA SEGUN LA IDACTIVIDAD
    * @param o
    * @return 
    */
    @Override
    public int compareTo(MedioTransporte o) {
        return Integer.compare(this.idActividad, o.idActividad);
    }

    
     
           
}
