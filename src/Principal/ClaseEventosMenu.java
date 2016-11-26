/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import ABD_Alumnos.ClaseEventosAlumnos;
import ABD_Alumnos.DlgAlumnos;
import ABD_Alumnos.FichaAlumno;
import ABD_Alumnos.ConexionAlumno;
import ABD_Alumnos.NegocioAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author 2DAM - Judit
 */
public class ClaseEventosMenu extends javax.swing.JFrame implements ActionListener {

    FrmMenu frm;
    DlgAlumnos dlgAlu;
    private ConexionAlumno conexion;
    private NegocioAlumno negocio;
    private FichaAlumno fichalumno;
    private JasperPrint jsPrint;

    public ClaseEventosMenu(FrmMenu frm) {
        this.frm = frm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Alumnos") {
            ClaseEventosAlumnos cleventos = new ClaseEventosAlumnos(frm);
            
        } else if (e.getActionCommand() == "Libros") {
            //DlgLibros dlgLibros = new DlgLibros(frm, true, null);
            //dlgLibros.setVisible(true);
        } else if (e.getActionCommand() == "Préstamos") {
            //DlgPrestamos dlgpres = new DlgPrestamos(frm, true, null);
            //dlgpres.setVisible(true);
        } else if (e.getActionCommand() == "Informes") {
            //DlgInforme dlgInforme = new DlgInforme(frm, true, null);
            //dlgInforme.setVisible(true);
        }
    }

}
