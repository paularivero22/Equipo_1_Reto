SELECT 
	titulo,
	fechaInicio,
	fechaFinal,
	horaInicio,
	horaFin,
	grupoalumnos.codGrupo as Grupo,
	curso.codcurso as Curso,
	grupoparticipa.Numparticipantes as num_participantes_grupo,
	cursoparticipa.Numparticipantes as num_participantes_curso
FROM 
    actividadprogramada 
    
    left join grupoparticipa 
    on actividadprogramada.idActividadProgramada = grupoparticipa.fk_idActividad
    left join cursoparticipa
    on actividadprogramada.idActividadProgramada = cursoparticipa.fk_idActividad2
    left join grupoalumnos
    on grupoparticipa.fk_idGrupo = grupoalumnos.idGrupo
    left join curso
    on cursoparticipa.fk_idCurso = curso.idcurso
WHERE fechaFinal BETWEEN '2024-04-01' AND '2024-04-30';