/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABD_Libros;


import static ABD_Libros.DlgLibros.jTablaLibros;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 2DAM - Judit
 */
public class VistaTablaLibros extends AbstractTableModel {

    private NegocioLibros negLibros;
    private int ultimaFila = -1;
    private FichaLibro libro;
    private static final String columnas[] = {"Codigo", "Titulo", "Autor", "Editorial", "Asignatura", "Estado"};
    
    ResultSet _rs;
    ResultSetMetaData md; //contiene información sobre la estructura de un ResulSet,especialmente sobre sus nom campos
    int _numColumnas;
    int _numFilas;
    
    public VistaTablaLibros(ResultSet rs){
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
    
    public VistaTablaLibros(NegocioLibros negLib) {
        negLibros = negLib;
    }

    @Override
    public int getRowCount() {
         try {
            return negLibros.NumeroRegistros();
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
                    libro = negLibros.getLibro(rowIndex + 1);
                    ultimaFila=rowIndex;
                    
                }
                switch (columnIndex) {
                    case 0:
                        return libro.getCodigo();
                    case 1:
                        return libro.getTitulo();
                    case 2:
                        return libro.getAutor();
                    case 3:
                        return libro.getEditorial();
                    case 4:
                        return libro.getAsignatura();
                    case 5:
                        return libro.getEstado();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return "";
    }

    
    private void TablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {                                          
        Mostrar_datos(jTablaLibros.getSelectedRow()); //pasa la linea donde el usuario ha hecho click y muestra los datos
    }                                         
    
    private void Mostrar_datos(int fila) {
        FichaLibro fichaalu = new FichaLibro();
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
