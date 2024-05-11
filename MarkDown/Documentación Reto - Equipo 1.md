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

## **BASES DE DATOS**<a name="bd"></a>
### **1. Descripcion de la base de datos**<a name="desBD"></a>

### **2. Diagrama E/R**<a name="ER"></a>
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

### **3. Diagrama relacional**<a name="REL"></a>
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
[Enlace-al-script-sql](https://github.com/paularivero22/Equipo_1_Reto/tree/3799f667727a6506bd0801b6774985d31df1fc63/Base%20datos)


## **PAGINA WEB**<a name="PW"></a>
### **1. Estructura de la pagina**<a name="ESTRUCT"></a><br><br>
### **1.1 Estructura comun de todas las paginas**<br>
- ### **Body** <br>
    <br>- **Header:** cabecera de la pagina <br><br>
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

    <br>- **Nav:** nav con un menú para navegar entre las paginas<br><br>
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

### **1.3 Pagina Inicio** <br>
- ### **Body** <br>  
    <br>- **Main:** contenido principal de la pagina<br><br>
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
    - div "ImagenContenedor": Contenedor con la imagen de la pagina, un texto y un recuadro<br>
        - div "texto": texto "Bienvenido" encima de la imagen 
        - div "botonFacebook": Un recuadro con el enlace al facecbook del insituto<br><br>

    <br>- **Footer:** pie de pagina con enlaces de interes del instituto<br><br>
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

### **1.3 Pagina Actividades** <br>
- ### **Body** <br>
    <br>- **Main:** contenido principal de la pagina<br><br>
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

### **1.4 Pagina "Sobre Nosotros"**<br>
- ### **Body** <br>
    <br>- **Main:** contenido principal de la pagina<br><br>
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

### **2. Tipos de estilo**<a name="ESTILO"></a><br><br>
### **1.1 CSS común a todas las paginas** <br>
- ### **Toda la pagina**
   ```css
   * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
   }
   ```
   - margin y padding 0px : No tendrá margen ni margen interno
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

   - font-family Arial, sanss-serif: La fuente de la letra, si el navegador no puede usar ese tipo de letra usará una secundaría
   - background-color: color del fondo
   - color: color de la letra
   - line-height 1.6: la altura de línea (altura vertical entre las líneas de texto) será de 1.6
   - margin y padding 0px: no tendra margen ni margen interno
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
   - padding 20px : margen interno, para que el contenido no salga pegado a los bordes de la pagina
   - align-content center: alinea verticalmente el contenido flexible dentro del main
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
   - padding 20px: margin interno

- ### **Contenido-cabecera (div)**
   ```css
   .contenido-cabecera {
    max-width: 100%;
    justify-content: left;
    height: 50px;
   }
   ```

   - max-width 1200px: anchura maxima del div
   - justify-content left: alinea horizontalmente el contnido flexible a la izquierda
   - height 50px: altura del contenedor

- ### **LogoImagen (img)**
   ```css
   .LogoImagen{
    display: flex;
    margin-left: 10px;
    width: 286px;
    height: 70px;
    vertical-align:middle;
   }
   ```

   - display flex: el contenedor de la imagen será flexible
   - margin-left 10px: margen de 10px por la izquierda
   - width 286px: el ancho de la imagen será de 286px
   - height 70px: la altura de la imagen será de 70px
   - vertical-align middle: alinea el contenido en linea al medio

- ### **H1**
   ```css
   h1 {
    font-size: 1.5em;
   }
   ```

   - font-size 1.5em: todos los tamaños de los titulos h1 de la pagina serán de 1.5em, la unidad utilizada (em) quiere decir que el tamaño será 1.5 veces el tamaño de fuente del elemento padre, usamos esto para que sea escalable si se cambia el tamaño de la ventana

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
   - padding 0% 2%: el margen interno por encima y por debajo será de 0% y por la izquierda y derecha será de 2%
   - margin 0px: no tendrá margen
   - display flex: los elementos del nav serán flexibles
   - justify-content center: los elementos flexibles se alinean horizontalmente al centro
   - align-items center: los elementos flexibles se alinean verticalemente al medio
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
   - vertical-align middle: los elementos en linea se alinean verticalmente al medio
   - display flex: los elementos del div serán flexibles
   - justify-content center: los elementos flexibles se alinean horizontalmente al centro
   - align-items center: los elementos flexibles se alinean verticalemente al medio

- ### **listamenu (ul)**
   ```css
   #listamenu {
    display: flex;
    margin-left: 10px;
    justify-content: center;
    padding: 0px;
    height: 100%;
    align-items: center;
    list-style-type: none;
   }
   ```

   - display flex: la lista ordenada será flexible
   - margin-left 10px: margen por la izquierda, para separar cada elemento
   - justify-content center: los elementos flexibles se alinean horizontalmente al centro
   - padding 0px: no tendra margen interno
   - height 100%: altura de la lista
   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - list-style-type none: el estilo del marcador de la lista  

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
   - list-style-type none: el estilo del marcador de la lista 
   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - height 100%: alto del elemento de la lista
   - width auto: el ancho de los elementos será el automatico para que se cambie segun la proporcion de la pantalla

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
   - margin-right 20px: margen por la derecha para separar los elementos

- ### **menuprincipal a**
   ```css
   #menuprincipal a {
    align-content: center;

    font: bold 18px Arial, sans-serif;
    color: #333333;
    text-decoration: none;
   }
   ```

   - align-content center: alinea verticalmente las lineas de los elementos flexibles al centro
   - font bold 18px Arial, sans-serif: estilo negrita, tamaño 18 pixeles y fuente arial o sans-serif
   - color: color del texto
   - text-decoration none: estilo del enlace (subrayado, negrita, nada etc...)

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

   - display flex: los elementos del div serán flexibles
   - justify-content space-around: los elementos flexibles se colocan de manera que el espacio entre ellos sea uniforme
   - margin 20px: margen del div
   - padding 15px: margen interno 
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
Estilo para los titulos h2 en el contenedor seccion pie<br>
   ```css
   .seccionpie h2 {
    font-size: 1.2em;
    margin-bottom: 15px;
    text-align: left;
   }
   ```

   - font-size 1.2em: el tamaño del texto será de 1.2em 
   - margin-bottom 15px: margen por debajo del titulo
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
   - text-decoration none: estilo del enlace (subrayado, negrita, nada etc...)

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

   - list-style none: el estilo del marcador de la lista 
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
   - text-decoration none: estilo del enlace (subrayado, negrita, nada etc...)

- ### **iconos-sociales li:hover**
Estilo para los elementos de la lista iconos-sociales para cuando se pase **el raton por encima**
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

### **1.2 CSS: Pagina Inicio**
- ### **main**
   ```css
   main {
    position: relative;
    padding: 0%;
   }
   ```
   - position-relative: El elemento se mantiene en el flujo normal del documento
   - padding 0%: no tendrá margen interno
   <br><br>

- ### **ImagenContenedor**
   ```css
   .ImagenContendor{
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
   - align-items center: Los elementos flexibles se alinean verticalemente al medio
   - width y height 100%: anchura y altura del contenedor 
   <br><br>

- ### **ImagenPrincipal**
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
   - max-height auto: altura maxima de la imagen puesto a automatico
   - filter opacity 60%: Filtro que pone la imagen opaca al 60%
   <br><br>

- ### **texto**
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
   - position-absolute: hace que un elemento se posicione con respecto a su contenedor mas cercano
   - top 32%: pone el texto a una altura de 32% con respecto de la parte mas alta
   - left 50%: pone el texto en el centro de la pantalla horizontalmente
   - transfrom translateX(-50%, -50%): sirve para poner el texto en el centro, tanto horizontal como verticalmente
   - z-index 1: para asegurarse de que el texto se queda dentro del contenedor
   - color: pone el color de las letras del texto a blanco
   - font-weight bold: Estilo del texto, en este caso negrita 
   - font-size 3.7: tamaño del texto a 3.7 de ancho de la ventana gráfica
   - text-shadow 2px 2px 4px: sombra para el texto 
   <br><br>

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
   - position-absolute: hace que un elemento se posicione con respecto a su contenedor posicionado mas cercano
   - top 42%: altura de 42%
   - left 50%: posicion al 50 % con respecto a la parte izquierda
   - transform-translateX(-50%): posicion a -50% en el eje x (horizontal)
   - z-index 1: para asegurarse de que el texto se queda dentro del contenedor
   - padding 0px: no tendrá margen interno
   - margin 0px: no tendrá margen
   - width 200px: anchura del botón
   - height 55px: altura del botón
   - line-height 55px: Establece la altura de linea a 55 px
   - text-align center: Alinea el texto en el centro
   - align-items center: los elementos flexibles se alinean verticalemente al medio
   - list-style-none: el estilo del marcador de la lista 
   - border-radius 30px: hace redondos los bordes del contenedor
   - background-color: color del fondo 
   <br><br>

- ### **botonFacebook img**
   ```css
   .botonFacebook img {
    width:50px;
    height:50px;
    vertical-align: middle;
   }
   ```
   - width 50px: Anchura del icono
   - height 50px: Altura del icono
   - vertical-align middle: alinea el contenido en linea al medio
   <br><br>

- ### **botonFacebook li**
   ```css
   .botonFacebook li {
    display: inline-block;
   }
   ```
   - display inline-block: el elemento se mostrará en la misma linea que los otros elementos
   <br><br>

- ### **botonFacebook li a**
   ```css
   .botonFacebook li a {
    color: #000000;
    text-decoration: none;
   }
   ```
   - color: color del texto
   - text-decoration: estilo del enlace (subrayado, negrita, ninguna etc...)
   <br><br>

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


### **1.3 CSS: Pagina Actividades**
- ### **TextoActividades h1**
   ```css
   .TextoActividades h1 {
    width: 100%;

    text-align: center;
    color: #fff;
    font-size: 1.5em;

    background-color: #333333;
    border-radius: 10px;
   }
   ```
- width 100%: anchura del 100% dentro del contnedor
- text-align center: los titulos estarán alineados al centro
- font-size 1.5em: el tamaño de fuente
- background-color: color del fondo 
- border-radius: hace redondos los bordes del contenedor

- ### **Viajes y Clases (div)**
   ```css
   .Viajes,
   .Clases {
    display:flex;
    margin-top: 20px;

    justify-content: left;
    align-items: center;

    background-color: #333;
    width: 13%;
    height: 15%;
    border-radius: 10px;

    color: #fff;
    font-weight: bold;
   }
   ```
- position relative: El elemento se mantiene en el flujo normal del documento
- margin-top 20px: margen por encima 
- justify-content left: los elementos flexibles se alinean horizontalmente a la izquierda
- align-items center: alinea verticalmente los elementos flexibles al centro
- background-color: color del fondo
- width 13%: anchura de los div
- height 30px: altura de los div
- border-radius 10px: hace redondos los bordes del contenedor
- color: color del texto
- font-weight bold: estilo del texto, en este caso negrita

- ### **Viajes p y Clases p (texto)**
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
- margin-left 5%: margen por la izquierda para separarlo del borde del contenedor

- ### **Viajes main y Clases main**
   ```css
   .ViajesMain,
   .ClasesMain {
    display: flex;
    width: 70%;
    margin: 20px;
    padding: 20px;

    background-color: #f4f4f4;
    border-radius: 10px;
   }
   ```
- position relative: El elemento se mantiene en el flujo normal del documento
- width 70%: anchura de los main
- margin 20px: margen de los main
- padding 20px: margen interno de los main
- background-color: color del fondo
- border-radius 10px: hace redondos los bordes de los main

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
    max-width: 10%;
   }
   ```
- padding 20px: margen interno
- text-align left: el texto se alinea a la izquierda

- ### **@media screen and (max-width: 1500px)**<br>
Estilo para cuando la ventana ocupe 1500 pixeless<br>
```css
   @media screen and (max-width: 1500px) {

    .TextoActividades h1 {
        font-size: 1.2em;
    }

    .Viajes,
    .Clases {
        max-width: 13%;
        max-height: 15%;
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

### **1.3 CSS: Pagina Sobre Nosotros**
- ### **InformacionTexto (div)**
   ```css
   .InformacionTexto {
    position: relative;
    width: 100%; 
   }
   ```
- position relative: El elemento se mantiene en el flujo normal del documento
- width 100%: ancho del 100%

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
- display flex: 
- flex-wrap wrap: 
- width: ancho del 100%
- padding-top 15px: margen interno por arriba
- justify-content: los elementos flexibles se colocan de manera que el espacio entre ellos sea uniforme
- backgournd-color: color del fondo

- ### **Informacion p (texto)**
   ```css
   .Informacion p{
    padding: 10px;
   }
   ```
- padding 10px: margen interno de 10px

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
-  margin-bottom 20px: margen por abajo 
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
- max-width 100%: ancho maximo de las imagenes
- max-height 50%: alto maximo de las imagenes

- ### **Ubicacion iframe**
   ```css
   .Ubicacion iframe {
    padding-top:15px;
    justify-content: center;
   }
   ```
- padding-top 15px: margen interno por arriba
- justify-content center: justifica los elementos flexibles al centro

### 3. Contenido de la web<a name="CONT"></a>
- ### **Pagina Inicio**<br>
[![Inicio.png](https://i.postimg.cc/Dw6dfJsS/Inicio.png)](https://postimg.cc/CRZfmKc0)
   - Esta es la vista grafica de la pagina de inicio de la web, donde encontramos un encabezado con el logo del instituto y un navegador para moverse entre paginas.
   Posteriormente, en la parte central se encuentra una foto con la vista del instituto desde arriba junto con un boton central que te lleva al Facebook del instituto.
   Por ultimo, en el pie de pagina nos encontramos los datos de contacto del centro asi como su localizacion y las redes sociales que emplean
   <br><br>

- ### **Pagina Actividades**<br>
[![Actividades.png](https://i.postimg.cc/LsYshw7r/Actividades.png)](https://postimg.cc/SX44vTmr)
   - Ahora la imagen que vemos es de la pagina actividades, donde se encuentran las actividades que realiza el instituto dividiendose en viajes extraescolares y clases extraescolares. A parte de esto, hay un encabezado y un pie de pagina, que son exactamente iguales que en la pagina de inicio.

- ### **Pagina "Sobre Nosotros"**<br>
[![Sobre-Nosotros.png](https://i.postimg.cc/9F257K4v/Sobre-Nosotros.png)](https://postimg.cc/4nWSC8Q5)
   - Tambien tenemos la pagina "Sobre Nosotros", donde ponemos información sobre el centro, ademas de las instalaciones de las que dispone el centro y un mapa con la localizacion del instituto.A parte de esto el encabezado y el pie de pagina son comunes al resto de Paginas.
   <br><br>


- ### **Pagina "Galeria"**<br>
[![Galeria.png](https://i.postimg.cc/GtzDQHvg/Galeria.png)](https://postimg.cc/fStkWW2Y)
   - Por último, tenemos la pagina Galeria, donde aparecerán todas las imagenes de las actividades y una descripción sobre ellas, tambien tendrán un icono para poder abrirlas en una pestaña nueva y verlas con su tamaño original 
   <br><br>

## Java<a name="JV"></a>
### 1. Diagrama de clases<a name="DIAG"></a>

### 2. Documentacion de las clases<a name="DOCU"></a>

### 3. Explicación<a name="EXPL"></a>


## Implementacion y despliegue<a name="IMPL"></a>
### 1. Tecnologias<a name="TEC"></a>

