/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABD_Alumnos;

import Principal.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
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
    private ConexionAlumno conexion;
    private NegocioAlumno negocio;
    private FichaAlumno fichalumno;
    private JasperPrint jsPrint;
    private VistaTablaAlumnos rsmodel;
    
    public ClaseEventosAlumnos(DlgAlumnos dlgAlu) {
        //frm = new FrmAlumnos(this);
        //FrmPrincipal frm=new FrmPrincipal();
        //frm.setVisible(true);

        //conexion = claseConexion.getInstance();
        this.dlgAlu = dlgAlu;
        conexion = new ConexionAlumno();
        negocio = new NegocioAlumno(conexion);
        fichalumno = new FichaAlumno();
        jsPrint = null;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Iniciar") {
            try {
                negocio.buscar();
                dlgAlu.iniciarTabla(conexion.getRs());
                //si la tabla de registros no está vacía
                if (conexion.getRs().first()) { 
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DlgAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Siguiente") {
            try {
                //si hay siguiente registro, lo muestra
                if (conexion.getRs().next()) {
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DlgAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Anterior") {
            try {
                //Si hay un registro anterior, lo muestra
                if (conexion.getRs().previous()) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DlgAlumnos.class.getName()).log(Level.SEVERE, null, ex);
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
            FrmMenu frmMenu = new FrmMenu();
            //DlgAlumnos dlgAlu = new DlgAlumnos(frmMenu, true, null);
            //dlgAlu(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            frmMenu.setVisible(true);
        } else if (e.getActionCommand() == "Bajas") {

        } else if (e.getActionCommand() == "Buscar") {
            negocio.buscarTextField();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        cargarDatosDeFichaAlumno();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        //Cuando clicamos en Buscar, se muestran los datos de los alumnos en los Textfields y en la tabla también
        // www.programandoconcafe.com/2010/11/java-llenar-un-jtable-con-resultset.html
       

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

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
