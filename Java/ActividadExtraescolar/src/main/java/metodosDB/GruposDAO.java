/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosDB;

import clases.Curso;
import metodosDB.AccesoBaseDatos;
import clases.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JTextField;

public class GruposDAO implements RepositorioDAO<Grupo> {

    /**
     *
     * @return
     */
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * METODO QUE LISTA LOS DATOS DE LA TABLA GRUPO
     *
     * @return
     */
    @Override
    public SortedSet<Grupo> listar() {
        SortedSet<Grupo> listaGrupos = new TreeSet<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM grupoalumnos;")) {
            while (rs.next()) {
                Grupo grupo = crearGrupo(rs);
                listaGrupos.add(grupo);
            }
        } catch (SQLException sql) {
            System.out.println("Error SQL: " + sql.getMessage());
        }
        return listaGrupos;
    }

    /**
     * METODO QUE BUSCA UN GRUPO POR CODGRUPO
     *
     * @param codGrupo
     * @return
     */
    @Override
    public Grupo buscarPor(String codGrupo) {
        Grupo grupo = null;
        String sql = "SELECT * FROM grupoalumnos WHERE codGrupo=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setString(1, codGrupo);
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

    /**
     * METODO QUE ELIMINA SEGUN CODGRUPO
     *
     * @param filtro
     */
    @Override
    public void eliminarPor(String filtro) {
        String sql = "DELETE FROM grupoalumnos WHERE codGrupo=?";
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

    /**
     * METODO QUE INSERTA EL GRUPO A MYSQL
     *
     * @param g
     */
    @Override
    public void insertar(Grupo g) {
        String sql = "INSERT INTO grupoalumnos(codGrupo,fk_curso,idGrupo, numAlumnos, activo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, g.getCodGrupo());
            stmt.setInt(2, g.getIdcurso());
            stmt.setInt(3, g.getIdGrupo());
            stmt.setInt(4, g.getNumeroAlumnos());
            stmt.setBoolean(5, g.isActivo());
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

    /**
     *
     * @param atributo
     * @param valorABuscar
     * @param valorNuevo
     */
    @Override
    public void actualizar(String atributo, String valorABuscar, JTextField valorNuevo) {
        // Implementación para deshabilitar grupo
        Grupo grupo = buscarPor(valorABuscar);
        if (grupo != null) {
            String sql = "UPDATE grupoalumnos SET " + atributo + " =? WHERE codGrupo=?;";
            try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
                switch(atributo){
                    case "codGrupo"->{
                        grupo.setCodGrupo(valorNuevo.getText());
                        stmt.setString(1, grupo.getCodGrupo());
                    }
                    case "numAlumnos"->{
                        grupo.setNumeroAlumnos(Integer.parseInt(valorNuevo.getText()));
                        stmt.setInt(1, grupo.getNumeroAlumnos());
                    }
                }
                stmt.setString(2, valorABuscar);
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

    /**
     * METODO QUE LISTA TODOS LOS GRUPOS
     */
    public void mostrarTodosGrupos() {
        SortedSet<Grupo> listaGrupos = listar();
        for (Grupo c : listaGrupos) {
            System.out.println(c.toString());
        }
    }
    /**
     * METODO QUE ACTUALIZA EL ACTIVO 
     * @param valorABuscar
     * @param activo 
     */
     public void actualizarActivo(String valorABuscar,boolean activo) {
        Grupo g= buscarPor(valorABuscar);
        String sql = "UPDATE grupoalumnos SET activo=? WHERE codGrupo=?;";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            g.setActivo(activo);
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
     * METODO QUE CREA EL GRUPO A PARTIR DE LOS DATOS DE MYSQL
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Grupo crearGrupo(ResultSet rs) throws SQLException {
        return new Grupo(rs.getInt("idGrupo"), rs.getString("codGrupo"), rs.getInt("fk_curso"), rs.getInt("numAlumnos"), rs.getBoolean("activo"));
    }
}
