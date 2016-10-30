package ABD_Alumnos;

import java.sql.SQLException;

/**
 *
 * @author 2DAM - Judit
 */
public class claseNegocio {

    private final claseConexion conexion;

    public claseNegocio(claseConexion conn) {
        conexion = conn;
    }

    public void altas(FichaAlumno fichalumno) {
        //claseConexion.crearConexion();
        conectar();
        //String consulta = "Insert into alumnos(dni, nombre, apellido1, apellido2) values ('" + frmP.getjTFDniAlu().getText() + "', '" + frmP.getjTFNombreAlu().getText() + "', '"
        //        + frmP.getjTFApellido1Alu().getText() + "', '" + frmP.getjTFApellido2Alu().getText() + "')";
        String consulta = "Insert into alumnos(dni, nombre, apellido1, apellido2) values ('" + fichalumno.getDni() + "', '"
                + fichalumno.getNombre() + "', '" + fichalumno.getApellido1() + "', '" + fichalumno.getApellido2() + "')";
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
        claseConexion.crearConexion();
    }
}
