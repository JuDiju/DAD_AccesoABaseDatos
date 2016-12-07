/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumnos;

import static Alumnos.DlgAlumnos.jTablaAlumnos;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 2DAM - Judit
 */
public class VistaTablaAlumnos extends AbstractTableModel {

    private NegocioAlumno negAlumnos;
    private int ultimaFila = -1;
    private FichaAlumno alumno;
    private static final String columnas[] = {"Registro", "Dni", "Nombre", "Apellido1", "Apellido2"};
    
    ResultSet _rs;
    ResultSetMetaData md; //contiene información sobre la estructura de un ResulSet,especialmente sobre sus nom campos
    int _numColumnas;
    int _numFilas;
    
    public VistaTablaAlumnos(ResultSet rs){
      this._rs=rs;
      try{
          md=rs.getMetaData();
          _rs.last();
          _numFilas=_rs.getRow();
          _numColumnas=md.getColumnCount();
          
      }
      catch( SQLException ex){
      }
    }
    
    public VistaTablaAlumnos(NegocioAlumno negAlum) {
        negAlumnos = negAlum;
    }

    @Override
    public int getRowCount() {
         try {
            return negAlumnos.NumeroRegistros();
        } catch (Exception e) {
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      
        if (rowIndex >= 0) {
            try {
                if(rowIndex != ultimaFila){
                    alumno = negAlumnos.getAlumno(rowIndex + 1);
                    ultimaFila=rowIndex;
                    
                }
                switch (columnIndex) {
                    case 0:
                        return alumno.getRegistro();
                    case 1:
                        return alumno.getDni();
                    case 2:
                        return alumno.getNombre();
                    case 3:
                        return alumno.getApellido1();
                    case 4:
                        return alumno.getApellido2();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return "";
    }

    
    private void TablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {                                          
        Mostrar_datos(jTablaAlumnos.getSelectedRow()); //pasa la linea donde el usuario ha hecho click y muestra los datos
    }                                         
    
    private void Mostrar_datos(int fila) {
        FichaAlumno fichaalu = new FichaAlumno();
        /*setText(String.valueOf(jTablaAlumnos.getValueAt(fila, 1)));
        txtRegistro.setText(String.valueOf(jTablaAlumnos.getValueAt(fila, 0)));
        txtNombre.setText(String.valueOf(jTablaAlumnos.getValueAt(fila, 2)));
        txtApellido1.setText(String.valueOf(jTablaAlumnos.getValueAt(fila, 3)));
        txtApellido2.setText(String.valueOf(jTablaAlumnos.getValueAt(fila, 4)));
       
        */
    }
    
    
    /*
public object getValueAt(int rowIndex, int columnIndex)
if(rowIndex >=0){
    prestamo =negprestamo.getPrestamo(index);
    switch(columnIndex) {
case 0:
return prestamo.getId();
    }
}
     */
}
