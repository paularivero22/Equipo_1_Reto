/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.time.LocalDate;

/**
 *
 * @author atres
 */
public class Solicitud {
    private int idSolicitud;
    private String titulo;
    private Tipo tipoSolicitud;
    private Departamento departamento;
    private boolean prevista;
    private Profesor profesor;
    private LocalTime horaInicio;
    private LocaTime horaFinal;
    public Estado estado;
    private String comentario;
    private boolean medioTransporte;
    private boolean Alojamiento;
    private String comentarioAlojamiento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    //Constructor por parámetros
    public Solicitud(int idSolicitud, String titulo, Tipo tipoSolicitud, Departamento departamento, boolean prevista, Profesor profesor, LocalTime horaInicio, LocaTime horaFinal, Estado estado, String comentario, boolean medioTransporte, boolean Alojamiento, String comentarioAlojamiento, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.idSolicitud = idSolicitud;
        this.titulo = titulo;
        this.tipoSolicitud = tipoSolicitud;
        this.departamento = departamento;
        this.prevista = prevista;
        this.profesor = profesor;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.comentario = comentario;
        this.medioTransporte = medioTransporte;
        this.Alojamiento = Alojamiento;
        this.comentarioAlojamiento = comentarioAlojamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
//Metodos get
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public Tipo getTipoSolicitud() {
        return tipoSolicitud;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public boolean isPrevista() {
        return prevista;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocaTime getHoraFinal() {
        return horaFinal;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getComentario() {
        return comentario;
    }

    public boolean isMedioTransporte() {
        return medioTransporte;
    }

    public boolean isAlojamiento() {
        return Alojamiento;
    }

    public String getComentarioAlojamiento() {
        return comentarioAlojamiento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    //Mostrar datos
    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", titulo=" + titulo + ", tipoSolicitud=" + tipoSolicitud + ", departamento=" + departamento + ", prevista=" + prevista + ", profesor=" + profesor + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", estado=" + estado + ", comentario=" + comentario + ", medioTransporte=" + medioTransporte + ", Alojamiento=" + Alojamiento + ", comentarioAlojamiento=" + comentarioAlojamiento + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + '}';
    }
   
    
    
}
