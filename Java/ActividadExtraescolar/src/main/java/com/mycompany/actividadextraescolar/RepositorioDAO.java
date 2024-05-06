/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.util.List;

/**
 *
 * @author atres
 */

//Interfaz que creará métodos con el aptrón dao
public interface RepositorioDAO<T> {
    // para listar todos los registros de una tabla
    public List<T> listar();
    // método para recuperar un objeto por su ID
    public T porId( int id);
    // método en este caso puede ser tanto para realizar la inserción o modificación de un objeto
    public void guardar(T t);
    // método para borrar un objeto por su ID
    public void eliminar( int  id);
    
    //Metodo para insertar datos a una tabla
    public void insertar(T t);
    
    //Metodo para actualizar datos de una tabla;
    public void actualizar(T t);
}
