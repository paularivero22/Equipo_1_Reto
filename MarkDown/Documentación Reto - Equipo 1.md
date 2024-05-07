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

### **1.4 Pagina "Sobre Nosotros"**<br>
- ### **Body** <br>
    <br>- **Main:** contenido principal de la pagina<br><br>
     - **InformaciónTexto**<br><br>
     [![Informacion-Texto.png](https://i.postimg.cc/PxtNK4kV/Informacion-Texto.png)](https://postimg.cc/94nWQy0y)
        - div "InformacionTexto": Texto con etiquetas h1 que sirve de titulo del apartado donde queda reflejada la información del centro por escrito
        <br><br>
    
     - **Información**<br><br>
     [![Informaci-n.png](https://i.postimg.cc/Hx0F2wtx/Informaci-n.png)](https://postimg.cc/BL6hZ1k9)
        - div "Información": Este div es utilizado para mostrar la informacion del centro entre etiquetas p
        <br><br>
    
     - **InstalacionTexto**<br><br>
     [![Instalaciones.png](https://i.postimg.cc/Prb0Ys4j/Instalaciones.png)](https://postimg.cc/1ftW1d2C)
        - div "InstalacionTexto": Texto con etiquetas h1 que sirve de titulo del apartado donde quedan reflejadas las distintas instalaciones del centro junto con sus respectivas fotos
        <br><br>

     - **Instalaciones**<br><br>
     [![instalaciones-Main.png](https://i.postimg.cc/DwYZkYMt/instalaciones-Main.png)](https://postimg.cc/rDxc5gcJ)
        - div "Instalaciones": Este div se utiliza para mostrar las distintantas secciones que aparecen en el codigo,donde estan las imagenes de las instalaciones
        <br><br>

    - **Secciones:**<br><br>
    [![Secciones.png](https://i.postimg.cc/KYXQZF4T/Secciones.png)](https://postimg.cc/18HDHkGR)
        - div "Secciones": En el div secciones, se muestra el nombre de la instalacion junto con su imagen, en este caso el ejemplo es de "Jefatura de estudios"
        <br><br>

     - **UbicacionTexto**<br><br>
     [![Ubicacion-Texto.png](https://i.postimg.cc/YCzW7hZh/Ubicacion-Texto.png)](https://postimg.cc/2136F8zD)
        - div "UbicacionTexto": Texto con etiquetas h1 que sirve de titulo del apartado donde se encuentra un mapa con la ubicación del centro
        <br><br>
    
     - **Ubicacion**<br><br>
     [![Ubicacion.png](https://i.postimg.cc/LsZBpHt7/Ubicacion.png)](https://postimg.cc/2qrBdNXF)
        - div "Ubicación": Este div se utiliza para mostrar un mapa que muestra donde se encuentra el instituto mediante la etiqueta iframe
        <br>
        <br>

### **2. Tipos de estilo**<a name="ESTILO"></a><br><br>
### **1.1 CSS común a todas las paginas** <br>
- ### **Toda la pagina**
[![todalapagina.png](https://i.postimg.cc/pXZLyHD3/todalapagina.png)](https://postimg.cc/w71pbn4k)<br>
- margin y padding 0px : No tendrá margen ni margen interno
- box-sizing border-box: indica que el tamaño total del ancho se calcula contando el margen y el margen interno (margin y padding)

- ### **Body**
[![body.png](https://i.postimg.cc/rmPYfKX7/body.png)](https://postimg.cc/R6wRFC0T)<br>
- font-family Arial, sanss-serif: La fuente de la letra, si el navegador no puede usar ese tipo de letra usará una secundaría
- background-color: color del fondo
- color: color de la letra
- line-height 1.6: la altura de línea (altura vertical entre las líneas de texto) será de 1.6
- margin y padding 0px: no tendra margen ni margen interno
- width 100%: ancho del body 

- ### **Main**
[![maincss.png](https://i.postimg.cc/t4Hsfk9N/maincss.png)](https://postimg.cc/w70xRhy1)
- width 100%: ancho del main
- margin-top 15px: margen por encima del body, para que se separe con el menú
- padding 20px : margen interno, para que el contenido no salga pegado a los bordes de la pagina
- align-content center: alinea verticalmente el contenido flexible dentro del main
- background-color: color del fondo

- ### **Header**
[![headercss.png](https://i.postimg.cc/qRzBgbsn/headercss.png)](https://postimg.cc/ygCCbTrY)<br>
- background-color: color del fondo
- color: color del texto
- padding 20px: margin interno

- ### **Contenido-cabecera (div)**
[![contenidocabecera-css.png](https://i.postimg.cc/Cxkqx1hY/contenidocabecera-css.png)](https://postimg.cc/Wdp39sqf)
- max-width 1200px: anchura maxima del div
- justify-content left: alinea horizontalmente el contnido flexible a la izquierda
- height 50px: altura del contenedor

- ### **LogoImagen (img)**
[![logoimagen-css.png](https://i.postimg.cc/KcJZ2ytz/logoimagen-css.png)](https://postimg.cc/yW3qmtQ4)
- display flex: el contenedor de la imagen será flexible
- margin-left 10px: margen de 10px por la izquierda
- width 286px: el ancho de la imagen será de 286px
- height 70px: la altura de la imagen será de 70px
- vertical-align middle: alinea el contenido en linea al medio

- ### **H1**
[![h1-css.png](https://i.postimg.cc/xdPzV1YC/h1-css.png)](https://postimg.cc/yJkdFBD4)
- font-size 1.5em: todos los tamaños de los titulos h1 de la pagina serán de 1.5em, la unidad utilizada (em) quiere decir que el tamaño será 1.5 veces el tamaño de fuente del elemento padre, usamos esto para que sea escalable si se cambia el tamaño de la ventana

- ### **menuprincipal (nav)**
[![menuprincipal-css.png](https://i.postimg.cc/DwNX2MbV/menuprincipal-css.png)](https://postimg.cc/gxvJs4D4)
- width 100%: anchura del nav
- height 80px: altura del nav
- padding 0% 2%: el margen interno por encima y por debajo será de 0% y por la izquierda y derecha será de 2%
- margin 0px: no tendrá margen
- display flex: los elementos del nav serán flexibles
- justify-content center: los elementos flexibles se alinean horizontalmente al centro
- align-items center: los elementos flexibles se alinean verticalemente al medio
- background-color: color del fondo

- ### **menuprincipal > div (div)**
[![menuprincipaldiv-css-png.png](https://i.postimg.cc/4xCnz7xd/menuprincipaldiv-css-png.png)](https://postimg.cc/tY5XbgPQ)
- width y height 100%: anchura y altura del contenedor
- vertical-align middle: los elementos en linea se alinean verticalmente al medio
- display flex: los elementos del div serán flexibles
- justify-content center: los elementos flexibles se alinean horizontalmente al centro
- align-items center: los elementos flexibles se alinean verticalemente al medio

- ### **listamenu (ul)**
[![listamenu2.png](https://i.postimg.cc/9QRZ2RLt/listamenu2.png)](https://postimg.cc/RWmNQF5N)
- display flex: la lista ordenada será flexible
- margin-left 10px: margen por la izquierda, para separar cada elemento
- justify-content center: los elementos flexibles se alinean horizontalmente al centro
- padding 0px: no tendra margen interno
- height 100%: altura de la lista
- align-items center: los elementos flexibles se alinean verticalemente al medio
- list-style-type none: el estilo del marcador de la lista  

- ### **listamenu li**
[![listamenuli.png](https://i.postimg.cc/qBPNN31Y/listamenuli.png)](https://postimg.cc/Z0LbgCtF)
- padding 15px 10px 0px 10px: el margen interno por arriba será de 12px, por la derecha de 10px, por abajo 0px y por la izquierda 10px
- list-style-type none: el estilo del marcador de la lista 
- align-items center: los elementos flexibles se alinean verticalemente al medio
- height 100%: alto del elemento de la lista
- width auto: el ancho de los elementos será el automatico para que se cambie segun la proporcion de la pantalla

- ### **listamenu a**
[![listamenua.png](https://i.postimg.cc/fTgMr3PC/listamenua.png)](https://postimg.cc/7f0vCLwJ)
- display flex: los enlaces serán flexibles
- align-items center: los elementos flexibles se alinean verticalemente al medio
- height 100%: alto del elemento de la lista
- color: color del texto de los enlaces
- font bold 18px Arial, sans-serif: será negrita, tamaño de 18px y fuente arial o sans-serif
- text-decoration none: estilo del enlace (subrayado, negrita, ninguna etc...)

- ### **iconosmenu (img)**
[![iconosmenu.png](https://i.postimg.cc/rphmMhZ6/iconosmenu.png)](https://postimg.cc/NyHYxxwb)
- margin 10px: margen de las imagenes
- align-items center: los elementos flexibles se alinean verticalemente al medio
- width y height 35px: anchura y altura de las imagenes

- ### **listamenu li:hover (hover)**
Estilo para los elementos de la lista cuando se pase el raton por encima<br>
[![listamenuhover.png](https://i.postimg.cc/FRsLxd8v/listamenuhover.png)](https://postimg.cc/qtSqJRpD)<br>
- background-color: color del fondo 
- transition background-color 0.6s ease: animación, en este caso el color del fondo aparecerá lentamente durante 0.6 segundos

- ### **menuprincipal li**
[![menuprincipal-Li.png](https://i.postimg.cc/Kj8wp7dG/menuprincipal-Li.png)](https://postimg.cc/R62gNtSy)<br>
- display flex: los elementos de la lista se colocarán de forma flexible
- height 80px : altura de los elementos
- padding 15px 10px 0px 10px: el margen interno por arriba será de 15px, por la derecha de 10px, por abajo 0px y por la izquierda 10px
- align-items center: los elementos flexibles se alinean verticalemente al medio
- margin-right 20px: margen por la derecha para separar los elementos

- ### **menuprincipal a**
[![menuprincipal-a.png](https://i.postimg.cc/kgNpFhHr/menuprincipal-a.png)](https://postimg.cc/216GCTmT)<br>
- align-content center: alinea verticalmente las lineas de los elementos flexibles al centro
- font bold 18px Arial, sans-serif: estilo negrita, tamaño 18 pixeles y fuente arial o sans-serif
- color: color del texto
- text-decoration none: estilo del enlace (subrayado, negrita, nada etc...)

- ### **footer**
[![footer-css.png](https://i.postimg.cc/9QZQPTZR/footer-css.png)](https://postimg.cc/87kGN7yN)<br>
- padding 20px: margen interno 
- background-color: color del fondo
- color: color del texto

- ### **pielogo (div)**
[![pielogo-css.png](https://i.postimg.cc/mZmjR1cH/pielogo-css.png)](https://postimg.cc/t7VWNTNq)<br>
- display flex: los elementos del div serán flexibles
- justify-content space-around: los elementos flexibles se colocan de manera que el espacio entre ellos sea uniforme
- margin 20px: margen del div
- padding 15px: margen interno 
- margin-top 5px: el margen por arriba será de 5 pixeles en vez de 20px 
- padding-top 5px: el margen interno por arriba será de 5 pixeles en vez de 15px

- ### **seccionpie (div)**
[![seccionpie-css.png](https://i.postimg.cc/1zdzSQx6/seccionpie-css.png)](https://postimg.cc/VSjw92kL)<br>
- flex 1: abreviacion de flex-grow 1, el elemento flexible puede ocupar todo el espacio disponible dentro del contenedor 
- margin-right 20px: margen por la derecha de 20 pixeles

- ### **seccionpie h2**
Estilo para los titulos h2 en el contenedor seccion pie<br>
[![seccionpie-H2-css.png](https://i.postimg.cc/KYxVJ90M/seccionpie-H2-css.png)](https://postimg.cc/68bYQhJW)<br>
- font-size 1.2em: el tamaño del texto será de 1.2em 
- margin-bottom 15px: margen por debajo del titulo
- text-align left: el texto se alineará a la izquierda

- ### **enlace-contacto (a)**
[![enlacecontacto.png](https://i.postimg.cc/cHndNkNL/enlacecontacto.png)](https://postimg.cc/jwtpHX5p)<br>
- align-items center: los elementos flexibles se alinean verticalemente al medio
- color: color del texto
- text-decoration none: estilo del enlace (subrayado, negrita, nada etc...)

- ### **enlace-contacto img**
[![enlacecontactoimg.png](https://i.postimg.cc/Bbv9nmrF/enlacecontactoimg.png)](https://postimg.cc/2bgXH78j)<br>
- max-width y max-height 20px: la anchura y la altura maxima de las imagenes, para que no se deformen
- vertical-align middle: alinea el contenido en linea al medio

- ### **enlace-contacto:hover**
Estilo para los enlaces de contacto cuando se pase el raton por encima<br>
[![enlacecontacto-hover.png](https://i.postimg.cc/NMCDcbBL/enlacecontacto-hover.png)](https://postimg.cc/9RTZPd4j)<br>
- text-decoration underline: los enlaces se subrayarán

- ### **iconos-sociales (ul)**
[![iconossociales-css.png](https://i.postimg.cc/8Pf7w4Yw/iconossociales-css.png)](https://postimg.cc/mtRZgYBF)<br>
- list-style none: el estilo del marcador de la lista 
-  margin y padding 0px: no tendrá margen ni margen interno

- ### **iconos-sociales li**
[![iconossociales-Li.png](https://i.postimg.cc/63g8NbbH/iconossociales-Li.png)](https://postimg.cc/Q9g8Qm35)<br>
- display inline-block: el elemento se mostrará en la misma linea que los otros elementos
- margin-right 10px: margen por la derecha 
- height 35px: la altura de los elementos  

- ### **iconos-sociales li img**
[![iconossociales-Li-img.png](https://i.postimg.cc/TwxvZVfz/iconossociales-Li-img.png)](https://postimg.cc/3ytqGDy1)<br>
- vertical-align middle: alinea el contenido en linea al medio

- ### **iconos-sociales li a**
[![iconossociales-Li-a-png.png](https://i.postimg.cc/C5HGcVmy/iconossociales-Li-a-png.png)](https://postimg.cc/YL0LSZ58)<br>
- color: color del texto
- text-decoration none: estilo del enlace (subrayado, negrita, nada etc...)

- ### **iconos-sociales li:hover**
Estilo para los elementos de la lista iconos-sociales para cuando se pase **el raton por encima**
- text-decoration underline: los enlaces se subrayarán

- ### **Facebook (img)**
[![facebook.png](https://i.postimg.cc/pXKXrJL6/facebook.png)](https://postimg.cc/KRvysLLP)<br>
- width y heigth 30px: anchura y altura 

- ### **Instagram (img)**
[![instagram.png](https://i.postimg.cc/LXs36skx/instagram.png)](https://postimg.cc/kVkbTqpS)<br>
- max-width y max-heigth 30px: anchura y altura maxima, para que la imagen no se deforme 

- ### **footer p**
[![footerp.png](https://i.postimg.cc/QdWPCrhL/footerp.png)](https://postimg.cc/zy8p26yp)<br>
- margin-top 15px: margen por encima, para separarlo del resto de contenido
- text-align center: el texto se alineará al centro
- font-size 13px: tamaño de la letra 

### **1.2 CSS: Pagina Inicio**
- ### **main**
[![Main.png](https://i.postimg.cc/TYjbvfk7/Main.png)](https://postimg.cc/N5MF1qvm)
   - position-relative: El elemento se mantiene en el flujo normal del documento
   - padding 0%: no tendrá margen interno
   <br><br>

- ### **ImagenContenedor**
[![Imagen-Contenedor.png](https://i.postimg.cc/Fz2rqdSW/Imagen-Contenedor.png)](https://postimg.cc/rRN2RpQx)
   - display flex: El contenedor es flexible
   - position relative: El elemento se mantiene en el flujo normal del documento
   - justify-content center: Los elementos flexibles se alinean horizontalmente al centro
   - align-items center: Los elementos flexibles se alinean verticalemente al medio
   - width y height 100%: anchura y altura del contenedor 
   <br><br>

- ### **ImagenPrincipal**
[![Imagen-Principal.png](https://i.postimg.cc/XN1Fg42t/Imagen-Principal.png)](https://postimg.cc/w3J7q8Yk)
   - width 100%: ancho de la imagen 
   - max-width 100%: ancho maximo de la imagen 
   - max-height auto: altura maxima de la imagen puesto a automatico
   - filter opacity 60%: Filtro que pone la imagen opaca al 60%
   <br><br>

- ### **texto**
[![texto.png](https://i.postimg.cc/xjm5qkjt/texto.png)](https://postimg.cc/V5YnVkCC)
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
[![boton-Facebook.png](https://i.postimg.cc/cHDJS76T/boton-Facebook.png)](https://postimg.cc/Q9TDgTQW)
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
[![Boton-Facebook-Img.png](https://i.postimg.cc/76PbR3gP/Boton-Facebook-Img.png)](https://postimg.cc/jW9swJgB)
   - width 50px: Anchura del icono
   - height 50px: Altura del icono
   - vertical-align middle: alinea el contenido en linea al medio
   <br><br>

- ### **botonFacebook li**
[![boton-Facebookli.png](https://i.postimg.cc/26vBpQ6P/boton-Facebookli.png)](https://postimg.cc/mzLrCF7w)
   - display inline-block: el elemento se mostrará en la misma linea que los otros elementos
   <br><br>

- ### **botonFacebook li a**
[![boton-Facebooklia.png](https://i.postimg.cc/yNjbmRsC/boton-Facebooklia.png)](https://postimg.cc/CZZ7YzRc)
   - color: color del texto
   - text-decoration: estilo del enlace (subrayado, negrita, ninguna etc...)
   <br><br>

- ### **botonFacebook:hover**
[![boton-Facebook-Hover.png](https://i.postimg.cc/ZRRvRGwz/boton-Facebook-Hover.png)](https://postimg.cc/McCp3Fk9)
   - background-color: color del fondo diferente al anterior
   - transition background-color 0.2s ease: animación, en este caso el nuevo color del fondo aparecerá lentamente durante 0.2 segundos
   <br><br>


### **1.3 CSS: Pagina Actividades**
- ### **TextoActividades h1**
[![textoactividades-h1.png](https://i.postimg.cc/QtbpkDRn/textoactividades-h1.png)](https://postimg.cc/47Y7sD4z)
- width 100%: anchura del 100% dentro del contnedor
- text-align center: los titulos estarán alineados al centro
- font-size 1.5em: el tamaño de fuente
- background-color: color del fondo 
- border-radius: hace redondos los bordes del contenedor

- ### **Viajes y Clases (div)**
[![viajes-y-clases.png](https://i.postimg.cc/JncmKrcJ/viajes-y-clases.png)](https://postimg.cc/Vr63kchL)
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
[![vijesp-y-clasesp.png](https://i.postimg.cc/3N2FqqfP/vijesp-y-clasesp.png)](https://postimg.cc/sGDWQTrc)
- margin-left 5%: margen por la izquierda para separarlo del borde del contenedor

- ### **Viajes main y Clases main**
[![viajesmain-y-clasesmain.png](https://i.postimg.cc/TP8YdHtk/viajesmain-y-clasesmain.png)](https://postimg.cc/0zfqZZRm)
- position relative: El elemento se mantiene en el flujo normal del documento
- width 70%: anchura de los main
- margin 20px: margen de los main
- padding 20px: margen interno de los main
- background-color: color del fondo
- border-radius 10px: hace redondos los bordes de los main

- ### **ViajesMain th, ViajesMain td, ClasesMain th y ClasesMain th**<br>
Estilo para los titulos y texto de las tablas<br>
[![th-y-td.png](https://i.postimg.cc/J7cs0mX9/th-y-td.png)](https://postimg.cc/c6CxkpXm)
- padding 20px: margen interno
- text-align left: el texto se alinea a la izquierda

### **1.3 CSS: Pagina Sobre Nosotros**
- ### **InformacionTexto (div)**
[![informaciontexto.png](https://i.postimg.cc/5t8ZMfKt/informaciontexto.png)](https://postimg.cc/rdFh12k6)
- position relative: El elemento se mantiene en el flujo normal del documento
- width 100%: ancho del 100%

- ### **InformacionTexto h1,Instalaciontexto h1,Ubicaciontexto h1**
[![instalaciones-h1.png](https://i.postimg.cc/t4vMQYzy/instalaciones-h1.png)](https://postimg.cc/ZW3c6YgD) 
- width 100%: ancho del 100%
- border-radius 10px: hace redondos los bordes del contenedor
- text-align center: alinea el texto al centro
- color: color del texto
- background-color: color del fondo

- ### **Informacion,instalaciones,Ubicacion (div)**
[![informacion-instalacion-ubicacion.png](https://i.postimg.cc/50Jz0m4V/informacion-instalacion-ubicacion.png)](https://postimg.cc/CZv5rknP)
- display flex: 
- flex-wrap wrap: 
- width: ancho del 100%
- padding-top 15px: margen interno por arriba
- justify-content: los elementos flexibles se colocan de manera que el espacio entre ellos sea uniforme
- backgournd-color: color del fondo

- ### **Informacion p (texto)**
[![informacionp.png](https://i.postimg.cc/D00MzNKW/informacionp.png)](https://postimg.cc/GT0Q7qtr)
- padding 10px: margen interno de 10px

- ### **secciones (section)**
[![secciones.png](https://i.postimg.cc/JnDTVk3J/secciones.png)](https://postimg.cc/ygKh0WbY)
- width 250px: ancho de las secciones
- height 250px: alto de las secciones
-  margin-bottom 20px: margen por abajo 
- text-align center: el texto se alinea al centro 

- ### **secciones h2**
[![secciones-h2.png](https://i.postimg.cc/nVw3VTSm/secciones-h2.png)](https://postimg.cc/s17YwPrf)
- margin-bottom 10px: margen por abajo

- ### **secciones img**
[![secciones-img.png](https://i.postimg.cc/T2ZHqCj6/secciones-img.png)](https://postimg.cc/xq3R9GFx)
- max-width 100%: ancho maximo de las imagenes
- max-height 50%: alto maximo de las imagenes

- ### **Ubicacion iframe**
[![ubicacion-iframe.png](https://i.postimg.cc/VLK0PH7y/ubicacion-iframe.png)](https://postimg.cc/Mvjpyt2t)
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
   - Por último, tenemos la pagina "Sobre Nosotros", donde ponemos información sobre el centro, ademas de las instalaciones de las que dispone el centro y un mapa con la localizacion del instituto.A parte de esto el encabezado y el pie de pagina son comunes al resto de Paginas.
   <br><br>
## Java<a name="JV"></a>
### 1. Diagrama de clases<a name="DIAG"></a>

### 2. Documentacion de las clases<a name="DOCU"></a>

### 3. Explicación<a name="EXPL"></a>


## Implementacion y despliegue<a name="IMPL"></a>
### 1. Tecnologias<a name="TEC"></a>

