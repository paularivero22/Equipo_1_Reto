/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.util.List;

/**
 *
 * @author atres
 * @param <T>
 */

//Interfaz que creará métodos con el aptrón dao
public interface RepositorioDAO<T> {
    // para listar todos los registros de una tabla
    public List<T> listar();
    // método para recuperar un objeto por una filtro de tipo cadena
    public T buscarPor(String filtro);
    // método para borrar un objeto por su filtro
    public void eliminarPor( String filtro);
    
    //Metodo para insertar datos a una tabla
    public void insertar(T t);
    
    //Metodo para actualizar datos de una tabla ;
    public void actualizar(String filtro);
    
    //Metodo para verificar credenciales
    public boolean verificarCredenciales(String contrasenia,String email);
    
    //Metodo para cambiar contraseña
    public boolean actualizarContrasenia (String dni, String nuevaContrasenia);
}
