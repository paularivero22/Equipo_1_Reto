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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JTextField;

/**
 *
 * @author atres
 */
public class ActividadProgramadaDAO implements RepositorioDAO<ActividadProgramada> {

    SolicitudesDAO metodosSolicitudes = new SolicitudesDAO();
    SortedSet<Solicitud> listaSolicitud = metodosSolicitudes.listar();

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * Metodo que lista las actividadesProgramadas
     *
     * @return
     */
    @Override
    public SortedSet<ActividadProgramada> listar() {
        SortedSet<ActividadProgramada> listaActividad = new TreeSet<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("SELECT * FROM actividadprogramada;");) {
            while (rs.next()) {
                ActividadProgramada ac = crearActividadProgramada(rs);
                if (!listaActividad.add(ac)) {
                    throw new Exception("Error, no se pudo mostrar la solicitud " + ac.getTitulo());
                }
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaActividad;
    }

    /**
     * METODO QUE BUSCA ACTIVIDADPROGRAMADA POR TITULO
     *
     * @param valorABuscar
     * @return
     */
    @Override
    public ActividadProgramada buscarPor(String valorABuscar) {
        ActividadProgramada ap = null;
        String sql = "select * from actividadprogramada where titulo=?;";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setString(1, valorABuscar);
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    ap = crearActividadProgramada(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return ap;
    }

    /**
     * METODO QUE ELIMINA UNA ACTIVIDADPROGRAMADA POR TITULO
     *
     * @param filtro
     */
    @Override
    public void eliminarPor(String filtro) {
        String sql = "DELETE FROM actividadprogramada WHERE titulo=?";
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

    /**
     * METODO QUE INSERTA UNA ACTIVIDADPROGRAMADA
     *
     * @param t
     */
    @Override
    public void insertar(ActividadProgramada t) {
        String sql = "INSERT into actividadprogramada(idActividadProgramada,estado,comentario,horaInicio,horaFin,prevista,Departamento,titulo,tipo,medioTransporte,profesor,alojamiento,fechaInicio,fechaFinal,totalParticipantes,comenRealizada)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, t.getIdSolicitud());
            stmt.setString(2, t.estado.name());
            stmt.setString(3, t.getComentario());
            stmt.setTime(4, Time.valueOf(t.getHoraInicio()));
            stmt.setTime(5, Time.valueOf(t.getHoraFinal()));
            stmt.setBoolean(6, t.prevista);
            stmt.setInt(7, t.iddepartamento);
            stmt.setString(8, t.titulo);
            stmt.setString(9, t.tipoSolicitud.name());
            stmt.setBoolean(10, t.isMedioTransporte());
            stmt.setInt(11, t.idprofesor);
            stmt.setBoolean(12, t.isAlojamiento());
            stmt.setDate(13, Date.valueOf(t.fechaInicio));
            stmt.setDate(14, Date.valueOf(t.fechaFinal));
            stmt.setInt(15, t.totalParticipantes);
            stmt.setString(16, t.getComentarioFase());

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
     * METODO QUE ACTUALIZA UNA ACTIVIDADPROGRAMADA
     *
     * @param atributo
     * @param valorABuscar
     * @param valornuevo
     */
    @Override
    public void actualizar(String atributo, String valorABuscar, JTextField valornuevo) {
        ActividadProgramada ap = buscarPor(valorABuscar);
        String sql = "UPDATE actividadprogramada SET " + atributo + "=? WHERE titulo=?;";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            switch (atributo) {
                case "horaInicio" -> {
                    ap.setHoraInicio(LocalTime.parse(valornuevo.getText()));
                    stmt.setTime(1, Time.valueOf(ap.horaInicio));
                }
                case "horaFin" -> {
                    ap.setHoraFinal(LocalTime.parse(valornuevo.getText()));
                    stmt.setTime(1, Time.valueOf(ap.horaFinal));
                }
                case "titulo" -> {
                    ap.setTitulo(valornuevo.getText());
                    stmt.setString(1, ap.titulo);
                }
                case "fechaInicio" -> {
                    ap.setFechaInicio(LocalDate.parse(valornuevo.getText()));
                    stmt.setDate(1, Date.valueOf(ap.fechaInicio));
                }
                case "fechaFinal" -> {
                    ap.setFechaFinal(LocalDate.parse(valornuevo.getText()));
                    stmt.setDate(1, Date.valueOf(ap.fechaFinal));
                }
                case "totalParticipantes" -> {
                    ap.setTotalParticipantes(Integer.parseInt(valornuevo.getText()));
                    stmt.setInt(1, ap.getTotalParticipantes());
                }
                case "comenRealizada" -> {
                    ap.setComentarioFase(valornuevo.getText());
                    stmt.setString(1, ap.getComentarioFase());
                }
            }
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
     * METODO QUE CREA UNA ACTIVIDADPROGRAMADA A PARTIR DE LOS DATOS DE MYSQL
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private ActividadProgramada crearActividadProgramada(final ResultSet rs) throws SQLException {
        return new ActividadProgramada(rs.getBoolean("medioTransporte"), rs.getString("comenRealizada"), rs.getInt("idActividadProgramada"), rs.getTime("horaInicio").toLocalTime(), rs.getTime("horaFin").toLocalTime(), rs.getString("comentario"), rs.getBoolean("prevista"), rs.getInt("Departamento"), rs.getString("titulo"), Tipo.valueOf(rs.getString("tipo")), rs.getInt("profesor"), rs.getBoolean("alojamiento"), rs.getDate("fechaInicio").toLocalDate(), rs.getDate("fechaFinal").toLocalDate(), rs.getInt("totalParticipantes"), Estado.valueOf(rs.getString("estado")));
    }

}
