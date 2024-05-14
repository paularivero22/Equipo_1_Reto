/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JTextField;

/**
 *
 * @author atres
 */
//Clase que implementará la interfaz repositorioDAO para la clase profesor
public class ProfesorDAO implements RepositorioDAO<Profesor> {

    /**
     * 
     * @return 
     */
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    /**
     * Lista todos los profesores
     * @return 
     */

    @Override
    public SortedSet<Profesor> listar() {
        SortedSet<Profesor> listaProfesor = new TreeSet<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM profesor;");) {
            while (rs.next()) {
                Profesor profesor = crearProfesor(rs);
                if (!listaProfesor.add(profesor)) {
                    throw new Exception("Error, no se pudo insertar al profesor con DNI: " + profesor.getDNI() + "a la lista");
                }
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaProfesor;
    }

    /**
     * Metodo que busca un profesor mediante su DNI
     * @param filtro
     * @return 
     */
    
    @Override
    public Profesor buscarPor(String filtro) {
        Profesor profesor = null;
        String sql = "SELECT * FROM profesor WHERE correo=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setString(1, filtro);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    profesor = crearProfesor(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return profesor;
    }
  /**
   * METODO QUE BUSCA UN PROFESOR POR DNI
   * @param valorAbuscar
   * @return 
   */  
     public Profesor buscarPorDNI(String valorAbuscar) {
        Profesor profesor = null;
        String sql = "SELECT * FROM profesor WHERE DNI=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setString(1, valorAbuscar);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    profesor = crearProfesor(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return profesor;
    }
    /**
    * Metodo que elimina un profesor por su dni
    * @param filtro 
     */
    @Override
    public void eliminarPor(String filtro) {
        String sql = "DELETE FROM profesor WHERE DNI=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, filtro);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            } else {
                System.out.println("Se ha eliminado el profesor con dni: " + filtro);
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Metodo que inserta un profesor a la bd
     * 
     * @param p
     */
 
    @Override
    public void insertar(Profesor p) {
        String sql = "INSERT into profesor(idProfesor,nombre,apellidos,DNI,perfilAcceso,fk_departamento,correo,activo,contraseña)VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, p.getIdProfesor());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getApellidos());
            stmt.setString(4, p.getDNI());
            stmt.setString(5, p.getPerfil().name());
            stmt.setInt(6, p.getIdDepartamento());
            stmt.setString(7, p.getCorreo());
            stmt.setBoolean(8, p.isActivo());
            stmt.setString(9, p.getContrasenia());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado el registro");
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *METODO QUE ACTUALIZA UN DATO ESPECIFICO A UN NUEVO VALOR
     * @param atributo
     * @param dni
     * @param valorNuevo
     */
    @Override
    public void actualizar(String atributo,String dni,JTextField valorNuevo) {
        Profesor p = buscarPor(dni);
        String sql = "UPDATE profesor SET "+atributo+"=? WHERE DNI=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
           stmt.setObject(1, valorNuevo.getText());
           stmt.setString(2, dni);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha modificado el registro");
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**Metodo que recorre y muestra los datos todos los profesores;
     * 
     */
    public void mostrarTodosProfesores() {
        SortedSet<Profesor> listaProfesor = listar();
        for (Profesor p : listaProfesor) {
            System.out.println(p.toString());
        }
    }

    /**
     * METODO QUE CREA UN PROFESOR RECOGIENDO LOS DATOS DE MYSQL
     * @param rs
     * @return
     * @throws SQLException 
     */
    private Profesor crearProfesor(final ResultSet rs) throws SQLException {
        return new Profesor(rs.getInt("idProfesor"), rs.getInt("fk_departamento"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("DNI"), rs.getString("correo"), rs.getBoolean("activo"), PerfilAcceso.valueOf(rs.getString("perfilAcceso")), rs.getString("contraseña"));
    }

}
