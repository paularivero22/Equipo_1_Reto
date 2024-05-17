/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosDB;

import metodosDB.AccesoBaseDatos;
import clases.MedioTransporte;
import clases.ActividadProgramada;
import Enumerados.TipoTransporte;
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
public class MedioTransporteDAO implements RepositorioDAO<MedioTransporte> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
/**
 * METODO QUE LISTA LOS MEDIODE TRANSPORTE
 * @return 
 */
    @Override
    public SortedSet<MedioTransporte> listar() {
        SortedSet<MedioTransporte> listaTransporte = new TreeSet<>();
        try (Statement stm = getConnection().createStatement(); ResultSet rs = stm.executeQuery("select mediotransporte.idTransporte, mediotransporte.tipo, mediotransporteutiliza.fk_actividad, mediotransporteutiliza.importe,mediotransporteutiliza.kilometros, mediotransporteutiliza.comentario from medioTransporte INNER JOIN mediotransporteutiliza on mediotransporte.idTransporte = mediotransporteutiliza.fk_transporte;");) {
            while (rs.next()) {
                MedioTransporte transporte=crearMedioTransporte(rs);
                if (!listaTransporte.add(transporte)) {
                    throw new Exception("Error, no se pudo mostrar la solicitud " + transporte.getTipo().name());
                }
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaTransporte;
    }

    /**
     * METODO QUE BUSCA UN MEDIO DE TRANSPORTE POR ID
     * @param valorABuscar
     * @return 
     */
    @Override
    public MedioTransporte buscarPor(String valorABuscar) {
        MedioTransporte medio = null;
        String sql = "select * from mediotransporte INNER JOIN mediotransporteutiliza on mediotransporte.idTransporte = mediotransporteutiliza.fk_transporte WHERE idTransporte =?;";
        try (PreparedStatement pst = getConnection().prepareStatement(sql);) {
            pst.setInt(1, Integer.parseInt(valorABuscar));
            try (ResultSet rs = pst.executeQuery();) {
                if (rs.next()) {
                    medio=crearMedioTransporte(rs);
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return medio;
    }
    
    /**
     * METODO QUE ELIMINA UN MEDIO DE TRANSPORTW
     * @param filtro 
     */

    @Override
    public void eliminarPor(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
/**
 * METODO QUE INSERTA UN MEDIO DE TRANSPORTE
 * @param t 
 */
    @Override
    public void insertar(MedioTransporte t) {
         String sql = "INSERT into mediotransporte(idTransporte,tipo)VALUES(?,?);";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
           stmt.setInt(1, t.getIdActividad());
           stmt.setString(2, t.getTipo().name());
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
     * METODO QUE INSERTA LOS MEDIOS DE TRANSPORTE A LA TABLA MEDIOUTILIZA
     * @param t
     * @param a 
     */
    public void insertarMedioUtiliza(MedioTransporte t,ActividadProgramada a){
        String sql = "INSERT into mediotransporteutiliza(kilometros,fk_transporte,fk_actividad,importe,comentario)VALUES(?,?,?,?,?);";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
           stmt.setDouble(1, t.getKilometros());
           stmt.setInt(2, t.getIdTransporte());
           stmt.setInt(3, a.getIdSolicitud());
           stmt.setDouble(4,t.getImporte());
           stmt.setString(5, a.getComentario());
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
     * METODO QUE ACTUALIZA LOS MEDIOS DE TRANSPORTE
     * @param filtro
     * @param valorABuscar
     * @param valornuevo 
     */
    @Override
    public void actualizar(String filtro, String valorABuscar, JTextField valornuevo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * METODO QUE CREA UN MEDIO DE TRANSPORTE
     * @param rs
     * @return
     * @throws SQLException 
     */
    private MedioTransporte crearMedioTransporte(final ResultSet rs) throws SQLException {
        return new MedioTransporte(rs.getInt("idTransporte"), rs.getInt("fk_actividad"), TipoTransporte.valueOf(rs.getString("tipo")), rs.getString("comentario"), rs.getDouble("importe"), rs.getInt("kilometros"));
    }

}
