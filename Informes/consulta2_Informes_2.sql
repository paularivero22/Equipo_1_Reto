SELECT 
    titulo, 
    fechaInicio, 
    fechaFinal, 
    horaInicio, 
    horaFin, 
    CASE 
        WHEN medioTransporte = 0 THEN 'no' 
        WHEN medioTransporte = 1 THEN 'sí' 
        ELSE 'desconocido' 
    END AS medioTransporte, 
    CASE 
        WHEN alojamiento = 0 THEN 'no' 
        WHEN alojamiento = 1 THEN 'sí' 
        ELSE 'desconocido' 
    END AS alojamiento, 
    prp.nombre AS profesor_participante, 
    prr.nombre AS profesor_responsable
FROM 
    actividadprogramada ap
LEFT JOIN 
    profesorsolicita as ps_participante ON ap.idActividadProgramada = ps_participante.fk_idActividad AND ps_participante.rol = 'PARTICIPANTE'
LEFT JOIN 
    profesorsolicita as ps_responsable ON ap.idActividadProgramada = ps_responsable.fk_idActividad AND ps_responsable.rol = 'RESPONSABLE'
LEFT JOIN 
    profesor as prp ON ps_participante.fk_idProfesor = prp.idProfesor
LEFT JOIN 
    profesor as prr ON ps_responsable.fk_idProfesor = prr.idProfesor 
WHERE 
    estado = 'REALIZADA' AND fechaFinal BETWEEN '2023-09-01' AND '2024-06-25';

