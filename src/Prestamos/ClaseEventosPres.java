/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos;

import Alumnos.ClaseEventosAlumnos;
import Alumnos.FichaAlumno;
import Principal.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author 2DAM - Judit
 */
public class ClaseEventosPres extends javax.swing.JDialog implements ActionListener, MouseListener {
    DlgPrestamos dlgPrestamos;
    ClaseEventosAlumnos clEventosAlu;
    FichaAlumno fichAlu;
    FrmMenu frm;
   
    public ClaseEventosPres(FrmMenu frmmenu){
        //clEventosAlu = new ClaseEventosAlumnos(frmmenu);
        dlgPrestamos = new DlgPrestamos(frmmenu, true, this);
        dlgPrestamos.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //buscar te abre el dlgAlumnos
        if ("Buscar".equals(e.getActionCommand())) {
            ClaseEventosAlumnos cleventos = new ClaseEventosAlumnos(frm);
            
            dlgPrestamos.getTxtRegistro().setText(fichAlu.getRegistro() + "");
            dlgPrestamos.getTxtDniAlu().setText(fichAlu.getDni());
            dlgPrestamos.getTxtNombreAlu().setText(fichAlu.getNombre());
            dlgPrestamos.getTxtApellido1Alu().setText(fichAlu.getApellido1());
            dlgPrestamos.getTxtApellido2Alu().setText(fichAlu.getApellido2());
            
            
            /*alumno=ctrlalumno.getAlumno();
            dlgmovimiento.getTxtDni().setText(alumno.getDni());
            dlgmovimiento.getTxtRegistro().setText(alumno.getRegistro()+"");
            try {
                negprestamo.setCodAlumno(alumno.getRegistro());
            } catch (Exception ex) {
                Logger.getLogger(CtrlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
            }
                //_negprestamos.Actualizar();
                rsmodel.fireTableDataChanged();
                    
        }
            
            */
        } else if ("Siguiente".equals(e.getActionCommand())) {

        } else if ("Bajas".equals(e.getActionCommand())) {

        } else if ("Agregar".equals(e.getActionCommand())) {

        } else if ("Quitar".equals(e.getActionCommand())) {

        } else if ("Editar".equals(e.getActionCommand())) {

        } else if ("Cerrar Ventana".equals(e.getActionCommand())) {
            dlgPrestamos.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
