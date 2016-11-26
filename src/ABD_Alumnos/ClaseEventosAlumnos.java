/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABD_Alumnos;

import Principal.VistaTabla;
import static ABD_Alumnos.DlgAlumnos.jTablaAlumnos;
import Principal.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author 2DAM - Judit
 */
public class ClaseEventosAlumnos extends javax.swing.JDialog implements ActionListener, MouseListener {

    //FrmAlumnos frm;
    DlgAlumnos dlgAlu;
    ResultSet rs;
    // private ConexionAlumno conexion;
    private NegocioAlumno negocioAlumno;
    private FichaAlumno fichalumno;

    private JasperPrint jsPrint;
    // private VistaTablaAlumnos rsmodel;

    public ClaseEventosAlumnos(FrmMenu frmmenu) {
        //frm = new FrmAlumnos(this);
        //FrmPrincipal frm=new FrmPrincipal();
        //frm.setVisible(true);

        //conexion = claseConexion.getInstance();
        //this.dlgAlu = dlgAlu;
        negocioAlumno = new NegocioAlumno();
        fichalumno = new FichaAlumno();

        dlgAlu = new DlgAlumnos(frmmenu, true, this);
        dlgAlu.setVisible(true);

        jsPrint = null;
    }

    public void cargarDatosDeFichaAlumno() {
        fichalumno = negocioAlumno.cargarDatosAlumno();
        dlgAlu.getjTFRegistro().setText(String.valueOf(fichalumno.getRegistro()));
        dlgAlu.getjTFDniAlu().setText(fichalumno.getDni());
        dlgAlu.getjTFNombreAlu().setText(fichalumno.getNombre());
        dlgAlu.getjTFApellido1Alu().setText(fichalumno.getApellido1());
        dlgAlu.getjTFApellido2Alu().setText(fichalumno.getApellido2());
    }

    public void iniciarTabla(ResultSet rs) {
        VistaTabla v = new VistaTabla(rs);
        jTablaAlumnos.setModel(v);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("Iniciar".equals(e.getActionCommand())) {
            try {
                // rs = conexion.getRs();
                negocioAlumno.iniciar();
                iniciarTabla(negocioAlumno.getRsDeConexion());
                //si la tabla de registros no está vacía
                if (negocioAlumno.getRsDeConexion().next() == true) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Iniciar'");
            }
        } else if ("Siguiente".equals(e.getActionCommand())) {
            try {
                //si hay siguiente registro, lo muestra
                if (negocioAlumno.siguiente()) {
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Siguiente'");
            }
        } else if ("Anterior".equals(e.getActionCommand())) {
            try {
                //Si hay un registro anterior, lo muestra
                if (negocioAlumno.anterior()) {
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Anterior'");
            }
        } else if ("Altas".equals(e.getActionCommand())) {
            fichalumno.setRegistro(Integer.parseInt(dlgAlu.getjTFRegistro().getText()));
            fichalumno.setDni(dlgAlu.getjTFDniAlu().getText());
            fichalumno.setNombre(dlgAlu.getjTFNombreAlu().getText());
            fichalumno.setApellido1(dlgAlu.getjTFApellido1Alu().getText());
            fichalumno.setApellido2(dlgAlu.getjTFApellido2Alu().getText());
            negocioAlumno.altas(fichalumno);
        } else if ("Generar informe de alumnos".equals(e.getActionCommand())) {
            //TERMINAR MÁS ADELANTE. 
        } else if ("Volver al menú".equals(e.getActionCommand())) {
            dlgAlu.dispose();
        } else if ("Bajas".equals(e.getActionCommand())) {
            negocioAlumno.bajas(fichalumno);
        } else if ("Buscar".equals(e.getActionCommand())) {
            negocioAlumno.buscarEnTextField(dlgAlu.getTextoABuscar().getText());
            mostrar(dlgAlu.getTextoABuscar().getText());
        }
    }

    public void mostrar(String buscarEnTextfield) {
        try {
            VistaTabla modelo;
            NegocioAlumno func = new NegocioAlumno();
            func.buscarEnTextField(buscarEnTextfield);
            modelo = new VistaTabla(negocioAlumno.getRsDeConexion());
            jTablaAlumnos.setModel(modelo);
            /*
            VistaTabla v = new VistaTabla(rs);
            jTablaAlumnos.setModel(v);      
             */
        } catch (Exception e) {
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cargarDatosDeFichaAlumno();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /*
    public void InicializarTabla() {
        try {
            fichalumno = new FichaAlumno(); //crea el objeto
            negocio = new NegocioAlumno(conexion); //crea objeto negocioAlumnos
            negocio.conectar();
            negocio.buscar();
            rsmodel = new VistaTablaAlumnos(negocio.conexion.getRs());
            DlgAlumnos.jTablaAlumnos.setModel(rsmodel);

        } catch (Exception ex) {
            //VentanaMensajeError(ex.toString());
        }
    }
     */
}
