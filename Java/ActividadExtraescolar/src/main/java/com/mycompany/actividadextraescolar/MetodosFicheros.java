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
import java.util.Iterator;
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

    //Metodo que lee cursos.csv y los inserta en una lista
    public static List<Curso> leerCSVCursos() {
        List<Curso> lista = new ArrayList<>();
        File fichero = new File("C:\\Users\\atres\\Documents\\Equipo_1_Reto\\Java\\Ficheros\\cursos.csv");
        FileReader fr;
        String linea = "";
        try {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    int idCurso = Integer.parseInt(datoslinea[0]);
                    String codCurso = datoslinea[1];
                    String descripcion = datoslinea[2];
                    Etapa etapa = Etapa.valueOf(datoslinea[3]);
                    boolean activo = formateoBoolean(datoslinea[4]);

                    //Curso c = new Curso(idCurso, codCurso, descripcion, etapa, activo);
                    //lista.add(c);
                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return lista;
    }
    //Metodo que lee departamentos.csv y los inserta en una lista

    public static List<Departamento> leerCSVDepartamentos() {
        List<Departamento> lista = new ArrayList<>();
        File fichero = new File("C:\\Users\\atres\\Documents\\Equipo_1_Reto\\Java\\Ficheros\\departamentos.csv");
        FileReader fr;
        String linea = "";
        int idJefe = 15;
        try {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    int idDepartamento = Integer.parseInt(datoslinea[0]);
                    String codDepartamento = datoslinea[1];
                    String nombre = datoslinea[2];
                    idJefe++;

                    Departamento d = new Departamento(idDepartamento, codDepartamento, nombre, idJefe);
                    lista.add(d);
                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return lista;
    }

    //Metodo que lee profesores.csv y los inserta en una lista
    public static List<Profesor> leerCSVProfesores() {
        List<Profesor> lista = new ArrayList<>();
        File fichero = new File("C:\\Users\\atres\\Documents\\Equipo_1_Reto\\Java\\Ficheros\\profesores.csv");
        FileReader fr;
        String linea = "";
        int idProfesor = 0;
        try {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    String apellidos = datoslinea[0];
                    String nombre = datoslinea[1];
                    String dni = datoslinea[2];
                    String email = datoslinea[3];
                    int departamento = Integer.parseInt(datoslinea[4]);
                    idProfesor++;
                    Profesor p = new Profesor(idProfesor, departamento, nombre, apellidos, dni, email, true, PerfilAcceso.PROFESOR, generarPassword(7));
                    lista.add(p);

                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return lista;
    }

    //Metodo que lee grupos.csv y los inserta en una lista
    public static List<Grupo> leerCSVGrupoAlumnos() {
        List<Grupo> lista = new ArrayList<>();
        File fichero = new File("C:\\Users\\atres\\Documents\\Equipo_1_Reto\\Java\\Ficheros\\grupos.csv");
        FileReader fr;
        String linea = "";
        try {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    int idGrupo = Integer.parseInt(datoslinea[0]);
                    String codGrupo=datoslinea[1];
                    int idCurso=Integer.parseInt(datoslinea[2]);
                    int alumnos=Integer.parseInt(datoslinea[3]);
                    boolean activo=formateoBoolean(datoslinea[4]);
                    Grupo g=new Grupo(idGrupo,codGrupo,idCurso,alumnos,activo);
                    lista.add(g);
                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return lista;
    }

    //Metodo que inserta una lista de cursos a la bd
    public static void insertarCurso(List<Curso> lista) {
        String sql = "INSERT into curso(idcurso,codcurso,descripcion,etapa,activo) VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            Iterator<Curso> it = lista.iterator();
            while (it.hasNext()) {
                Curso c = it.next();
                stmt.setInt(1, c.getIdCurso());
                stmt.setString(2, c.getCodCurso());
                stmt.setString(3, c.getDescripcion());
                stmt.setString(4, c.getEtapa().name());
                stmt.setBoolean(5, c.isActivo());
                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    throw new Exception("Error, no se pudo insertar el registro");
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo que inserta una lista de departamentos a la bd
    public static void insertarDepartamento(List<Departamento> lista) {
        String sql = "INSERT into departamento(iddepartamento,codDepartamento,nombre,idJefe)VALUES(?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            Iterator<Departamento> it = lista.iterator();
            while (it.hasNext()) {
                Departamento d = it.next();
                stmt.setInt(1, d.getIdDepartamento());
                stmt.setString(2, d.getCodigoDepartamento());
                stmt.setString(3, d.getNombre());
                stmt.setInt(4, d.getIdJefe());
                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    throw new Exception("Error, no se pudo insertar el registro");
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo que inserta los datos de la lista de profesores a la bd
    public static void insertarProfesores(List<Profesor> listaProfesor) {
        String sql = "INSERT into profesor(idProfesor,nombre,apellidos,DNI,perfilAcceso,fk_departamento,correo,activo,contraseña)VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            Iterator<Profesor> it = listaProfesor.iterator();
            while (it.hasNext()) {
                Profesor p = it.next();
                stmt.setInt(1, p.getIdProfesor());
                stmt.setString(2, p.getNombre());
                stmt.setString(3, p.getApellidos());
                stmt.setString(4, p.getDNI());
                stmt.setString(5, p.getPerfil().name());
                stmt.setInt(6, p.getIdDepartamento());
                stmt.setString(7, p.getCorreo());
                stmt.setBoolean(8, p.isActivo());
                stmt.setString(9, p.getContrasenia());
                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    throw new Exception("Error, no se pudo insertar el registro");
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Metodo que inserta los datos de una lista de grupos de alumnos a la bd
     public static void insertarGruposAlumnos(List<Grupo> lista) {
        String sql = "INSERT into grupoalumnos(codGrupo,fk_curso,numAlumnos,activo,idGrupo)VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            Iterator<Grupo> it = lista.iterator();
            while (it.hasNext()) {
                Grupo g= it.next();
                stmt.setString(1, g.getCodGrupo());
                stmt.setInt(2,g.getIdcurso());
                stmt.setInt(3, g.getNumeroAlumnos());
                stmt.setBoolean(4,g.isActivo());
                stmt.setInt(5, g.getIdGrupo());
                
                int salida = stmt.executeUpdate();
                if (salida != 1) {
                    throw new Exception("Error, no se pudo insertar el registro");
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

     //Metodo que genera una contraseña aleatoria para los profesores
    private static String generarPassword(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        char[] password = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            password[i] = caracteres.charAt(r.nextInt(caracteres.length()));
        }
        return new String(password);
    }

    //Metodo que formatea los booleanos
    private static boolean formateoBoolean(String cad) {

        return Integer.parseInt(cad) == 1 ? true : false;
    }

}
