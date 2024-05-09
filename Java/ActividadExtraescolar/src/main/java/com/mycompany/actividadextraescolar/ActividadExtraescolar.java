/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ActividadExtraescolar {
    public static void main(String[] args) {
        SolicitudesDAO s=new SolicitudesDAO();
        Solicitud solicitud=new Solicitud(LocalTime.of(10, 30),LocalTime.of(15, 40),"",true,5,"Museo",Tipo.ExtraEscolar,true,5,false,LocalDate.of(2024, 5, 9),LocalDate.of(2024, 5, 9),100,"",Estado.SOLICITADA);
        s.insertar(solicitud);
    }
    
    //Metodo estatico para cargar los csv a bd
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


