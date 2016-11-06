/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABD_Alumnos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author 2DAM - Judit
 */
public class ClaseEventosAlumnos extends javax.swing.JFrame implements ActionListener, MouseListener {

    FrmAlumnos frm;
    private claseConexion conexion;
    private claseNegocio negocio;
    private FichaAlumno fichalumno;
    private JasperPrint jsPrint;

    public ClaseEventosAlumnos() {
        frm = new FrmAlumnos(this);
        //FrmPrincipal frm=new FrmPrincipal();
        frm.setVisible(true);

        //conexion = claseConexion.getInstance();
        conexion = new claseConexion();
        negocio = new claseNegocio(conexion);
        fichalumno = new FichaAlumno();
        jsPrint = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Buscar") {
            try {
                negocio.buscar();
                //si la tabla de registros no está vacía
                if (conexion.getRs().next()) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Siguiente") {
            try {
                //si hay siguiente registro, lo muestra
                if (conexion.getRs().next()) {
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Anterior") {
            try {
                //Si hay un registro anterior, lo muestra
                if (conexion.getRs().previous()) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Altas") {
            fichalumno.setDni(frm.getjTFDniAlu().getText());
            fichalumno.setNombre(frm.getjTFNombreAlu().getText());
            fichalumno.setApellido1(frm.getjTFApellido1Alu().getText());
            fichalumno.setApellido2(frm.getjTFApellido2Alu().getText());
            negocio.altas(fichalumno);
        } else if (e.getActionCommand() == "Generar informe de alumnos") {
            //TERMINAR MÁS ADELANTE. 
        }
    }

    public void cargarDatosDeFichaAlumno() {
        fichalumno = negocio.cargarDatosAlumno();
        frm.getjTFDniAlu().setText(fichalumno.getDni());
        frm.getjTFNombreAlu().setText(fichalumno.getNombre());
        frm.getjTFApellido1Alu().setText(fichalumno.getApellido1());
        frm.getjTFApellido2Alu().setText(fichalumno.getApellido2());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
            //Cuando clicamos en Buscar, se muestran los datos de los alumnos en los Textfields y en la tabla también
            // www.programandoconcafe.com/2010/11/java-llenar-un-jtable-con-resultset.html
            
            negocio.cargarDatosAlumno();         
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
