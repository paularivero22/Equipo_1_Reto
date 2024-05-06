/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class ActividadExtraescolar {
    public static void main(String[] args) {
        //Pruebo los metodos ProfesorDAO
        System.out.println("---LISTAR TODOS LOS PROFESORES---");
        ProfesorDAO metodosProfesor=new ProfesorDAO();
        //Listo todos los profesores
        metodosProfesor.mostrarTodosProfesores();
        System.out.println("");
        
        //Buscar un profesor por su dni
        System.out.println("---BUSCAR POR DNI");
        Profesor profeEncontrado=metodosProfesor.buscarPor("17394999M");
        System.out.println(profeEncontrado.toString());
        System.out.println("");
      
        //Insertar un nuevo profesor
        System.out.println("---INSERTAR NUEVO PROFESOR---");
        Profesor profeNuevo=new Profesor(16,7,"Juan","Gómez Pelayo","12345678Z","lucasgp@educantabria.es",true,PerfilAcceso.EQUIPO_DIRECTIVO,Profesor.generarPassword(7));
        metodosProfesor.insertar(profeNuevo);
        Profesor profeEncontrado1=metodosProfesor.buscarPor("12345678Z");
        System.out.println(profeEncontrado1.toString());
        System.out.println("");
        
        //Actualizar un profesor
        System.out.println("---ACTUALIZAR DNI---");
        metodosProfesor.actualizar("12345678Z");
        Profesor profeEncontrado2=metodosProfesor.buscarPor("12345678Z");
        System.out.println(profeEncontrado2.toString());
        System.out.println("");
      
        //Borrar un profesor
        System.out.println("---ELIMINAR PROFESOR---");
        metodosProfesor.eliminarPor("12345678Z");
        Profesor profeEncontrado3=metodosProfesor.buscarPor("123456789Z");
        if(profeEncontrado==null){
            System.out.println("No existe el profesor con dni "+profeEncontrado.getDNI());
        }
       
       
       
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
