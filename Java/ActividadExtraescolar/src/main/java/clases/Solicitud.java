/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Enumerados.Estado;
import Enumerados.Tipo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * IMPLEMENTA COMPARABLE PARA ORDENAR
 *
 * @author atres
 */
public class Solicitud implements Comparable<Solicitud> {

    protected int idSolicitud;
    protected String titulo;
    protected Tipo tipoSolicitud;
    protected int iddepartamento;
    protected boolean prevista;
    protected int idprofesor;
    protected LocalTime horaInicio;
    protected LocalTime horaFinal;
    public Estado estado;
    protected String comentario;
    protected boolean Alojamiento;
    protected LocalDate fechaInicio;
    protected LocalDate fechaFinal;
    protected int totalParticipantes;

    /**
     * CONSTRUCTOR POR PARÁMETOS QUE NO PASA LA IDSOLICITUD
     *
     * @param horaInicio
     * @param horaFinal
     * @param comentario
     * @param prevista
     * @param iddepartamento
     * @param titulo
     * @param tipoSolicitud
     * @param idprofesor
     * @param Alojamiento
     * @param fechaInicio
     * @param fechaFinal
     * @param totalParticipantes
     * @param estado
     */
    public Solicitud(LocalTime horaInicio, LocalTime horaFinal, String comentario, boolean prevista, int iddepartamento, String titulo, Tipo tipoSolicitud,int idprofesor, boolean Alojamiento, LocalDate fechaInicio, LocalDate fechaFinal, int totalParticipantes, Estado estado) {
        this.titulo = titulo;
        this.tipoSolicitud = tipoSolicitud;
        this.iddepartamento = iddepartamento;
        this.prevista = prevista;
        this.idprofesor = idprofesor;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.comentario = comentario;
        this.Alojamiento = Alojamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.totalParticipantes = totalParticipantes;
    }

    /**
     * CONSTRUCTOR POR PARÁMETROS QUE PASA LA IDSOLICITUD
     *
     * @param idSolicitud
     * @param horaInicio
     * @param horaFinal
     * @param comentario
     * @param prevista
     * @param iddepartamento
     * @param titulo
     * @param tipoSolicitud
     * @param idprofesor
     * @param Alojamiento
     * @param fechaInicio
     * @param fechaFinal
     * @param totalParticipantes
     * @param estado
     */
    public Solicitud(int idSolicitud, LocalTime horaInicio, LocalTime horaFinal, String comentario, boolean prevista, int iddepartamento, String titulo, Tipo tipoSolicitud,int idprofesor, boolean Alojamiento, LocalDate fechaInicio, LocalDate fechaFinal, int totalParticipantes, Estado estado) {
        this.idSolicitud = idSolicitud;
        this.titulo = titulo;
        this.tipoSolicitud = tipoSolicitud;
        this.iddepartamento = iddepartamento;
        this.prevista = prevista;
        this.idprofesor = idprofesor;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.comentario = comentario;
        this.Alojamiento = Alojamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.totalParticipantes = totalParticipantes;
    }

    /**
     * METODOS GET Y SET
     *
     * @return
     */
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTotalParticipantes() {
        return totalParticipantes;
    }

    public Tipo getTipoSolicitud() {
        return tipoSolicitud;
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public boolean isPrevista() {
        return prevista;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getComentario() {
        return comentario;
    }

    public boolean isAlojamiento() {
        return Alojamiento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }
    //Metodos set

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipoSolicitud(Tipo tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public void setPrevista(boolean prevista) {
        this.prevista = prevista;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public void setAlojamiento(boolean Alojamiento) {
        this.Alojamiento = Alojamiento;
    }


    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setTotalParticipantes(int totalParticipantes) {
        this.totalParticipantes = totalParticipantes;
    }

    /**
     * HASHCODE
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idSolicitud;
        hash = 41 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    /**
     * METODO EQUALS
     *
     * @param obj
     * @return
     */
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
        final Solicitud other = (Solicitud) obj;
        if (this.idSolicitud != other.idSolicitud) {
            return false;
        }
        return Objects.equals(this.titulo, other.titulo);
    }

    /**
     * METODO TO STRING PARA MOSTRAR DATOS
     *
     * @return
     */
    @Override   
    public String toString() {

        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", titulo=" + titulo + ", tipoSolicitud=" + tipoSolicitud + ", iddepartamento=" + iddepartamento + ", prevista=" + prevista + ", idprofesor=" + idprofesor + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", estado=" + estado + ", comentario=" + comentario + ", Alojamiento=" + Alojamiento + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", totalParticipantes=" + totalParticipantes + '}';
    }

    /**
     * METODO QUE ORDENA LAS SOLICITUDES POR FECHAiNICIO DE MÁS RECIENTE A MENOS
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Solicitud o) {
        int comparacion=o.getEstado().compareTo(this.getEstado());
        if(comparacion!=0){
            return comparacion;
        }else{
            return compararFecha(o);
        }
    }
    public int compararFecha(Solicitud o){
         if (this.getFechaInicio().isAfter(o.getFechaInicio())) {
            return -1;
        } else if (this.getFechaInicio().isBefore(o.getFechaFinal())) {
            return 1;
        } else {
            return 0;
        }
    }

}
