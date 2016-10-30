/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABD_Libros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author 2DAM - Judit
 */
public class ClaseEventosLibros extends javax.swing.JFrame implements ActionListener {
    FrmLibros frm;
    private claseConexion_Libros conexionLibro;
    private claseNegocio_Libros negocioLibros;
    private FichaLibros fichaLibro;
    
    public ClaseEventosLibros() {
        frm = new FrmLibros(this);
        frm.setVisible(true);

        conexionLibro = new claseConexion_Libros();
        negocioLibros = new claseNegocio_Libros(conexionLibro);
        fichaLibro = new FichaLibros();
    }
    
    public void cargarDatosDeFichaLibro()  {
        fichaLibro = negocioLibros.cargarDatosLibro();
          
        frm.getTxtCodigo().setText(fichaLibro.getCodigo());
        frm.getTxtTitulo().setText(fichaLibro.getTitulo());
        frm.getTxtAutor().setText(fichaLibro.getAutor());
        frm.getTxtEditorial().setText(fichaLibro.getEditorial());
        frm.getTxtAsignatura().setText(fichaLibro.getAsignatura());
        frm.getTxtEstado().setText(fichaLibro.getEstado());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Buscar") {
            try {
                  
                negocioLibros.buscar();
                
                
             
                //si la tabla de registros no está vacía
                if (conexionLibro.getRs().next()) {
                    cargarDatosDeFichaLibro();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Siguiente") {
            try {
                //si hay siguiente registro, lo muestra
                if (conexionLibro.getRs().next()) {
                    cargarDatosDeFichaLibro();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Anterior") {
            try {
                //Si hay un registro anterior, lo muestra
                if (conexionLibro.getRs().previous()) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaLibro();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Altas") {
            fichaLibro.setCodigo(frm.getTxtCodigo().getText());
            fichaLibro.setTitulo(frm.getTxtTitulo().getText());
            fichaLibro.setAutor(frm.getTxtAutor().getText());
            fichaLibro.setAsignatura(frm.getTxtAsignatura().getText());
            fichaLibro.setEditorial(frm.getTxtEditorial().getText());
            fichaLibro.setEstado(frm.getTxtEstado().getText());
            
            negocioLibros.altas(fichaLibro);
        } 
    }
    
}
