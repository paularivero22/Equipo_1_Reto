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
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz RepositorioDAO para la clase Curso.
 */
public class CursosDAO implements RepositorioDAO<Curso> {
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Curso> listar() {
        List<Curso> listaCursos = new ArrayList<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM curso;");) {
            while (rs.next()) {
                Curso curso = crearCurso(rs);
                if (!listaCursos.add(curso)) {
                    throw new Exception("Error, no se pudo insertar el curso con ID: " + curso.getIdCurso() + " a la lista");
                }
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaCursos;
    }

    @Override
    public Curso buscarPor(String filtro) {
        Curso curso = null;
        String sql = "SELECT * FROM curso WHERE codcurso=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setString(1, filtro);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    curso = crearCurso(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return curso;
    }

    @Override
    public void eliminarPor(String filtro) {
        String sql = "DELETE FROM curso WHERE codcurso=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, filtro);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            } else {
                System.out.println("Se ha eliminado el curso con código: " + filtro);
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertar(Curso c) {
        String sql = "INSERT into curso(idcurso, codcurso, descripcion, etapa, activo) VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            
            stmt.setInt(1, c.getIdCurso());
            stmt.setString(2, c.getCodCurso());
            stmt.setString(3, c.getDescripcion());
            stmt.setString(4, c.getEtapa().name());
            stmt.setBoolean(5, c.isActivo());
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
    
    public void actualizar(String filtro) {
       // Implementación para deshabilitar curso
        Curso curso = buscarPor(filtro);
        if (curso != null) {
            String sql = "UPDATE curso SET activo=false WHERE idcurso=?";
            try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
                stmt.setInt(1, curso.getIdCurso());
                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    throw new Exception("No se ha modificado el registro");
                }
                System.out.println("El curso con ID " + curso.getIdCurso() + " ha sido deshabilitado.");
            } catch (SQLException s) {
                System.out.println("Error SQL: " + s.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("El curso no existe.");
        }
    }
    
    // Método para mostrar todos los cursos
    public void mostrarTodosCursos() {
        List<Curso> listaCursos = listar();
        for (Curso c : listaCursos) {
            System.out.println(c.toString());
        }
    }

    // Método que crea un curso a partir de los datos en la base de datos
    private Curso crearCurso(final ResultSet rs) throws SQLException {
        return new Curso(rs.getInt("idcurso"), rs.getString("codcurso"), rs.getString("descripcion"), Etapa.valueOf(rs.getString("etapa")), rs.getBoolean("activo"));
    }

    @Override
    public boolean verificarCredenciales(String contrasenia, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarContrasenia(String dni, String nuevaContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}
