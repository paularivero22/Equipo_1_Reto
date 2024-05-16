# **DOCUMENTACIÓN DEL RETO - EQUIPO 1**

### **Integrantes:**<br>
### - Adrian Tresgallo
### - Rodrigo Ruiz
### - Néstor Serna 
### - Paula Rivero
---
<br>

## **ÍNDICE DE CONTENIDOS**
1. [Bases de datos](#bd)
    - [Descripcion de la base de datos](#desBD)
    - [Diagrama E/R](#ER)
    - [Diagrama relacional](#REL)
    - [Script sql](#SQL)

2. [Pagina web](#PW) 
    - [Estructura de la página](#ESTRUCT)
    - [Tipos de estilo](#ESTILO)
    - [Contenido de la web](#CONT)

3. [Java](#JV)
    - [Diagrama de clases](DIAG)
    - [Diagrama de casos de uso](USO)
    - [Documentacion de las clases](DOCU)
    - [Explicación](EXPL)

4. [Implementacion y despliegue](#IMPL)
    - [Tecnologias](#TEC)


<br><br>

## **BASES DE DATOS**<a name="bd"></a>
<hr>

### **1. Descripción de la base de datos**<a name="desBD"></a>
![Diagrama paso a tablas](./Imagenes/diagrama%20paso%20a%20tablas.png)
<br><br>
**Tabla GrupoAlumnos**<br>
- codGrupo VARCHAR(10)
- fk_curso INT
- numAlumnos VARCHAR(45)
- activo TINYINT
- idGrupo INT

**Tabla GrupoParticipa**<br>
- fk_idGrupo INT
- fk_idActividad INT
- Numparticipantes INT

**Tabla Curso**<br>
- idCurso INT
- codCurso VARCHAR(10)
- descripcion VARCHAR(50)
- etapa ENUM(...)
- activo TINYINY

**Tabla cursoparticipa**<br>
- fk_idCurso INT
- fk_idActividad2 INT
- Numparticipantes INT

**Tabla departamento**<br>
- iddepartamento INT
- codDepartamento VARCHAR(45)
- nombre VARCHAR(45)
- idJefe INT

**Tabla profesor**<br>
- idProfesor INT 
- nombre VARCHAR(33)
- apellidos VARCHAR(45)
- DNI VARCHAR(9)
- perfilAcceso ENUM(...)
- fk_departamento VARCHAR(30)
- correo VARCHAR(45)
- activo TINYINT
- contraseña VARCHAR(20)

**Tala solicitud**<br>
- idActividad INT
- horaInicio TIME
- horaFin TIME
- comentario VARCHAR(50)
- prevista TINYINT
- departamento INT
- titulo VARCHAR(45)
- tipo ENUM(...)
- profesor INT
- alojamiento TINYINY
- fechaInicio DATE
- fechaFinal DATE
- totalParticipantes INT
- estado ENUM

**Tabla profesorsolicita**<br>
- rol enum(..)
- fk_idProfesor INT
- fk_idActividad INT

**Tabla actividadprogramada**<br>
- idActividadProgramada INT
- estado ENUM
- comentario VARCHAR(50)
- horaInicio TIME
- horaFin TIME
- prevista TINYINT
- departamento INT
- titulo VARCHAR(45)
- tipo ENUM(...)
- medioTransporte TINYINT
- profesor INT
- alojamiento TINYINY
- fechaInicio DATE
- fechaFinal DATE
- comentAlojamiento VARCHAR(45)
- totalParticipantes INT
- comentRealizada VARCHAR(45)


**Tabla mediotransporte**<br>
- idTransporte INT
- tipo ENUM(...)

**Tabla mediotransporteutiliza**<br>
- kilometros DOUBLE
- fk_idTransporte INT
- fk_idActividad INT
- importe double
- comentario VARCHAR(45)

**Tabla fotoactividad**<br>
- url VARCHAR(45)
- descripción VARCHAR(45)
- idFoto INT
- fk_idActividad INT


<span style="color:red">* </span>Se crea el campo idActividad con la relacion ActividadProgramada - FotoActividad

### **2. Diagrama E/R**<a name="ER"></a>
[![Diagrama-ER-Equipo-1-1.jpg](https://i.postimg.cc/5NGZbGsW/Diagrama-ER-Equipo-1-1.jpg)](https://postimg.cc/9rdxBx3L)

**Profesor** <br>
- idProf: identificador numérico, es clave primaria
- nombre
- apellidos
- dni
- Perfil de acceso: Podrá tomar los valores "superusuario", "administrador", "equipo directivo" o "profesor"
- CorreoInstitucional: correo propio del profesor, será UNIQUE
- Contraseña: contraseña de acceso a la aplicación
- Activo: registra si el profesor está activo o no, será de tipo boolean (TINYINT)

**Relacion pertenece**<br>
Un profesor puede pertenecer solo a un departamento y un departamento puede tener de 1 a muchos profesores

**Departamento**<br>
- idDep: identificador numérico, será clave primaria
- codDepartamento: código de departamento, estará formado por tres letras mayúsculas que no admite repeticiones
- nombre: nombre del departamento

**Relacion es_jefe**<br>
Un profesor puede ser jefe de departamento para ello creamos esta relación<br>
Un departamento puede tener solo un jefe y un profesor puede ser jefe de ninguno o de solo un departamento

**Solicitud**<br>
- id: Identificador numérico de la solicitud, será clave primaria
- Profesor: participación de un profesor: solicitante, reponsable y participante
- Tipo: Tipo de actividad, podrá ser extraescolar o complementaria
- Departamento: Departamento al que pertenece el profesor solicitante
- Prevista: Si estaba o no prevista la activiadad, será de tipo boolean (TINYINT)
- MedioTransporte: Si requiere medio de transporte, será de tipo booean (TINYINY)
- FechaInicio y FechaFinal: Fecha de comienzo y fin de la actividad
- HoraInicio y HoraFin: Horario de la actividad
- Alojamiento: Si requiere alojamiento, será de tipo boolean (TINYINT)
- comentAlojamiento: un comentario sobre el alojamiento
- Comentario: Comentario adicional sobre la solicitud

**Relacion solicita**<br>
Un profesor puede solicitar desde 1 a muchas actividades y una actividad puede ser solicitada de 1 a muchos profesores, dentro de la actividad el profesor tendrá un rol, que podrá ser solicitante, participante o responsable de la actividad 

**Curso**<br>
- idCurso: Identificador numérico del curso, será clave primaria
- codCurso: Código del curso, será de hasta 5 caracteres 
- descripción: Texto descriptivo del curso
- etapa: podrá ser ESO, Bachillerato, FPGS, FPGM, FPB, FPCE
- activod: si el curso esta activo es decir, si existe durante este año

**Grupo**<br>
- idGrupo: Idenificador numérico, será clave primaria
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
- id: Identificador numérico de la actividad, será clave primaria
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
- idTransporte: Identificador numérico del transporte, será clave primaria
- tipo: Tipo del transporte, podrá ser Andando, en bici, bus, taxi, tren, barco, avión.

**Relación utiliza**<br>
Una actividad puede utilizar o ninguno o varios transportes, un transporte puede ser utilizado por ninguna o muchas actividades<br>
- kilometros: una actividad puede utilizar un transporte solo para un tramo del recorrido
- Empresa: empresa del transporte elegido
- Importe: importe del transporte
- Comentario: cometario sobre el transporte
* Todos estos campos dependen de la actividad, por eso van en la relacion y no en la entidad (tabla)

**Foto actividad**<br>
- idFoto: Identificador numérico de la foto, será clave primaria
- url: Url a el archivo de la foto
- descripción: breve descripción de la foto

**Relacion tiene**<br>
...

### **3. Diagrama relacional**<a name="REL"></a>
[![Diagrama-relacional-Equipo-1-1.jpg](https://i.postimg.cc/L6vNS6Mb/Diagrama-relacional-Equipo-1-1.jpg)](https://postimg.cc/4m7zbGy6)

**Tabla curso**<br>
- idCurso(Primary Key)
- codCurso(UNIQUE)
- descripción
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
- descripción

<span style="color:red">* </span>Se crea el campo idActividad con la relacion ActividadProgramada - FotoActividad

### **4. Script sql**<a name="SQL"></a>
[Enlace-al-script-sql](https://github.com/paularivero22/Equipo_1_Reto/tree/3799f667727a6506bd0801b6774985d31df1fc63/Base%20datos)
<br><br>

## **PÁGINA WEB**<a name="PW"></a>
<hr>

### **1. Estructura de la página**<a name="ESTRUCT"></a><br><br>
### **1.1 Estructura comun de todas las páginas**<br>
- ### **Body** <br>
    <br>- **Header:** cabecera de la página <br><br>
    ```html
    <header>
        <div class="contenido-cabecera">
            <a href="./Inicio.html">
                <img src="./Imagenes./logo.png" class="LogoImagen">
            </a>
        </div>
    </header>
    ```
 
    - div "contenido cabecera": contenedor con el logo de IES miguel herrero <br>

    <br>- **Nav:** nav con un menú para navegar entre las páginas<br><br>
    ```html
      <nav id="menuprincipal">
        <div>
            <ul id="listamenu">
                <li>
                    <a href="./Inicio.html">
                        <img src="./Iconos./casa.png" alt="Inicio" class="iconosMenu">
                    </a>
                    <a href="./Inicio.html">INICIO</a>
                </li>

                <li>
                    <a href="./Actividades.html">
                        <img src="./Iconos./actividad.png" alt="Actividades" class="iconosMenu">
                    </a>
                    <a href="./Actividades.html">ACTIVIDADES</a>
                </li>
                <li>
                    <a href="./SobreNosotros.html">
                        <img src="./Iconos./info.png" alt="Sobre nosotros" class="iconosMenu">
                    </a>
                    <a href="./SobreNosotros.html">SOBRE NOSOTROS</a>
                </li>
                <li>
                    <a href="./GaleriaDeFotos.html">
                        <img src="./Iconos./foto.png" alt="Inicio" class="iconosMenu">
                    </a>
                    <a href="./GaleriaDeFotos.html">GALERIA</a>
                </li>
            </ul>
        </div>
    </nav>
    ```
    - div: contendor para la los elementos del nav<br>
        - ul "listamenu": los elementos del menú seran una lista ordenada, cada elemento li es un icono y una imagen <br><br>

### **1.3 Página Inicio** <br>
- ### **Body** <br>  
    <br>- **Main:** contenido principal de la página<br><br>
    ```html
    <main>
        <div class="ImagenContenedor">
            <img src="./Imagenes./IES_MIGUEL_HERRERO_PEREDA.jpg" alt="IES MIGUEL HERRERO" class="ImagenPrincipal">
            <div class="texto">BIENVENIDO</div>
            <div class="botonFacebook">
                <ul>
                    <li>
                        <a href="https://www.facebook.com/profile.php?id=100087928148760" target="_blank">
                            <img src="./Iconos./facebookIcono.png" alt="Facebook">
                        </a>
                        <a href="https://www.facebook.com/profile.php?id=100087928148760"
                            target="_blank"><span>Facebook</span></a>
                    </li>
                </ul>
            </div>
        </div>

    </main>
    ```
    - div "ImagenContenedor": Contenedor con la imagen de la página, un texto y un recuadro<br>
        - div "texto": texto "Bienvenido" encima de la imagen 
        - div "botonFacebook": Un recuadro con el enlace al facecbook del insituto<br><br>

    <br>- **Footer:** pie de página con enlaces de interes del instituto<br><br>
    ```html
    <footer>
        <div class="pielogo">
            <div class="seccionpie">
                <h2>Contacto</h2>
                <a href="https://www.google.com/maps/place/Torrelavega+Cantabria" target="_blank"
                    class="enlace-contacto">
                    <img src="./Iconos./IconoMaps.png" alt="Mapa" width="20px" height="20px">
                    <span>P.º de Julio Hauzeur, 59, 39300, Torrelavega, Cantabria</span>
                </a><br><br>
                <a href="tel:+123456789" class="enlace-contacto">
                    <img src="./Iconos./telefonoIcono.png" alt="Teléfono" width="20px" height="20px">
                    <span>942 88 24 98</span>
                </a><br><br>
                <a href="mailto:ies.miguel.herrero.pereda@educantabria.es" class="enlace-contacto">
                    <img src="./Iconos./correo.png" alt="Correo electrónico" width="25px" height="25px">
                    <span>ies.miguel.herrero.pereda@educantabria.es</span>
                </a>
            </div>
            <div class="seccionpie">
                <h2>Redes sociales</h2>
                <ul class="iconos-sociales">
                    <li>
                        <a href="https://www.facebook.com/profile.php?id=100087928148760" target="_blank">
                            <img src="./Iconos./facebookIcono.png" alt="Facebook" class="Facebook">
                        </a>
                        <a href="https://www.facebook.com/profile.php?id=100087928148760"
                            target="_blank"><span>Facebook</span></a>
                    </li>
                    <li>
                        <a href="https://www.instagram.com/ies.miguelherrero/" target="_blank">
                            <img src="./Iconos./InstagramIcono.png" alt="Instagram" class="Instagram">
                        </a>
                        <a href="https://www.instagram.com/ies.miguelherrero/"
                            target="_blank"><span>Instagram</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <hr>
        <p> © Copyright 2024. Todos los derechos reservados. </p>
    </footer>
    ```
    - div "pielogo": contenedor con los enlaces de interes del footer
        - div "seccionpie": seccion 1 de enlaces, contiene la ubicacion y los enlaces de contacto (telefono y email)<br>
        Cada enlace contiene un icono y un enlace
        - div "seccionpie": seccion 2 de enlaces, contiene las redes sociales (facebook e instagram)
        Cada enlace es un elemento de una lista ordenada y contiene un icono y un enlace
        - p: Texto de compyright al final del footer

### **1.3 Página Actividades** <br>
- ### **Body** <br>
    <br>- **Main:** contenido principal de la página<br><br>
     - **TextoActividades**<br><br> 
       ```html
         <div class="TextoActividades">
            <h1>Actividades Extraescolares</h1>
        </div>
         ```
        - div "TextoActividades": Texto con etiquetas h1 que sirve de titulo
        <br><br>

     - **Viajes**<br><br>
       ```html
         <div class="Viajes">
            <p>Viajes Extraescolares</p>
        </div>
         ```
        - div "Viajes": Texto con etiquetas p que se utiliza a modo de titulo del apartado de Viajes Extraescolares
        <br><br>


     - **ViajesMain**<br><br>
       ```html
         <div class="ViajesMain">
            <table>
                <thead>
                    <tr>
                        <th>Actividad</th>
                        <th>Estado de Gestión</th>
                        <th>Personas Involucradas</th>
                        <th>Profesor responsable</th>
                        <th>Profesores participantes</th>
                        <th> Fecha </th>
                        <th> Horario </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Excursión al Museo de Historia Natural</td>
                        <td>En proceso</td>
                        <td>25 estudiantes,<br>3 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>09/05/2024</td>
                        <td>9:30-13:30</td>
                    </tr>
                    <tr>
                        <td>Visita al Acuario</td>
                        <td>Confirmado</td>
                        <td>20 estudiantes,<br>2 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>09/05/2024</td>
                        <td>9:30-13:30</td>
                    </tr>
                    <tr>
                        <td>Excursión al Parque Nacional</td>
                        <td>Pendiente</td>
                        <td>30 estudiantes,<br>4 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>09/05/2024</td>
                        <td>9:30-13:30</td>
                    </tr>
                    <tr>
                        <td>Visita a la Granja Educativa</td>
                        <td>Confirmado</td>
                        <td>15 estudiantes,<br>2 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>09/05/2024</td>
                        <td>9:30-13:30</td>
                    </tr>
                    <tr>
                        <td>Excursión al Planetario</td>
                        <td>Cancelado</td>
                        <td>10 estudiantes,<br>1 profesor</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>09/05/2024</td>
                        <td>9:30-13:30</td>
                    </tr>
                    <tr>
                        <td>Salida al Zoológico</td>
                        <td>En proceso</td>
                        <td>22 estudiantes,<br>3 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>09/05/2024</td>
                        <td>9:30-13:30</td>
                    </tr>
                </tbody>
            </table> 
        </div>
         ```
        - div "ViajesMain": div donde mediante el uso de la etiqueta table,thead y tr, se crea una tabla donde aparece la información de los Viajes Extraescolares
        <br><br>
    
     - **Clases**<br><br>
       ```html
         <div class="Clases">
            <p>Clases Extraescolares</p>
        </div>
         ```
        - div "Clases": Texto con etiquetas p que se utiliza a modo de titulo del apartado de Clases Extraescolares
        <br><br>
    
     - **ClasesMain**<br><br>
       ```html
         <div class="ClasesMain">
            <table>
                <thead>
                    <tr>
                        <th>Actividad</th>
                        <th>Estado de Gestión</th>
                        <th>Personas Involucradas</th>
                        <th>Profesor responsable</th>
                        <th>Profesores participantes</th>
                        <th>Horario y Fecha</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Informática</td>
                        <td>En proceso</td>
                        <td>25 estudiantes, 3 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>9:30-13:30 09/05/2024</td>
                    </tr>
                    <tr>
                        <td>Biologia</td>
                        <td>Confirmado</td>
                        <td>10 estudiantes, 1 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>9:30-13:30 09/05/2024</td>
                    </tr>
                    <tr>
                        <td>Robotica</td>
                        <td>Pendiente</td>
                        <td>30 estudiantes, 4 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>9:30-13:30 09/05/2024</td>
                    </tr>
                    <tr>
                        <td>Deportes</td>
                        <td>Confirmado</td>
                        <td>15 estudiantes, 2 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>9:30-13:30 09/05/2024</td>
                    </tr>
                    <tr>
                        <td>Historia</td>
                        <td>Cancelado</td>
                        <td>10 estudiantes, 1 profesor</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>9:30-13:30 09/05/2024</td>
                    </tr>
                    <tr>
                        <td>Economia</td>
                        <td>En proceso</td>
                        <td>22 estudiantes, 3 profesores</td>
                        <td>Pedro Perez</td>
                        <td>Alberto Jimenez, Roberto Gonzalez,Maria Benitez</td>
                        <td>9:30-13:30 09/05/2024</td>
                    </tr>
                </tbody>
            </table> 
        </div>
         ```
        - div "ClasesMain": div donde mediante el uso de la etiqueta table,thead,tbody,tr y td, se crea una tabla donde aparece la información de las Clases Extraescolares
        <br><br>

### **1.4 Página "Sobre Nosotros"**<br>
- ### **Body** <br>
    <br>- **Main:** contenido principal de la página<br><br>
     - **InformaciónTexto**<br><br>
       ```html
         <div class="InformacionTexto">
            <h1>Informacion</h1>
        </div>
         ```
        - div "InformacionTexto": Texto con etiquetas h1 que sirve de titulo del apartado donde queda reflejada la información del centro por escrito
        <br><br>
    
     - **Información**<br><br>
       ```html
         <div class="Informacion">
            <p>El IES Miguel Herrero Pereda se encuentra ubicado en Torrelavega, Cantabria. Es un instituto público de educación secundaria, bachillerato y formación profesional que ofrece una amplia variedad de programas educativos para sus estudiantes.
                <br>
                Oferta educativa:
                <br>
                <br><strong>Educación Secundaria Obligatoria (ESO)</strong>: El centro imparte la ESO con un enfoque en la preparación de los estudiantes para el bachillerato o la formación profesional.
                  <br>Bachillerato: Se ofrecen las siguientes modalidades de bachillerato:
                  <br>Ciencias y Tecnología.
                  <br>Humanidades y Ciencias Sociales.
                  <br>Artes.
                  <br>General.
                <br><strong>Formación Profesional (FP)</strong>: El IES Miguel Herrero Pereda ofrece ciclos de FP de grado medio en las siguientes áreas:
                  <br>Administración y Finanzas.
                  <br>Electricidad y Electrónica.
                  <br>Hostelería y Turismo.
                  <br>Informática.
                  <br>Instalaciones Eléctricas y Automáticas.</p>
        </div>
         ```
        - div "Información": Este div es utilizado para mostrar la informacion del centro entre etiquetas p
        <br><br>
    
     - **InstalacionTexto**<br><br>
       ```html
         <div class="Instalaciontexto">
            <h1>Instalaciones</h1>
        </div>
         ```
        - div "InstalacionTexto": Texto con etiquetas h1 que sirve de titulo del apartado donde quedan reflejadas las distintas instalaciones del centro junto con sus respectivas fotos
        <br><br>

     - **Instalaciones**<br><br>
       ```html
          <div class="instalaciones">
        <section class="secciones">
            <h2>Jefatura de Estudios</h2>
            <img src="./Imagenes./Jefatura de Estudios.jpg" alt="Jefatura de Estudios">
          </section>
      
          <section class="secciones">
            <h2>Secretaría</h2>
            <img src="./Imagenes./Secretaria.jpg" alt="Secretaría">
          </section>
      
          <section class="secciones">
            <h2>Hall centro</h2>
            <img src="./Imagenes./Hall.jpg" alt="Hall centro">
          </section>
      
          <section class="secciones">
            <h2>Informática</h2>
            <img src="./Imagenes./Informatica.jpeg" alt="Acceso a Conserjería">
          </section>

          <section class="secciones">
            <h2>Biblioteca</h2>
            <img src="./Imagenes./Biblioteca.jpg" alt="Acceso a Conserjería">
          </section>

          <section class="secciones">
            <h2>Gimnasio</h2>
            <img src="./Imagenes./Gimnasio.jpg" alt="Acceso a Conserjería">
          </section>

          <section class="secciones">
            <h2>Taller Mecanico</h2>
            <img src="./Imagenes./mecanizado.jpg" alt="Acceso a Conserjería">
          </section>

          <section class="secciones">
            <h2>Robótica</h2>
            <img src="./Imagenes./Robotica.jpg" alt="Acceso a Conserjería">
          </section>

          <section class="secciones">
            <h2>Salón de Actos</h2>
            <img src="./Imagenes./Salon_actos.jpg" alt="Acceso a Conserjería">
          </section>

          <section class="secciones">
            <h2>Administrativo</h2>
            <img src="./Imagenes./administrativo.jpg" alt="Acceso a Conserjería">
          </section>
        </div>
         ```
        - div "Instalaciones": Este div se utiliza para mostrar las distintantas secciones que aparecen en el codigo,donde estan las imagenes de las instalaciones
        <br><br>

    - **Secciones:**<br><br>
       ```html
         <section class="secciones">
            <h2>Jefatura de Estudios</h2>
            <img src="./Imagenes./Jefatura de Estudios.jpg" alt="Jefatura de Estudios">
          </section>
         ```
        - section "Secciones": En el div secciones, se muestra el nombre de la instalacion junto con su imagen, en este caso el ejemplo es de "Jefatura de estudios"
        <br><br>

     - **UbicacionTexto**<br><br>
       ```html
         <div class="Ubicaciontexto">
            <h1>Ubicación del Centro</h1>
        </div>
         ```
        - div "UbicacionTexto": Texto con etiquetas h1 que sirve de titulo del apartado donde se encuentra un mapa con la ubicación del centro
        <br><br>
    
     - **Ubicacion**<br><br>
       ```html
         <div class="Ubicacion">
            <iframe allowfullscreen="1" loading="lazy" src="https://maps.google.com/maps?q=43.35200359821082,-4.062908597564259&amp;hl=es;z=14&amp;output=embed" style="border:0;" width="60%" height="400"></iframe>  
        </div>
         ```
        - div "Ubicación": Este div se utiliza para mostrar un mapa que muestra donde se encuentra el instituto mediante la etiqueta iframe
        <br>
        <br>

### **1.3 Página Actividades** <br>
- ### **Body** <br>
    <br>- **Main:** contenido principal de la página<br><br>
     - **Galería (div)**<br><br> 
        Contenedor con todas las imagenes de la galeria separadas por secciones<br><br>
        - **imagenes (section)**
       ```html
            <section class="imagenes">
                <img src="./Imagenes/imagen (1).jpg" alt="Jefatura de Estudios">
                <div class="texto">Esta semana hemos tenido en nuestro centro a los
                    compañeros de @stjohasparren. Durante dos intensos días,
                    hemos compartido experiencias y aprendido mutuamente. Muchas
                    gracias a todos los profesores y estudiantes que colaboraron
                    explicando su trabajo y la oferta formativa de nuestro instituto.
                    Seguro que podremos seguir colaborando y aprendiendo juntos.
                    <div class="abrir-imagen">
                        <a href="./Imagenes/imagen (1).jpg" target="_blank">
                            <img src="./Iconos./abrir.png" alt="abrir_en_otra_pestaña">
                        </a>
                    </div>
                </div>
            </section>
         ```

       ```html
            <section class="imagenes">
                <img src="./Imagenes/imagen (2).jpg" alt="Secretaría">
                <div class="texto">Con @anniehurtadoc súper bien!!! Gracias por
                    cuidarnos!! Los alumnos y alumnas del @ies.miguelherrero
                    <div class="abrir-imagen">
                        <a href="./Imagenes/imagen (2).jpg" target="_blank">
                            <img src="./Iconos./abrir.png" alt="abrir_en_otra_pestaña">
                        </a>
                    </div>
                </div>
            </section>
         ```

        - section "imagenes": Secciones para cada imagen de la galeria
        - div "texto": Contenedor para el texto descriptivo
        - div "abrir-imagen": Contenedor para el icono que abre la imagen en una pestaña<br><br>

### **2. Tipos de estilo**<a name="ESTILO"></a><br><br>
### **1.1 CSS común a todas las páginas** <br>
- ### **Toda la página**
   ```css
   * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
   }
   ```
   - margin y padding 0px : No tendrá margen ni margen interno, el contenido ocupará todo el tamaño de la página
   - box-sizing border-box: indica que el tamaño total del ancho se calcula contando el margen y el margen interno (margin y padding)

- ### **Body**
   ```css
   body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    color: #333;

    line-height: 1.6;
    margin: 0;
    padding: 0;
    width: 100%;
   }
   ```

   - font-family Arial, sans-serif: La fuente de la letra será arial, si el navegador no puede usar ese tipo de letra usará una secundaría, sans-serif
   - background-color: color del fondo
   - color: color de la letra
   - line-height 1.6: altura entre lineas de 1.6 para que se lea bien el texto
   - margin y padding 0px: no tendra margen ni margen interno, ocupará todo el tamaño de la página
   - width 100%: ancho del body 

- ### **Main**
   ```css
   main {
    width: 100%;
    margin-top: 15px;
    padding: 20px;

    align-content: center;

    background-color: #fff;
   }
   ```
   - width 100%: ancho del main
   - margin-top 15px: margen por encima del body, para que se separe con el menú
   - padding 20px : margen interno, para que el contenido no salga pegado a los bordes de la página
   - align-content center: alinea verticalmente el contenido flexible al centro
   - background-color: color del fondo

- ### **Header**
   ```css
   header {
    background-color:#333;
    color: #fff;

    padding: 20px;
   }
   ```

   - background-color: color del fondo
   - color: color del texto
   - padding 20px: margin interno para que el contenido no salga pegado a los bordes del header

- ### **Contenido-cabecera (div)** 
   ```css
   .contenido-cabecera {
    max-width: 100%;
    justify-content: left;
    height: 50px;
   }
   ```

   - max-width 1200px: anchura maxima del div
   - justify-content left: alinea horizontalmente el contenido flexible (la imagen) a la izquierda
   - height 50px: altura del contenedor

- ### **LogoImagen (img)**
   ```css
   .LogoImagen{
    display: flex;
    margin-left: 10px;
    width: 286px;
    height: 70px;
   }
   ```

   - display flex: el contenedor de la imagen será flexible
   - margin-left 10px: margen de 10px por la izquierda, para que la imagen salga despegada del borde izquierdo
   - width 286px: el ancho de la imagen será de 286px
   - height 70px: la altura de la imagen será de 70px

- ### **H1**
   ```css
   h1 {
    font-size: 1.5em;
   }
   ```

   - font-size 1.5em: todos los tamaños de los titulos h1 de la página serán de 1.5em, la unidad utilizada (em) quiere decir que el tamaño será 1.5 veces el tamaño de fuente del elemento padre, usamos esto para que sea escalable si se cambia el tamaño de la ventana

- ### **menuprincipal (nav)**
   ```css
   #menuprincipal {
    width: 100%;
    height: 80px;
    padding: 0% 2%;
    margin: 0%;
    display: flex;
    justify-content: center;
    align-items: center;

    background-color: #ffffff;
   }   
   ```

   - width 100%: anchura del nav
   - height 80px: altura del nav
   - padding 0% 2%: el margen interno por encima y por debajo será de 0%, por la izquierda y derecha será de 2%
   - margin 0px: no tendrá margen
   - display flex: el nav será flexible
   - justify-content center: los elementos flexibles dentro del nav se alinean horizontalmente al centro
   - align-items center: los elementos flexibles se alinean verticalemente al centro
   - background-color: color del fondo

- ### **menuprincipal > div (div)**
   ```css
   #menuprincipal > div {
    width: 100%;
    height: 100%;
    vertical-align: middle;
    display: flex;
    justify-content: center; 
    align-items: center; 
   }
   ```
   
   - width y height 100%: anchura y altura del contenedor
   - vertical-align middle: nos aseguramos de que los elementos en linea se alineen verticalmente al medio
   - display flex: el div será flexible
   - justify-content center: los elementos flexibles dentro del div se alinean horizontalmente al centro
   - align-items center: los elementos flexibles se alinean verticalemente al centro

- ### **listamenu (ul)**
   ```css
   #listamenu {
    display: flex;
    justify-content: center;
    padding: 0px;
    height: 100%;
    align-items: center;
   }
   ```

   - display flex: la lista ordenada será flexible
   - justify-content center: los elementos flexibles se alinean horizontalmente al centro
   - padding 0px: no tendra margen interno
   - height 100%: la altura ocupará todo el contendor menuprincipal
   - align-items center: los elementos flexibles se alinean verticalemente al medio

- ### **listamenu li**
   ```css
   #listamenu li {
    padding: 15px 10px 0px 10px;
    list-style: none;
    align-items: center;
    height: 100%;
    width: auto;
   }
   ```

   - padding 15px 10px 0px 10px: el margen interno por arriba será de 12px, por la derecha de 10px, por abajo 0px y por la izquierda 10px
   - list-style-type none: el estilo del marcador de la lista, en este caso no tendrá
   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - height 100%: alto del elemento de la lista
   - width auto: el ancho de los elementos será el automatico para que se cambie segun la proporcion de la ventana

- ### **listamenu a**
   ```css
   #listamenu a {
    display: flex;
    align-items: center;
    height: 100%;

    color: #333333;
    font: bold 18px Arial, sans-serif;
    text-decoration: none;
   }
   ```

   - display flex: los enlaces serán flexibles
   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - height 100%: alto del elemento de la lista
   - color: color del texto de los enlaces
   - font bold 18px Arial, sans-serif: será negrita, tamaño de 18px y fuente arial o sans-serif
   - text-decoration none: estilo del enlace (subrayado, negrita, ninguna etc...)

- ### **iconosmenu (img)**
   ```css
   .iconosMenu {
    margin: 10px;
    align-items: center;
    width:35px;
    height:35px;
   }
   ```

   - margin 10px: margen de las imagenes
   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - width y height 35px: anchura y altura de las imagenes

- ### **listamenu li:hover (hover)**
    Estilo para los elementos de la lista cuando se pase el raton por encima<br>
   ```css
   #listamenu li:hover {
    background-color: #dbdbdb;
    transition: background-color 0.6s ease;
   }
   ```

   - background-color: color del fondo 
   - transition background-color 0.6s ease: animación, en este caso el color del fondo aparecerá lentamente durante 0.6 segundos

- ### **menuprincipal li**
   ```css
   #menuprincipal li { 
    display: flex;
    height: 80px;
    padding: 15px 10px 0px 10px;
    align-items: center;
    margin-right: 20px;
   }
   ```

   - display flex: los elementos de la lista se colocarán de forma flexible
   - height 80px : altura de los elementos
   - padding 15px 10px 0px 10px: el margen interno por arriba será de 15px, por la derecha de 10px, por abajo 0px y por la izquierda 10px
   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - margin-right 20px: margen por la derecha para separar los elementos entre ellos

- ### **menuprincipal a**
   ```css
   #menuprincipal a {
    align-content: center;

    font: bold 18px Arial, sans-serif;
    color: #333333;
    text-decoration: none;
   }
   ```

   - align-content center: alinea verticalmente los elementos flexibles al centro
   - font bold 18px Arial, sans-serif: estilo negrita, tamaño 18 pixeles y fuente arial o sans-serif
   - color: color del texto
   - text-decoration none: estilo del enlace, en este caso ninguno

- ### **footer**
   ```css
   footer {
    padding: 20px;

    background-color: #333;
    color: #fff;
   }
   ```

   - padding 20px: margen interno 
   - background-color: color del fondo
   - color: color del texto

- ### **pielogo (div)**
   ```css
   .pielogo {
    display: flex;
    justify-content: space-between;
    margin: 20px;
    padding: 15px;
    margin-top:5px;
    padding-top: 5px;
   }
   ```

   - display flex: el div será flexible
   - justify-content space-around: los elementos flexibles se colocan de manera que el espacio entre ellos sea uniforme
   - margin 20px: margen del div
   - padding 15px: margen interno del div
   - margin-top 5px: el margen por arriba será de 5 pixeles en vez de 20px 
   - padding-top 5px: el margen interno por arriba será de 5 pixeles en vez de 15px

- ### **seccionpie (div)**
   ```css
   .seccionpie {
    flex: 1;
    margin-right: 20px;
   }
   ```

   - flex 1: abreviacion de flex-grow 1, el elemento flexible puede ocupar todo el espacio disponible dentro del contenedor 
   - margin-right 20px: margen por la derecha de 20 pixeles

- ### **seccionpie h2**
   ```css
   .seccionpie h2 {
    font-size: 1.2em;
    margin-bottom: 15px;
    text-align: left;
   }
   ```

   - font-size 1.2em: el tamaño de los titulos será de 1.2em 
   - margin-bottom 15px: margen por debajo 
   - text-align left: el texto se alineará a la izquierda

- ### **enlace-contacto (a)**
   ```css
   .enlace-contacto {
    align-items: center;
    
    color: #fff;
    text-decoration: none;
   }
   ```

   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - color: color del texto
   - text-decoration none: estilo del enlace, en este caso ninguno

- ### **enlace-contacto img**
   ```css
   .enlace-contacto img {
    max-width: 30px ;
    max-height: 30px;
    vertical-align: middle;
   }
   ```

   - max-width y max-height 20px: la anchura y la altura maxima de las imagenes, para que no se deformen
   - vertical-align middle: alinea el contenido en linea al medio

- ### **enlace-contacto:hover**
    Estilo para los enlaces de contacto cuando se pase el raton por encima<br>
   ```css
   .enlace-contacto:hover {
    text-decoration: underline;
   }
   ```

   - text-decoration underline: los enlaces se subrayarán

- ### **iconos-sociales (ul)**
   ```css
   .iconos-sociales {
    list-style: none;
    padding: 0;
    margin: 0;
   } 
   ```

   - list-style none: el estilo del marcador de la lista, en este caso ninguno
   -  margin y padding 0px: no tendrá margen ni margen interno

- ### **iconos-sociales li**
   ```css
   .iconos-sociales li {
    display: inline-block;
    margin-right: 10px;
    height: 35px;
   }
   ```
   
   - display inline-block: el elemento se mostrará en la misma linea que los otros elementos
   - margin-right 10px: margen por la derecha 
   - height 35px: la altura de los elementos  

- ### **iconos-sociales li img**
   ```css
   .iconos-sociales li img {
    vertical-align: middle;
   }
   ```

   - vertical-align middle: alinea el contenido en linea al medio

- ### **iconos-sociales li a**
   ```css
   .iconos-sociales li a {
    color: #fff;
    text-decoration: none;
   }
   ```

   - color: color del texto
   - text-decoration none: estilo del enlace, en este caso ninguno

- ### **iconos-sociales li:hover**
    Estilo para los elementos de la lista iconos-sociales para cuando se pase el raton por encima
   ```css
   .iconos-sociales li:hover {
    text-decoration: underline;
   }
   ```
   - text-decoration underline: los enlaces se subrayarán

- ### **Facebook (img)**
   ```css
   .Facebook {
    width: 30px;
    height: 30px;
   }
   ```

   - width y heigth 30px: anchura y altura 

- ### **Instagram (img)**
   ```css
   .Instagram {
    max-width: 30px;
    max-height: 30px;
   }
   ```
   
   - max-width y max-heigth 30px: anchura y altura maxima, para que la imagen no se deforme 

- ### **footer p**
   ```css
   footer p {
    margin-top: 15px;
    text-align: center;
    font-size: 13px;
   }
   ```
   
   - margin-top 15px: margen por encima, para separarlo del resto de contenido
   - text-align center: el texto se alineará al centro
   - font-size 13px: tamaño de la letra 

### **1.2 CSS: Página Inicio**
- ### **main**
   ```css
   main {
    position: relative;
    padding: 0%;
   }
   ```
   - position-relative: El elemento se mantiene en el flujo normal del documento
   - padding 0%: no tendrá margen interno

- ### **ImagenContenedor (div)**
   ```css
   .ImagenContenedor{
    display: flex;
    position: relative;
    justify-content: center; 
    align-items: center;

    width: 100%; 
    height: 100%; 
   }
   ```
   - display flex: El contenedor es flexible
   - position relative: El elemento se mantiene en el flujo normal del documento
   - justify-content center: Los elementos flexibles se alinean horizontalmente al centro
   - align-items center: Los elementos flexibles se alinean verticalemente al centro
   - width y height 100%: anchura y altura del contenedor 

- ### **ImagenPrincipal (img)**
   ```css
   .ImagenPrincipal{
    width: 100%;
    max-width: 100%; 
    max-height: auto;
    
    filter: opacity(60%);
   }
   ```
   - width 100%: ancho de la imagen 
   - max-width 100%: ancho maximo de la imagen 
   - max-height auto: la altura maxima de la imagen será automatica segun la proporcion de la ventana
   - filter opacity 60%: Filtro que pone la imagen opaca al 60%

- ### **texto (div)**
   ```css
   .texto {
    position: absolute;
    top: 32%;
    left: 50%;
    transform: translate(-50%, -50%);
    z-index: 1;

    color: white;
    font-weight: bold;
    font-size: 3.7vw;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
   }
   ```
   - position-absolute: el elemento se posiciona con respecto a su contenedor padre
   - top 32%: pone el texto a una altura de 32% con respecto de la parte mas alta
   - left 50%: pone el texto en el centro de la pantalla horizontalmente
   - transfrom translateX(-50%, -50%): para alinear el texto al centro, tanto horizontal como verticalmente
   - z-index 1: para asegurarse de que el texto se queda dentro del contenedor
   - color: color del texto
   - font-weight bold: estilo del texto, en este caso negrita 
   - font-size 3.7: tamaño del texto a 3.7 de ancho de la ventana 
   - text-shadow 2px 2px 4px: sombra para el texto, 2px hacia la derecha, 2px hacia abajo y 4px de desenfoque de sombra

- ### **botonFacebook**
   ```css
   .botonFacebook {
    position: absolute;
    top: 42%;
    left: 50%;
    transform: translateX(-50%);
    z-index: 1;

    padding: 0;
    margin: 0;
    width: 200px;
    height: 55px;
    line-height: 55px;

    text-align: center;
    align-items: center;
    list-style: none;

    border-radius: 30px;
    background-color: #eaeaeb;
   }  
   ```
   - position-absolute: hace que un elemento se posicione con respecto a su contenedor padre
   - top 42%: altura de 42%
   - left 50%: posicion al 50 % con respecto a la parte izquierda
   - transform-translateX(-50%): posicion a -50% en el eje x (horizontal)
   - z-index 1: para asegurarse de que el texto se queda dentro del contenedor
   - margin y padding 0px: no tendrá margen ni margen interno
   - width 200px: anchura del botón
   - height 55px: altura del botón
   - line-height 55px: establece la altura de linea a 55 px
   - text-align center: alinea el texto en el centro
   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - list-style-none: el estilo del marcador de la lista, en este caso ninguno
   - border-radius 30px: hace redondos los bordes del contenedor
   - background-color: color del fondo 

- ### **botonFacebook img**
   ```css
   .botonFacebook img {
    width:50px;
    height:50px;
    vertical-align: middle;
   }
   ```
   - width 50px: anchura del icono
   - height 50px: altura del icono
   - vertical-align middle: alinea el contenido en linea al medio

- ### **botonFacebook li**
   ```css
   .botonFacebook li {
    display: inline-block;
   }
   ```
   - display inline-block: el elemento se mostrará en la misma linea que los otros elementos

- ### **botonFacebook li a**
   ```css
   .botonFacebook li a {
    color: #000000;
    text-decoration: none;
   }
   ```
   - color: color del texto
   - text-decoration: estilo del enlace, en este caso ninguno

- ### **botonFacebook:hover**
   ```css
   .botonFacebook:hover {
    background-color: #cfcfd1;
    transition: background-color 0.2s ease;
   }
   ```
   - background-color: color del fondo diferente al anterior
   - transition background-color 0.2s ease: animación, en este caso el nuevo color del fondo aparecerá lentamente durante 0.2 segundos
    <br><br>

### **1.3 CSS: Página Actividades**
- ### **TextoActividades h1**
   ```css
   .TextoActividades h1 {
    width: 100%;

    text-align: center;
    color: #fff;
    font-size: 1.5em;

    background-color: #333333;
    border-radius: 10px;
    word-wrap: break-word;
    overflow-wrap: break-word;
   }
   ```
  - width 100%: anchura del 100% dentro del contenedor
  - text-align center: los titulos estarán alineados al centro
  - color: color del texto
  - font-size 1.5em: el tamaño de fuente será de 1.5 em
  - background-color: color del fondo 
  - border-radius: hace redondos los bordes del contenedor
  - word-wrap break-word: las palabras deben saltar a la siguiente linea si no caben en el contendor
  - overflow-wrap break-word: es lo mismo que word-wrap break-word pero en algunos navegadores no funciona

- ### **Viajes y Clases (div)**
   ```css
   .Viajes,
   .Clases {
    display:flex;
    margin-top: 20px;

    justify-content: left;
    align-items: center;

    background-color: #333;
    width: 20%;
    height: 20%;
    border-radius: 10px;

    color: #fff;
    font-weight: bold;
   }
   ```
  - display flex: los contenedores serán flexibles 
  - margin-top 20px: margen por encima 
  - justify-content left: los elementos flexibles se alinean horizontalmente a la izquierda
  - align-items center: alinea verticalmente los elementos flexibles al centro
  - background-color: color del fondo
  - width 20%: anchura de los div
  - height 20%: altura de los div
  - border-radius 10px: hace redondos los bordes del contenedor
  - color: color del texto
  - font-weight bold: estilo del texto, en este caso negrita

- ### **Viajes p y Clases p**
   ```css
   .Viajes p,
   .Clases p {
    display:flex;
    margin:0%;
    padding: 0 20px;
    font-size: 0.99em;
    text-align: left;
   }
   ```
  - display flex: el texto será felxible
  - margin 0%: no tendrá margen
  - padding 0 20px: 0px de margen interno por arriba y por abajo, 20px por la izquierda y derecha
  - font-size 0.99em: tamaño de la letra, esta unidad se utiliza para que se escale segun el tamao de la ventana
  - text-align left: el texto se alinea a la izquierda

- ### **Viajes main y Clases main (div)**
   ```css
    .ViajesMain,
    .ClasesMain {
    display: flex;
    width: 95%;
    margin: 20px;
    padding: 20px;

    background-color: #f4f4f4;
    border-radius: 10px;
    border: solid black;
    }
   ```
  - display flex: el contenedor será flexible
  - width 95%: anchura de los main
  - margin 20px: margen 
  - padding 20px: margen interno
  - background-color: color del fondo
  - border-radius 10px: hace redondos los bordes de los main
  - border solid black: borde para la tabla
  - overflow-x auto: si el texto se desborda aparece una barra de desplazamiento

- ### **ViajesMain th, ViajesMain td, ClasesMain th y ClasesMain th**<br>
    Estilo para los titulos y texto de las tablas<br>
   ```css
    .ViajesMain th,
    .ViajesMain td,
    .ClasesMain th,
    .ClasesMain td {
    display: flexbox;
    padding: 20px;
    text-align: left;
    width: auto;
    }
   ```
  - display flexbox: los elementos de la tabla serán cajas flexibles
  - padding 20px: margen interno
  - text-align left: el texto se alinea a la izquierda
  - width auto: anchura automática

- ### **ViajesMain td:nth-child,ViajesMain th:nth-child,ClasesMain td:nth-child,ClasesMain th:nth-child**<br>
    Estilo para la primera columna, para hacer espacio a las demás columnas<br>
   ```css
    .ViajesMain td:nth-child,
    .ViajesMain th:nth-child,
    .ClasesMain td:nth-child,
    .ClasesMain th:nth-child {
    width: 250px;
    }
   ```
   - width 250px: ancho de la columna

- ### **ViajesMain td:nth-child(7),ViajesMain th:nth-child(7),ClasesMain td:nth-child(7),ClasesMain th:nth-child(7)**<br>
    Estilo para la columna profesores participantes, para hacer espacio a las demás columnas<br>
   ```css
    .ViajesMain td:nth-child(7),
    .ViajesMain th:nth-child(7),
    .ClasesMain td:nth-child(7),
    .ClasesMain th:nth-child(7) {
    width: 180px; 
    }
   ```
   - width 180px: ancho de la columna

- ### **ViajesMain td:nth-child(3),ViajesMain th:nth-child(3),ClasesMain td:nth-child(3),ClasesMain th:nth-child(3)**<br>
    Estilo para la columna personas involucradas, para hacer espacio a las demás columnas<br>
   ```css
    .ViajesMain td:nth-child(3),
    .ViajesMain th:nth-child(3),
    .ClasesMain td:nth-child(3),
    .ClasesMain th:nth-child(3) {
    width: 155px; 
    }
   ```
   - width 155px: ancho de la columna

- ### **ViajesMain th:last-child,ViajesMain td:last-child,ClasesMain th:last-child,ClasesMain td:last-child**<br>
    Estilo para quitar el borde por la derecha de la ultima columna <br>
   ```css
    .ViajesMain th:last-child,
    .ViajesMain td:last-child,
    .ClasesMain th:last-child,
    .ClasesMain td:last-child {
    border-right: none;
    }
   ```
   - border-right none: ningun borde por la derecha

- ### **.ViajesMain th,ClasesMain th**<br>
    Estilo para quitar el borde por la derecha de la ultima columna <br>
   ```css
    .ViajesMain th,
    .ClasesMain th {
    border-top: none;
    }
   ```
   - border-top none: ningun borde por arriba

- ### **@media screen and (max-width: 1500px)**<br>
    Estilo para cuando la ventana ocupe 1500 pixeles<br>
    ```css
    @media screen and (max-width: 1500px) {

    .TextoActividades h1 {
        font-size: 1.2em;
    }

    .Viajes,
    .Clases {
        max-width: 30%;
        max-height: 30%;
    }

    .Viajes p,
    .Clases p {
        font-size: 0.9em;
        padding: 0 10px;
        max-width: 100%;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    .ViajesMain,
    .ClasesMain {
        width: 95%;
        margin: 5px auto;
        padding: 5px;
    }

    .ViajesMain th,
    .ViajesMain td,
    .ClasesMain th,
    .ClasesMain td {
        padding: 10px; 
        font-size: 0.9em;
      }
    }
    ```
    - texto actividades h1
      - font size 1.2em: tamaño de la fuente, se usa esta unidad para que se esclae segun el tamaño de la ventana

    - viajes, clases
      - max-with 30%: anchura maxima del contenedor
      - max-height 30%: altura maxima del cotenedor

    - viajes p, clases p
      - font-size 0.9em: tamaño de la fuente, se usa esta unidad para que se esclae segun el tamaño de la ventana
      - padding 0 10px: margen interno de 0px por arriba y por abajo y 10px por la izquierda y la derecha
      - max-width 100%: anchura maxima del texto
      - overflow hidden: el contenido que se desborda del contenedor se recorta y no se muestra
      - text-overflow ellipsis: cuando el contenido se desborda y no se muestra, se remplaza por un caracter "(...)"

    - ViajesMain y ClasesMain
      - width 95%: anchura de los contenedores
      - margin 5px auto: margen de 5px por arriba y por abajo y automatico por la derecha y por la izquierda, para que el espacio entre los elementos se pueda cambiar con el tamaño de la ventana
      - padding 5px: margen interno 

    - ViajesMain th, ViajesMain td, ClasesMain th, ClasesMain td
      - padding 10px: margen interno
      - font-size 0.9em: tamaño de la fuente, se usa esta unidad para que se esclae segun el tamaño de la ventana
  

- ### **@media screen and (max-width: 1100px)**<br>
    Estilo para cuando la ventana ocupe 1100 pixeles<br>
    ```css
    @media screen and (max-width: 1100px) {

    .TextoActividades h1 {
        font-size: 1em;
    }

    .Viajes,
    .Clases {
        width: 100%;
        height: auto;
        margin: 10px auto;
        justify-content: center;
    }

    .Viajes p,
    .Clases p {
        font-size: 0.8em;
        padding: 5px;
        text-align: center;
    }

    .ViajesMain,
    .ClasesMain {
        width: 100%;
        margin: 10px auto;
        padding: 10px;
    }

    .ViajesMain th,
    .ViajesMain td,
    .ClasesMain th,
    .ClasesMain td {
        padding: 5px;
        font-size: 0.8em;
    }

    .ViajesMain td:first-child,
    .ViajesMain th:first-child,
    .ClasesMain td:first-child,
    .ClasesMain th:first-child,
    .ViajesMain td:nth-child(7),
    .ViajesMain th:nth-child(7),
    .ClasesMain td:nth-child(7),
    .ClasesMain th:nth-child(7),
    .ViajesMain td:nth-child(3),
    .ViajesMain th:nth-child(3),
    .ClasesMain td:nth-child(3),
    .ClasesMain th:nth-child(3) {
        width: auto;
     }
    }
    ```

- ### **@media screen and (max-width: 800px)**<br>
    Estilo para cuando la ventana ocupe 800 pixeles<br>
    ```css
    @media screen and (max-width: 800px) {

    .TextoActividades h1 {
        font-size: 1em;
    }

    .Viajes,
    .Clases {
        width: 90%;
        height: auto;
        margin: 10px auto;
        justify-content: center;
    }

    .Viajes p,
    .Clases p {
        font-size: 0.8em;
        padding: 5px;
        text-align: center;
    }

    .ViajesMain,
    .ClasesMain {
        width: 100%;
        margin: 10px auto;
        padding: 10px;
    }

    .ViajesMain th,
    .ViajesMain td,
    .ClasesMain th,
    .ClasesMain td {
        padding: 5px;
        font-size: 0.8em;
    }

    .ViajesMain td:first-child,
    .ViajesMain th:first-child,
    .ClasesMain td:first-child,
    .ClasesMain th:first-child,
    .ViajesMain td:nth-child(7),
    .ViajesMain th:nth-child(7),
    .ClasesMain td:nth-child(7),
    .ClasesMain th:nth-child(7),
    .ViajesMain td:nth-child(3),
    .ViajesMain th:nth-child(3),
    .ClasesMain td:nth-child(3),
    .ClasesMain th:nth-child(3) {
        width: auto;
     }
    }
    ```
<br><br>

### **1.3 CSS: Página Sobre Nosotros**
- ### **InformacionTexto (div)**
   ```css
   .InformacionTexto {
    position: relative;
    width: 100%; 
   }
   ```
  - position relative: El elemento se mantiene en el flujo normal del documento
  - width 100%: ancho del div

- ### **InformacionTexto h1,Instalaciontexto h1,Ubicaciontexto h1**
   ```css
   .InformacionTexto h1,
   .Instalaciontexto h1,
   .Ubicaciontexto h1 {
    width: 100%;
    border-radius: 10px;

    text-align: center;
    color: #fff;
    background-color: #333333;
   }
   ```
  - width 100%: ancho del 100%
  - border-radius 10px: hace redondos los bordes del contenedor
  - text-align center: alinea el texto al centro
  - color: color del texto
  - background-color: color del fondo

- ### **Informacion,instalaciones,Ubicacion (div)**
   ```css
   .Informacion,
   .instalaciones,
   .Ubicacion {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    padding-top: 15px;

    justify-content: space-around;
    background-color: #fff;  
   }
   ```
  - display flex: los contenedores son flexibles 
  - flex-wrap wrap: si no hay suficiente espacio para un elemento flex, pasará a la siguiente linea
  - width: ancho del div
  - padding-top 15px: margen interno por arriba
  - justify-content: los elementos flexibles se colocan de manera que el espacio entre ellos sea uniforme
  - backgournd-color: color del fondo

- ### **Informacion p**
   ```css
   .Informacion p{
    padding: 10px;
   }
   ```
  - padding 10px: margen interno 

- ### **secciones (section)**
   ```css
   .secciones {
    width: 250px;
    height: 250px;
    margin-bottom: 20px;

    text-align: center;
   }
   ```
  - width 250px: ancho de las secciones
  - height 250px: alto de las secciones
  - margin-bottom 20px: margen por abajo 
  - text-align center: el texto se alinea al centro 

- ### **secciones h2**
   ```css
   .secciones h2 {
    margin-bottom: 10px;
   }
   ```
  - margin-bottom 10px: margen por abajo

- ### **secciones img**
   ```css
   .secciones img {
    max-width: 100%;
    max-height: 50%;
   }
   ```
  - max-width 100%: ancho maximo de las imagenes, para que no se deformen
  - max-height 50%: alto maximo de las imagenes

- ### **Ubicacion iframe**
   ```css
   .Ubicacion iframe {
    padding-top:15px;
    justify-content: center;
   }
   ```
  - padding-top 15px: margen interno por arriba
  - justify-content center: alinea horizontalmente los elementos flexibles al centro

### **1.3 CSS: Página Galeria**
- ### **galeria (div)**
   ```css
   .galeria {
    display: flex;
    flex-wrap: wrap;
    width: 90%;
    justify-content: center;
    margin: 0 auto;
    background-color: #fff;  
    }
   ```
  - display flex: el contenedor será flexible
  - flex-wrap wrap: si no hay suficiente espacio para una imagen, pasará a la siguiente linea
  - width 90%: anchura del div
  - justify-content center: alinea horizontalmente el contenido flexible al centro
  - margin 0 auto: centra horizontalmente el contendor, se usa para que el contenido se ajuste al ancho del contenedor
  - background color: color del fondo

- ### **imagenes (section)**
   ```css
   .imagenes {
    position: relative;
    margin: 15px;
    max-width: 300px; 
    max-height: 300px; 
    overflow: hidden; 
    } 
   ```
   - position relative:
   - margin 15px: margen para seapara unas imagenes de otras
   - max-width y max-height: altura y anchura maxima de las secciones
   - overflow hidden: garantiza que las imágenes y el texto superpuesto no se salgan del contenedor

- ### **imagenes img**
   ```css
   .imagenes img {
    display: block;
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.3s ease;
    } 
   ```
   - display block: las imagenes se comportan como bloques, con esto nos aseguramos de que puedan ocupar todo el contenedor
   - width y height: las imagenes ocuparán todo el ancho y alto del contenedor
   - object-fit cover: para ocupar todo el contenedor, la imagen se recortará en vez de deformarse
   - transition transform 0.3s ease: transicion suave para cuando ocurra cualquier cambio en la imagen (por ejemplo al pasar el raton por encima) 

- ### **texto (div)**
   ```css
   .texto {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.7);
    color: white;
    padding: 20px;
    opacity: 0;
    transition: opacity 0.3s ease;
    overflow: auto;
    text-align: center;
    word-wrap: break-word;
    line-height: 1.5;
    } 
   ```
   - position absolute: el elemento se coloca con respecto a el contendor padre
   - top 0, left 0, right 0, bottom 0: define la posicion para elementos absolutos, en este caso el texto se extiende completamente dentro de su contenedor
   - background color: color del fondo
   - color white: color del texto
   - padding 20px: margen interno para separar el texto de los bordes del contenedor
   - opacity 0: opacidad del contenedor, al ponerlo a 0 estará oculto hasta que se pase el raton por encima
   - transition opacity 0.3s ease: transicion suave para cuando ocurra cualquier cambio, por ejemplo al cambiarse la opacidad
   - overflow: auto: cuando el contenido se desborde del contenedor aparecerá una barra de desplazamiento para seguir leyendo el texto
   - text-align center; el texto se alinea al centro
   - word-wrap break word: cuando una palabra no quepa pasará a la siguiente linea
   - line-height 1.5: altura entre lineas para que se lea bien el texto

- ### **texto (div)**
   ```css
   .abrir-imagen img {
    display: flex;
    width:20px;
    height: 20px;
    margin: 15px auto;
    } 
   ```
   - display flex: la imagen será flexible
   - width y heigth: anchura y altura de la imgagen
   - margin 15px auto: margen de la imagen de 15 pixeles para separarlo del texto, los margenes horizontales y verticales se estableceran automaticamente segun el navegador

- ### **imagenes:hover .texto**
    Estilo para el div texto cuando se pase el raton por encima
   ```css
   .imagenes:hover .texto {
    opacity: 1;
    } 
   ```
   - opacity 1: la opacidad se pondrá a 1, es decir aparecerá, ademas con la transicion de la imagen se mostrará lentamente

- ### **imagenes:hover .texto**
    Estilo para el la iamgen cuando se pase el raton por encima
    ```css
   .imagenes:hover img {
    transform: scale(1.1);
    } 
   ```
   - transform scale(1.1): la imagen se acercará a una escala(1.1), ademas con la transicion de la imagen, lo hará lentamente

### **3. Contenido de la web**<a name="CONT"></a>
- ### **Página Inicio**<br>
![PaginaInicio](./Imagenes/PaginaInicio.png)
- Encontramos un encabezado con el logo del instituto y un menu para moverse entre páginas.
- En la parte central se encuentra una foto del instituto junto con un texto de bienvenida y un boton central que te lleva al Facebook del instituto.
- En el pie de página nos encontramos los datos de contacto del centro asi como su localizacion y las redes sociales

- ### **Página Actividades**<br>
![PaginaActividades](./Imagenes/PaginaActividades.png)
   - En esta página se encuentran las actividades que realiza el instituto dividiendose en viajes extraescolares y clases extraescolares 
   - A parte de esto, hay un encabezado y un pie de página, que son exactamente iguales que en la página de inicio

- ### **Página "Sobre Nosotros"**<br>
![PaginaSobreNosotros](./Imagenes/PaginaSobreNosotros.png)
   - En esta página hay información sobre el centro, las instalaciones de las que dispone y un mapa con la localizacion del instituto
   - Tambien cuenta con un encabezado y pie de página iguales a las anteriores páginas

- ### **Página "Galería"**<br>
![PaginaGaleria](./Imagenes/PaginaGaleria.png)
   - En esta página aparecerán todas las imagenes de las actividades y una descripción sobre ellas, tambien tendrán un icono para poder abrirlas en una pestaña nueva y verlas con su tamaño original 
   - Al igual que en las otras páginas cuenta con un encabezado y pie de página 
<br><br>

## **JAVA**<a name="JV"></a>
<hr>

### **1. Diagrama de clases**<a name="DIAG"></a>
![DiagramaDeClases](./Imagenes/diagramaDeClases.jpg)
- Profesor
    - Atributos:
        - idProfesor: int
        - nombre: String
        - apellido: String
        - dni: String
        - correo: String
        - perfilAcceso: enum (PerfilAceso)
        - activo: boolean
        - contrasenia: String
    - Métodos:
        - Profesor(): Constructor
        - getPerfil(): Enum
        - setPerfil(enum): Setter para el perfil
        - getIdProfesor(): int
        - setIdProfesor(int): Setter para ID de profesor
        - getIdDepartamento(): int
        - setIdDepartamento(int): Setter para ID del departamento
        - getContrasenia(): String
        - setContrasenia(String): Setter para la contraseña
        - getNombre(): String
        - setNombre(String): Setter para el nombre
        - getApellido(): String
        - setApellido(String): Setter para el apellido
        - getDNI(): String
        - setDNI(String): Setter para el DNI
        - getCorreo(): String
        - setCorreo(String): Setter para el correo
        - isActivo(): void
        - setActivo(boolean): Setter para el estado activo
        - toString(): String
    - Relaciones: 
        - Relación uno a muchos con **Departamento**
        - Relación uno a muchos con **Solicitud**
    
- Curso
    - Atributos:
        - codCurso: int
        - descripcion: String
        - duracion: int
        - etapa: enum
        - activo: boolean
    - Métodos:
        - Curso(): Constructor
        - getCodCurso(): int
        - setCodCurso(int): Setter para el código del curso
        - getDescripcion(): String
        - setDescripcion(String): Setter para la descripción
        - getDuracion(): int
        - setDuracion(int): Setter para la duración
        - getEtapa(): enum
        - setEtapa(enum): Setter para la etapa
        - isActivo(): boolean
        - setActivo(boolean): Setter para el estado activo
        - toString(): String
    - Relaciones:
        - Relación uno a muchos con Grupo

- Grupo: 
    - Atributos:
        - codGrupo: int
        - curso: Curso
        - numeroAlumnos: int
        - activo: boolean
    - Métodos:
        - Grupo(): Constructor
        - getCodGrupo(): int
        - setCodGrupo(int): Setter para el código del grupo
        - getCurso(): Curso
        - setCurso(Curso): Setter para el curso
        - getNumeroAlumnos(): int
        - setNumeroAlumnos(int): Setter para el número de alumnos
        - isActivo(): boolean
        - setActivo(boolean): Setter para el estado activo
        - toString(): String
    - Relaciones:
        - Relación muchos a uno con Curso

- Solicitud
    - Atributos:
        - idSolicitud: int
        - titulo: String
        - descripcion: String
        - fechaInicio: LocalDate
        - fechaFin: LocalDate
        - horaInicio: LocalTime
        - horaFin: LocalTime
        - estado: enum
        - comentario: String
        - isPrivada: boolean
    - Métodos:
        - Solicitud(): Constructor
        - getIdSolicitud(): int
        - setIdSolicitud(int): Setter para ID de la solicitud
        - getTitulo(): String
        - setTitulo(String): Setter para el título
        - getDescripcion(): String
        - setDescripcion(String): Setter para la descripción
        - getFechaInicio(): LocalDate
        - setFechaInicio(LocalDate): Setter para la fecha de inicio
        - getFechaFin(): LocalDate
        setFechaFin(LocalDate): Setter para la fecha de fin
        - getHoraInicio(): LocalTime
        setHoraInicio(LocalTime): Setter para la hora de inicio
        - getHoraFin(): LocalTime
        - setHoraFin(LocalTime): Setter para la hora de fin
        - getEstado(): enum
        - setEstado(enum): Setter para el estado
        - getComentario(): String
        - setComentario(String): Setter para el comentario
        - isPrivada(): boolean
        - setPrivada(boolean): Setter para el estado privado
        - toString(): String
    - Relaciones:
        - Relación uno a muchos con Profesor
        - Relación muchos a uno con Departamento
        - Relación uno a uno con ActividadProgramada
    
- Actividad Programada
    - Atributos:
        - idActividad: int
        - estado: enum
        - comentario: String
    - Métodos:
- ActividadProgramada(): Constructor
    - getIdActividad(): int
    - setIdActividad(int): Setter para ID de la actividad
    - getEstado(): enum
    - setEstado(enum): Setter para el estado
    - getComentario(): String
    - setComentario(String): Setter para el comentario
    - toString(): String
- Relaciones: 
    - Relación uno a uno con Solicitud
    - Relación muchos a uno con MedioTransporte

- MedioTransporte
    - Atributos: 
        - idTransporte: int
        - tipo: enum
        - comentario: String
        - importe: double
        - empresa: String
    - Métodos:
        - MedioTransporte(): Constructor
        - getIdTransporte(): int
        - setIdTransporte(int): Setter para ID de transporte
        - getTipo(): enum
        - setTipo(enum): Setter para el tipo
        - getComentario(): String
        - setComentario(String): Setter para el comentario
        - getImporte(): double
        - setImporte(double): Setter para el importe
        - getEmpresa(): String
        - setEmpresa(String): Setter para la empresa
        - toString(): String
    - Relaciones:
        - Relación muchos a uno con ActividadProgramada
<br><br>

### **2. Diagramas de caso de uso**<a name="USO"></a>
![Diagrama Casos de Uso](./Imagenes/casosDeUso.jpg)
- El superusuario podrá: 
    - Modificar y consultar ficheros
    - Cargar datos

- El profesor podrá:
    - Ver una solicitud
    - Crear una solicitud
    - Modificar una solicitud

- El equipo directivo podrá:
    - Aprobar o denegar solicitudes

- El administrador podrá:
    - Modificar y consultar ficheros
    - Cargar datos 
    - Modificar una solicitud
    - Completar una solicitud
    - Aprobar o denegar solicitudes

### **3. Documentación de las clases**<a name="DOCU"></a>


### **4. Explicación al registrar una actividad nueva**<a name="EXPL"></a>
A la hora de registrar una actividad


## Implementacion y despliegue<a name="IMPL"></a>
### **1. Tecnologias**<a name="TEC"></a>