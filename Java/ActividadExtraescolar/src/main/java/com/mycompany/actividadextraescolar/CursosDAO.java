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
 * Clase que implementa la interfaz RepositorioDAO para la clase Curso.
 */
public class CursosDAO implements RepositorioDAO<Curso> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * METODO QUE LISTA LA TABLA CURSO
     *
     * @return
     */
    @Override
    public SortedSet<Curso> listar() {
        SortedSet<Curso> listaCursos = new TreeSet();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("select * from curso");) {
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

    /**
     * METODO QUE BUSCA UN CURSO POR codCurso
     *
     * @param valorABuscar
     * @return
     */
    @Override
    public Curso buscarPor(String valorABuscar) {
        Curso curso = null;
        String sql = "SELECT * FROM curso WHERE codCurso=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setString(1, valorABuscar);
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

    /**
     * METODO QUE ELIMINA UN CURSO POR DESCRIPCION
     *
     * @param filtro
     */
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

    /**
     * METODO QUE INSERTA UN CURSO A LA TABLA CURSO
     *
     * @param c
     */
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

    /**
     * METODO QUE ACTUALIZA SEGUN EL ATRIBUTO PASADO POR PARÁMETRO Y UN VALOR
     * NUEVO
     *
     * @param atributo
     * @param valorABuscar
     * @param valorNuevo
     */
    @Override
    public void actualizar(String atributo, String valorABuscar, JTextField valorNuevo) {
        // Implementación para deshabilitar curso
        Curso curso = buscarPor(valorABuscar);
        if (curso != null) {
            String sql = "UPDATE curso SET " + atributo + " =? " + " WHERE codCurso=?";
            try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
                stmt.setString(2, valorABuscar);
                stmt.setObject(1, valorNuevo.getText());
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
    
    /**
     * METODO QUE CAMBIA EL ACTIVO DE UN CURSO
     * @param valorABuscar
     * @param activo 
     */
     public void actualizarActivo(String valorABuscar,boolean activo) {
        Curso cu = buscarPor(valorABuscar);
        String sql = "UPDATE curso SET activo=? WHERE codCurso=?;";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            
            stmt.setBoolean(1, activo);
            stmt.setString(2, valorABuscar);
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

    /**
     * METODO QUE MUESTRA TODOS LOS CURSOS
     */
    public void mostrarTodosCursos() {
        SortedSet<Curso> listaCursos = listar();
        for (Curso c : listaCursos) {
            System.out.println(c.toString());
        }
    }

    /**
     * METODO QUE CREA EL CODIGOCURSO
     * @param curso
     * @param anio
     * @return 
     */
    public String crearCodigoCurso(String curso, String anio) {
        return curso.toUpperCase().substring(0, 2) + anio;
    }

    /**
     * METODO QUE CREA UN CURSO CON LOS DATOS DE MYSQL
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Curso crearCurso(final ResultSet rs) throws SQLException {
        return new Curso(rs.getInt("idcurso"), rs.getString("codcurso"), rs.getString("descripcion"), Etapa.valueOf(rs.getString("etapa")), rs.getBoolean("activo"));
    }

    @Override
    public boolean verificarCredenciales(String correo, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarContraenia(String DNI, String nuevaContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
