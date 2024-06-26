/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Enumerados.Estado;
import Enumerados.Tipo;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Usuario
 */
public class ActividadProgramada extends Solicitud{

    private boolean medioTransporte;
    private String comentarioFase;

    /**
     * CONSTRUCTOR SIN IDSOLICITUD
     * @param medioTransporte
     * @param comentarioFase
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
    public ActividadProgramada(boolean medioTransporte, String comentarioFase, LocalTime horaInicio, LocalTime horaFinal, String comentario, boolean prevista, int iddepartamento, String titulo, Tipo tipoSolicitud, int idprofesor, boolean Alojamiento, LocalDate fechaInicio, LocalDate fechaFinal, int totalParticipantes, Estado estado) {  
        super(horaInicio, horaFinal, comentario, prevista, iddepartamento, titulo, tipoSolicitud, idprofesor, Alojamiento, fechaInicio, fechaFinal, totalParticipantes, estado);
        this.medioTransporte = medioTransporte;
        this.comentarioFase = comentarioFase;
    }

    /**
     * CONSTRUCTOR CON IDSOLICITUD
     * @param medioTransporte
     * @param comentarioFase
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
    public ActividadProgramada(boolean medioTransporte, String comentarioFase, int idSolicitud, LocalTime horaInicio, LocalTime horaFinal, String comentario, boolean prevista, int iddepartamento, String titulo, Tipo tipoSolicitud, int idprofesor, boolean Alojamiento, LocalDate fechaInicio, LocalDate fechaFinal, int totalParticipantes, Estado estado) {
        super(idSolicitud, horaInicio, horaFinal, comentario, prevista, iddepartamento, titulo, tipoSolicitud, idprofesor, Alojamiento, fechaInicio, fechaFinal, totalParticipantes, estado);
        this.medioTransporte = medioTransporte;
        this.comentarioFase = comentarioFase;
    }

    /**
     * METODOS GET Y SET
     * @return 
     */
    public boolean isMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(boolean medioTransporte) {
        this.medioTransporte = medioTransporte;
    }


    public String getComentarioFase() {
        return comentarioFase;
    }

    public void setComentarioFase(String comentarioFase) {
        this.comentarioFase = comentarioFase;
    }

    /**
     * METODO QUE MUESTRA LA INFORMACIÓN DE LA ACTIVIDAD PROGRAMADA
     * @return 
     */
    @Override
    public String toString() {
        return "ActividadProgramada{"+super.toString() + "medioTransporte=" + medioTransporte + ", comentarioFase=" + comentarioFase + '}';
    }
    
}
