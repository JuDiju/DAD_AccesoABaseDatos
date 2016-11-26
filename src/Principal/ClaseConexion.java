/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import ABD_Alumnos.DlgAlumnos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2DAM - Judit
 */
public class ClaseConexion {

    private static Connection conn;
    private ResultSet rs;
    private Statement stmt;

    public ClaseConexion() {
    }

    public static void crearConexion() {
        try {
            //le damos la URL de la BD al objeto conexión
            //conn=new Connection() ;
            String sUrl = "jdbc:mysql://localhost:3306/Biblioteca";
            conn = DriverManager.getConnection(sUrl, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DlgAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaConInsertUpdateODelete(String consulta) {
        try {
            //Creamos el canal de Conexión
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Modifica los datos que le damos por consulta
            int i = stmt.executeUpdate(consulta);
        } catch (SQLException ex) {

            Logger.getLogger(DlgAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaConSelect(String consulta) {
        try {
            //Creamos el canal de Conexión
            stmt = conn.createStatement();
            //Devuelve los datos buscados con el resulSet
            rs = stmt.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(DlgAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}
