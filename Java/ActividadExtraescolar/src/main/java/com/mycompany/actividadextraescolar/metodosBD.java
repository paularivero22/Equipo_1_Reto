/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */

public class metodosBD{

    
    
    /*
    //-------------------------------------------------------------------//
    //---    MÉTODOS PARA GESTIONAR LAS ACTIVIDADES EXRTRAESCOLARES   ---//
    //-------------------------------------------------------------------//
    

    //Método para insertar iuna nueva actividad extraescolar
    public void insertarActividadExtraescolar(String titulo, String descripcion, String tipo, String fechaInicio, String fechaFin, int totalParticipantes, String comentario) {
        String sql = "INSERT INTO ActividadExtraescolar (titulo, descripcion, tipo, fechaInicio, fechaFin, totalParticipantes, comentario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql);) {
                stmt.setString(1, titulo);
                stmt.setString(2, descripcion);
                stmt.setString(3, tipo);
                stmt.setString(4, fechaInicio);
                stmt.setString(5, fechaFin);
                stmt.setInt(6, totalParticipantes);
                stmt.setString(7, comentario);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Actividad extraescolar insertada correctamente.");
                } else {
                    System.out.println("No se pudo insertar la actividad extraescolar.");
                }
        } catch (SQLException ex) {
            System.out.println("Error al insertar actividad extraescolar: " + ex.getMessage());
        }
    }

    // Método para actualizar una actividad extraescolar existente
    public void actualizarActividadExtraescolar(int idActividad, String titulo, String descripcion, String tipo, String fechaInicio, String fechaFin, int totalParticipantes, String comentario) {
        try () 
            
                ) {
                String sql = "UPDATE ActividadExtraescolar SET titulo=?, descripcion=?, tipo=?, fechaInicio=?, fechaFin=?, totalParticipantes=?, comentario=? WHERE idActividad=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, titulo);
                    stmt.setString(2, descripcion);
                    stmt.setString(3, tipo);
                    stmt.setString(4, fechaInicio);
                    stmt.setString(5, fechaFin);
                    stmt.setInt(6, totalParticipantes);
                    stmt.setString(7, comentario);
                    stmt.setInt(8, idActividad);

                    int filasAfectadas = stmt.executeUpdate();
                    if (filasAfectadas > 0) {
                        System.out.println("Actividad extraescolar actualizada correctamente.");
                    } else {
                        System.out.println("No se pudo actualizar la actividad extraescolar.");
                    }
                }
            }catch (SQLException ex) {
                System.out.println("Error al actualizar actividad extraescolar: " + ex.getMessage());
            }
        }
        // Método para eliminar una actividad extraescolar
    public void eliminarActividadExtraescolar(int idActividad) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "DELETE FROM ActividadExtraescolar WHERE idActividad=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idActividad);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Actividad extraescolar eliminada correctamente.");
                } else {
                    System.out.println("No se pudo encontrar la actividad extraescolar para eliminar.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar actividad extraescolar: " + ex.getMessage());
        }
    }

    // Método para obtener todas las actividades extraescolares
    public List<ActividadExtraescolar> obtenerTodasLasActividadesExtraescolares() {
        List<ActividadExtraescolar> actividades = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "SELECT * FROM ActividadExtraescolar";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        ActividadExtraescolar actividad = new ActividadExtraescolar();
                        actividad.setIdActividad(rs.getInt("idActividad"));
                        actividad.setTitulo(rs.getString("titulo"));
                        actividad.setDescripcion(rs.getString("descripcion"));
                        actividad.setTipo(rs.getString("tipo"));
                        actividad.setFechaInicio(rs.getString("fechaInicio"));
                        actividad.setFechaFin(rs.getString("fechaFin"));
                        actividad.setTotalParticipantes(rs.getInt("totalParticipantes"));
                        actividad.setComentario(rs.getString("comentario"));
                        actividades.add(actividad);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener actividades extraescolares: " + ex.getMessage());
        }
        return actividades;
    }

    //-------------------------------------------------------------------//
    //------      MÉTODOS PARA GESTIONAR LOS PARTICIPANTES        -------//
    //-------------------------------------------------------------------//
    // Método para inscribir un estudiante en una actividad extraescolar
    public void inscribirEstudianteEnActividad(int idEstudiante, int idActividad) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "INSERT INTO EstudianteActividad (idEstudiante, idActividad) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idEstudiante);
                stmt.setInt(2, idActividad);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Estudiante inscrito en la actividad correctamente.");
                } else {
                    System.out.println("No se pudo inscribir al estudiante en la actividad.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al inscribir estudiante en actividad: " + ex.getMessage());
        }
    }

    // Método para eliminar un estudiante de una actividad extraescolar
    public void eliminarEstudianteDeActividad(int idEstudiante, int idActividad) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "DELETE FROM EstudianteActividad WHERE idEstudiante=? AND idActividad=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idEstudiante);
                stmt.setInt(2, idActividad);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Estudiante eliminado de la actividad correctamente.");
                } else {
                    System.out.println("No se pudo encontrar al estudiante en la actividad para eliminar.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar estudiante de actividad: " + ex.getMessage());
        }
    }

    // Método para obtener todos los estudiantes inscritos en una actividad extraescolar
    public List<Integer> obtenerEstudiantesInscritosEnActividad(int idActividad) {
        List<Integer> estudiantes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "SELECT idEstudiante FROM EstudianteActividad WHERE idActividad=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idActividad);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        estudiantes.add(rs.getInt("idEstudiante"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener estudiantes inscritos en actividad: " + ex.getMessage());
        }
        return estudiantes;
    }

    //-------------------------------------------------------------------//
    //------        MÉTODOS PARA GESTIONAR LOS PROFESORES         -------//
    //-------------------------------------------------------------------//
    // Método para agregar un nuevo profesor
    public void agregarProfesor(String nombre, String apellidos, String dni, String perfilAcceso, String departamento, String correo, boolean activo, String contraseña) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "INSERT INTO Profesor (nombre, apellidos, DNI, perfilAcceso, fk_departamento, correo, activo, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombre);
                stmt.setString(2, apellidos);
                stmt.setString(3, dni);
                stmt.setString(4, perfilAcceso);
                stmt.setString(5, departamento);
                stmt.setString(6, correo);
                stmt.setBoolean(7, activo);
                stmt.setString(8, contraseña);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Profesor agregado correctamente.");
                } else {
                    System.out.println("No se pudo agregar al profesor.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar profesor: " + ex.getMessage());
        }
    }

    // Método para actualizar información de un profesor
    public void actualizarProfesor(int idProfesor, String nombre, String apellidos, String dni, String perfilAcceso, String departamento, String correo, boolean activo, String contraseña) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "UPDATE Profesor SET nombre=?, apellidos=?, DNI=?, perfilAcceso=?, fk_departamento=?, correo=?, activo=?, contraseña=? WHERE idProfesor=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombre);
                stmt.setString(2, apellidos);
                stmt.setString(3, dni);
                stmt.setString(4, perfilAcceso);
                stmt.setString(5, departamento);
                stmt.setString(6, correo);
                stmt.setBoolean(7, activo);
                stmt.setString(8, contraseña);
                stmt.setInt(9, idProfesor);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Información del profesor actualizada correctamente.");
                } else {
                    System.out.println("No se pudo actualizar la información del profesor.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar profesor: " + ex.getMessage());
        }
    }

    // Método para eliminar un profesor
    public void eliminarProfesor(int idProfesor) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "DELETE FROM Profesor WHERE idProfesor=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idProfesor);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Profesor eliminado correctamente.");
                } else {
                    System.out.println("No se pudo encontrar al profesor para eliminar.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar profesor: " + ex.getMessage());
        }
    }

    // Método para obtener todos los profesores
    public List<Profesor> obtenerTodosLosProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "SELECT * FROM Profesor";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Profesor profesor = new Profesor();
                        profesor.setIdProfesor(rs.getInt("idProfesor"));
                        profesor.setNombre(rs.getString("nombre"));
                        profesor.setApellidos(rs.getString("apellidos"));
                        profesor.setDni(rs.getString("DNI"));
                        profesor.setPerfilAcceso(rs.getString("perfilAcceso"));
                        profesor.setDepartamento(rs.getString("fk_departamento"));
                        profesor.setCorreo(rs.getString("correo"));
                        profesor.setActivo(rs.getBoolean("activo"));
                        profesor.setContraseña(rs.getString("contraseña"));
                        profesores.add(profesor);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener profesores: " + ex.getMessage());
        }
        return profesores;
    }

    //-------------------------------------------------------------------//
    //------          MÉTODOS PARA GESTIONAR LOS GRUPOS           -------//
    //-------------------------------------------------------------------//
    // Método para crear un nuevo grupo
    public void crearGrupo(String codGrupo, String codCurso, int numAlumnos, boolean activo) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "INSERT INTO grupoAlumnos (codGrupo, fk_curso, numAlumnos, activo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, codGrupo);
                stmt.setString(2, codCurso);
                stmt.setInt(3, numAlumnos);
                stmt.setBoolean(4, activo);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Grupo creado correctamente.");
                } else {
                    System.out.println("No se pudo crear el grupo.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al crear grupo: " + ex.getMessage());
        }
    }

    // Método para agregar un estudiante a un grupo existente
    public void agregarEstudianteAGrupo(String codGrupo, int idEstudiante) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "INSERT INTO EstudianteGrupo (codGrupo, idEstudiante) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, codGrupo);
                stmt.setInt(2, idEstudiante);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Estudiante agregado al grupo correctamente.");
                } else {
                    System.out.println("No se pudo agregar al estudiante al grupo.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar estudiante al grupo: " + ex.getMessage());
        }
    }

    // Método para eliminar un estudiante de un grupo
    public void eliminarEstudianteDeGrupo(String codGrupo, int idEstudiante) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "DELETE FROM EstudianteGrupo WHERE codGrupo=? AND idEstudiante=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, codGrupo);
                stmt.setInt(2, idEstudiante);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Estudiante eliminado del grupo correctamente.");
                } else {
                    System.out.println("No se pudo encontrar al estudiante en el grupo para eliminar.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar estudiante del grupo: " + ex.getMessage());
        }
    }

    // Método para obtener todos los estudiantes de un grupo
    public List<Integer> obtenerEstudiantesDeGrupo(String codGrupo) {
        List<Integer> estudiantes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "SELECT idEstudiante FROM EstudianteGrupo WHERE codGrupo=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, codGrupo);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        estudiantes.add(rs.getInt("idEstudiante"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener estudiantes del grupo: " + ex.getMessage());
        }
        return estudiantes;
    }

    //-------------------------------------------------------------------//
    //------        MÉTODOS PARA GESTIONAR LAS SOLICITUDES        -------//
    //-------------------------------------------------------------------//
    // Método para realizar una solicitud de actividad extraescolar
    public void realizarSolicitudDeActividad(int idProfesor, String titulo, String tipo, String comentarios, boolean prevista, int departamento, int profesor, boolean alojamiento, String fechaInicio, String fechaFinal, int totalParticipantes, String comenAlojamiento) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "INSERT INTO Solicitud (idProfesor, titulo, tipo, comentarios, prevista, Departamento, profesor, alojamiento, fechaInicio, fechaFinal, totalParticipantes, comenAlojamiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idProfesor);
                stmt.setString(2, titulo);
                stmt.setString(3, tipo);
                stmt.setString(4, comentarios);
                stmt.setBoolean(5, prevista);
                stmt.setInt(6, departamento);
                stmt.setInt(7, profesor);
                stmt.setBoolean(8, alojamiento);
                stmt.setString(9, fechaInicio);
                stmt.setString(10, fechaFinal);
                stmt.setInt(11, totalParticipantes);
                stmt.setString(12, comenAlojamiento);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Solicitud realizada correctamente.");
                } else {
                    System.out.println("No se pudo realizar la solicitud.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al realizar solicitud de actividad: " + ex.getMessage());
        }
    }

    // Método para aprobar una solicitud de actividad extraescolar
    public void aprobarSolicitudDeActividad(int idSolicitud) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "UPDATE Solicitud SET estado='Aprobada' WHERE idActividad=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idSolicitud);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Solicitud aprobada correctamente.");
                } else {
                    System.out.println("No se pudo encontrar la solicitud para aprobar.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al aprobar solicitud de actividad: " + ex.getMessage());
        }
    }

    // Método para rechazar una solicitud de actividad extraescolar
    public void rechazarSolicitudDeActividad(int idSolicitud) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "UPDATE Solicitud SET estado='Rechazada' WHERE idActividad=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idSolicitud);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Solicitud rechazada correctamente.");
                } else {
                    System.out.println("No se pudo encontrar la solicitud para rechazar.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al rechazar solicitud de actividad: " + ex.getMessage());
        }
    }

    // Método para reservar recursos para una actividad extraescolar
    public void reservarRecursosParaActividad(int idActividad, String recursos) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            String sql = "UPDATE ActividadProgramada SET recursos=? WHERE idActividadProgramada=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, recursos);
                stmt.setInt(2, idActividad);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Recursos reservados correctamente.");
                } else {
                    System.out.println("No se pudo encontrar la actividad para reservar recursos.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al reservar recursos para actividad: " + ex.getMessage());
        }
    }

}
*/
}
