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
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JTextField;

/**
 *
 * @author atres
 */
public class SolicitudesDAO implements RepositorioDAO<Solicitud> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * Lista las solicitudes solicitadas
     *
     * @return
     */
    @Override
    public SortedSet<Solicitud> listar() {
        SortedSet<Solicitud> listaSolicitudes = new TreeSet<>();
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

    /**
     * METODO QUE BUSCA UNA SOLICITUD POR TITULO
     *
     * @param filtro
     * @return
     */
    @Override
    public Solicitud buscarPor(String filtro) {
        Solicitud solicitud = null;
        String sql = "select * from solicitud where titulo=?;";
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

    /**
     * METODO QUE ELIMINA POR TITULO
     *
     * @param filtro
     */
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

    /**
     * METODO QUE INSERTA UNA SOLICITUD A LA BASE DE DATOS
     *
     * @param t
     */
    @Override
    public void insertar(Solicitud t) {
        String sql = "INSERT into Solicitud(idActividad,horaInicio,horaFin,comentarios,prevista,Departamento,titulo,tipo,profesor,alojamiento,fechaInicio,fechaFinal,totalParticipantes,estado)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, t.getIdSolicitud());
            stmt.setTime(2, Time.valueOf(t.getHoraInicio()));
            stmt.setTime(3, Time.valueOf(t.getHoraFinal()));
            stmt.setString(4, t.getComentario());
            stmt.setBoolean(5, t.isPrevista());
            stmt.setInt(6, t.getIddepartamento());
            stmt.setString(7, t.getTitulo());
            stmt.setString(8, t.getTipoSolicitud().name());
            stmt.setInt(9, t.getIdprofesor());
            stmt.setBoolean(10, t.isAlojamiento());
            stmt.setDate(11, Date.valueOf(t.getFechaInicio()));
            stmt.setDate(12, Date.valueOf(t.getFechaFinal()));
            stmt.setInt(13, t.getTotalParticipantes());
            stmt.setString(14, t.getEstado().name());

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
     * METODO QUE ACTUALIZA UN ATRIBUTO A UN VALOR NUEVO
     *
     * @param atributo
     * @param valorABuscar
     * @param valorNuevo
     */
    @Override
    public void actualizar(String atributo, String valorABuscar, JTextField valorNuevo) {
        Solicitud so = buscarPor(valorABuscar);
        String sql = "UPDATE solicitud SET " + atributo + "=? WHERE titulo=?;";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            so.setComentario(valorNuevo.getText());
            stmt.setObject(1, so.getComentario());
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
     * Metodo que actualiza el estado de una solicitud
     *
     * @param valorABuscar
     * @param estado
     */
    public void actualizarEstado(String valorABuscar, String estado) {
        Solicitud so = buscarPor(valorABuscar);
        String sql = "UPDATE solicitud SET estado=? WHERE titulo=?;";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (estado.equalsIgnoreCase("APROBADA")) {
                so.setEstado(Estado.APROBADA);
            } else if (estado.equalsIgnoreCase("DENEGADA")) {
                so.setEstado(Estado.DENEGADA);
            }
            stmt.setString(1, estado);
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
     * Metodo que crea una solicitud a partir de los datos en mysql
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Solicitud crearSolicitud(final ResultSet rs) throws SQLException {
        return new Solicitud(rs.getInt("idActividad"), rs.getTime("horaInicio").toLocalTime(), rs.getTime("horaFin").toLocalTime(), rs.getString("comentarios"), rs.getBoolean("prevista"), rs.getInt("Departamento"), rs.getString("titulo"), Tipo.valueOf(rs.getString("tipo")), rs.getInt("profesor"), rs.getBoolean("alojamiento"), rs.getDate("fechaInicio").toLocalDate(), rs.getDate("fechaFinal").toLocalDate(), rs.getInt("totalParticipantes"), Estado.valueOf(rs.getString("estado")));
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
