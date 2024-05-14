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
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JTextField;

/**
 *
 * @author atres
 */
public class DepartamentoDAO implements RepositorioDAO<Departamento> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * METODO QUE LISTA LA TABLA DEPARTAMENTO
     *
     * @return
     */
    @Override
    public SortedSet<Departamento> listar() {
        SortedSet<Departamento> listaDepartamento = new TreeSet<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM departamento;");) {
            while (rs.next()) {
                Departamento departamento = crearDepartamento(rs);
                if (!listaDepartamento.add(departamento)) {
                    throw new Exception("Error, no se pudo mostrar el departamento " + departamento.getCodigoDepartamento());
                }
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaDepartamento;
    }

    /**
     * METODO QUE BUSCA UN DEPARTAMENTO MEDIANTE nombre
     *
     * @param filtro
     * @return
     */
    @Override
    public Departamento buscarPor(String filtro) {
        Departamento departamento = null;
        String sql = "SELECT * FROM departamento WHERE nombre=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setString(1, filtro);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return departamento;
    }

    /**
     * METODO QUE ELIMINA UN DEPARTAMENTO POR codDepartamento
     *
     * @param filtro
     */
    @Override
    public void eliminarPor(String filtro) {
        String sql = "DELETE FROM departamento WHERE nombre=?";
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

    /**
     * METODO QUE INSERTA UN DEPARTAMENTO A LA TABLA DEPARTAMENTO
     *
     * @param d
     */
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

    /**
     * METODO QUE ACTUALIZA MEDIANTE UN ATRIBUTO A UN VALOR NUEVO
     *
     * @param atributo
     * @param valorABuscar
     * @param valorNuevo
     */
    @Override
    public void actualizar(String atributo, String valorABuscar, JTextField valorNuevo) {
        Departamento d = buscarPor(valorABuscar);
        String nuevo=valorNuevo.getText();
        String sql = "UPDATE departamento SET " + atributo + "=? WHERE nombre=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(2, valorABuscar);
            switch(atributo){
                case "codDepartamento"->{
                    d.setCodigoDepartamento(nuevo);
                    stmt.setString(1,nuevo);
                }
                case "nombre"->{
                    d.setNombre(nuevo);
                    stmt.setString(1, nuevo);
                }
                case "idJefe"->{
                    d.setIdJefe(Integer.parseInt(nuevo));
                    stmt.setInt(1, Integer.parseInt(nuevo));
                }
            }
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
     * METODO QUE LISTA TODOS LOS DEPARTAMENTOS
     */
    public void mostrarTodosDepartamentos() {
        SortedSet<Departamento> listaDepartamento = listar();
        for (Departamento d : listaDepartamento) {
            System.out.println(d.toString());
        }
    }

    /**
     * METODO QUE CREA UN DEPARTAMENTO A PARTIR DE LOS DATOS DE MYSQL
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Departamento crearDepartamento(final ResultSet rs) throws SQLException {
        return new Departamento(rs.getInt("iddepartamento"), rs.getString("codDepartamento"), rs.getString("nombre"), rs.getInt("idJefe"));
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
