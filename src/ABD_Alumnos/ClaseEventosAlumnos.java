/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABD_Alumnos;

import static ABD_Alumnos.DlgAlumnos.jTablaAlumnos;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author 2DAM - Judit
 */
public class ClaseEventosAlumnos extends javax.swing.JDialog implements ActionListener, MouseListener {

    //FrmAlumnos frm;
    DlgAlumnos dlgAlu;
    ResultSet rs;
    private ConexionAlumno conexion;
    private NegocioAlumno negocio;
    private FichaAlumno fichalumno;
    private JasperPrint jsPrint;
    // private VistaTablaAlumnos rsmodel;

    public ClaseEventosAlumnos() {
        //frm = new FrmAlumnos(this);
        //FrmPrincipal frm=new FrmPrincipal();
        //frm.setVisible(true);

        //conexion = claseConexion.getInstance();
        //this.dlgAlu = dlgAlu;
        conexion = new ConexionAlumno();
        negocio = new NegocioAlumno(conexion);
        fichalumno = new FichaAlumno();
        jsPrint = null;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rs = conexion.getRs();
        if (e.getActionCommand() == "Iniciar") {
            try {
               // rs = conexion.getRs();
                negocio.iniciar();
                iniciarTabla(conexion.getRs());
                //si la tabla de registros no está vacía
                if (conexion.getRs().next()== true) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Iniciar'");
            }
        } else if (e.getActionCommand() == "Siguiente") {
            try {
                //si hay siguiente registro, lo muestra
                if (rs.next()) {
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Siguiente'");
            }
        } else if (e.getActionCommand() == "Anterior") {
            try {
                //Si hay un registro anterior, lo muestra
                if (rs.previous()) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Anterior'");
            }
        } else if (e.getActionCommand() == "Altas") {
            fichalumno.setRegistro(Integer.parseInt(dlgAlu.getjTFRegistro().getText()));
            fichalumno.setDni(dlgAlu.getjTFDniAlu().getText());
            fichalumno.setNombre(dlgAlu.getjTFNombreAlu().getText());
            fichalumno.setApellido1(dlgAlu.getjTFApellido1Alu().getText());
            fichalumno.setApellido2(dlgAlu.getjTFApellido2Alu().getText());
            negocio.altas(fichalumno);
        } else if (e.getActionCommand() == "Generar informe de alumnos") {
            //TERMINAR MÁS ADELANTE. 
        } else if (e.getActionCommand() == "Volver al menú") {
            dlgAlu.dispose();
        } else if (e.getActionCommand() == "Bajas") {

        } else if (e.getActionCommand() == "Buscar") {
            negocio.buscarEnTextField(dlgAlu.getTextoABuscar().getText());
            iniciarTabla(rs);
            //mostrar(dlgAlu.getTextoABuscar().getText());
        }
    }

    public void mostrar(String buscarEnTextfield) {
        try {
            VistaTabla modelo;
            NegocioAlumno func = new NegocioAlumno(conexion);
            func.buscarEnTextField(buscarEnTextfield);
            modelo = new VistaTabla(conexion.getRs());
            jTablaAlumnos.setModel(modelo);
            /*
            VistaTabla v = new VistaTabla(rs);
            jTablaAlumnos.setModel(v);      
             */
        } catch (Exception e) {
        }
    }

    public void cargarDatosDeFichaAlumno() {
        fichalumno = negocio.cargarDatosAlumno();
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

    public void iniciarDialog(Frame frm) {
        dlgAlu = new DlgAlumnos(frm, true, this);
        dlgAlu.setVisible(true);
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
