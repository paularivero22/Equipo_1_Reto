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

public class GruposDAO implements RepositorioDAO<Grupo> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Grupo> listar() {
        List<Grupo> listaGrupos = new ArrayList<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM grupoAlumnos;")) {
            while (rs.next()) {
                Grupo grupo = crearGrupo(rs);
                listaGrupos.add(grupo);
            }
        } catch (SQLException sql) {
            System.out.println("Error SQL: " + sql.getMessage());
        }
        return listaGrupos;
    }

    @Override
    public Grupo buscarPor(String filtro) {
        Grupo grupo = null;
        String sql = "SELECT * FROM grupoAlumnos WHERE codGrupo=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setInt(1, Integer.parseInt(filtro));
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    grupo = crearGrupo(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println("Error SQL: " + s.getMessage());
        }
        return grupo;
    }

    @Override
    public void eliminarPor(String filtro) {
        String sql = "DELETE FROM grupoAlumnos WHERE codGrupo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(filtro));
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception("No se ha borrado ningún registro");
            } else {
                System.out.println("Se ha eliminado el grupo con ID " + filtro);
            }
        } catch (SQLException s) {
            System.out.println("Error SQL: " + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void insertar(Grupo g) {
        String sql = "INSERT INTO grupoAlumnos(codGrupo, idGrupo, numAlumnos, activo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, g.getCodGrupo());
            stmt.setInt(2, g.getIdGrupo());
            stmt.setInt(3, g.getNumeroAlumnos());
            stmt.setBoolean(4, g.isActivo());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception("No se ha insertado el registro");
            }
        } catch (SQLException s) {
            System.out.println("Error SQL: " + s.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(String filtro) {
        // Implementación para deshabilitar grupo
        Grupo grupo = buscarPor(filtro);
        if (grupo != null) {
            String sql = "UPDATE grupoAlumnos SET activo=false WHERE codGrupo=?";
            try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
                stmt.setString(1, grupo.getCodGrupo());
                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    throw new Exception("No se ha modificado el registro");
                }
                System.out.println("El grupo con ID " + grupo.getCodGrupo() + " ha sido deshabilitado.");
            } catch (SQLException s) {
                System.out.println("Error SQL: " + s.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("El grupo no existe.");
        }
    }
    
    // Método para mostrar todos los cursos
    public void mostrarTodosGrupos() {
        List<Grupo> listaGrupos = listar();
        for (Grupo c : listaGrupos) {
            System.out.println(c.toString());
        }
    }

    private Grupo crearGrupo(ResultSet rs) throws SQLException {
        return new Grupo(rs.getInt("codGrupo"), rs.getString("fk_curso"), rs.getInt("numAlumnos"), rs.getInt("idGrupo"), rs.getBoolean("activo"));
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
