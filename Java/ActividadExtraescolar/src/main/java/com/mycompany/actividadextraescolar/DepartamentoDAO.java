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
 *
 * @author atres
 */
public class DepartamentoDAO implements RepositorioDAO<Departamento> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    //Lista todos los departamentos
    @Override
    public List<Departamento> listar() {
        List<Departamento> listaDepartamento = new ArrayList<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM departamento;");) {
            while (rs.next()) {
                Departamento departamento = crearDepartamento(rs);
                if (!listaDepartamento.add(departamento)) {
                    throw new Exception("Error, no se pudo mostrar el departamento "+departamento.getCodigoDepartamento());
                }
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaDepartamento;
    }

    //Metodo que busca un departamento mediante su codDepartamento
    @Override
    public Departamento buscarPor(String filtro) {
        Departamento departamento = null;
        String sql = "SELECT * FROM departamento WHERE nombre=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setString(1, filtro);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    departamento=crearDepartamento(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return departamento;
    }

    //Metodo elimina un departamento por su codDepartamento
    @Override
    public void eliminarPor(String filtro) {
        String sql = "DELETE FROM departamento WHERE codDepartamento=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, filtro);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            } else {
                System.out.println("Se ha eliminado el departamento " + filtro);
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo que inserta un departamento a la bd
    @Override
    public void insertar(Departamento d) {
        String sql = "INSERT into departamento(iddepartamento,codDepartamento,nombre,idJefe) VALUES(?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, d.getIdDepartamento());
            stmt.setString(2, d.getCodigoDepartamento());
            stmt.setString(3, d.getNombre());
            stmt.setInt(4, d.getIdJefe());
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

    @Override
    public void actualizar(String filtro) {
        Departamento d = buscarPor(filtro);
        String sql = "UPDATE departamento SET codDepartamento=?,nombre=?,idJefe=? WHERE codDepartamento=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            d.setCodigoDepartamento("JAP");
            d.setNombre("Japonés");
            d.setIdJefe(50);
            stmt.setString(4, d.getCodigoDepartamento());
            stmt.setString(1, d.getCodigoDepartamento());
            stmt.setString(2, d.getNombre());
            stmt.setInt(3, d.getIdJefe());
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

    //Metodo que recorre y muestra los datos todos los profesores;
    public void mostrarTodosDepartamentos() {
        List<Departamento> listaDepartamento = listar();
        for (Departamento d : listaDepartamento) {
            System.out.println(d.toString());
        }
    }

    //Metodo que crea un departamento a partir de los datos en mysql
    private Departamento crearDepartamento(final ResultSet rs) throws SQLException {
       return new Departamento(rs.getInt("iddepartamento"),rs.getString("codDepartamento"),rs.getString("nombre"),rs.getInt("idJefe"));
    }

}
