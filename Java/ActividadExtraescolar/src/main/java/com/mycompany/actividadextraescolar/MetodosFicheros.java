/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author atres
 */
public class MetodosFicheros {

    private static Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    public static void importarCSVCursos() {
        
        File fichero = new File("C:\\Users\\atres\\Documents\\TrabajoEquipo1\\Java\\Ficheros\\cursos.csv");
        FileReader fr;
        String linea = "";
        String sql = "INSERT into curso(idcurso,codcurso,descripcion,etapa,activo) VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    String idCurso = datoslinea[0];
                    String codCurso = datoslinea[1];
                    String descripcion = datoslinea[2];
                    String etapa = datoslinea[3];
                    String activo = datoslinea[4];

                    stmt.setInt(1, Integer.parseInt(idCurso));
                    stmt.setString(2, codCurso);
                    stmt.setString(3, descripcion);
                    stmt.setString(4, Etapa.valueOf(etapa).name());
                    stmt.setInt(5, Integer.valueOf(activo));
                    int salida = stmt.executeUpdate();
                    if (salida != 1) {
                        throw new Exception("Error, no se pudo insertar el registro");
                    }
                }
            } else {
                throw new NullPointerException("Error, el archivo no existe");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void importarCSVGrupos() {
        
        File fichero = new File("C:\\Users\\atres\\Documents\\TrabajoEquipo1\\Java\\Ficheros\\grupos.csv");
        FileReader fr;
        String linea = "";
        String sql = "INSERT into grupoAlumnos(codGrupo,fk_curso,numAlumnos,activo,idGrupo) VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    String idGrupo = datoslinea[0];
                    String codigoGrupo= datoslinea[1];
                    String idCurso = datoslinea[2];
                    String alumnos=datoslinea[3];
                    String activo = datoslinea[4];
                    
         
                    stmt.setInt(1, Integer.parseInt(codigoGrupo));
                    stmt.setString(2, codigoGrupo);
                    stmt.setString(3, alumnos);
                    stmt.setString(4,alumnos);
                    stmt.setInt(5, Integer.valueOf(activo));
                    int salida = stmt.executeUpdate();
                    if (salida != 1) {
                        throw new Exception("Error, no se pudo insertar el registro");
                    }
                }
            } else {
                throw new NullPointerException("Error, el archivo no existe");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void importarCSVDepartamento() {
        
        File fichero = new File("C:\\Users\\atres\\Documents\\TrabajoEquipo1\\Java\\Ficheros\\departamentos.csv");
        FileReader fr;
        String linea = "";
        String sql = "INSERT into departamento(iddepartamento,coddepartamento,nombre,idJefe)VALUES(?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    String iddepartamento = datoslinea[0];
                    String coddepartamento = datoslinea[1];
                    String nombre = datoslinea[2];
                    int idJefe=1;

                    stmt.setInt(1, Integer.parseInt(iddepartamento));
                    stmt.setString(2, coddepartamento);
                    stmt.setString(3, nombre);
                    stmt.setInt(4,idJefe++);
                    int salida = stmt.executeUpdate();
                    if (salida != 1) {
                        throw new Exception("Error, no se pudo insertar el registro");
                    }
                }
            } else {
                throw new NullPointerException("Error, el archivo no existe");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void importarCSVProfesores() {
        
        File fichero = new File("C:\\Users\\atres\\Documents\\TrabajoEquipo1\\Java\\Ficheros\\profesores.csv");
        FileReader fr;
        String linea = "";
        String sql = "INSERT into profesor(idProfesor,nombre,apellidos,DNI,perfilAcceso,fk_departamento,correo,activo,contraseña) VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql);) {
            if(fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    String apellidos = datoslinea[0];
                    String nombre = datoslinea[1];
                    String dni = datoslinea[2];
                    String email=datoslinea[3];
                    String departamento=datoslinea[4];
                    int id=1;
                    ps.setInt(1,id++);
                    ps.setString(2,nombre);
                    ps.setString(3, apellidos);
                    ps.setString(4,dni);
                    ps.setString(5, PerfilAcceso.valueOf("PROFESOR").name());
                    ps.setInt(6,Integer.parseInt(departamento));
                    ps.setString(7, email);
                    ps.setInt(8, 1);
                    ps.setString(9,generarPassword(6));
                    int salida=ps.executeUpdate();
                    if(salida!=1){
                        throw new Exception("Error, no se ha insertado los registros");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error en la inserción de datos " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String generarPassword(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        char[] password = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            password[i] = caracteres.charAt(r.nextInt(caracteres.length()));
        }
        return new String(password);
    }
    
}
