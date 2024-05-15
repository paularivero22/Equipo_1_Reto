/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package metodosDB;


import java.util.SortedSet;
import javax.swing.JTextField;



/**
 *
 * @author atres
 * @param <T>
 */

//Interfaz que creará métodos con el aptrón dao
public interface RepositorioDAO<T> {
    // para listar todos los registros de una tabla
    /**
     * 
     * @return 
     */
    public SortedSet<T> listar();
    // método para recuperar un objeto por una filtro de tipo cadena

    /**
     *
     * @param valorABuscar
     * @return T
     */
    public T buscarPor(String valorABuscar);
    /**
     * 
     * @param filtro 
     */
    // método para borrar un objeto por su filtro
    public void eliminarPor( String filtro);
    /**
     * 
     * @param t 
     */
    //Metodo para insertar datos a una tabla
    public void insertar(T t);
    /**
     * 
     * @param filtro
     * @param valornuevo
     * @param valorABuscar 
     */
    //Metodo para actualizar datos de una tabla ;
    public void actualizar(String filtro,String valorABuscar,JTextField valornuevo);
}
