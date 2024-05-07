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
        //Pruebo los metodos DepartamentoDAO
        System.out.println("---LISTAR TODOS LOS DEPARTAMENTOS---");
        DepartamentoDAO metodosDepartamento=new DepartamentoDAO();
        //Listo todos los profesores
        metodosDepartamento.mostrarTodosDepartamentos();
        System.out.println("");
      
        //Buscar un departamento por su codDepartamento
        System.out.println("---BUSCAR POR CODDEPARTAMENTO");
        Departamento departamentoEncontrado=metodosDepartamento.buscarPor("AG");
        System.out.println(departamentoEncontrado.toString());
        System.out.println("");
      
        //Insertar un nuevo departamento
        System.out.println("---INSERTAR NUEVO DEPARTAMENTO---");
        Departamento departamentoNuevo=new Departamento(20,"ALE","Alemán",35);
        metodosDepartamento.insertar(departamentoNuevo);
        Departamento departamentoEncontrado1=metodosDepartamento.buscarPor("ALE");
        System.out.println(departamentoEncontrado1.toString());
        System.out.println("");
        
        //Actualizar un departamento
        System.out.println("---ACTUALIZAR DEPARTAMENTO---");
        metodosDepartamento.actualizar("ALE");
        Departamento departamentoEncontrado2=metodosDepartamento.buscarPor("ALE");
        System.out.println(departamentoEncontrado2.toString());
        System.out.println("");

        //Borrar un departamento
        System.out.println("---ELIMINAR DEPARTAMENTO---");
        metodosDepartamento.eliminarPor("ALE");
        Departamento departamentoEncontrado3=metodosDepartamento.buscarPor("ALE");
        if(departamentoEncontrado3==null){
            System.out.println("No existe el departamento "+departamentoEncontrado2.getCodigoDepartamento());
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
