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
    
    //---------------------------------//
    //---PRUEBA DE MÉTODOS PROFESORDAO---//
    //---------------------------------//
        
        System.out.println("---LISTAR TODOS LOS PROFESORES---");
        ProfesorDAO metodosProfesor = new ProfesorDAO();
        //---Listo todos los profesores---//
        metodosProfesor.mostrarTodosProfesores();
        System.out.println("");
        
        //---Buscar un profesor por su dni---//
        System.out.println("---BUSCAR POR DNI");
        Profesor profeEncontrado = metodosProfesor.buscarPor("17394999M");
        System.out.println(profeEncontrado.toString());
        System.out.println("");
      
        //---Insertar un nuevo profesor---//
        System.out.println("---INSERTAR NUEVO PROFESOR---");
        Profesor profeNuevo=new Profesor(16,7,"Juan","Gómez Pelayo","12345678Z","lucasgp@educantabria.es",true,PerfilAcceso.EQUIPO_DIRECTIVO,Profesor.generarPassword(7));
        metodosProfesor.insertar(profeNuevo);
        Profesor profeEncontrado1 = metodosProfesor.buscarPor("12345678Z");
        System.out.println(profeEncontrado1.toString());
        System.out.println("");
        
        //---Actualizar un profesor---//
        System.out.println("---ACTUALIZAR DNI---");
        metodosProfesor.actualizar("12345678Z");
        Profesor profeEncontrado2 = metodosProfesor.buscarPor("12345678Z");
        System.out.println(profeEncontrado2.toString());
        System.out.println("");
      
        //---Borrar un profesor---//
        System.out.println("---ELIMINAR PROFESOR---");
        metodosProfesor.eliminarPor("12345678Z");
        Profesor profeEncontrado3 = metodosProfesor.buscarPor("123456789Z");
        if(profeEncontrado == null){
            System.out.println("No existe el profesor con dni "+profeEncontrado.getDNI());
        }
    
        
        
    //---------------------------------//
    //---PRUEBA DE MÉTODOS CURSOSDAO---//
    //---------------------------------//
    
        CursosDAO metodosCursos = new CursosDAO();
        //---Listo todos los cursos---//
        metodosCursos.mostrarTodosCursos();
        System.out.println("");
        
        //---Buscar un curso por su codcurso---//
        System.out.println("---BUSCAR POR CODCURSO---");
        Curso cursoEncontrado = metodosCursos.buscarPor("1234567891");
        System.out.println(profeEncontrado.toString());
        System.out.println("");
       
        //---Insertar un nuevo curso---//
        System.out.println("---INSERTAR NUEVO CURSO---");
        Curso cursoNuevo = new Curso(1, "123456f", "Muy chulo", Etapa.ESO, true);
        metodosCursos.insertar(cursoNuevo);
        Curso cursoEncontrado1 = metodosCursos.buscarPor("12345678Z");
        System.out.println(cursoEncontrado1.toString());
        System.out.println("");
        
        
        //---Actualizar un curso (deshabilitarlo) ---//
        System.out.println("---DESHABILITAR CURSO---");
        metodosCursos.actualizar("12345678Z");
        Curso cursoEncontrado2 = metodosCursos.buscarPor("12345678Z");
        System.out.println(cursoEncontrado2.toString());
        System.out.println("");
      
        //---Borrar un curso---//
        System.out.println("---ELIMINAR CURSO---");
        metodosProfesor.eliminarPor("12345678Z");
        Curso cursoEncontrado3 = metodosCursos.buscarPor("123456789Z");
        if(cursoEncontrado == null){
            System.out.println("No existe el curso con el códgio "+cursoEncontrado.getCodCurso());
      }
        
    //---------------------------------//
    //---PRUEBA DE MÉTODOS GRUPOSDAO---//
    //---------------------------------//
    
        GruposDAO metodosGrupos = new GruposDAO();
        //---Listo todos los grupos---//
        metodosGrupos.mostrarTodosGrupos();
        System.out.println("");
        
        //---Buscar un curso por su codGrupo---//
        System.out.println("---BUSCAR POR CODGRUPO---");
        Grupo grupoEncontrado = metodosGrupos.buscarPor("1234567891");
        System.out.println(grupoEncontrado.toString());
        System.out.println("");
       
        //---Insertar un nuevo grupo---//
        System.out.println("---INSERTAR NUEVO GRUPO---");
        Grupo grupoNuevo = new Grupo(1, "123A", 12, 22, true);
        metodosGrupos.insertar(grupoNuevo);
        Grupo grupoEncontrado1 = metodosGrupos.buscarPor("12345678Z");
        System.out.println(grupoEncontrado1.toString());
        System.out.println("");
        
        
        //---Actualizar un grupo (deshabilitarlo) ---//
        System.out.println("---DESHABILITAR GRUPO---");
        metodosCursos.actualizar("12345678Z");
        Grupo grupoEncontrado2 = metodosGrupos.buscarPor("12345678Z");
        System.out.println(grupoEncontrado2.toString());
        System.out.println("");
      
        //---Borrar un grupo---//
        System.out.println("---ELIMINAR GRUPO---");
        metodosProfesor.eliminarPor("12345678Z");
        Grupo grupoEncontrado3 = metodosGrupos.buscarPor("123456789Z");
        if(grupoEncontrado == null){
            System.out.println("No existe el curso con el códgio "+grupoEncontrado.getCodGrupo());
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


