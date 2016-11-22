package ABD_Alumnos;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2DAM - Judit
 */
public class NegocioAlumno {

    final ConexionAlumno conexion;
    public static final int COLUMN_ALUMNO_REGISTRO = 0;
    public static final int COLUMN_ALUMNO_DNI = 1;
    public static final int COLUMN_ALUMNO_NOMBRE = 2;
    public static final int COLUMN_ALUMNO_APELLIDO1 = 3;
    public static final int COLUMN_ALUMNO_APELLIDO2 = 4;

    public NegocioAlumno(ConexionAlumno conn) {
        conexion = conn;
    }
    
    public void altas(FichaAlumno fichalumno) {
        //claseConexion.crearConexion();
        conectar();
        //String consulta = "Insert into alumnos(dni, nombre, apellido1, apellido2) values ('" + frmP.getjTFDniAlu().getText() + "', '" + frmP.getjTFNombreAlu().getText() + "', '"
        //        + frmP.getjTFApellido1Alu().getText() + "', '" + frmP.getjTFApellido2Alu().getText() + "')";
        String consulta = "Insert into alumnos(registro, dni, nombre, apellido1, apellido2) values ('" + fichalumno.getRegistro() + "', '"
                + fichalumno.getDni() + "', '" + fichalumno.getNombre() + "', '" + fichalumno.getApellido1() + "', '" + fichalumno.getApellido2() + "')";
        conexion.consultaConSelect(consulta);
    }

    public void buscar() {
        //claseConexion.crearConexion();
        conectar();
        String consulta = "Select * from alumnos";
        conexion.consultaConInsertUpdateODelete(consulta);
    }

    public FichaAlumno cargarDatosAlumno() {
        FichaAlumno fichaalu = new FichaAlumno();
        try {
            fichaalu.setRegistro(conexion.getRs().getInt("registro"));
            fichaalu.setDni(conexion.getRs().getString("dni"));
            fichaalu.setNombre(conexion.getRs().getString("nombre"));
            fichaalu.setApellido1(conexion.getRs().getString("apellido1"));
            fichaalu.setApellido2(conexion.getRs().getString("apellido2"));
            //frmP.getjTFDniAlu().setText(conexion.getRs().getString("dni"));
            //frmP.getjTFNombreAlu().setText(conexion.getRs().getString("nombre"));
            //frmP.getjTFApellido1Alu().setText(conexion.getRs().getString("apellido1"));
            //frmP.getjTFApellido2Alu().setText(conexion.getRs().getString("apellido2"));
        } catch (SQLException ex) {

        }
        return fichaalu;
    }

    public void conectar() {
        ConexionAlumno.crearConexion();
    }

    public void darDeBaja() {
        conectar();
        FichaAlumno alumno = null;
        String consulta = "DELETE FROM alumnos WHERE Registro = " + alumno.getRegistro();
        conexion.consultaConInsertUpdateODelete(consulta);
    }

    public int NumeroRegistros() throws Exception {
        int fila = -1;
        if (conexion.getRs().last()) {
            fila = conexion.getRs().getRow();
        }
        return fila;
    }

    //los metadatos empiezan en base 1, por eso +1
    public FichaAlumno getAlumno(int row) throws Exception {
        FichaAlumno alumno = null;
        if (conexion.getRs().absolute(row)) {

            alumno = new FichaAlumno();

            int registro = conexion.getRs().getInt(COLUMN_ALUMNO_REGISTRO + 1);
            String dni = conexion.getRs().getString(COLUMN_ALUMNO_DNI + 1);
            String nombre = conexion.getRs().getString(COLUMN_ALUMNO_NOMBRE + 1);
            String apellido1 = conexion.getRs().getString(COLUMN_ALUMNO_APELLIDO1 + 1);
            String apellido2 = conexion.getRs().getString(COLUMN_ALUMNO_APELLIDO2 + 1);

            alumno.setRegistro(registro);
            alumno.setDni(dni);
            alumno.setNombre(nombre);
            alumno.setApellido1(apellido1);
            alumno.setApellido2(apellido2);

        }
        return alumno;
    }

    public DefaultTableModel buscarTextField(String buscar) {

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
    }

    /*conectar();
        FichaAlumno alumno = null;
         //Obtenemos el valor del JTextField para el filtro
        String filtro = DlgAlumnos.getTextoABuscar().getText();
    
        String consulta = "DELETE FROM alumnos WHERE Registro = " + alumno.getRegistro();
    
            String consulta = "Select * from tabla where Nombre like '%" + getTextoABuscar().getText()+ "%'";
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                //son 3 columnas, la dimension del objeto datos de 3
                Object[] datos = new Object[3];
                for (int row = 0; row < 3; row++) {
                    datos[row] = resultado.getObject(row+1);

                }
                modelo.addRow(datos);
            }

            jTable1.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
}
