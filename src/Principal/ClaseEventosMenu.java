/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Alumnos.ClaseEventosAlumnos;
import Libros.ClaseEventosLibros;
import Prestamos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author 2DAM - Judit
 */
public class ClaseEventosMenu extends javax.swing.JFrame implements ActionListener {
    FrmMenu frm;
    //Clase
    

    public ClaseEventosMenu(FrmMenu frm) {
        this.frm = frm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Alumnos".equals(e.getActionCommand())) {
            ClaseEventosAlumnos cleventos = new ClaseEventosAlumnos(frm);
        } else if ("Libros".equals(e.getActionCommand())) {
            ClaseEventosLibros cleventos = new ClaseEventosLibros(frm);
        } else if ("Préstamos".equals(e.getActionCommand())) {
            //
           ClaseEventosPres cleventos = new ClaseEventosPres(frm);
            //DlgPrestamos dlgpres = new DlgPrestamos(frm, true, null);
        } else if ("Informes".equals(e.getActionCommand())) {
            //DlgInforme dlgInforme = new DlgInforme(frm, true, null);
        }
        
    }

}
