package ABD_Libros;

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
public class claseConexion_Libros {
    
    private static Connection conn;
    private ResultSet rs;
    private Statement stmt;

    public claseConexion_Libros() {
    }
    
    public static void crearConexion() {
        try {
            //le damos la URL de la BD al objeto conexión
            String sUrl = "jdbc:mysql://localhost:3306/Biblioteca";
            conn = DriverManager.getConnection(sUrl, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(FrmLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaConSelect(String consulta) {
        try {
            //Creamos el canal de Conexión
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Modifica los datos que le damos por consulta
            stmt.executeUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(FrmLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaConInsertUpdateODelete(String consulta) {
        try {
            //Creamos el canal de Conexión
            stmt = conn.createStatement();
            //Devuelve los datos buscados con el resulSet
            rs = stmt.executeQuery(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(FrmLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    
}
