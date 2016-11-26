/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABD_Libros;


import static ABD_Libros.DlgLibros.jTablaLibros;
import Principal.FrmMenu;
import Principal.VistaTabla;
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
public class ClaseEventosLibros extends javax.swing.JDialog implements ActionListener, MouseListener {
    
    //FrmLibros frm;
    DlgLibros dlgLibro;
    ResultSet rs;
    private NegocioLibros negocioLibros;
    private FichaLibro fichaLibro;
    private JasperPrint jsPrint;
    
    public ClaseEventosLibros(FrmMenu frmmenu) {
        negocioLibros = new NegocioLibros();
        fichaLibro = new FichaLibro();
        dlgLibro = new DlgLibros(frmmenu, true, this);
        dlgLibro.setVisible(true);
        jsPrint = null;
    }
    
    public void cargarDatosDeFichaLibro()  {
        fichaLibro = negocioLibros.cargarDatosLibro();
        dlgLibro.getTxtCodigo().setText(String.valueOf(fichaLibro.getCodigo()));
        dlgLibro.getTxtTitulo().setText(fichaLibro.getTitulo());
        dlgLibro.getTxtAutor().setText(fichaLibro.getAutor());
        dlgLibro.getTxtEditorial().setText(fichaLibro.getEditorial());
        dlgLibro.getTxtAsignatura().setText(fichaLibro.getAsignatura());
        dlgLibro.getTxtEstado().setText(fichaLibro.getEstado());
    }
    
     public void iniciarTabla(ResultSet rs) {
        VistaTabla v = new VistaTabla(rs);
        jTablaLibros.setModel(v);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Iniciar".equals(e.getActionCommand())) {
            try {
                // rs = conexion.getRs();
                negocioLibros.iniciar();
                iniciarTabla(negocioLibros.getRsDeConexion());
                //si la tabla de registros no está vacía
                if (negocioLibros.getRsDeConexion().next() == true) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaLibro();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Iniciar'");
            }
        } else if ("Siguiente".equals(e.getActionCommand())) {
            try {
                //si hay siguiente registro, lo muestra
                if (negocioLibros.siguiente()) {
                    cargarDatosDeFichaLibro();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Siguiente'");
            }
        } else if ("Anterior".equals(e.getActionCommand())) {
            try {
                //Si hay un registro anterior, lo muestra
                if (negocioLibros.anterior()) {
                    cargarDatosDeFichaLibro();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el botón 'Anterior'");
            }
        } else if ("Altas".equals(e.getActionCommand())) {
            fichaLibro.setCodigo(Integer.parseInt(dlgLibro.getTxtCodigo().getText()));
            fichaLibro.setTitulo(dlgLibro.getTxtTitulo().getText());
            fichaLibro.setAutor(dlgLibro.getTxtAutor().getText());
            fichaLibro.setAsignatura(dlgLibro.getTxtAsignatura().getText());
            fichaLibro.setEditorial(dlgLibro.getTxtEditorial().getText());
            fichaLibro.setEstado(dlgLibro.getTxtEstado().getText());

            negocioLibros.altas(fichaLibro);
        } else if ("Generar informe de libros".equals(e.getActionCommand())) {
            //TERMINAR MÁS ADELANTE. 
        } else if ("Volver al menú".equals(e.getActionCommand())) {
            dlgLibro.dispose();
        } else if ("Bajas".equals(e.getActionCommand())) {
            negocioLibros.bajas(fichaLibro);
        } else if ("Buscar".equals(e.getActionCommand())) {
            negocioLibros.buscarEnTextField(dlgLibro.getTextoABuscar().getText());
            mostrar(dlgLibro.getTextoABuscar().getText());
        }
    }
    
    //error
    public void mostrar(String buscarEnTextfield) {
        try {
            VistaTabla modelo;
            NegocioLibros func = new NegocioLibros();
            func.buscarEnTextField(buscarEnTextfield);
            modelo = new VistaTabla(negocioLibros.getRsDeConexion());
            jTablaLibros.setModel(modelo);
            /*
            VistaTabla v = new VistaTabla(rs);
            jTablaAlumnos.setModel(v);      
             */
        } catch (Exception e) {
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
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
    
}
