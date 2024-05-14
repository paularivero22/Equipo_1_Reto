/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;


/**
 *
 * @author Usuario
 */
public class ActividadExtraescolar {
    public static void main(String[] args) {
        SolicitudesDAO s=new SolicitudesDAO();
        ActividadProgramadaDAO metodosprogramada=new ActividadProgramadaDAO();
        SortedSet<Solicitud>lista=s.listar();
        ActividadProgramada p=null;
        for(Solicitud so:lista){
            if(so.getEstado().name().equalsIgnoreCase("APROBADA")){
             p=new ActividadProgramada(false,"",so.idSolicitud,so.getHoraInicio(),so.getHoraFinal(),so.comentario,so.isPrevista(),so.getIddepartamento(),so.titulo,so.tipoSolicitud,so.idprofesor,so.Alojamiento,so.fechaInicio,so.fechaFinal,so.totalParticipantes,so.estado);
             metodosprogramada.insertar(p);  
            }
        }
        /*
                p=new ActividadProgramada(false,"",solicitudAux.idSolicitud,solicitudAux.getHoraInicio(),solicitudAux.getHoraFinal(),solicitudAux.comentario,solicitudAux.isPrevista(),solicitudAux.getIddepartamento(),solicitudAux.titulo,solicitudAux.tipoSolicitud,solicitudAux.idprofesor,solicitudAux.Alojamiento,solicitudAux.fechaInicio,solicitudAux.fechaFinal,solicitudAux.totalParticipantes,solicitudAux.estado);
                metodosprogramada.insertar(p);   
        }*/
    }
    /**
     * Metodo estatico para cargar los csv a bd
     */
    public static void cargarArchivos(){
        List<Curso>listaCursos=MetodosFicheros.leerCSVCursos();
        List<Departamento>listaDepartamentos=MetodosFicheros.leerCSVDepartamentos();
        List<Profesor>listaProfesor=MetodosFicheros.leerCSVProfesores();
        List<Grupo>listaGrupo=MetodosFicheros.leerCSVGrupoAlumnos();
        MetodosFicheros.insertarCurso(listaCursos);
        MetodosFicheros.insertarDepartamento(listaDepartamentos);
        MetodosFicheros.insertarProfesores(listaProfesor);
        MetodosFicheros.insertarGruposAlumnos(listaGrupo);
    }
    
  
}   


