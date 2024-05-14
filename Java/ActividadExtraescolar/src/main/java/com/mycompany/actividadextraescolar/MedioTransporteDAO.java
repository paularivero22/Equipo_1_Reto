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
 *
 * @author atres
 */
public class MedioTransporteDAO implements RepositorioDAO<MedioTransporte> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

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

    @Override
    public void eliminarPor(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar(MedioTransporte t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(String filtro, String valorABuscar, JTextField valornuevo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private MedioTransporte crearMedioTransporte(final ResultSet rs) throws SQLException {
        return new MedioTransporte(rs.getInt("idTransporte"), rs.getInt("fk_actividad"), TipoTransporte.valueOf(rs.getString("tipo")), rs.getString("comentario"), rs.getDouble("importe"), rs.getInt("kilometros"));
    }

}
