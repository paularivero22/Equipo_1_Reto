/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import Enumerados.TipoTransporte;
import Enumerados.PerfilAcceso;
import Enumerados.Tipo;
import Enumerados.Etapa;
import Enumerados.Estado;
import metodosDB.SolicitudesDAO;
import metodosDB.ProfesorDAO;
import metodosDB.MedioTransporteDAO;
import metodosDB.GruposDAO;
import metodosDB.DepartamentoDAO;
import metodosDB.CursosDAO;
import metodosDB.ActividadProgramadaDAO;
import metodosDB.AccesoBaseDatos;
import clases.Solicitud;
import clases.Profesor;
import clases.MedioTransporte;
import clases.Grupo;
import clases.Departamento;
import clases.ActividadProgramada;
import clases.Curso;
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
    private ProfesorDAO metodosprofesor;
    private Profesor profesorAux;
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
        this.setExtendedState(MAXIMIZED_BOTH);
        tabla = new DefaultTableModel();
        solicitud = new SolicitudesDAO();
        metodosdepartamento = new DepartamentoDAO();
        metodosGrupo = new GruposDAO();
        metodosprofesor = new ProfesorDAO();
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
        Object[] ob = new Object[4];
        Iterator<Curso> it = lista.iterator();
        while (it.hasNext()) {
            Curso curso = it.next();
            ob[0] = curso.getCodCurso();
            ob[1] = curso.getDescripcion();
            ob[2] = curso.getEtapa();
            ob[3] = curso.isActivo();
            tabla.addRow(ob);
        }
        tabla1.setModel(tabla);
    }

    private void insertarTablaGrupos(SortedSet<Grupo> lista, JTable tabla1) {
        tabla = (DefaultTableModel) tabla1.getModel();
        Object[] ob = new Object[4];
        Iterator<Grupo> it = lista.iterator();
        while (it.hasNext()) {
            Grupo grupo = it.next();
            ob[0] = grupo.getCodGrupo();
            ob[1] = grupo.getIdcurso();
            ob[2] = grupo.getNumeroAlumnos();
            ob[3] = grupo.isActivo();
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

    private void insertarTablaProfesor(SortedSet<Profesor> lista, JTable tabla1) {
        tabla = (DefaultTableModel) tabla1.getModel();
        Object[] ob = new Object[8];
        Iterator<Profesor> it = lista.iterator();
        while (it.hasNext()) {
            Profesor profesor = it.next();
            ob[0] = profesor.getNombre();
            ob[1] = profesor.getApellidos();
            ob[2] = profesor.getDNI();
            ob[3] = profesor.getIdDepartamento();
            ob[4] = profesor.getCorreo();
            ob[5] = profesor.isActivo();
            ob[6] = profesor.getPerfil();
            ob[7]=profesor.getContrasenia();
            
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
            ob[3] = soli.getHoraInicio();
            ob[4] = soli.getHoraFinal();
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
        java.awt.GridBagConstraints gridBagConstraints;

        Login = new javax.swing.JPanel();
        txtEmail = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtcontrasen = new javax.swing.JLabel();
        txtcontrasenia = new javax.swing.JPasswordField();
        iniciar_sesion = new javax.swing.JLabel();
        olvidaste_tu_contrasenia = new javax.swing.JLabel();
        botonLogin = new javax.swing.JLabel();
        botonRestablecerContrasenia = new javax.swing.JLabel();
        Lo_In_Login = new javax.swing.JLabel();
        botonVerContrasenia = new javax.swing.JLabel();
        CambiarContraseña = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtnuevaContrasenia = new javax.swing.JPasswordField();
        botonCambiarContrasenia = new javax.swing.JLabel();
        botonVolver = new javax.swing.JLabel();
        Lo_In_cambiarContrasenia = new javax.swing.JLabel();
        botonVerContrasenia_RC = new javax.swing.JLabel();
        MenuInicio = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
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
        Crear = new javax.swing.JButton();
        ModificarProfesor = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        EliminarDeshabilitarProfesor = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
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
        jButton31 = new javax.swing.JButton();
        ModificarGrupo = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jComboBox12 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        DeshabilitarGrupo = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
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
        jButton30 = new javax.swing.JButton();
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
        jButton28 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton29 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
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
        getContentPane().setLayout(new java.awt.CardLayout(6, 6));

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Login.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                LoginAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmail.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        txtEmail.setText("Email");
        Login.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        txtemail.setBackground(new java.awt.Color(65, 174, 181));
        txtemail.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        txtemail.setBorder(null);
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        Login.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 270, 30));

        txtcontrasen.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        txtcontrasen.setText("Contraseña");
        Login.add(txtcontrasen, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        txtcontrasenia.setBackground(new java.awt.Color(65, 174, 181));
        txtcontrasenia.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        txtcontrasenia.setBorder(null);
        txtcontrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseniaActionPerformed(evt);
            }
        });
        Login.add(txtcontrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 270, 30));

        iniciar_sesion.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        iniciar_sesion.setText("INICIAR SESIÓN");
        Login.add(iniciar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        olvidaste_tu_contrasenia.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 12)); // NOI18N
        olvidaste_tu_contrasenia.setText("¿Olvidaste tu contraseña?");
        Login.add(olvidaste_tu_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 160, 20));

        botonLogin.setBackground(new java.awt.Color(0, 0, 0));
        botonLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonLogin.setText("Iniciar sesión");
        botonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonLoginMouseClicked(evt);
            }
        });
        Login.add(botonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 140, -1));

        botonRestablecerContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonRestablecerContrasenia.setText("Restablecer Contraseña");
        botonRestablecerContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRestablecerContraseniaMouseClicked(evt);
            }
        });
        Login.add(botonRestablecerContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, 30));
        Login.add(Lo_In_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        botonVerContrasenia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonVerContrasenia.setText("Ver");
        botonVerContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerContraseniaMouseClicked(evt);
            }
        });
        Login.add(botonVerContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 30, 30));

        getContentPane().add(Login, "card19");

        CambiarContraseña.setBackground(new java.awt.Color(255, 255, 255));
        CambiarContraseña.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CambiarContraseñaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        CambiarContraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REESTABLECER CONTRASEÑA");
        CambiarContraseña.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 330, 33));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        jLabel2.setText("CORREO");
        CambiarContraseña.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 140, 20));

        jLabel3.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        jLabel3.setText("Nueva Contraseña");
        CambiarContraseña.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, 20));

        txtDNI.setBackground(new java.awt.Color(65, 174, 181));
        txtDNI.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        txtDNI.setBorder(null);
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        CambiarContraseña.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 250, 30));

        txtnuevaContrasenia.setBackground(new java.awt.Color(65, 174, 181));
        txtnuevaContrasenia.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        txtnuevaContrasenia.setBorder(null);
        CambiarContraseña.add(txtnuevaContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 250, 30));

        botonCambiarContrasenia.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        botonCambiarContrasenia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonCambiarContrasenia.setText("Cambiar");
        botonCambiarContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCambiarContraseniaMouseClicked(evt);
            }
        });
        CambiarContraseña.add(botonCambiarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 80, 30));

        botonVolver.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        botonVolver.setText("Volver");
        botonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVolverMouseClicked(evt);
            }
        });
        CambiarContraseña.add(botonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 60, 30));
        CambiarContraseña.add(Lo_In_cambiarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        botonVerContrasenia_RC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonVerContrasenia_RC.setText("Ver");
        botonVerContrasenia_RC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerContrasenia_RCMouseClicked(evt);
            }
        });
        CambiarContraseña.add(botonVerContrasenia_RC, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 20, 20));

        getContentPane().add(CambiarContraseña, "card2");

        MenuInicio.setBackground(new java.awt.Color(255, 255, 255));
        MenuInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MENÚ DE INICIO");
        MenuInicio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 330, 50));
        MenuInicio.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 110));

        getContentPane().add(MenuInicio, "card3");

        CrearProfesor.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("CREAR PROFESOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(80, 140, 0, 0);
        CrearProfesor.add(jLabel4, gridBagConstraints);

        jLabel6.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(84, 50, 0, 0);
        CrearProfesor.add(jLabel6, gridBagConstraints);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 106;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(84, 24, 0, 0);
        CrearProfesor.add(jTextField1, gridBagConstraints);

        jLabel7.setText("Apellidos: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(84, 20, 0, 0);
        CrearProfesor.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 146;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(84, 20, 0, 0);
        CrearProfesor.add(jTextField3, gridBagConstraints);

        jLabel8.setText("DNI:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(94, 84, 0, 0);
        CrearProfesor.add(jLabel8, gridBagConstraints);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(94, 12, 0, 140);
        CrearProfesor.add(jTextField4, gridBagConstraints);

        jLabel9.setText("Perfil:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(128, 50, 0, 0);
        CrearProfesor.add(jLabel9, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PROFESOR", "ADMINISTRADOR", "EQUIPO_DIRECTIVO", "SUPERUSUARIO" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(128, 14, 0, 0);
        CrearProfesor.add(jComboBox1, gridBagConstraints);

        jLabel10.setText("Departamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(128, 0, 0, 0);
        CrearProfesor.add(jLabel10, gridBagConstraints);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biología y Geología", "Dibujo", "Economía", "Educación Física", "Filosofía", "Física y Química", "Francés", "Geología e Historia", "Inglés", "Latín", "Lengua Castellana", "Matemáticas", "Música", "Tecnología", "Administración y Gestión", "Formación y Orientación Laboral", "Informática y Comunicaciones", "Fabricación Mecánica", "Transporte y Mantenimiento de Vehículos" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(128, 20, 0, 0);
        CrearProfesor.add(jComboBox2, gridBagConstraints);

        jLabel11.setText("Correo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(128, 94, 0, 0);
        CrearProfesor.add(jLabel11, gridBagConstraints);

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(128, 22, 0, 140);
        CrearProfesor.add(jTextField5, gridBagConstraints);

        Crear.setText("Crear");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(108, 160, 157, 0);
        CrearProfesor.add(Crear, gridBagConstraints);

        getContentPane().add(CrearProfesor, "card4");

        ModificarProfesor.setLayout(new java.awt.GridBagLayout());

        jLabel12.setText("MODIFICAR PROFESOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 248, 0, 0);
        ModificarProfesor.add(jLabel12, gridBagConstraints);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "apellidos", "perfilAcceso", "correo", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(83, 248, 0, 0);
        ModificarProfesor.add(jComboBox3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(83, 48, 0, 0);
        ModificarProfesor.add(jTextField7, gridBagConstraints);

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(83, 190, 157, 0);
        ModificarProfesor.add(Buscar, gridBagConstraints);

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(83, 31, 157, 0);
        ModificarProfesor.add(Modificar, gridBagConstraints);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "DNI", "Perfil", "Departamento", "Correo", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1184;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(61, 0, 0, 0);
        ModificarProfesor.add(jScrollPane1, gridBagConstraints);

        getContentPane().add(ModificarProfesor, "card5");

        EliminarDeshabilitarProfesor.setLayout(new java.awt.GridBagLayout());

        jLabel14.setText("ELIMINAR O DESHABILITAR PROFESOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 24, 0, 0);
        EliminarDeshabilitarProfesor.add(jLabel14, gridBagConstraints);

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 280, 147, 0);
        EliminarDeshabilitarProfesor.add(jButton3, gridBagConstraints);

        jButton4.setText("Deshabilitar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 154, 147, 0);
        EliminarDeshabilitarProfesor.add(jButton4, gridBagConstraints);

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 120, 147, 0);
        EliminarDeshabilitarProfesor.add(jButton5, gridBagConstraints);

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "DNI", "Perfil", "Departamento", "Correo", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable13MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable13);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1184;
        gridBagConstraints.ipady = 280;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(44, 0, 0, 0);
        EliminarDeshabilitarProfesor.add(jScrollPane2, gridBagConstraints);

        jButton11.setText("Habilitar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 107, 147, 0);
        EliminarDeshabilitarProfesor.add(jButton11, gridBagConstraints);

        getContentPane().add(EliminarDeshabilitarProfesor, "card6");

        CrearCurso.setLayout(new java.awt.GridBagLayout());

        jLabel16.setText("CREAR CURSO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 170, 0, 0);
        CrearCurso.add(jLabel16, gridBagConstraints);

        jLabel17.setText("Descripción: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(64, 290, 0, 0);
        CrearCurso.add(jLabel17, gridBagConstraints);

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(64, 20, 0, 0);
        CrearCurso.add(jTextField9, gridBagConstraints);

        jLabel18.setText("Etapa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(64, 110, 0, 0);
        CrearCurso.add(jLabel18, gridBagConstraints);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESO", "BACHILLERATO", "FPGS", "FPGM", "FPB", "FPCE" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(64, 16, 0, 194);
        CrearCurso.add(jComboBox4, gridBagConstraints);

        jButton24.setText("Crear");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(74, 180, 357, 0);
        CrearCurso.add(jButton24, gridBagConstraints);

        jLabel46.setText("Año:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 130, 0, 0);
        CrearCurso.add(jLabel46, gridBagConstraints);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º", "2º", "3º", "4º", "5º", "6º" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 26, 0, 0);
        CrearCurso.add(jComboBox10, gridBagConstraints);

        getContentPane().add(CrearCurso, "card7");

        EliminarCurso.setLayout(new java.awt.GridBagLayout());

        jLabel19.setText("ELIMINAR O DESHABILITAR CURSO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 77, 0, 0);
        EliminarCurso.add(jLabel19, gridBagConstraints);

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 237, 147, 0);
        EliminarCurso.add(jButton6, gridBagConstraints);

        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 300, 147, 0);
        EliminarCurso.add(jButton7, gridBagConstraints);

        jButton8.setText("Deshabilitar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 188, 147, 0);
        EliminarCurso.add(jButton8, gridBagConstraints);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codCurso", "Descripción", "Etapa", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1164;
        gridBagConstraints.ipady = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(44, 0, 0, 0);
        EliminarCurso.add(jScrollPane3, gridBagConstraints);

        getContentPane().add(EliminarCurso, "card8");

        CrearGrupo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("CREAR GRUPO DE ALUMNOS");
        CrearGrupo.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabel22.setText("Descripción del Curso: ");
        CrearGrupo.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));
        CrearGrupo.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 110, -1));

        jLabel23.setText("Número de Alumnos:");
        CrearGrupo.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));
        CrearGrupo.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 110, -1));

        jButton9.setText("Crear");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        CrearGrupo.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Grupo", "Curso", "Numero alumnos", "activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable1);

        CrearGrupo.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 207, 1200, 440));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESO1", "ESO2", "ESO3", "ESO4", "BCH1", "BCH2", "FM1", "FM2", "MV1", "MV2", "CAR1", "CAR2", "EVA1", "EVA2", "SMR1", "SMR2", "AF1", "AF2", "DAM1", "DAM2", "DAW1", "DAW2", "DFM1", "DFM2" }));
        CrearGrupo.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jLabel20.setText("Curso");
        CrearGrupo.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jButton31.setText("Limpiar");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        CrearGrupo.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, -1, -1));

        getContentPane().add(CrearGrupo, "card9");

        ModificarGrupo.setLayout(new java.awt.GridBagLayout());

        jLabel24.setText("MODIFICAR GRUPO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 29, 0, 0);
        ModificarGrupo.add(jLabel24, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 30, 0, 0);
        ModificarGrupo.add(jTextField13, gridBagConstraints);

        jButton10.setText("Buscar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 120, 0, 0);
        ModificarGrupo.add(jButton10, gridBagConstraints);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Grupo", "Curso", "Numero alumnos", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable10MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTable10);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1094;
        gridBagConstraints.ipady = 520;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(17, 30, 0, 0);
        ModificarGrupo.add(jScrollPane12, gridBagConstraints);

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "codGrupo", "numAlumnos" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 30, 0, 0);
        ModificarGrupo.add(jComboBox12, gridBagConstraints);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 20, 0, 0);
        ModificarGrupo.add(jButton1, gridBagConstraints);

        getContentPane().add(ModificarGrupo, "card10");

        DeshabilitarGrupo.setLayout(new java.awt.GridBagLayout());

        jLabel58.setText("DESHABILITAR GRUPO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 188, 0, 0);
        DeshabilitarGrupo.add(jLabel58, gridBagConstraints);

        jButton23.setText("Deshabilitar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 159, 0, 0);
        DeshabilitarGrupo.add(jButton23, gridBagConstraints);

        jButton26.setText("Buscar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 170, 0, 0);
        DeshabilitarGrupo.add(jButton26, gridBagConstraints);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Grupo", "Curso", "Numero Alumnos", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTable4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1124;
        gridBagConstraints.ipady = 371;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 142, 0);
        DeshabilitarGrupo.add(jScrollPane11, gridBagConstraints);

        jButton2.setText("Habilitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 198, 0, 0);
        DeshabilitarGrupo.add(jButton2, gridBagConstraints);

        getContentPane().add(DeshabilitarGrupo, "card18");

        CrearDepartamento.setLayout(new java.awt.GridBagLayout());

        jLabel27.setText("CREAR DEPARTAMENTO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 81, 0, 0);
        CrearDepartamento.add(jLabel27, gridBagConstraints);

        jLabel28.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 30, 0, 0);
        CrearDepartamento.add(jLabel28, gridBagConstraints);

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 11, 0, 0);
        CrearDepartamento.add(jTextField15, gridBagConstraints);

        jLabel29.setText("Código de Departamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 46, 0, 0);
        CrearDepartamento.add(jLabel29, gridBagConstraints);

        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 11, 0, 0);
        CrearDepartamento.add(jTextField16, gridBagConstraints);

        jLabel30.setText("Correo de Jefe de Departamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 50, 0, 0);
        CrearDepartamento.add(jLabel30, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 97;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 13, 0, 0);
        CrearDepartamento.add(jTextField17, gridBagConstraints);

        jButton12.setText("Crear");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 19, 0, 0);
        CrearDepartamento.add(jButton12, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1114;
        gridBagConstraints.ipady = 330;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(34, 0, 113, 0);
        CrearDepartamento.add(jScrollPane7, gridBagConstraints);

        getContentPane().add(CrearDepartamento, "card11");

        ModificarDepartamento.setLayout(new java.awt.GridBagLayout());

        jLabel31.setText("MODIFICAR DEPARTAMENTO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 278, 0, 0);
        ModificarDepartamento.add(jLabel31, gridBagConstraints);

        jButton13.setText("Buscar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 160, 157, 0);
        ModificarDepartamento.add(jButton13, gridBagConstraints);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "codDepartamento", "idJefe" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 278, 0, 0);
        ModificarDepartamento.add(jComboBox5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 18, 0, 0);
        ModificarDepartamento.add(jTextField19, gridBagConstraints);

        jButton14.setText("Cambiar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 17, 0, 0);
        ModificarDepartamento.add(jButton14, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1114;
        gridBagConstraints.ipady = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(44, 0, 0, 0);
        ModificarDepartamento.add(jScrollPane10, gridBagConstraints);

        getContentPane().add(ModificarDepartamento, "card12");

        EliminarDepartamento.setLayout(new java.awt.GridBagLayout());

        jLabel33.setText("ELIMINAR DEPARTAMENTO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 298, 0, 0);
        EliminarDepartamento.add(jLabel33, gridBagConstraints);

        jButton15.setText("Buscar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 110, 137, 0);
        EliminarDepartamento.add(jButton15, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1064;
        gridBagConstraints.ipady = 260;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(54, 40, 0, 0);
        EliminarDepartamento.add(jScrollPane13, gridBagConstraints);

        jButton16.setText("Eliminar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 322, 0, 0);
        EliminarDepartamento.add(jButton16, gridBagConstraints);

        getContentPane().add(EliminarDepartamento, "card13");

        CrearSolicitud.setLayout(new java.awt.GridBagLayout());

        jLabel35.setText("CREAR SOLICITUD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 20, 0, 0);
        CrearSolicitud.add(jLabel35, gridBagConstraints);

        jLabel36.setText("Título:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 156, 0, 0);
        CrearSolicitud.add(jLabel36, gridBagConstraints);

        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 166;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 0, 0);
        CrearSolicitud.add(jTextField21, gridBagConstraints);

        jLabel37.setText("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 90, 0, 0);
        CrearSolicitud.add(jLabel37, gridBagConstraints);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXTRAESCOLAR", "COMPLEMENTARIA" }));
        jComboBox6.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 13, 0, 148);
        CrearSolicitud.add(jComboBox6, gridBagConstraints);

        jLabel38.setText("Departamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 60, 0, 0);
        CrearSolicitud.add(jLabel38, gridBagConstraints);

        jLabel39.setText("Hora Inicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 156, 0, 0);
        CrearSolicitud.add(jLabel39, gridBagConstraints);

        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 166;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 10, 0, 0);
        CrearSolicitud.add(jTextField23, gridBagConstraints);

        jLabel40.setText("Hora Final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 156, 0, 0);
        CrearSolicitud.add(jLabel40, gridBagConstraints);

        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 166;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 0);
        CrearSolicitud.add(jTextField24, gridBagConstraints);

        jLabel41.setText("Correo Profesor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 50, 0, 0);
        CrearSolicitud.add(jLabel41, gridBagConstraints);

        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 176;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 13, 0, 148);
        CrearSolicitud.add(jTextField25, gridBagConstraints);

        jLabel42.setText("Fecha inicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 156, 0, 0);
        CrearSolicitud.add(jLabel42, gridBagConstraints);

        jLabel43.setText("Fecha Final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 156, 0, 0);
        CrearSolicitud.add(jLabel43, gridBagConstraints);

        jLabel44.setText("Participantes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 70, 0, 0);
        CrearSolicitud.add(jLabel44, gridBagConstraints);

        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 176;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 13, 0, 148);
        CrearSolicitud.add(jTextField28, gridBagConstraints);

        jButton17.setText("Crear");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 142, 0);
        CrearSolicitud.add(jButton17, gridBagConstraints);

        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 166;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 10, 0, 0);
        CrearSolicitud.add(jTextField26, gridBagConstraints);

        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 166;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 0, 0);
        CrearSolicitud.add(jTextField27, gridBagConstraints);

        jCheckBox1.setText("Alojamiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(78, 126, 0, 0);
        CrearSolicitud.add(jCheckBox1, gridBagConstraints);

        jCheckBox2.setText("Prevista");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(78, 80, 0, 0);
        CrearSolicitud.add(jCheckBox2, gridBagConstraints);

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biología y Geología", "Dibujo", "Economía", "Educación Física", "Filosofía", "Física y Química", "Francés", "Geografía e Historia", "Inglés", "Latín", "Lengua Castellana y Literatura", "Matemáticas", "Música", "Tecnología", "Administración y Gestión", "Formación y Orientación Laboral", "Informática y Comunicaciones", "Fabricación Mecánica", "Transporte y Mantenimiento de Vehículos" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = -14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 13, 0, 148);
        CrearSolicitud.add(jComboBox11, gridBagConstraints);

        jButton30.setText("Limpiar");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 11, 0, 0);
        CrearSolicitud.add(jButton30, gridBagConstraints);

        getContentPane().add(CrearSolicitud, "card14");

        ConsultarSolicitudes.setLayout(new java.awt.GridBagLayout());

        jLabel47.setText("CONSULTAR SOLICITUDES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 318, 0, 0);
        ConsultarSolicitudes.add(jLabel47, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        ConsultarSolicitudes.add(jLabel48, gridBagConstraints);

        jButton18.setText("Buscar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 17, 0, 0);
        ConsultarSolicitudes.add(jButton18, gridBagConstraints);

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
        jTable6.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane19.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setHeaderValue("idSolicitud");
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1074;
        gridBagConstraints.ipady = 520;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 10);
        ConsultarSolicitudes.add(jScrollPane19, gridBagConstraints);

        getContentPane().add(ConsultarSolicitudes, "card15");

        AprobarDenegarSolicitudes.setLayout(new java.awt.GridBagLayout());

        jLabel49.setText("APROBAR O DENEGAR SOLICITUDES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 28, 0, 0);
        AprobarDenegarSolicitudes.add(jLabel49, gridBagConstraints);

        jLabel50.setText("Solicitudes Asignadas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 40, 0, 0);
        AprobarDenegarSolicitudes.add(jLabel50, gridBagConstraints);

        jButton20.setText("Aprobar");
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(87, 13, 77, 0);
        AprobarDenegarSolicitudes.add(jButton20, gridBagConstraints);

        jButton21.setText("Denegar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(87, 116, 77, 0);
        AprobarDenegarSolicitudes.add(jButton21, gridBagConstraints);

        jLabel51.setText("Comentario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 90, 0, 0);
        AprobarDenegarSolicitudes.add(jLabel51, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 143;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 5, 0, 0);
        AprobarDenegarSolicitudes.add(jTextField31, gridBagConstraints);

        jButton25.setText("Buscar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 364, 0, 0);
        AprobarDenegarSolicitudes.add(jButton25, gridBagConstraints);

        jScrollPane20.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

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
        jTable7.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable7.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(jTable7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1084;
        gridBagConstraints.ipady = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 0, 0);
        AprobarDenegarSolicitudes.add(jScrollPane20, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 13, 0, 0);
        AprobarDenegarSolicitudes.add(Insertar, gridBagConstraints);

        getContentPane().add(AprobarDenegarSolicitudes, "card16");

        FasePreparacion.setLayout(new java.awt.GridBagLayout());

        jLabel52.setText("FASE PREPARACIÓN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 38, 0, 0);
        FasePreparacion.add(jLabel52, gridBagConstraints);

        jLabel53.setText("Solicitudes Aprobadas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 0, 0);
        FasePreparacion.add(jLabel53, gridBagConstraints);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "horaInicio", "horaFin", "fechaInicio", "fechaFinal", "tipo", "totalParticipantes", "comenRealizada", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 20, 0, 0);
        FasePreparacion.add(jComboBox7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 2, 0, 0);
        FasePreparacion.add(jTextField30, gridBagConstraints);

        jButton22.setText("Modificar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 16, 0, 0);
        FasePreparacion.add(jButton22, gridBagConstraints);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
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
                .addContainerGap(48, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.ipady = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 56, 0, 0);
        FasePreparacion.add(MedioTransporte, gridBagConstraints);

        jButton19.setText("Realizada");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        FasePreparacion.add(jButton19, gridBagConstraints);

        jCheckBox3.setText("MedioTransporte");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 99, 0, 0);
        FasePreparacion.add(jCheckBox3, gridBagConstraints);

        jButton27.setText("Buscar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 0, 0);
        FasePreparacion.add(jButton27, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1082;
        gridBagConstraints.ipady = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(14, 20, 0, 12);
        FasePreparacion.add(jScrollPane8, gridBagConstraints);

        jButton28.setText("Insertar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 119, 0, 0);
        FasePreparacion.add(jButton28, gridBagConstraints);

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable12MouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(jTable12);
        if (jTable12.getColumnModel().getColumnCount() > 0) {
            jTable12.getColumnModel().getColumn(11).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1082;
        gridBagConstraints.ipady = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 80, 12);
        FasePreparacion.add(jScrollPane14, gridBagConstraints);

        jButton29.setText("Mostrar realizadas");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 30, 0, 0);
        FasePreparacion.add(jButton29, gridBagConstraints);

        getContentPane().add(FasePreparacion, "card17");

        jMenuBar1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jMenuBar1ComponentAdded(evt);
            }
        });

        Archivo.setText("Archivo");
        Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArchivoActionPerformed(evt);
            }
        });

        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        Archivo.add(CerrarSesion);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Archivo.add(Salir);

        jMenuBar1.add(Archivo);

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

    private void ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArchivoActionPerformed
        // TODO add your handling code here:
        //Asigno que sea visible cuando clickemos encima del menu
      

    }//GEN-LAST:event_ArchivoActionPerformed

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
                p = new ActividadProgramada(false, "", so.getIdSolicitud(), so.getHoraInicio(), so.getHoraFinal(), so.getComentario(), so.isPrevista(), so.getIddepartamento(), so.getTitulo(), so.getTipoSolicitud(), so.getIdprofesor(), so.isAlojamiento(), so.getFechaInicio(), so.getFechaFinal(), so.getTotalParticipantes(), so.getEstado());
                metodosprogramada.insertar(p);
            }
        }
    }//GEN-LAST:event_fasedepreparacionMenuActionPerformed

    private void jMenuBar1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jMenuBar1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1ComponentAdded

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
        String nombre = jTextField1.getText();
        String apellidos = jTextField3.getText();
        String DNI = jTextField4.getText();
        String correo = jTextField5.getText();
        PerfilAcceso perfil = (PerfilAcceso) PerfilAcceso.valueOf(jComboBox1.getSelectedItem().toString());
        String departamento = jComboBox2.getSelectedItem().toString();
        Departamento dep=metodosdepartamento.buscarPor(departamento);
        Profesor profesorencontrado = metodosprofesor.buscarPor(correo);
        int idDepartamento = dep.getIdDepartamento();
        String contrasenia = MetodosFicheros.generarPassword(7);
        Profesor profesor = new Profesor(idDepartamento, nombre, apellidos, DNI, correo, true, perfil, contrasenia);

        metodosprofesor.insertar(profesor);

      
    }//GEN-LAST:event_CrearActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String valorABuscar = profesorAux.getCorreo();
        metodosprofesor.eliminarPor(valorABuscar);
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
        int profesor = metodosProfesor.buscarPor(jTextField25.getText()).getIdProfesor();
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
        System.out.println(cursoAux.toString());
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
        metodosGrupo.actualizarActivo(valorABuscar, false);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        SortedSet<Grupo> listaGrupo = metodosGrupo.listar();
        limpiarTabla();
        insertarTablaGrupos(listaGrupo, jTable10);
        //Y asigno el jTable al atributo tabla
        jTable10.setModel(tabla);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        String atributo = jComboBox7.getSelectedItem().toString();
        String valorABuscar = prograux.getTitulo();
        metodosprogramada.actualizar(atributo, valorABuscar, jTextField30);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        SortedSet<ActividadProgramada> listaProgramada = metodosprogramada.listarAprobadas();
        limpiarTabla();
        insertarTablaProgramadas(listaProgramada, jTable11);
        //Y asigno el jTable al atributo tabla
        jTable11.setModel(tabla);

    }//GEN-LAST:event_jButton27ActionPerformed

    private void jTable11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MouseClicked
        // TODO add your handling code here:
        //Obtengo el índice de la fila que selecciono
        int filaSeleccionada = jTable11.rowAtPoint(evt.getPoint());
        DefaultTableModel tablaF = (DefaultTableModel) jTable11.getModel();
        String valor1 = tablaF.getValueAt(filaSeleccionada, 7).toString();
        prograux = metodosprogramada.buscarPor(valor1);
        System.out.println(prograux.toString());
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
        int idSolicitud = prograux.getIdSolicitud();
        TipoTransporte tipo = TipoTransporte.valueOf(jComboBox9.getSelectedItem().toString());
        double importe = Double.parseDouble(jTextField33.getText());
        double km = Double.parseDouble(jTextField35.getText());
        String comentario = jTextField34.getText();
        MedioTransporte m = new MedioTransporte(idSolicitud, tipo, comentario, importe, km);
        metodotransporte.insertar(m);
        metodotransporte.insertarMedioUtiliza(m, prograux);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        if (prograux != null) {
            String titulo = prograux.getTitulo();
            metodosprogramada.actualizarEstado(titulo, "REALIZADA");
            limpiarTabla();
        }

    }//GEN-LAST:event_jButton19ActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        SortedSet<Profesor> listaProfesor = metodosprofesor.listar();
        limpiarTabla();
        insertarTablaProfesor(listaProfesor, jTable3);
        //Y asigno el jTable al atributo tabla
        jTable3.setModel(tabla);
    }//GEN-LAST:event_BuscarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        String atributo=jComboBox3.getSelectedItem().toString();
        String valorABuscar=profesorAux.getCorreo();
        metodosprofesor.actualizar(atributo, valorABuscar,jTextField7);
    }//GEN-LAST:event_ModificarActionPerformed

    private void jTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseClicked
        //Obtengo el índice de la fila que selecciono
        int filaSeleccionada = jTable10.getSelectedRow();
        int columna = jTable10.getSelectedColumn();
        //Cargo la tabla
        tabla = (DefaultTableModel) jTable10.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud
        String valor1 = tabla.getValueAt(filaSeleccionada, 1).toString();
        grupoAux = metodosGrupo.buscarPor(valor1);
        System.out.println(grupoAux.toString());
    }//GEN-LAST:event_jTable10MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String valorABuscar = profesorAux.getCorreo();
        Profesor c = metodosprofesor.buscarPor(valorABuscar);
        boolean activo=false;
        metodosprofesor.actualizarEstado(valorABuscar,false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SortedSet<Profesor> listaProfesor = metodosprofesor.listar();
        limpiarTabla();
        insertarTablaProfesor(listaProfesor, jTable13);
        //Y asigno el jTable al atributo tabla
        jTable13.setModel(tabla);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable12MouseClicked

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        SortedSet<ActividadProgramada> listaProgramada = metodosprogramada.listarRealizadas();
        limpiarTabla();
        insertarTablaProgramadas(listaProgramada, jTable12);
        //Y asigno el jTable al atributo tabla
        jTable1.setModel(tabla);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtcontraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseniaActionPerformed

    private void botonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLoginMouseClicked
        // Obtener el correo electrónico y la contraseña ingresados por el usuario
        String correo = txtemail.getText();
        String contrasenia = new String(txtcontrasenia.getPassword());

        // Crear una instancia de tu RepositorioDAO (por ejemplo, ProfesorDAO)
        ProfesorDAO profesorDAO = new ProfesorDAO(); // Reemplaza 'conexion' con tu conexión a la base de datos

        // Verificar las credenciales
        boolean credencialesValidas = profesorDAO.verificarCredenciales(correo, contrasenia);

        // Si las credenciales son válidas, mostrar un mensaje de inicio de sesión completado
        if (credencialesValidas) {
            
            Profesor aux = profesorDAO.buscarPor(correo);
            
            
            if(aux.getPerfil().toString().equalsIgnoreCase("profesor")){
                
                JOptionPane.showConfirmDialog(null, "ingreso profesor ");
                Login.setVisible(false);
                MenuInicio.setVisible(true);
                jMenuBar1.setVisible(true);
                consutarSolicitudesMenu.setVisible(false);
                aprobarDenegarSolicitudMenu.setVisible(false);
                fasedepreparacionMenu.setVisible(false);
                Profesores.setVisible(false);
                Cursos.setVisible(false);
                Grupo.setVisible(false);
                Departamento.setVisible(false);
                Archivo.setVisible(false);
                /**CambiarContraseña.setVisible(true);
                CrearSolicitud.setVisible(true);**/
                
            }else if (aux.getPerfil().toString().equalsIgnoreCase("administrador")){
            
            JOptionPane.showConfirmDialog(null, "ingreso administrador ");
            Login.setVisible(false);
            jMenuBar1.setVisible(true);
            MenuInicio.setVisible(true);
        
            
        }else if (aux.getPerfil().toString().equalsIgnoreCase("equipo_directivo")){
         
            JOptionPane.showConfirmDialog(null, "Ingreso Equipo Directivo ");
                Login.setVisible(false);
                MenuInicio.setVisible(true);
                jMenuBar1.setVisible(true);
                crearSolicitudMenu.setVisible(false);
                consutarSolicitudesMenu.setVisible(false);
                fasedepreparacionMenu.setVisible(false);
                Profesores.setVisible(false);
                Cursos.setVisible(false);
                Grupo.setVisible(false);
                Departamento.setVisible(false);
                Archivo.setVisible(false);
            
        }else if (aux.getPerfil().toString().equalsIgnoreCase("superusuario")){
            
            JOptionPane.showConfirmDialog(null, "Ingreso SuperUsuario");
            Login.setVisible(false);
            jMenuBar1.setVisible(true);
            MenuInicio.setVisible(true);
            Archivo.setVisible(false);
        }
            
            
            
            /*JOptionPane.showMessageDialog(this, "Inicio de sesión completado", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Cerrar la pestaña de inicio de sesión
            Login.setVisible(false);

            // Abrir la pestaña de MenuInicio
            MenuInicio.setVisible(true);
            jMenuBar1.setVisible(true);
            */
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

    private void botonVerContraseniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerContraseniaMouseClicked
        // TODO add your handling code here:
        txtcontrasenia.setEchoChar(txtcontrasenia.getEchoChar() == '*' ? '\0' : '*');
    }//GEN-LAST:event_botonVerContraseniaMouseClicked

    private void LoginAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_LoginAncestorAdded
        // TODO add your handling code here:
        jMenuBar1.setVisible(false);
    }//GEN-LAST:event_LoginAncestorAdded

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void botonCambiarContraseniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCambiarContraseniaMouseClicked
        // TODO add your handling code here:
        // Obtener el DNI y la nueva contraseña ingresados por el usuario
        String correo = txtDNI.getText();
        String nuevaContraseña = new String(txtnuevaContrasenia.getPassword());

        // Verificar si se han ingresado valores en los campos DNI y Nueva Contraseña
        if (correo.isEmpty() || nuevaContraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, introduzca el DNI y la nueva contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si falta algún dato
        }

        // Mostrar un mensaje de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que quiere cambiar su contraseña?", "Confirmar Cambio de Contraseña", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // El usuario confirmó el cambio de contraseña

            // Acceder a la base de datos y actualizar la contraseña del profesor correspondiente
            ProfesorDAO profesorDAO = new ProfesorDAO();
            boolean cambioExitoso = profesorDAO.actualizarContraenia(correo, nuevaContraseña);

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

    private void botonVerContrasenia_RCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerContrasenia_RCMouseClicked
        // TODO add your handling code here:
        txtnuevaContrasenia.setEchoChar(txtnuevaContrasenia.getEchoChar() == '*' ? '\0' : '*');
    }//GEN-LAST:event_botonVerContrasenia_RCMouseClicked

    private void CambiarContraseñaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CambiarContraseñaAncestorAdded
        // TODO add your handling code here:
        jMenuBar1.setVisible(false);
    }//GEN-LAST:event_CambiarContraseñaAncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String valorABuscar = grupoAux.getCodGrupo();
        String atributo = jComboBox12.getSelectedItem().toString();
        metodosGrupo.actualizar(atributo, valorABuscar, jTextField13);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String valorABuscar = grupoAux.getCodGrupo();
        metodosGrupo.actualizarActivo(valorABuscar, true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTable4.getSelectedRow();
        int columna = jTable4.getSelectedColumn();
        //Cargo la tabla
        tabla = (DefaultTableModel) jTable4.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud
        String valor1 = tabla.getValueAt(filaSeleccionada, 1).toString();
        grupoAux = metodosGrupo.buscarPor(valor1);
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTable3.getSelectedRow();
        //Cargo la tabla
        tabla = (DefaultTableModel) jTable3.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud

        String valor1 = tabla.getValueAt(filaSeleccionada,4).toString();

        profesorAux = metodosprofesor.buscarPor(valor1);
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable13MouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTable13.getSelectedRow();
        //Cargo la tabla
        tabla = (DefaultTableModel) jTable13.getModel();
        //Obtengo el valor del indice que utilizo para buscar una solicitud

        String valor1 = tabla.getValueAt(filaSeleccionada,4).toString();

        profesorAux = metodosprofesor.buscarPor(valor1);
    }//GEN-LAST:event_jTable13MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String valorABuscar = profesorAux.getCorreo();
        Profesor c = metodosprofesor.buscarPor(valorABuscar);
        boolean activo=true;
        metodosprofesor.actualizarEstado(valorABuscar,activo);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        limpiarCrearSolicitud();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        jTextField11.setText("");
        jTextField12.setText("");
    }//GEN-LAST:event_jButton31ActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        Login.setVisible(rootPaneCheckingEnabled);
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
        FasePreparacion.setVisible(false);
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

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
    private javax.swing.JMenu Archivo;
    private javax.swing.JButton Buscar;
    private javax.swing.JPanel CambiarContraseña;
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JPanel ConsultarSolicitudes;
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
    private javax.swing.JLabel Lo_In_Login;
    private javax.swing.JLabel Lo_In_cambiarContrasenia;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel MedioTransporte;
    private javax.swing.JPanel MenuInicio;
    private javax.swing.JButton Modificar;
    private javax.swing.JPanel ModificarDepartamento;
    private javax.swing.JPanel ModificarGrupo;
    private javax.swing.JPanel ModificarProfesor;
    private javax.swing.JMenu Profesores;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenu Solicitudes;
    private javax.swing.JMenuItem aprobarDenegarSolicitudMenu;
    private javax.swing.JLabel botonCambiarContrasenia;
    private javax.swing.JLabel botonLogin;
    private javax.swing.JLabel botonRestablecerContrasenia;
    private javax.swing.JLabel botonVerContrasenia;
    private javax.swing.JLabel botonVerContrasenia_RC;
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
    private javax.swing.JLabel iniciar_sesion;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
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
    private javax.swing.JComboBox<String> jComboBox12;
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
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
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
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
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
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JMenuItem modificarDepartamentoMenu;
    private javax.swing.JMenuItem modificarGrupoMenu;
    private javax.swing.JMenuItem modificarProfesorMenu;
    private javax.swing.JLabel olvidaste_tu_contrasenia;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtcontrasen;
    private javax.swing.JPasswordField txtcontrasenia;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtnuevaContrasenia;
    // End of variables declaration//GEN-END:variables
}
