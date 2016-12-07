/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos;

import Principal.ClaseConexion;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author 2DAM - Judit
 */
public class NegocioPrestamos {

    final ClaseConexion conexion;
    ResultSet rs;
    public static final int COLUMN_PRESTAMO_ID = 0;
    public static final int COLUMN_PRESTAMO_CODALUMNO = 1;
    public static final int COLUMN_PRESTAMO_CODLIBROS = 2;
    public static final int COLUMN_PRESTAMO_FECHAPRESTAMO = 3;
    public static final int COLUMN_PRESTAMO_FECHADEVOLUCION = 4;
    public static final int COLUMN_PRESTAMO_ESTADO = 5;
    
    // public static final int COLUMN_PRESTAMO_TITULO = 6;
    //public static final int COLUMN_PRESTAMO_AUTOR = 7;
    
    
    public NegocioPrestamos() {
        conexion = new ClaseConexion();
    }

    public ResultSet getRsDeConexion() {
        return conexion.getRs();
    }

    public void conectar() {
        ClaseConexion.crearConexion();
    }
       
    public void getNegocioAlumno(){
        //abrirá la clase negocioAlumno
        
    }
    
     public OdtPrestamo getPrestamo(int row) throws Exception {
        OdtPrestamo prestamo = null;
        if (rs.absolute(row + 1)) {
            int id = rs.getInt(COLUMN_PRESTAMO_ID + 1);
            int codAlumno = rs.getInt(COLUMN_PRESTAMO_CODALUMNO + 1);
            int codLibro = rs.getInt(COLUMN_PRESTAMO_CODLIBROS + 1);
            Date fecPrestamo = rs.getDate(COLUMN_PRESTAMO_FECHAPRESTAMO + 1);
            Date fecDevolucion = rs.getDate(COLUMN_PRESTAMO_FECHADEVOLUCION + 1);
            String estado = rs.getString(COLUMN_PRESTAMO_ESTADO + 1);
            
            //String titulo = rs.getString(COLUMN_PRESTAMO_TITULO + 1);
            //String autor = rs.getString(COLUMN_PRESTAMO_AUTOR + 1);
           
            prestamo = new OdtPrestamo(id, codAlumno, codLibro, fecPrestamo, fecDevolucion, estado/*, titulo, autor*/);
        }
        return prestamo;
    }
}
