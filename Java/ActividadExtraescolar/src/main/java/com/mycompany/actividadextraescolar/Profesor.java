/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

/**
 *
 * @author Usuario
 */
public class Profesor {

    private int idProfesor;
    private String nombre;
    private String apellidos;
    private String DNI;
    private String correo;
    private boolean activo;
    private String contrasenia;

    public enum perfilAcceso {
        SUPERUSUARIO, ADMINISTRADOR, EQUIPO_DIRECTIVO, PROFESOR
    }

    public Profesor(int idProfesor, String nombre, String apellidos, String DNI, String correo, boolean activo, String contrasenia) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.correo = correo;
        this.activo = activo;
        this.contrasenia = contrasenia;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
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

    public String getContraseña() {
        return contrasenia;
    }

    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Profesor{" + "Identificador=" + idProfesor + ", Nombre=" + nombre + ", Apellidos=" + apellidos + ", DNI=" + DNI + ", Correo electrónico=" + correo + ", Trabajando=" + activo + ", Contraseña=" + contrasenia + '}';
    }
    
}
