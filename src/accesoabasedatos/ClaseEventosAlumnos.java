/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoabasedatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author 2DAM - Judit
 */
public class ClaseEventosAlumnos extends javax.swing.JFrame implements ActionListener {

    FrmPrincipal frm;
    private claseConexion conexion;
    private claseNegocio negocio;
    private FichaAlumno fichalumno;

    public ClaseEventosAlumnos() {
        frm = new FrmPrincipal(this);
        //FrmPrincipal frm=new FrmPrincipal();
        frm.setVisible(true);

        //conexion = claseConexion.getInstance();
        conexion = new claseConexion();
        negocio = new claseNegocio(conexion);
        fichalumno = new FichaAlumno();
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
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Siguiente") {
            try {
                //si hay siguiente registro, lo muestra
                if (conexion.getRs().next()) {
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Anterior") {
            try {
                //Si hay un registro anterior, lo muestra
                if (conexion.getRs().previous()) {
                    //negocio.cargarDatosAlumno();
                    cargarDatosDeFichaAlumno();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand() == "Altas") {
            fichalumno.setDni(frm.getjTFDniAlu().getText());
            fichalumno.setNombre(frm.getjTFNombreAlu().getText());
            fichalumno.setApellido1(frm.getjTFApellido1Alu().getText());
            fichalumno.setApellido2(frm.getjTFApellido2Alu().getText());
            negocio.altas(fichalumno);
        } else if (e.getActionCommand() == "Generar informe de alumnos") {

            try {
                Map params = new HashMap();
                params.put("TITULO", "PAISES");
                params.put("FECHA", new java.util.Date());
                JasperReport report = JasperCompileManager.compileReport("report1.jrxml");
                JasperPrint rellenar = JasperFillManager.fillReport(report, params, conexion);
                // Exporta el informe a PDF
                JasperExportManager.exportReportToPdfFile(rellenar, "C:\\Users\\2DAM - Judit\\Documents\\NetBeansProjects\\AccesoABaseDatos\\src\\accesoabasedatos\\reportAlumnos.pdf");
                //Para visualizar el pdf directamente desde java
                JasperViewer.viewReport(rellenar, false);
                //TERMINAR
                /*
                negocio.buscar();
                JasperReport reporte = (JasperReport) JRLoader.loadObject("report1.jasper");
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte1.pdf"));
                exporter.exportReport();
                 */
            } catch (JRException ex) {
                Logger.getLogger(ClaseEventosAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void cargarDatosDeFichaAlumno() {
        fichalumno = negocio.cargarDatosAlumno();
        frm.getjTFDniAlu().setText(fichalumno.getDni());
        frm.getjTFNombreAlu().setText(fichalumno.getNombre());
        frm.getjTFApellido1Alu().setText(fichalumno.getApellido1());
        frm.getjTFApellido2Alu().setText(fichalumno.getApellido2());
    }
}
