# DOCUMENTACION DEL RETO - EQUIPO 1 

## INDICE DE CONTENIDOS
1. [Bases de datos](#bd)
    - [Descripcion de la base de datos](#desBD)
    - [Diagrama E/R](#ER)
    - [Diagrama relacional](#REL)
    - [Script sql](#SQL)

2. [Pagina web](#PW) 
    - [Estructura de la pagina](#ESTRUCT)
    - [Tipos de estilo](#ESTILO)
    - [Contenido de la web](#CONT)

3. [Java](#JV)
    - [Diagrama de clases](DIAG)
    - [Documentacion de las clases](DOCU)
    - [Explicación](EXPL)

4. [Implementacion y despliegue](#IMPL)
    - [Tecnologias](#TEC)

---

## BASES DE DATOS<a name="bd"></a>
### 1. Descripcion de la base de datos<a name="desBD"></a>

### 2. Diagrama E/R<a name="ER"></a>
[![Diagrama-ER-Equipo-1-1.jpg](https://i.postimg.cc/5NGZbGsW/Diagrama-ER-Equipo-1-1.jpg)](https://postimg.cc/9rdxBx3L)

**Profesor** <br>
- idProf: identificador numerico, es clave primaria
- nombre
- apellidos
- dni
- Perfil de acceso: Podrá tomar los valores "superusuario", "administrador", "equipo directivo" o "profesor"
- CorreoInstitucional: correo propio del profesor, será UNIQUE
- Contraseña: Contraseña de acceso a la aplicacion
- Activo: registra si el profesor está activo o no, será de tipo boolean (TINYINT)

**Relacion pertenece**<br>
Un profesor puede pertenecer solo a un departamento y un departamento puede tener de 1 a muchos profesores

**Departamento**<br>
- idDep: identificador numerico, será clave primaria
- codDepartamento: codigo de departamento, estará formado por tres letras mayúsculas que no admite repeticiones
- nombre: nombre del departamento

**Relacion es_jefe**<br>
Un profesor puede ser jefe de departamento para ello creamos esta relación<br>
Un departamento puede tener solo un jefe y un profesor puede ser jefe de ninguno o de solo un departamento

**Solicitud**<br>
- id: Identificador numerico de la solicitud, será clave primaria
- Profesor: participacion de un profesor, solicitante, reponsable y participante
- Tipo: Tipo de actividad, podrá ser extraescolar o complementaria
- Departamento: Departamento al que pertenece el profesor solicitante
- Prevista: Si estaba o no prevista la activiada, será de tipo boolean (TINYINT)
- MedioTransporte: Si requiere medio de transporte, será de tipo booean (TINYINY)
- FechaInicio y FechaFinal: Fecha de comienzo y fin de la actividad
- HoraInicio y HoraFin: Horario de la actividad
- Alojamiento: Si requiere alojamiento, será de tipo boolean (TINYINT)
- comentAlojamiento: un comentario sobre el alojamiento
- Comentario: Comentario adicional sobre la solicitud

**Relacion solicita**<br>
Un profesor puede solicitar desde 1 a muchas actividades y una actividad puede ser solicitada de 1 a muchos profesores, dentro de la actividad el profesor tendrá un rol, que podrá ser solicitante, participante o responsable de la actividad 

**Curso**<br>
- idCurso: Identificador numerico del curso, será clave primaria
- codCurso: Código del curso, será de hasta 5 caracteres 
- descripcion: Texto descriptor del curso
- etapa: podrá ser ESO, Bachillerato, FPGS, FPGM, FPB, FPCE
- activod: si el curso esta activo es decir, si existe durante este año

**Grupo**<br>
- idGrupo: Idenificador numerico, será clave primaria
- codCurso: Codigo de grupo, será de hasta 8 caracteres
- numAlumnos: Numero de alumnos que forman el grupo
- activo: si el grupo esta activo es decir, si existe durante este año

**Relacion se_forma**<br>
Un curso esta formado por 1 o varios grupos (si no tuviera ningun grupo, significaría que no está activo) y un grupo pertenece a 1 solo curso

**Relacion participa**<br>
Varios grupos o cursos podrán participar en una actividad, por eso creamos está relacion
Un curso o grupo puede participar en 1 o muchas actividades y una actividad puede tener 1 o muchos cursos o 1 o muchos grupos 
De cada grupo o curso participante se registrán cuantos alumnos participan de cada uno, ya que en un curso o grupo puede haber, por ejemplo, 20 alumnos y solo participar 12 en una actividad

**Actividad programada**<br>
Si la solicitud de una actividad es aprobada, se hará una copia en la tabla de Actividades programadas (aprobadas), esta tabla tendrá los mismos campos que la tabla solicitud, que son:
- id: Identificador numerico de la actividad, será clave primaria
- Profesor: participacion de un profesor, solicitante, reponsable y participante
- Tipo: Tipo de actividad, podrá ser extraescolar o complementaria
- Departamento: Departamento al que pertenece el profesor solicitante
- Prevista: Si estaba o no prevista la activiada, será de tipo boolean (TINYINT)
- MedioTransporte: Si requiere medio de transporte, será de tipo booean (TINYINY)
- FechaInicio y FechaFinal: Fecha de comienzo y fin de la actividad
- HoraInicio y HoraFin: Horario de la actividad
- Alojamiento: Si requiere alojamiento, será de tipo boolean (TINYINT)
- comentAlojamiento: un comentario sobre el alojamiento
- ComentarioSolicitud: Comentario adicional sobre la solicitud<br>

Además se le añadiran 1 campo más<br>
- ComentarioRealizada: Comentario sobre la realización de la actividad

**Relacion resulta**<br>
Una solicitud puede ser aprobada 1 sola vez, una actividad programada tiene que haber sido solicitada 

**MedioTransporte**<br>
Si la actividad requiere medio de transporte necesitaremos registrar varias carácteristicas del mismo, por eso creamos esta tabla
- idTransporte: Identificador numerico del transporte, será clave primaria
- tipo: Tipo del transporte, podrá ser Andando, en bici, bus, taxi, tren, barco, avión.

**Relación utiliza**<br>
Una actividad puede utilizar o ninguno o varios transportes, un transporte puede ser utilizado por ninguna o muchas actividades<br>
- kilometros: una actividad puede utilizar un transporte solo para un tramo del recorrido
- Empresa: empresa del transporte elegido
- Importe: importe del transporte
- Comentario: cometario sobre el transporte
* Todos estos campos dependen de la actividad, por eso van en la relacion y no en la entidad (tabla)

**Foto actividad**<br>
- idFoto: Identificador numerico de la foto, será clave primaria
- url: Url a el archivo de la foto
- descripción: breve descripcion de la foto

**Relacion tiene**<br>
...

### 3. Diagrama relacional<a name="REL"></a>
[![Diagrama-relacional-Equipo-1-1.jpg](https://i.postimg.cc/L6vNS6Mb/Diagrama-relacional-Equipo-1-1.jpg)](https://postimg.cc/4m7zbGy6)

**Tabla curso**<br>
- idCurso(Primary Key)
- codCurso(UNIQUE)
- descripcion
- etapa
- activo 

**Tabla CursoParticipa**<br>
- idCurso(Foreign key)(Primary Key) <span style="color:red">*</span>
- idActividad(Foreign key)(Primary key) <span style="color:red">*</span>
- participantes 

<span style="color:red">* </span>Se crea el campo idCurso con la relacion Curso-Solicitud<br>
<span style="color:red">* </span> Se crea el campo idActividad con la relacion Solicitud-Curso

**Tabla Grupo**<br>
- idGrupo(Primary Key)
- codGrupo(UNIQUE)
- curso(Foreign key) <span style="color:red">*</span>
- numAlumnos
- activo

<span style="color:red">*</span> Se crea el campo curso(FK) con la relacion Curso-Grupo

**Tabla GrupoParticipa**<br>
- idGrupo(Foreign key)(Primary Key) <span style="color:red">*</span>
- idActividad(Foreign key)(Primary key) <span style="color:red">*</span>
- participantes

<span style="color:red">* </span> Se crea el campo idGrupo con la relacion Grupo-Solicitud<br>
<span style="color:red">* </span> Se crea el campo idActividad con la relacion Solicitud-Grupo

**Tabla Departamento**<br>
- idDep(PrimaryKey)
- codDepartamento(UNIQUE)
- nombre
- idJefe(Foreign Key) <span style="color:red">* </span>

<span style="color:red">* </span>Se crea el campo idJefe con la relacion Profesor- es_jefe -Departamento

**Tabla Profesor**<br>
- idProf(Primary Key)
- nombre
- apellidos
- dni
- departamento(Foreign Key) <span style="color:red">* </span>
- perfilAcceso
- correoInstitucional(UNIQUE)
- activo
- contraseña

<span style="color:red">* </span>Se crea el campo departamento con la relacion Profesor-Departamento

**Tala Solicitud**<br>
- id(Primary Key)
- profesor(Foreign key)
- titulo
- tipo
- departamento(Foreign Key)
- prevista
- medioTrasporte
- fechaInicio
- fechaFinal
- horaInicio
- horaFinal
- alojamiento
- comentAlojamiento
- comentario

**Tabla Solicita**<br>
- idProf(Primary Key)(Foreign Key)
- idActividad(PrimaryKey)(Foreign Key)
- rol

**Tabla ActividadProgramada**<br>
- id(Primary Key)
- profesor(Foreign key)
- titulo
- tipo
- departamento(Foreign Key)
- prevista
- medioTrasporte
- fechaInicio
- fechaFinal
- horaInicio
- horaFinal
- alojamiento
- comentAlojamiento
- comentario
- comentarioRealizada

**Tabla MedioTransporte**<br>
- idTransporte(PrimaryKey)
- tipo

**Tabla Utiliza**<br>
- idActividad(Primary Key)(Foreign Key)
- idTransporte(Primary Key)(Foreign Key)
- kilometros
- importe
- empresa
- comentario

**Tabla FotoActividad**<br>
- idFoto(PrimaryKey)
- url
- idActividad(Foreign Key) <span style="color:red">* </span>
- descripcion

<span style="color:red">* </span>Se crea el campo idActividad con la relacion ActividadProgramada - FotoActividad

### 4. Script sql<a name="SQL"></a>
[Enlace-al-script-sql]()

## PAGINA WEB<a name="PW"></a>
### 1. Estructura de la pagina<a name="ESTRUCT"></a>

### 2. Tipos de estilo<a name="ESTILO"></a>

### 3. Contenido de la web<a name="CONT"></a>


## Java<a name="JV"></a>
### 1. Diagrama de clases<a name="DIAG"></a>

### 2. Documentacion de las clases<a name="DOCU"></a>

### 3. Explicación<a name="EXPL"></a>


## Implementacion y despliegue<a name="IMPL"></a>
### 1. Tecnologias<a name="TEC"></a>

