/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author atres
 */
public class SolicitudesDAO implements RepositorioDAO<Solicitud> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
//Lista las solicitudes solicitadas

    @Override
    public List<Solicitud> listar() {
        List<Solicitud> listaSolicitudes = new ArrayList<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM solicitud;");) {
            while (rs.next()) {
                Solicitud solicitud = crearSolicitud(rs);
                if (!listaSolicitudes.add(solicitud)) {
                    throw new Exception("Error, no se pudo mostrar la solicitud " + solicitud.getTitulo());
                }
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaSolicitudes;
    }

    @Override
    public Solicitud buscarPor(String filtro) {
        Solicitud solicitud = null;
        String sql = "SELECT * FROM Solicitud WHERE titulo=?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setString(1, filtro);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    solicitud = crearSolicitud(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return solicitud;
    }

    @Override
    public void eliminarPor(String filtro) {
        String sql = "DELETE FROM solicitud WHERE titulo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, filtro);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            } else {
                System.out.println("Se ha eliminado la solicitud " + filtro);
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertar(Solicitud t) {
        String sql = "INSERT into Solicitud(idActividad,horaInicio,horaFin,comentarios,prevista,Departamento,titulo,tipo,medioTransporte,profesor,alojamiento,fechaInicio,fechaFinal,totalParticipantes,comenAlojamiento)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, t.getIdSolicitud());
            stmt.setTime(2, Time.valueOf(t.getHoraInicio()));
            stmt.setTime(3, Time.valueOf(t.getHoraFinal()));
            stmt.setString(4, t.getComentario());
            stmt.setBoolean(5, t.isPrevista());
            stmt.setInt(6, t.getIddepartamento());
            stmt.setString(7, t.getTitulo());
            stmt.setString(8, t.getTipoSolicitud().name());
            stmt.setBoolean(9, t.isMedioTransporte());
            stmt.setInt(10, t.getIdprofesor());
            stmt.setBoolean(11, t.isAlojamiento());
            stmt.setDate(12, Date.valueOf(t.getFechaInicio()));
            stmt.setDate(13, Date.valueOf(t.getFechaFinal()));
            stmt.setInt(14, t.getTotalParticipantes());
            stmt.setString(15, t.getComentarioAlojamiento());

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
        Solicitud so = buscarPor(filtro);
        String sql = "UPDATE totalPartcipantes=? WHERE titulo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            so.setTotalParticipantes(200);
            stmt.setString(2, filtro);
            stmt.setInt(1, so.getTotalParticipantes());
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
//Metodo que crea una solicituf a partir de los datos en mysql

    private Solicitud crearSolicitud(final ResultSet rs) throws SQLException {
        return new Solicitud(rs.getInt("idActividad"), rs.getTime("horaInicio").toLocalTime(), rs.getTime("horaFin").toLocalTime(), rs.getString("comentarios"), rs.getBoolean("prevista"), rs.getInt("Departamento"), rs.getString("titulo"), Tipo.valueOf(rs.getString("tipo")), rs.getBoolean("medioTransporte"), rs.getInt("profesor"), rs.getBoolean("alojamiento"), rs.getDate("fechaInicio").toLocalDate(), rs.getDate("fechaFinal").toLocalDate(), rs.getInt("totalParticipantes"), rs.getString("comenAlojamiento"), Estado.SOLICITADA);
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
