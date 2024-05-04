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

    public int idProfesor;
    private int idDepartamento;
    private String nombre;
    private String apellidos;
    private String DNI;
    private String correo;
    private boolean activo;
    private PerfilAcceso perfil;
    private String contrasenia;

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

    public PerfilAcceso getPerfil() {
        return perfil;
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


    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", correo=" + correo + ", activo=" + activo + ", perfil=" + perfil + ", contrasenia=" + contrasenia + '}';
    }

   

    
    
}