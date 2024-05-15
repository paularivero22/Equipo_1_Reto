UPDATE departamento d
INNER JOIN profesor p ON d.iddepartamento = p.fk_departamento
SET d.idJefe = p.idProfesor;
