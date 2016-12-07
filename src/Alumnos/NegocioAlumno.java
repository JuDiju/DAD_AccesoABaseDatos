package Alumnos;

import Principal.ClaseConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2DAM - Judit
 */
public class NegocioAlumno {

    final ClaseConexion conexion;
    ResultSet rs;
    public static final int COLUMN_ALUMNO_REGISTRO = 0;
    public static final int COLUMN_ALUMNO_DNI = 1;
    public static final int COLUMN_ALUMNO_NOMBRE = 2;
    public static final int COLUMN_ALUMNO_APELLIDO1 = 3;
    public static final int COLUMN_ALUMNO_APELLIDO2 = 4;

    public NegocioAlumno() {
        conexion = new ClaseConexion();
    }
    
    public ResultSet getRsDeConexion(){
        return conexion.getRs();
    }
    
    public void conectar() {
        ClaseConexion.crearConexion();
    }
    
    public void iniciar() {
        conectar();
        String consulta = "SELECT * FROM alumnos";
        //conexion.consultaConSelect(consulta);
        rsDeConsultaSelect(consulta);
    }
    
    public boolean siguiente() throws SQLException{
        return rs.next(); 
    }
    
    public boolean anterior() throws SQLException{
      return rs.previous();
    }
    
    public void rsDeConsultaSelect(String consulta){
        conexion.consultaConSelect(consulta);
        rs = conexion.getRs();
    }
    
    public void buscarEnTextField(String fichaAlumno) {
        //conectar();
        String consulta = "SELECT * FROM alumnos WHERE dni like '%" + fichaAlumno + "%' "
                + " OR nombre like '%" + fichaAlumno + "%' OR apellido1 like '%"
                + fichaAlumno + "%' OR apellido2 like '%" + fichaAlumno + "%' ORDER BY nombre";
        //conexion.consultaConSelect(consulta);
        rsDeConsultaSelect(consulta);
    }

    public void altas(FichaAlumno fichalumno) {
        try {
            //claseConexion.crearConexion();
            conectar();
            //String consulta = "Insert into alumnos(dni, nombre, apellido1, apellido2) values ('" + frmP.getjTFDniAlu().getText() + "', '" + frmP.getjTFNombreAlu().getText() + "', '"
            //        + frmP.getjTFApellido1Alu().getText() + "', '" + frmP.getjTFApellido2Alu().getText() + "')";
            String consulta = "Insert into alumnos(registro, dni, nombre, apellido1, apellido2) values ('" + fichalumno.getRegistro() + "', '"
                    + fichalumno.getDni() + "', '" + fichalumno.getNombre() + "', '" + fichalumno.getApellido1() + "', '" + fichalumno.getApellido2() + "')";
            conexion.consultaConInsertUpdateODelete(consulta);
            
            //if(conexion.consultaConInsertUpdateODelete() == 1){ //arreglar condicion. Que compruebe que se ha añadido un registro de la tabla
                //JOptionPane.showMessageDialog(null, "Registro añadido");
            //}
        } catch (Exception ex) {
            Logger.getLogger(NegocioAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bajas(FichaAlumno fichalumno) {
        conectar();
        String consulta = "delete from alumnos where registro = " + fichalumno.getRegistro();
        conexion.consultaConInsertUpdateODelete(consulta);
        
        //if(conexion.consultaConInsertUpdateODelete(consulta) == 0){ //arreglar condicion. Que compruebe que se ha quitado un registro de la tabla
            //JOptionPane.showMessageDialog(null, "Registro eliminado");
        //}
    }
    
    public FichaAlumno cargarDatosAlumno() {
        FichaAlumno fichaalu = new FichaAlumno();
        try {
           
            fichaalu.setRegistro(rs.getInt("registro"));
            fichaalu.setDni(rs.getString("dni"));
            fichaalu.setNombre(rs.getString("nombre"));
            fichaalu.setApellido1(rs.getString("apellido1"));
            fichaalu.setApellido2(rs.getString("apellido2"));

            //frmP.getjTFDniAlu().setText(conexion.getRs().getString("dni"));
            //frmP.getjTFNombreAlu().setText(conexion.getRs().getString("nombre"));
            //frmP.getjTFApellido1Alu().setText(conexion.getRs().getString("apellido1"));
            //frmP.getjTFApellido2Alu().setText(conexion.getRs().getString("apellido2"));
        } catch (SQLException ex) {

        }
        return fichaalu;
    }
   

    public int NumeroRegistros() throws Exception {
        int fila = -1;
        if (rs.last()) {
            fila = rs.getRow();
        }
        return fila;
    }

    //los metadatos empiezan en base 1, por eso +1
    public FichaAlumno getAlumno(int row) throws Exception {
        FichaAlumno alumno = null;
        if (rs.absolute(row)) {
            alumno = new FichaAlumno();

            int registro = rs.getInt(COLUMN_ALUMNO_REGISTRO + 1);
            String dni = rs.getString(COLUMN_ALUMNO_DNI + 1);
            String nombre = rs.getString(COLUMN_ALUMNO_NOMBRE + 1);
            String apellido1 = rs.getString(COLUMN_ALUMNO_APELLIDO1 + 1);
            String apellido2 = rs.getString(COLUMN_ALUMNO_APELLIDO2 + 1);

            alumno.setRegistro(registro);
            alumno.setDni(dni);
            alumno.setNombre(nombre);
            alumno.setApellido1(apellido1);
            alumno.setApellido2(apellido2);

        }
        return alumno;
    }

    /*public DefaultTableModel buscarTextField(String buscar) {

        DefaultTableModel modeloTabla;
        
        String[] columnas = {"registro", "dni", "nombre", "apellido1", "apellido2"};
        String[] registro = new String[5];

        modeloTabla = new DefaultTableModel(null, columnas);
        
        String SSQL;
        SSQL = "select * from alumnos where dni like '%" + buscar + "%' "
                + " or nombre like '%" + buscar +  "%' or apellido1 like '%" 
                + buscar + "%' or apellido2 like '%" + "%' order by nombre" ;
        try {
            conectar();

            while (conexion.getRs().next()) {
                registro[0] = conexion.getRs().getString("registro");
                registro[1] = conexion.getRs().getString("dni");
                registro[2] = conexion.getRs().getString("nombre");
                registro[3] = conexion.getRs().getString("apellido1");
                registro[4] = conexion.getRs().getString("apellido2");

                modeloTabla.addRow(registro);
            }

        } catch (SQLException e) {

        }
        return modeloTabla;
    }*/
 /* public void darDeBaja() {
        conectar();
        FichaAlumno alumno = null;
        String consulta = "DELETE FROM alumnos WHERE Registro = " + alumno.getRegistro();
        conexion.consultaConInsertUpdateODelete(consulta);
    }*/
}
