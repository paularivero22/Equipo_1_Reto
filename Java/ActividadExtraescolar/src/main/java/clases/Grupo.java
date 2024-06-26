/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Objects;

/**
 *
 * @author atres
 */
public class Grupo implements Comparable<Grupo>{
    private int idGrupo;
    private String codGrupo;
    private int idcurso;
    public int numeroAlumnos;
    public boolean activo;

   /**
    * CONSTRUCTOR POR PARÁMETROS QUE PIDE IDGRUPO
    * @param idGrupo
    * @param codGrupo
    * @param idcurso
    * @param numeroAlumnos
    * @param activo 
    */
    public Grupo(int idGrupo, String codGrupo, int idcurso, int numeroAlumnos, boolean activo) {
        this.idGrupo = idGrupo;
        this.codGrupo = codGrupo;
        this.idcurso = idcurso;
        this.numeroAlumnos = numeroAlumnos;
        this.activo = activo;
    }
    
    /**
     * CONSTRUCTOR POR PARÁMETROS QUE NO PIDE IDGRUPO
     * @param codGrupo
     * @param idcurso
     * @param numeroAlumnos
     * @param activo 
     */

    public Grupo(String codGrupo, int idcurso, int numeroAlumnos, boolean activo) {
        this.codGrupo = codGrupo;
        this.idcurso = idcurso;
        this.numeroAlumnos = numeroAlumnos;
        this.activo = activo;
    }
    /**
     * CONSTRUCTOR POR PARAMETROS QUE NO TIENE IDGRUPO NI IDCURSO
     * @param codGrupo
     * @param numeroAlumnos
     * @param activo 
     */
    public Grupo(String codGrupo, int numeroAlumnos, boolean activo) {
        this.codGrupo = codGrupo;
        this.numeroAlumnos = numeroAlumnos;
        this.activo = activo;
    }
    
    
    /**
     * METODOS GET Y SET
     * @return 
     */
    
    public int getIdGrupo() {
        return idGrupo;
    }

    public String getCodGrupo() {
        return codGrupo;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public void setCodGrupo(String codGrupo) {
        this.codGrupo = codGrupo;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    

    /**
     * METODOS EQUALS Y HASHCODE MIRANDO LA IDCURSO Y IDGRUPO
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idGrupo;
        hash = 41 * hash + Objects.hashCode(this.codGrupo);
        hash = 41 * hash + this.idcurso;
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
        final Grupo other = (Grupo) obj;
        if (this.idGrupo != other.idGrupo) {
            return false;
        }
        if (this.idcurso != other.idcurso) {
            return false;
        }
        return Objects.equals(this.codGrupo, other.codGrupo);
    }
    
    
    /**
     * METODO QUE DEVUELVE LA INFORMACIÓN DE UN GRUPO
     * @return 
     */
    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", codGrupo=" + codGrupo + ", idcurso=" + idcurso + ", numeroAlumnos=" + numeroAlumnos + ", activo=" + activo + '}';
    }

    /**
     * ORDENA POR CODGRUPO
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Grupo o) {
        return this.getCodGrupo().compareTo(o.getCodGrupo());
    }

    

    

   
    
    
    
}
