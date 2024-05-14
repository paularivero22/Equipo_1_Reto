/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.SortedSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author atres
 */
public class Swing extends javax.swing.JFrame {

//Creo un atributo del tipo defaultTableModel para las tablas
    private DefaultTableModel tabla;
    private SolicitudesDAO solicitud;
    private CursosDAO cursos;
    private Curso cursoAux;
    private GruposDAO metodosGrupo;
    private Grupo grupoAux;
    private Departamento departamentoAux;
    private DepartamentoDAO metodosdepartamento;
    private Solicitud solicitudAux;
    private ActividadProgramadaDAO metodosprogramada;
    private ActividadProgramada prograux;
    private MedioTransporteDAO metodotransporte;
    private String correoLogin;
    private String contralogin;

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    /**
     * Creates new form Swing
     */
    public Swing() {
        initComponents();
        tabla = new DefaultTableModel();
        solicitud = new SolicitudesDAO();
        metodosdepartamento = new DepartamentoDAO();
        metodosGrupo = new GruposDAO();
        cursos = new CursosDAO();
        metodosprogramada = new ActividadProgramadaDAO();
        metodotransporte = new MedioTransporteDAO();
    }

    private void cargarItemsDepartamento() {
        String solicitudes = "";
        SortedSet<Departamento> lista = metodosdepartamento.listar();
        for (Departamento d : lista) {
            // jComboBox9.addItem(d.getNombre());
            //jComboBox8.addItem(d.getNombre());
            jComboBox11.addItem(d.getNombre());
        }
    }

    /**
     * Metodo que inserta los datos de la lista en un jTable
     *
     * @param lista
     * @param tabla1
     */
    private void insertarTablaSolicitudes(SortedSet<Solicitud> lista, JTable tabla1) {
        tabla = (DefaultTableModel) tabla1.getModel();
        Object[] ob = new Object[16];
        Iterator<Solicitud> it = lista.iterator();
        while (it.hasNext()) {
            Solicitud soli = it.next();
            ob[0] = soli.getIdSolicitud();
            ob[1] = soli.getHoraInicio();
            ob[2] = soli.getHoraFinal();
            ob[3] = soli.getComentario();
            ob[4] = soli.isPrevista();
            ob[5] = soli.getIddepartamento();
            ob[6] = soli.getTitulo();
            ob[7] = soli.getTipoSolicitud();
            ob[8] = soli.getIdprofesor();
            ob[9] = soli.isAlojamiento();
            ob[10] = soli.getFechaInicio();
            ob[11] = soli.getFechaFinal();
            ob[12] = soli.getTotalParticipantes();
            ob[13] = soli.getEstado();
            tabla.addRow(ob);
        }
        tabla1.setModel(tabla);
    }

    /**
     * Metodo que inserta los datos de los cursos en un jTable
     *
     * @param lista
     * @param tabla1
     */
    private void insertarTablaCursos(SortedSet<Curso> lista, JTable tabla1) {
        tabla = (DefaultTableModel) tabla1.getModel();
        Object[] ob = new Object[5];
        Iterator<Curso> it = lista.iterator();
        while (it.hasNext()) {
            Curso curso = it.next();
            ob[0] = curso.getIdCurso();
            ob[1] = curso.getCodCurso();
            ob[2] = curso.getDescripcion();
            ob[3] = curso.getEtapa();
            ob[4] = curso.isActivo();
            tabla.addRow(ob);
        }
        tabla1.setModel(tabla);
    }

    private void insertarTablaGrupos(SortedSet<Grupo> lista, JTable tabla1) {
        tabla = (DefaultTableModel) tabla1.getModel();
        Object[] ob = new Object[5];
        Iterator<Grupo> it = lista.iterator();
        while (it.hasNext()) {
            Grupo grupo = it.next();
            ob[0] = grupo.getIdGrupo();
            ob[1] = grupo.getCodGrupo();
            ob[2] = grupo.getIdcurso();
            ob[3] = grupo.getNumeroAlumnos();
            ob[4] = grupo.isActivo();
            tabla.addRow(ob);
        }
        tabla1.setModel(tabla);
    }

    private void insertarTablaDepartamento(SortedSet<Departamento> lista, JTable tabla1) {
        tabla = (DefaultTableModel) tabla1.getModel();
        Object[] ob = new Object[5];
        Iterator<Departamento> it = lista.iterator();
        while (it.hasNext()) {
            Departamento d = it.next();
            ob[0] = d.getIdDepartamento();
            ob[1] = d.getCodigoDepartamento();
            ob[2] = d.getNombre();
            ob[3] = d.getIdJefe();
            tabla.addRow(ob);
        }
        tabla1.setModel(tabla);
    }

    private void insertarTablaProgramadas(SortedSet<ActividadProgramada> lista, JTable tabla1) {
        tabla = (DefaultTableModel) tabla1.getModel();
        Object[] ob = new Object[16];
        Iterator<ActividadProgramada> it = lista.iterator();
        while (it.hasNext()) {
            ActividadProgramada soli = it.next();
            ob[0] = soli.getIdSolicitud();
            ob[1] = soli.estado;
            ob[2] = soli.getComentario();
            ob[3] = soli.horaInicio;
            ob[4] = soli.horaFinal;
            ob[5] = soli.isPrevista();
            ob[6] = soli.getIddepartamento();
            ob[7] = soli.getTitulo();
            ob[8] = soli.getTipoSolicitud();
            ob[9] = soli.isMedioTransporte();
            ob[10] = soli.getIdprofesor();
            ob[11] = soli.isAlojamiento();
            ob[12] = soli.getFechaInicio();
            ob[13] = soli.getFechaFinal();
            ob[14] = soli.getTotalParticipantes();
            ob[15] = soli.getComentarioFase();
            tabla.addRow(ob);
        }
        tabla1.setModel(tabla);
    }

    /**
     * Metodo que limpia la tabla
     */
    public void limpiarTabla() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.removeRow(i);
            i = i - 1;
        }
    }

    /**
     * Metodo que limpia las casillas de crear solicitud;
     */
    public void limpiarCrearSolicitud() {
        jTextField21.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField26.setText("");
        jTextField27.setText("");
        jTextField28.setText("");
        jTextField25.setText("");
        jCheckBox2.setSelected(false);
        jCheckBox1.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        txtEmail = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtcontrasen = new javax.swing.JLabel();
        txtcontrasenia = new javax.swing.JPasswordField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        botonLogin = new javax.swing.JLabel();
        botonRestablecerContrasenia = new javax.swing.JLabel();
        CambiarContraseña = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtnuevaContrasenia = new javax.swing.JPasswordField();
        botonCambiarContrasenia = new javax.swing.JLabel();
        botonVolver = new javax.swing.JLabel();
        MenuInicio = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        CrearProfesor = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Crear = new javax.swing.JButton();
        ModificarProfesor = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        Buscar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        EliminarDeshabilitarProfesor = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jButton5 = new javax.swing.JButton();
        CrearCurso = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton24 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        EliminarCurso = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        CrearGrupo = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        ModificarGrupo = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        DeshabilitarGrupo = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        CrearDepartamento = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        ModificarDepartamento = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField19 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        EliminarDepartamento = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        CrearSolicitud = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBox11 = new javax.swing.JComboBox<>();
        ConsultarSolicitudes = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        AprobarDenegarSolicitudes = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        Insertar = new javax.swing.JButton();
        FasePreparacion = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jTextField30 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        MedioTransporte = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jComboBox9 = new javax.swing.JComboBox<>();
        jButton19 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton27 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton28 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Contraseña = new javax.swing.JMenu();
        Profesores = new javax.swing.JMenu();
        crearProfesorMenu = new javax.swing.JMenuItem();
        modificarProfesorMenu = new javax.swing.JMenuItem();
        deshabilitarEliminarProfesorMenu = new javax.swing.JMenuItem();
        Cursos = new javax.swing.JMenu();
        CrearCursoMenu = new javax.swing.JMenuItem();
        EliminarCursoMenu = new javax.swing.JMenuItem();
        Grupo = new javax.swing.JMenu();
        crearGrupoMenu = new javax.swing.JMenuItem();
        modificarGrupoMenu = new javax.swing.JMenuItem();
        deshabilitarGrupoMenu = new javax.swing.JMenuItem();
        Departamento = new javax.swing.JMenu();
        crearDepartamentoMenu = new javax.swing.JMenuItem();
        modificarDepartamentoMenu = new javax.swing.JMenuItem();
        deshabilitarDepartamentoMenu = new javax.swing.JMenuItem();
        Solicitudes = new javax.swing.JMenu();
        crearSolicitudMenu = new javax.swing.JMenuItem();
        consutarSolicitudesMenu = new javax.swing.JMenuItem();
        aprobarDenegarSolicitudMenu = new javax.swing.JMenuItem();
        fasedepreparacionMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmail.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        txtEmail.setText("Email");
        Login.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        Login.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 203, -1));

        txtcontrasen.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        txtcontrasen.setText("Contraseña");
        Login.add(txtcontrasen, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        txtcontrasenia.setText("jPasswordField2");
        txtcontrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseniaActionPerformed(evt);
            }
        });
        Login.add(txtcontrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 202, -1));

        jLabel62.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        jLabel62.setText("INICIAR SESIÓN");
        Login.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jLabel63.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 12)); // NOI18N
        jLabel63.setText("¿Olvidaste tu contraseña?");
        Login.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 350, 160, 20));

        botonLogin.setBackground(new java.awt.Color(0, 0, 0));
        botonLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonLogin.setText("BOTON LOGIN");
        botonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonLoginMouseClicked(evt);
            }
        });
        Login.add(botonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 140, -1));

        botonRestablecerContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonRestablecerContrasenia.setText("Restablecer Contraseña");
        botonRestablecerContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRestablecerContraseniaMouseClicked(evt);
            }
        });
        Login.add(botonRestablecerContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, -1, -1));

        getContentPane().add(Login, "card19");

        CambiarContraseña.setBackground(new java.awt.Color(255, 255, 255));
        CambiarContraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REESTABLECER CONTRASEÑA");
        CambiarContraseña.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 330, 33));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        jLabel2.setText("DNI");
        CambiarContraseña.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 140, 20));

        jLabel3.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        jLabel3.setText("Nueva Contraseña:");
        CambiarContraseña.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, 20));

        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        CambiarContraseña.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 180, -1));
        CambiarContraseña.add(txtnuevaContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 180, -1));

        botonCambiarContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonCambiarContrasenia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonCambiarContrasenia.setText("Cambiar");
        botonCambiarContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCambiarContraseniaMouseClicked(evt);
            }
        });
        CambiarContraseña.add(botonCambiarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 80, 30));

        botonVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonVolver.setText("Volver");
        botonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVolverMouseClicked(evt);
            }
        });
        CambiarContraseña.add(botonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 330, 60, 30));

        getContentPane().add(CambiarContraseña, "card2");

        MenuInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("MENÚ DE INICIO");
        MenuInicio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 130, 50));

        getContentPane().add(MenuInicio, "card3");

        CrearProfesor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("CREAR PROFESOR");
        CrearProfesor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel6.setText("Nombre:");
        CrearProfesor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        CrearProfesor.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, -1));

        jLabel7.setText("Apellidos: ");
        CrearProfesor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));
        CrearProfesor.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 110, -1));

        jLabel8.setText("DNI:");
        CrearProfesor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        CrearProfesor.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 130, -1));

        jLabel9.setText("Perfil:");
        CrearProfesor.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Profesor", "Administrador", "Equipo Directivo", "SuperUsuario" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        CrearProfesor.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, -1));

        jLabel10.setText("Departamento:");
        CrearProfesor.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biología y Geología", "Dibujo", "Economía", "Educación Física", "Filosofía", "Física y Química", "Francés", "Geología e Historia", "Inglés", "Latín", "Lengua Castellana", "Matemáticas", "Música", "Tecnología", "Administración y Gestión", "Formación y Orientación Laboral", "Informática y Comunicaciones", "Fabricación Mecánica", "Transporte y Mantenimiento de Vehículos" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        CrearProfesor.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 100, -1));

        jLabel11.setText("Correo:");
        CrearProfesor.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        CrearProfesor.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 120, -1));
        CrearProfesor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 520, 50));

        Crear.setText("Crear");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });
        CrearProfesor.add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        getContentPane().add(CrearProfesor, "card4");

        ModificarProfesor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("MODIFICAR PROFESOR");
        ModificarProfesor.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel13.setText("DNI Profesor:");
        ModificarProfesor.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));
        ModificarProfesor.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 111, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellidos", "Perfil", "Correo", "Departamento" }));
        ModificarProfesor.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 111, -1));
        ModificarProfesor.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 461, 53));
        ModificarProfesor.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 109, -1));
        ModificarProfesor.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 460, 40));

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        ModificarProfesor.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        ModificarProfesor.add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        getContentPane().add(ModificarProfesor, "card5");

        EliminarDeshabilitarProfesor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("ELIMINAR O DESHABILITAR PROFESOR");
        EliminarDeshabilitarProfesor.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 28, 230, -1));

        jLabel15.setText("DNI Profesor:");
        EliminarDeshabilitarProfesor.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 73, -1, -1));
        EliminarDeshabilitarProfesor.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 70, 139, -1));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        EliminarDeshabilitarProfesor.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 204, -1, -1));

        jButton4.setText("Deshabilitar");
        EliminarDeshabilitarProfesor.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 204, -1, -1));
        EliminarDeshabilitarProfesor.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 470, 60));

        jButton5.setText("Buscar");
        EliminarDeshabilitarProfesor.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        getContentPane().add(EliminarDeshabilitarProfesor, "card6");

        CrearCurso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("CREAR CURSO");
        CrearCurso.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel17.setText("Descripción: ");
        CrearCurso.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 70, -1));

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        CrearCurso.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 100, -1));

        jLabel18.setText("Etapa:");
        CrearCurso.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESO", "BACHILLERATO", "FPGS", "FPGM", "FPB", "FPCE" }));
        CrearCurso.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        jButton24.setText("Crear");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        CrearCurso.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabel46.setText("Año:");
        CrearCurso.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º", "2º", "3º", "4º", "5º", "6º" }));
        CrearCurso.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        getContentPane().add(CrearCurso, "card7");

        EliminarCurso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("ELIMINAR O DESHABILITAR CURSO");
        EliminarCurso.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        EliminarCurso.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        EliminarCurso.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        jButton8.setText("Deshabilitar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        EliminarCurso.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idCurso", "codCurso", "Descripción", "Etapa", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable8);

        EliminarCurso.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 530, 190));

        getContentPane().add(EliminarCurso, "card8");

        CrearGrupo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("CREAR GRUPO DE ALUMNOS");
        CrearGrupo.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel22.setText("Descripción del Curso: ");
        CrearGrupo.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));
        CrearGrupo.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 110, -1));

        jLabel23.setText("Número de Alumnos:");
        CrearGrupo.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));
        CrearGrupo.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 110, -1));

        jButton9.setText("Crear");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        CrearGrupo.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grupo", "Codigo Grupo", "Curso", "Numero alumnos", "activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable1);

        CrearGrupo.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 207, 650, 220));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESO1", "ESO2", "ESO3", "ESO4", "BCH1", "BCH2", "FM1", "FM2", "MV1", "MV2", "CAR1", "CAR2", "EVA1", "EVA2", "SMR1", "SMR2", "AF1", "AF2", "DAM1", "DAM2", "DAW1", "DAW2", "DFM1", "DFM2" }));
        CrearGrupo.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabel20.setText("Curso");
        CrearGrupo.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        getContentPane().add(CrearGrupo, "card9");

        ModificarGrupo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setText("MODIFICAR GRUPO");
        ModificarGrupo.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 110, -1));

        jLabel25.setText("Descripción del Curso:");
        ModificarGrupo.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        ModificarGrupo.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 140, -1));

        jButton10.setText("Buscar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        ModificarGrupo.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        jLabel26.setText("Número de Alumnos: ");
        ModificarGrupo.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        ModificarGrupo.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        jButton11.setText("Cambiar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        ModificarGrupo.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grupo", "Codigo Grupo", "Curso", "Numero Alumnos", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable3);

        ModificarGrupo.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 500, 50));

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grupo", "Codigo Grupo", "Curso", "Numero alumnos", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTable10);

        ModificarGrupo.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 410, 70));

        getContentPane().add(ModificarGrupo, "card10");

        jLabel58.setText("DESHABILITAR GRUPO");

        jLabel59.setText("Nombre Grupo:");

        jButton23.setText("Deshabilitar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton26.setText("Buscar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grupo", "Codigo Grupo", "Curso", "Numero Alumnos", "Activo"
            }
        ));
        jScrollPane11.setViewportView(jTable4);

        javax.swing.GroupLayout DeshabilitarGrupoLayout = new javax.swing.GroupLayout(DeshabilitarGrupo);
        DeshabilitarGrupo.setLayout(DeshabilitarGrupoLayout);
        DeshabilitarGrupoLayout.setHorizontalGroup(
            DeshabilitarGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeshabilitarGrupoLayout.createSequentialGroup()
                .addGroup(DeshabilitarGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeshabilitarGrupoLayout.createSequentialGroup()
                        .addGroup(DeshabilitarGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DeshabilitarGrupoLayout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(jLabel58))
                            .addGroup(DeshabilitarGrupoLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel59)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(jButton26))
                    .addGroup(DeshabilitarGrupoLayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jButton23))
                    .addGroup(DeshabilitarGrupoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        DeshabilitarGrupoLayout.setVerticalGroup(
            DeshabilitarGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeshabilitarGrupoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel58)
                .addGap(18, 18, 18)
                .addGroup(DeshabilitarGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton23)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        getContentPane().add(DeshabilitarGrupo, "card18");

        CrearDepartamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setText("CREAR DEPARTAMENTO");
        CrearDepartamento.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 33, 143, -1));

        jLabel28.setText("Nombre:");
        CrearDepartamento.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 70, 59, -1));

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        CrearDepartamento.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 67, 84, -1));

        jLabel29.setText("Código de Departamento:");
        CrearDepartamento.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 70, 149, -1));

        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        CrearDepartamento.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 67, 110, -1));

        jLabel30.setText("Correo de Jefe de Departamento:");
        CrearDepartamento.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 124, -1, -1));
        CrearDepartamento.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 121, 161, -1));

        jButton12.setText("Crear");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        CrearDepartamento.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 121, -1, -1));

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idDepartamento", "codDepartamento", "Nombre", "idJefe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable9);

        CrearDepartamento.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 177, 600, 250));

        getContentPane().add(CrearDepartamento, "card11");

        ModificarDepartamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setText("MODIFICAR DEPARTAMENTO");
        ModificarDepartamento.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 30, -1, -1));

        jButton13.setText("Buscar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        ModificarDepartamento.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "codDepartamento", "idJefe" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        ModificarDepartamento.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));
        ModificarDepartamento.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 123, -1));

        jButton14.setText("Cambiar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        ModificarDepartamento.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idDepartamento", "codDepartamento", "Nombre", "idJefe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTable2);

        ModificarDepartamento.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 600, 220));

        getContentPane().add(ModificarDepartamento, "card12");

        EliminarDepartamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setText("ELIMINAR DEPARTAMENTO");
        EliminarDepartamento.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jButton15.setText("Buscar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        EliminarDepartamento.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idDepartamento", "codDepartamento", "nombre", "idJefe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jTable5);

        EliminarDepartamento.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 500, 160));

        jButton16.setText("Eliminar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        EliminarDepartamento.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        getContentPane().add(EliminarDepartamento, "card13");

        CrearSolicitud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setText("CREAR SOLICITUD");
        CrearSolicitud.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 16, -1, -1));

        jLabel36.setText("Título:");
        CrearSolicitud.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 43, -1));
        CrearSolicitud.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 190, -1));

        jLabel37.setText("Tipo:");
        CrearSolicitud.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 43, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXTRAESCOLAR", "COMPLEMENTARIA" }));
        CrearSolicitud.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 210, -1));

        jLabel38.setText("Departamento:");
        CrearSolicitud.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel39.setText("Hora Inicio:");
        CrearSolicitud.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        CrearSolicitud.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 190, -1));

        jLabel40.setText("Hora Final:");
        CrearSolicitud.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        CrearSolicitud.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 190, -1));

        jLabel41.setText("DNI Profesor:");
        CrearSolicitud.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 97, -1));
        CrearSolicitud.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 210, -1));

        jLabel42.setText("Fecha inicio:");
        CrearSolicitud.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 30));

        jLabel43.setText("Fecha Final:");
        CrearSolicitud.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel44.setText("Participantes:");
        CrearSolicitud.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));
        CrearSolicitud.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 210, -1));

        jButton17.setText("Crear");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        CrearSolicitud.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));
        CrearSolicitud.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 180, -1));
        CrearSolicitud.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 180, -1));

        jCheckBox1.setText("Alojamiento");
        CrearSolicitud.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jCheckBox2.setText("Prevista");
        CrearSolicitud.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biología y Geología", "Dibujo", "Economía", "Educación Física", "Filosofía", "Física y Química", "Francés", "Geografía e Historia", "Inglés", "Latín", "Lengua Castellana y Literatura", "Matemáticas", "Música", "Tecnología", "Administración y Gestión", "Formación y Orientación Laboral", "Informática y Comunicaciones", "Fabricación Mecánica", "Transporte y Mantenimiento de Vehículos" }));
        CrearSolicitud.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 190, -1));

        getContentPane().add(CrearSolicitud, "card14");

        ConsultarSolicitudes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setText("CONSULTAR SOLICITUDES");
        ConsultarSolicitudes.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));
        ConsultarSolicitudes.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 65, -1, -1));

        jButton18.setText("Buscar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        ConsultarSolicitudes.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idSolicitud", "horaInicio", "horaFin", "comentarios", "prevista", "Departamento", "titulo", "tipo", "Profesor", "Alojamiento", "fechaInicio", "fechaFinal", "Participantes", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setDoubleBuffered(true);
        jTable6.setDropMode(javax.swing.DropMode.ON);
        jScrollPane19.setViewportView(jTable6);

        ConsultarSolicitudes.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 590, 330));

        getContentPane().add(ConsultarSolicitudes, "card15");

        AprobarDenegarSolicitudes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setText("APROBAR O DENEGAR SOLICITUDES");
        AprobarDenegarSolicitudes.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 31, 205, -1));

        jLabel50.setText("Solicitudes Asignadas");
        AprobarDenegarSolicitudes.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jButton20.setText("Aprobar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        AprobarDenegarSolicitudes.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jButton21.setText("Denegar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        AprobarDenegarSolicitudes.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));

        jLabel51.setText("Comentario:");
        AprobarDenegarSolicitudes.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 74, -1));
        AprobarDenegarSolicitudes.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 207, -1));

        jButton25.setText("Buscar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        AprobarDenegarSolicitudes.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idSolicitud", "horaInicio", "horaFin", "comentarios", "prevista", "Departamento", "titulo", "tipo", "Profesor", "Alojamiento", "fechaInicio", "fechaFinal", "Participantes", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(jTable7);

        AprobarDenegarSolicitudes.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 590, 130));

        Insertar.setText("Insertar");
        Insertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InsertarMouseClicked(evt);
            }
        });
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });
        AprobarDenegarSolicitudes.add(Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        getContentPane().add(AprobarDenegarSolicitudes, "card16");

        FasePreparacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setText("FASE PREPARACIÓN");
        FasePreparacion.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel53.setText("Solicitudes Aprobadas");
        FasePreparacion.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "horaInicio", "horaFin", "fechaInicio", "fechaFinal", "tipo", "totalParticipantes", "comenRealizada", " " }));
        FasePreparacion.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));
        FasePreparacion.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 124, -1));

        jButton22.setText("Modificar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        FasePreparacion.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel45.setText("Tipo:");

        jLabel55.setText("Importe:");

        jLabel56.setText("Comentario:");

        jLabel57.setText("Km:");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ANDANDO", "BICI", "BUS", "TAXI", "TREN", "BARCO", "AVION" }));

        javax.swing.GroupLayout MedioTransporteLayout = new javax.swing.GroupLayout(MedioTransporte);
        MedioTransporte.setLayout(MedioTransporteLayout);
        MedioTransporteLayout.setHorizontalGroup(
            MedioTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedioTransporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MedioTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MedioTransporteLayout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MedioTransporteLayout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MedioTransporteLayout.setVerticalGroup(
            MedioTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedioTransporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MedioTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel55)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(MedioTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MedioTransporteLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(MedioTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57)
                            .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MedioTransporteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel56)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        FasePreparacion.add(MedioTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 390, 80));

        jButton19.setText("Realizada");
        FasePreparacion.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jCheckBox3.setText("MedioTransporte");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        FasePreparacion.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jButton27.setText("Buscar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        FasePreparacion.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idSolicitud", "Estado", "comentario", "Hora de Inicio", "Hora Fin", "Prevista", "Departamento", "Titulo", "Tipo", "Medio De Transporte", "Profesor", "Alojamiento", "Fecha de Inicio", "Fecha de Fin", "Participantes", "comentarioFinal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, false, false, true, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable11MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable11);
        if (jTable11.getColumnModel().getColumnCount() > 0) {
            jTable11.getColumnModel().getColumn(11).setResizable(false);
        }

        FasePreparacion.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 90));

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(jTable12);

        FasePreparacion.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 460, 90));

        jButton28.setText("Insertar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        FasePreparacion.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        getContentPane().add(FasePreparacion, "card17");

        jMenuBar1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jMenuBar1ComponentAdded(evt);
            }
        });

        Contraseña.setText("Contraseña");
        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        jMenuBar1.add(Contraseña);

        Profesores.setText("Profesores");

        crearProfesorMenu.setText("Crear Profesor");
        crearProfesorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearProfesorMenuActionPerformed(evt);
            }
        });
        Profesores.add(crearProfesorMenu);

        modificarProfesorMenu.setText("Modificar Profesor");
        modificarProfesorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProfesorMenuActionPerformed(evt);
            }
        });
        Profesores.add(modificarProfesorMenu);

        deshabilitarEliminarProfesorMenu.setText("Eliminar/Deshabilitar Profesor");
        deshabilitarEliminarProfesorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshabilitarEliminarProfesorMenuActionPerformed(evt);
            }
        });
        Profesores.add(deshabilitarEliminarProfesorMenu);

        jMenuBar1.add(Profesores);

        Cursos.setText("Cursos");

        CrearCursoMenu.setText("Crear Curso");
        CrearCursoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearCursoMenuActionPerformed(evt);
            }
        });
        Cursos.add(CrearCursoMenu);

        EliminarCursoMenu.setText("Eliminar Curso");
        EliminarCursoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCursoMenuActionPerformed(evt);
            }
        });
        Cursos.add(EliminarCursoMenu);

        jMenuBar1.add(Cursos);

        Grupo.setText("Grupo");

        crearGrupoMenu.setText("Crear Grupo");
        crearGrupoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearGrupoMenuActionPerformed(evt);
            }
        });
        Grupo.add(crearGrupoMenu);

        modificarGrupoMenu.setText("Modificar Grupo");
        modificarGrupoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarGrupoMenuActionPerformed(evt);
            }
        });
        Grupo.add(modificarGrupoMenu);

        deshabilitarGrupoMenu.setText("Deshabilitar Grupo");
        deshabilitarGrupoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshabilitarGrupoMenuActionPerformed(evt);
            }
        });
        Grupo.add(deshabilitarGrupoMenu);

        jMenuBar1.add(Grupo);

        Departamento.setText("Departamento");

        crearDepartamentoMenu.setText("Crear Departamento");
        crearDepartamentoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearDepartamentoMenuActionPerformed(evt);
            }
        });
        Departamento.add(crearDepartamentoMenu);

        modificarDepartamentoMenu.setText("Modificar Departamento");
        modificarDepartamentoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarDepartamentoMenuActionPerformed(evt);
            }
        });
        Departamento.add(modificarDepartamentoMenu);

        deshabilitarDepartamentoMenu.setText("Deshabilitar Departametnto");
        deshabilitarDepartamentoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshabilitarDepartamentoMenuActionPerformed(evt);
            }
        });
        Departamento.add(deshabilitarDepartamentoMenu);

        jMenuBar1.add(Departamento);

        Solicitudes.setText("Solicitudes");

        crearSolicitudMenu.setText("Crear Solicitud");
        crearSolicitudMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearSolicitudMenuActionPerformed(evt);
            }
        });
        Solicitudes.add(crearSolicitudMenu);

        consutarSolicitudesMenu.setText("Consultar Solicitudes");
        consutarSolicitudesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consutarSolicitudesMenuActionPerformed(evt);
            }
        });
        Solicitudes.add(consutarSolicitudesMenu);

        aprobarDenegarSolicitudMenu.setText("Aprobar/Denegar Solicitud");
        aprobarDenegarSolicitudMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobarDenegarSolicitudMenuActionPerformed(evt);
            }
        });
        Solicitudes.add(aprobarDenegarSolicitudMenu);

        fasedepreparacionMenu.setText("Fase de Preparación");
        fasedepreparacionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fasedepreparacionMenuActionPerformed(evt);
            }
        });
        Solicitudes.add(fasedepreparacionMenu);

        jMenuBar1.add(Solicitudes);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        CambiarContraseña.setVisible(rootPaneCheckingEnabled);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);

    }//GEN-LAST:event_ContraseñaActionPerformed

    private void crearProfesorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProfesorMenuActionPerformed
        // TODO add your handling code here
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(rootPaneCheckingEnabled);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_crearProfesorMenuActionPerformed

    private void modificarProfesorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProfesorMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(rootPaneCheckingEnabled);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_modificarProfesorMenuActionPerformed

    private void deshabilitarEliminarProfesorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshabilitarEliminarProfesorMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(rootPaneCheckingEnabled);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_deshabilitarEliminarProfesorMenuActionPerformed

    private void CrearCursoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearCursoMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(rootPaneCheckingEnabled);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_CrearCursoMenuActionPerformed

    private void EliminarCursoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCursoMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(rootPaneCheckingEnabled);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_EliminarCursoMenuActionPerformed

    private void crearGrupoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearGrupoMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(rootPaneCheckingEnabled);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_crearGrupoMenuActionPerformed

    private void modificarGrupoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarGrupoMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(rootPaneCheckingEnabled);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_modificarGrupoMenuActionPerformed

    private void deshabilitarGrupoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshabilitarGrupoMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(rootPaneCheckingEnabled);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_deshabilitarGrupoMenuActionPerformed

    private void crearDepartamentoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearDepartamentoMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(rootPaneCheckingEnabled);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_crearDepartamentoMenuActionPerformed

    private void modificarDepartamentoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarDepartamentoMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(rootPaneCheckingEnabled);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_modificarDepartamentoMenuActionPerformed

    private void deshabilitarDepartamentoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshabilitarDepartamentoMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(rootPaneCheckingEnabled);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_deshabilitarDepartamentoMenuActionPerformed

    private void crearSolicitudMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearSolicitudMenuActionPerformed
        // TODO add your handling code here
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(rootPaneCheckingEnabled);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);

        cargarItemsDepartamento();
    }//GEN-LAST:event_crearSolicitudMenuActionPerformed

    private void consutarSolicitudesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consutarSolicitudesMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(rootPaneCheckingEnabled);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_consutarSolicitudesMenuActionPerformed

    private void aprobarDenegarSolicitudMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobarDenegarSolicitudMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(rootPaneCheckingEnabled);
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_aprobarDenegarSolicitudMenuActionPerformed

    private void fasedepreparacionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fasedepreparacionMenuActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
        Login.setVisible(false);
        //Asigno que sea visible cuando clickemos encima del menu
        CambiarContraseña.setVisible(false);
        MenuInicio.setVisible(false);
        CrearProfesor.setVisible(false);
        ModificarProfesor.setVisible(false);
        EliminarDeshabilitarProfesor.setVisible(false);
        CrearCurso.setVisible(false);
        EliminarCurso.setVisible(false);
        CrearGrupo.setVisible(false);
        ModificarGrupo.setVisible(false);
        DeshabilitarGrupo.setVisible(false);
        CrearDepartamento.setVisible(false);
        ModificarDepartamento.setVisible(false);
        EliminarDepartamento.setVisible(false);
        CrearSolicitud.setVisible(false);
        ConsultarSolicitudes.setVisible(false);
        AprobarDenegarSolicitudes.setVisible(false);
        FasePreparacion.setVisible(rootPaneCheckingEnabled);
        MedioTransporte.setVisible(false);
        jButton28.setVisible(false);
        SolicitudesDAO s = new SolicitudesDAO();
        ActividadProgramadaDAO metodosprogramada = new ActividadProgramadaDAO();
        SortedSet<Solicitud> lista = s.listar();
        ActividadProgramada p = null;
        for (Solicitud so : lista) {
            if (so.getEstado().name().equalsIgnoreCase("APROBADA")) {
                p = new ActividadProgramada(false, "", so.idSolicitud, so.getHoraInicio(), so.getHoraFinal(), so.comentario, so.isPrevista(), so.getIddepartamento(), so.titulo, so.tipoSolicitud, so.idprofesor, so.Alojamiento, so.fechaInicio, so.fechaFinal, so.totalParticipantes, so.estado);
                metodosprogramada.insertar(p);
            }
        }
    }//GEN-LAST:event_fasedepreparacionMenuActionPerformed

    private void jMenuBar1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jMenuBar1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1ComponentAdded

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_CrearActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed

    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        CursosDAO cursos = new CursosDAO();
        String descripcion = jTextField9.getText();
        String anioCurso = jComboBox10.getSelectedItem().toString();
        String codCurso = cursos.crearCodigoCurso(descripcion, anioCurso);
        Etapa etapa = (Etapa) Etapa.valueOf(jComboBox4.getSelectedItem().toString());
        Curso curso1 = new Curso(codCurso, descripcion, etapa, true);

        cursos.insertar(curso1);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        SortedSet<Curso> listaCurso = cursos.listar();
        limpiarTabla();
        insertarTablaCursos(listaCurso, jTable8);
        //Y asigno el jTable al atributo tabla
        jTable8.setModel(tabla);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String valorABuscar = cursoAux.getCodCurso();
        cursos.eliminarPor(valorABuscar);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //Obtengo el índice de la fila que selecciono
        String valorABuscar = cursoAux.getCodCurso();
        Curso c = cursos.buscarPor(valorABuscar);
        cursos.actualizarActivo(valorABuscar, false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DepartamentoDAO dep = new DepartamentoDAO();
        String nombre = jTextField15.getText();
        String codDepartamento = jTextField16.getText();
        String correo = jTextField17.getText();
        Departamento departamento = new Departamento(codDepartamento, nombre, 6);
        dep.insertar(departamento);

        SortedSet<Departamento> listaDepartamento = metodosdepartamento.listar();
        limpiarTabla();
        insertarTablaDepartamento(listaDepartamento, jTable9);
        //Y asigno el jTable al atributo tabla
        jTable6.setModel(tabla);

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        SortedSet<Departamento> listaDepartamento = metodosdepartamento.listar();
        limpiarTabla();
        insertarTablaDepartamento(listaDepartamento, jTable2);
        //Y asigno el jTable al atributo tabla
        jTable6.setModel(tabla);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String atributo = jComboBox5.getSelectedItem().toString();
        String valorABuscar = departamentoAux.getNombre();
        metodosdepartamento.actualizar(atributo, valorABuscar, jTextField19);


    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        SortedSet<Departamento> listaDepartamento = metodosdepartamento.listar();
        limpiarTabla();
        insertarTablaDepartamento(listaDepartamento, jTable5);
        //Y asigno el jTable al atributo tabla
        jTable5.setModel(tabla);


    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String nombre = departamentoAux.getNombre();
        metodosdepartamento.eliminarPor(nombre);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        SolicitudesDAO metodosSolicitudes = new SolicitudesDAO();
        DepartamentoDAO metodosDepartamento = new DepartamentoDAO();
        ProfesorDAO metodosProfesor = new ProfesorDAO();
        String titulo = jTextField21.getText();
        Tipo tipo = Tipo.valueOf(jComboBox6.getSelectedItem().toString());
        int departamento = metodosdepartamento.buscarPor(jComboBox11.getSelectedItem().toString()).getIdDepartamento();
        LocalTime horaInicio = LocalTime.parse(jTextField23.getText());
        LocalTime horaFin = LocalTime.parse(jTextField24.getText());
        int profesor = metodosProfesor.buscarPorDNI(jTextField25.getText()).getIdProfesor();
        LocalDate fechaInicio = LocalDate.parse(jTextField26.getText());
        LocalDate fechaFin = LocalDate.parse(jTextField27.getText());
        int participantes = Integer.parseInt(jTextField28.getText());
        boolean prevista = false;
        boolean alojamiento = false;
        if (jCheckBox2.isSelected()) {
            prevista = true;
        }
        if (jCheckBox1.isSelected()) {
            alojamiento = true;
        }
        Estado estado = Estado.SOLICITADA;

        Solicitud s = new Solicitud(horaInicio, horaFin, "", prevista, departamento, titulo, tipo, profesor, alojamiento, fechaInicio, fechaFin, participantes, estado);
        metodosSolicitudes.insertar(s);
        limpiarCrearSolicitud();

    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        SortedSet<Solicitud> listaSolicitud = solicitud.listar();
        limpiarTabla();
        insertarTablaSolicitudes(listaSolicitud, jTable6);
        //Y asigno el jTable al atributo tabla
        jTable6.setModel(tabla);
    }//GEN-LAST:event_jButton18ActionPerformed

    /**
     *
     * @param evt
     */
    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        SortedSet<Solicitud> listaSolicitud = solicitud.listar();
        jTextField31.setText("");
        limpiarTabla();
        insertarTablaSolicitudes(listaSolicitud, jTable7);
        //Y asigno el jTable al atributo tabla
        jTable7.setModel(tabla);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        // TODO add your handling code here:
        String titulo = solicitudAux.getTitulo();
        String atributo = "comentarios";
        solicitud.actualizar(atributo, titulo, jTextField31);
    }//GEN-LAST:event_InsertarActionPerformed

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
        //Obtengo el índice de la fila que selecciono
        int filaSeleccionada = jTable7.getSelectedRow();
        //Cargo la tabla
        DefaultTableModel tablaF = (DefaultTableModel) jTable7.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud

        String valor1 = tablaF.getValueAt(filaSeleccionada, 6).toString();
        solicitudAux = solicitud.buscarPor(valor1);
    }//GEN-LAST:event_jTable7MouseClicked

    private void InsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertarMouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        String titulo = solicitudAux.getTitulo();
        solicitud.actualizarEstado(titulo, "APROBADA");
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        String titulo = solicitudAux.getTitulo();
        solicitud.actualizarEstado(titulo, "DENEGADA");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTable8.getSelectedRow();
        //Cargo la tabla
        DefaultTableModel tablaF = (DefaultTableModel) jTable8.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud

        String valor1 = tablaF.getValueAt(filaSeleccionada, 1).toString();
        cursoAux = cursos.buscarPor(valor1);
    }//GEN-LAST:event_jTable8MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        //Obtengo el índice de la fila que selecciono
        int filaSeleccionada = jTable2.getSelectedRow();
        //Cargo la tabla
        tabla = (DefaultTableModel) jTable2.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud

        String valor1 = tabla.getValueAt(filaSeleccionada, 2).toString();
        departamentoAux = metodosdepartamento.buscarPor(valor1);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTable5.getSelectedRow();
        //Cargo la tabla
        tabla = (DefaultTableModel) jTable5.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud

        String valor1 = tabla.getValueAt(filaSeleccionada, 2).toString();
        departamentoAux = metodosdepartamento.buscarPor(valor1);
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String codGrupo = jTextField11.getText();
        int numAlumnos = Integer.parseInt(jTextField12.getText());

        String curso = jComboBox8.getSelectedItem().toString();
        Curso cursoencontrado = cursos.buscarPor(curso);

        int idCurso = cursoencontrado.getIdCurso();
        Grupo grupo = new Grupo(codGrupo, idCurso, numAlumnos, true);

        metodosGrupo.insertar(grupo);

        SortedSet<Grupo> listaGrupo = metodosGrupo.listar();
        limpiarTabla();
        insertarTablaGrupos(listaGrupo, jTable1);
        //Y asigno el jTable al atributo tabla
        jTable1.setModel(tabla);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        SortedSet<Grupo> listaGrupo = metodosGrupo.listar();
        limpiarTabla();
        insertarTablaGrupos(listaGrupo, jTable4);
        jTable4.setModel(tabla);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String valorABuscar = grupoAux.getCodGrupo();
        Curso c = cursos.buscarPor(valorABuscar);
        cursos.actualizarActivo(valorABuscar, false);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        SortedSet<Grupo> listaGrupo = metodosGrupo.listar();
        limpiarTabla();
        insertarTablaGrupos(listaGrupo, jTable10);
        //Y asigno el jTable al atributo tabla
        jTable10.setModel(tabla);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String atributo = jTextField14.getText();
        String valorABuscar = String.valueOf(grupoAux.getNumeroAlumnos());
        metodosGrupo.actualizar(atributo, valorABuscar, jTextField14);

        SortedSet<Grupo> listaGrupo = metodosGrupo.listar();
        limpiarTabla();
        insertarTablaGrupos(listaGrupo, jTable3);
        //Y asigno el jTable al atributo tabla
        jTable3.setModel(tabla);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        String atributo = jComboBox7.getSelectedItem().toString();
        String valorABuscar = prograux.titulo;
        metodosprogramada.actualizar(atributo, valorABuscar, jTextField30);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:

        SortedSet<ActividadProgramada> listaProgramada = metodosprogramada.listar();
        limpiarTabla();
        insertarTablaProgramadas(listaProgramada, jTable11);
        //Y asigno el jTable al atributo tabla
        jTable11.setModel(tabla);

    }//GEN-LAST:event_jButton27ActionPerformed

    private void jTable11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MouseClicked
        // TODO add your handling code here:
        //Obtengo el índice de la fila que selecciono
        int filaSeleccionada = jTable11.getSelectedRow();
        //Cargo la tabla
        DefaultTableModel tablaF = (DefaultTableModel) jTable11.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud

        String valor1 = tablaF.getValueAt(filaSeleccionada, 7).toString();
        prograux = metodosprogramada.buscarPor(valor1);
    }//GEN-LAST:event_jTable11MouseClicked

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox3.isSelected()) {
            MedioTransporte.setVisible(true);
            jButton28.setVisible(true);
        } else {
            MedioTransporte.setVisible(false);
            jButton28.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        int idSolicitud = prograux.idSolicitud;
        TipoTransporte tipo = TipoTransporte.valueOf(jComboBox9.getSelectedItem().toString());
        double importe = Double.parseDouble(jTextField33.getText());
        double km = Double.parseDouble(jTextField35.getText());
        String comentario = jTextField34.getText();
        MedioTransporte m = new MedioTransporte(idSolicitud, tipo, comentario, importe, km);
        metodotransporte.insertar(m);
        metodotransporte.insertarMedioUtiliza(m, prograux);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModificarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void txtcontraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseniaActionPerformed

    private void botonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLoginMouseClicked
         // Obtener el correo electrónico y la contraseña ingresados por el usuario
    String correo = txtemail.getText();
    String contrasenia = new String(txtcontrasenia.getPassword());
    
    // Crear una instancia de tu RepositorioDAO (por ejemplo, ProfesorDAO)
    RepositorioDAO<Profesor> profesorDAO = new ProfesorDAO(); // Reemplaza 'conexion' con tu conexión a la base de datos
    
    // Verificar las credenciales
    boolean credencialesValidas = profesorDAO.verificarCredenciales(correo, contrasenia);
    
    // Si las credenciales son válidas, mostrar un mensaje de inicio de sesión completado
    if (credencialesValidas) {
        JOptionPane.showMessageDialog(this, "Inicio de sesión completado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Cerrar la pestaña de inicio de sesión
        this.dispose();
        
        // Abrir la pestaña de MenuInicio
        
        MenuInicio.setVisible(true);
    } else {
        // Si las credenciales no son válidas, mostrar un mensaje de error
        JOptionPane.showMessageDialog(this, "Correo electrónico o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_botonLoginMouseClicked

    private void botonRestablecerContraseniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRestablecerContraseniaMouseClicked
        // TODO add your handling code here:
        CambiarContraseña.setVisible(true);
        Login.setVisible(false);
    }//GEN-LAST:event_botonRestablecerContraseniaMouseClicked

    private void botonCambiarContraseniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCambiarContraseniaMouseClicked
        // TODO add your handling code here:
        // Obtener el DNI y la nueva contraseña ingresados por el usuario
        String dni = txtDNI.getText();
        String nuevaContraseña = new String(txtnuevaContrasenia.getPassword());

        // Verificar si se han ingresado valores en los campos DNI y Nueva Contraseña
        if (dni.isEmpty() || nuevaContraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, introduzca el DNI y la nueva contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si falta algún dato
        }

        // Mostrar un mensaje de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que quiere cambiar su contraseña?", "Confirmar Cambio de Contraseña", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // El usuario confirmó el cambio de contraseña

            // Acceder a la base de datos y actualizar la contraseña del profesor correspondiente
            ProfesorDAO profesorDAO = new ProfesorDAO();
            boolean cambioExitoso = profesorDAO.actualizarContraenia(dni, nuevaContraseña);

            if (cambioExitoso) {
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mostrar un mensaje de error si no se encontró ningún profesor con el DNI proporcionado
                JOptionPane.showMessageDialog(this, "Ningún profesor encontrado con el DNI proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonCambiarContraseniaMouseClicked

    private void botonVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVolverMouseClicked
        // TODO add your handling code here:
        CambiarContraseña.setVisible(false);
        Login.setVisible(true);
    }//GEN-LAST:event_botonVolverMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Swing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AprobarDenegarSolicitudes;
    private javax.swing.JButton Buscar;
    private javax.swing.JPanel CambiarContraseña;
    private javax.swing.JPanel ConsultarSolicitudes;
    private javax.swing.JMenu Contraseña;
    private javax.swing.JButton Crear;
    private javax.swing.JPanel CrearCurso;
    private javax.swing.JMenuItem CrearCursoMenu;
    private javax.swing.JPanel CrearDepartamento;
    private javax.swing.JPanel CrearGrupo;
    private javax.swing.JPanel CrearProfesor;
    private javax.swing.JPanel CrearSolicitud;
    private javax.swing.JMenu Cursos;
    private javax.swing.JMenu Departamento;
    private javax.swing.JPanel DeshabilitarGrupo;
    private javax.swing.JPanel EliminarCurso;
    private javax.swing.JMenuItem EliminarCursoMenu;
    private javax.swing.JPanel EliminarDepartamento;
    private javax.swing.JPanel EliminarDeshabilitarProfesor;
    private javax.swing.JPanel FasePreparacion;
    private javax.swing.JMenu Grupo;
    private javax.swing.JButton Insertar;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel MedioTransporte;
    private javax.swing.JPanel MenuInicio;
    private javax.swing.JButton Modificar;
    private javax.swing.JPanel ModificarDepartamento;
    private javax.swing.JPanel ModificarGrupo;
    private javax.swing.JPanel ModificarProfesor;
    private javax.swing.JMenu Profesores;
    private javax.swing.JMenu Solicitudes;
    private javax.swing.JMenuItem aprobarDenegarSolicitudMenu;
    private javax.swing.JLabel botonCambiarContrasenia;
    private javax.swing.JLabel botonLogin;
    private javax.swing.JLabel botonRestablecerContrasenia;
    private javax.swing.JLabel botonVolver;
    private javax.swing.JMenuItem consutarSolicitudesMenu;
    private javax.swing.JMenuItem crearDepartamentoMenu;
    private javax.swing.JMenuItem crearGrupoMenu;
    private javax.swing.JMenuItem crearProfesorMenu;
    private javax.swing.JMenuItem crearSolicitudMenu;
    private javax.swing.JMenuItem deshabilitarDepartamentoMenu;
    private javax.swing.JMenuItem deshabilitarEliminarProfesorMenu;
    private javax.swing.JMenuItem deshabilitarGrupoMenu;
    private javax.swing.JMenuItem fasedepreparacionMenu;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JMenuItem modificarDepartamentoMenu;
    private javax.swing.JMenuItem modificarGrupoMenu;
    private javax.swing.JMenuItem modificarProfesorMenu;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtcontrasen;
    private javax.swing.JPasswordField txtcontrasenia;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtnuevaContrasenia;
    // End of variables declaration//GEN-END:variables
}
