/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import clases.Solicitud;
import clases.Profesor;
import clases.Grupo;
import clases.Departamento;
import clases.ActividadProgramada;
import clases.Curso;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import metodosDB.ProfesorDAO;


/**
 *
 * @author Usuario
 */
public class ActividadExtraescolar {
    public static void main(String[] args) {
       cargarArchivos();
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


