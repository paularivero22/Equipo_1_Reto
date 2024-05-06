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
    [![Captura-de-pantalla-2024-05-06-172309.png](https://i.postimg.cc/bwS4bQG7/Captura-de-pantalla-2024-05-06-172309.png)](https://postimg.cc/NKYNv2kD)

    - div "contenido cabecera": contenedor con el logo de IES miguel herrero <br>

    <br>- **Nav:** nav con un menú para navegar entre las paginas<br><br>
    [![Captura-de-pantalla-2024-05-06-173750.png](https://i.postimg.cc/mDZSBs7b/Captura-de-pantalla-2024-05-06-173750.png)](https://postimg.cc/f3Fdf1HF)
    - div: contendor para la los elementos del nav<br>
        - ul "listamenu": los elementos del menú seran una lista ordenada, cada elemento li es un icono y una imagen <br><br>
### **1.3 Pagina Inicio** <br>
- ### **Body** <br>  
    <br>- **Main:** contenido principal de la pagina<br><br>
    [![main.png](https://i.postimg.cc/DwFx6Zgz/main.png)](https://postimg.cc/xcxGT9Br)
    - div "ImagenContenedor": Contenedor con la imagen de la pagina, un texto y un recuadro<br>
        - div "texto": texto "Bienvenido" encima de la imagen 
        - div "botonFacebook": Un recuadro con el enlace al facecbook del insituto<br><br>

    <br>- **Footer:** pie de pagina con enlaces de interes del instituto<br><br>
    [![footer.png](https://i.postimg.cc/Vv2nh7nw/footer.png)](https://postimg.cc/QKkF9JfY)
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
     [![Texto-Actividad.png](https://i.postimg.cc/28LjCZ09/Texto-Actividad.png)](https://postimg.cc/RN9xRN5w)
        - div "TextoActividades": Texto con etiquetas h1 que sirve de titulo
        <br><br>

     - **Viajes**<br><br>
     [![Viajes.png](https://i.postimg.cc/4d7KjNFr/Viajes.png)](https://postimg.cc/YG7qWk73)
        - div "Viajes": Texto con etiquetas p que se utiliza a modo de titulo del apartado de Viajes Extraescolares
        <br><br>


     - **ViajesMain**<br><br>
     [![Viajes-Main.png](https://i.postimg.cc/L875MMKf/Viajes-Main.png)](https://postimg.cc/fVcDxpbT)
        - div "ViajesMain": div donde mediante el uso de la etiqueta table,thead y tr, se crea una tabla donde aparece la información de los Viajes Extraescolares
        <br><br>
    
     - **Clases**<br><br>
     [![Clases.png](https://i.postimg.cc/d1tnzfbb/Clases.png)](https://postimg.cc/B8kxFmQp)
        - div "Clases": Texto con etiquetas p que se utiliza a modo de titulo del apartado de Clases Extraescolares
        <br><br>
    
     - **ClasesMain**<br><br>
     [![Clases-Main.png](https://i.postimg.cc/BnhHyvCC/Clases-Main.png)](https://postimg.cc/LJ1Jg2wq)
        - div "ClasesMain": div donde mediante el uso de la etiqueta table,thead,tbody,tr y td, se crea una tabla donde aparece la información de las Clases Extraescolares
        <br><br>

### **2. Tipos de estilo**<a name="ESTILO"></a><br><br>
### **1.1 CSS común a todas las paginas** <br>
- ### **Toda la pagina**
[![todalapagina.png](https://i.postimg.cc/pXZLyHD3/todalapagina.png)](https://postimg.cc/w71pbn4k)<br>
- Margin y Padding: No tendrá margen ni margen interno
- 
- ### **Body**
[![body.png](https://i.postimg.cc/rmPYfKX7/body.png)](https://postimg.cc/R6wRFC0T)<br>
- font-family: La fuente de la letra, si el navegador no puede usar ese tipo de letra usará una secundaría
- background-color: color del fondo
- color: color de la letra
- line-height: 
- Margin y padding: no tendra margen ni margen interno
- width: el ancho del body será del 100%

- ### **Main**
[![maincss.png](https://i.postimg.cc/t4Hsfk9N/maincss.png)](https://postimg.cc/w70xRhy1)
- width: ancho del 100%
- margin-top: margen por encima del body, para que se separe con el menú
- padding: un margen interno de 20 pixeles, para que el contenido no salga pegado a los bordes de la pagina
- align-content: el contenido (texto, imagenes etc...) estará alineado al centro
- background-color: color del fondo

- ### **Header**
[![headercss.png](https://i.postimg.cc/qRzBgbsn/headercss.png)](https://postimg.cc/ygCCbTrY)<br>

- ### **Contenido-cabecera (div)**
[![contenidocabecera-css.png](https://i.postimg.cc/Cxkqx1hY/contenidocabecera-css.png)](https://postimg.cc/Wdp39sqf)
- max-width: anchura maxima del contenido
- justify-content: el contenido estará justificado (o alineado) al centro
- height: altura del contenedor

- ### **LogoImagen (img)**
[![logoimagen-css.png](https://i.postimg.cc/KcJZ2ytz/logoimagen-css.png)](https://postimg.cc/yW3qmtQ4)
- display:
- margin-left: margen de 10px por la izquierda
- width: el ancho de la imagen será de 286px
- height: la altura de la imagen será de 70px
- vertical-align: la imagen se alineará verticalmente al medio dentro del contenedor

- ### **H1**
[![h1-css.png](https://i.postimg.cc/xdPzV1YC/h1-css.png)](https://postimg.cc/yJkdFBD4)
- font-size: todos los tamaños de los titulos h1 de la pagina serán de 1.5em

- ### **menuprincipal (nav)**
[![menuprincipal-css.png](https://i.postimg.cc/DwNX2MbV/menuprincipal-css.png)](https://postimg.cc/gxvJs4D4)
- width y height: anchura y altura del menú
- padding:
- margin: el contenedor no tendrá margen
- display:
- justify-content: el contenido del nav se alineará verticalmente al centro
- align-items: el contenido del nav se alineará al centro
- background-color: color del fondo

- ### **menuprincipal > div (div)**
[![menuprincipaldiv-css-png.png](https://i.postimg.cc/Pq4NCVCr/menuprincipaldiv-css-png.png)](https://postimg.cc/VSJzTR93)
- width y height: anchura y altura del contenedor
- vertical-align: alineado verticalmente al medio
- display: 
- justify-content: 
- align-items:

- ### **listamenu (ul)**
[![listamenu.png](https://i.postimg.cc/W1fq8H2W/listamenu.png)](https://postimg.cc/Xrdv7xBd)
- display: el contenedor
- margin-left: margen por la izquierda, para separar cada elemento
- justify-content:
- padding: no tendra margen interno
- height: altura del 100%
- align-items:
- list-style-type: el estilo del marcador de la lista 

- ### **listamenu li**
[![listamenuli.png](https://i.postimg.cc/qBPNN31Y/listamenuli.png)](https://postimg.cc/Z0LbgCtF)
- padding: 
- list-style-type: el estilo del marcador de la lista 
- align-items:
- height: alto del elemento de la lista
- width: el ancho de los elementos será el automatico para que se cambie segun la proporcion de la pantalla

- ### **listamenu a**
[![listamenua.png](https://i.postimg.cc/fTgMr3PC/listamenua.png)](https://postimg.cc/7f0vCLwJ)
- display-flex:
- align-items:
- height: alto del elemento de la lista
- color: color del texto de los enlaces
- font: será negrita, tamaño de 18px y fuente arial o sans-serif
- text-decoration: estilo del enlace (subrayado, nada etc...)

- ### **iconosmenu (img)**
[![iconosmenu.png](https://i.postimg.cc/rphmMhZ6/iconosmenu.png)](https://postimg.cc/NyHYxxwb)
- margin: margen de 10px por todos los lados de la imagen
- align-items:
- width y height: anchura y altura de la imagen

- ### **listamenu li:hover (hover)**
Estilo para los elementos de la lista cuando se pase el raton por encima<br>
[![listamenuhover.png](https://i.postimg.cc/FRsLxd8v/listamenuhover.png)](https://postimg.cc/qtSqJRpD)<br>
- background-color: color del fondo 
- transition: animación, en este caso el color del fondo aparecerá lentamente durante 0.6 segundos




### 3. Contenido de la web<a name="CONT"></a>

## Java<a name="JV"></a>
### 1. Diagrama de clases<a name="DIAG"></a>

### 2. Documentacion de las clases<a name="DOCU"></a>

### 3. Explicación<a name="EXPL"></a>


## Implementacion y despliegue<a name="IMPL"></a>
### 1. Tecnologias<a name="TEC"></a>

