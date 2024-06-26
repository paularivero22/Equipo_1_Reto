/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Enumerados.PerfilAcceso;
import Enumerados.PerfilAcceso;
import java.util.Objects;
import java.util.Random;

/**
 * 
 * @author Usuario
 */
public class Profesor implements Comparable<Profesor> {

    public int idProfesor;
    private int idDepartamento;
    private String nombre;
    private String apellidos;
    private String DNI;
    private String correo;
    private boolean activo;
    private PerfilAcceso perfil;
    private String contrasenia;

    /**
     * CONSTRUCTOR POR PARÁMETROS QUE PIDE IDPROFESOR
     * @param idProfesor
     * @param idDepartamento
     * @param nombre
     * @param apellidos
     * @param DNI
     * @param correo
     * @param activo
     * @param perfil
     * @param contrasenia 
     */
    
    public Profesor(int idProfesor, int idDepartamento, String nombre, String apellidos, String DNI, String correo, boolean activo, PerfilAcceso perfil, String contrasenia) {
        this.idProfesor = idProfesor;
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.correo = correo;
        this.activo = activo;
        this.perfil = perfil;
        this.contrasenia = contrasenia;
    }

    /**
     * CONTRUCTOR POR PARÁMETROS SIN IDPROFESOR
     * @param idDepartamento
     * @param nombre
     * @param apellidos
     * @param DNI
     * @param correo
     * @param activo
     * @param perfil
     * @param contrasenia 
     */
    public Profesor(int idDepartamento, String nombre, String apellidos, String DNI, String correo, boolean activo, PerfilAcceso perfil, String contrasenia) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.correo = correo;
        this.activo = activo;
        this.perfil = perfil;
        this.contrasenia = contrasenia;
    }
/**
 * CONSTRUCTOR SIN PARÁMETROS
 */
    public Profesor() {
    } 

    /**
     * METODOS GET Y SET
     * @return 
     */
    public PerfilAcceso getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilAcceso perfil) {
        this.perfil = perfil;
    }
    
    
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    

    public String getContrasenia() {
        return contrasenia;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
/**
 * METODO EQUALS Y HASHCODE
 * @return 
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idProfesor;
        hash = 89 * hash + Objects.hashCode(this.DNI);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (this.idProfesor != other.idProfesor) {
            return false;
        }
        return Objects.equals(this.DNI, other.DNI);
    }


    /**
     * METODO QUE MUESTRA INFORMACIÓN DEL PROFESOR
     * @return 
     */
    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", correo=" + correo + ", activo=" + activo + ", perfil=" + perfil + ", contrasenia=" + contrasenia + '}';
    }

    /**
     * METODO QUE GENERAR ALEATORIAMENTE UNA CONTRASEÑA PARA EL PROFESOR
     * @param longitud
     * @return 
     */
    public static String generarPassword(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        char[] password = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            password[i] = caracteres.charAt(r.nextInt(caracteres.length()));
        }
        return new String(password);
    }
/**
 * METODO ORDENA POR IDPROFESOR
 * @param o
 * @return 
 */
    @Override
    public int compareTo(Profesor o) {
        return Integer.compare(this.getIdProfesor(), o.getIdProfesor());
    }

    
    
}
