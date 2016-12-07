package Libros;


import Principal.ClaseConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2DAM - Judit
 */
public class NegocioLibros {
    
    final ClaseConexion conexion;
    ResultSet rs;
    public static final int COLUMN_LIBROS_CODIGO = 0;
    public static final int COLUMN_LIBROS_TITULO = 1;
    public static final int COLUMN_LIBROS_AUTOR = 2;
    public static final int COLUMN_LIBROS_EDITORIAL = 3;
    public static final int COLUMN_LIBROS_ASIGNATURA = 4;
    public static final int COLUMN_LIBROS_ESTADO = 5;
    
    public NegocioLibros() {
        conexion = new ClaseConexion();
    }

    public ResultSet getRsDeConexion() {
        return conexion.getRs();
    }
   
     public void conectar() {
        ClaseConexion.crearConexion();
    }
    
     public void iniciar() {
        conectar();
        String consulta = "SELECT * FROM libros";
        //conexion.consultaConSelect(consulta);
        rsDeConsultaSelect(consulta);
    }
    
    public boolean siguiente() throws SQLException{
        return rs.next();
    }
    
    public boolean anterior() throws SQLException{
      return rs.previous();
    }
    
    public void rsDeConsultaSelect(String consulta) {
        conexion.consultaConSelect(consulta);
        rs = conexion.getRs();
    }
    
    public void buscarEnTextField(String fichaLibro) {
        String consulta = "SELECT * FROM libros WHERE codigo like '%" + fichaLibro + "%' "
                + " OR titulo like '%" + fichaLibro + "%' OR autor like '%" + fichaLibro 
                + "%' OR editorial like '%" + fichaLibro + "%' OR asignatura like '%" 
                + fichaLibro + "%' OR estado like '%" + fichaLibro +"%' ORDER BY codigo";
        //conexion.consultaConSelect(consulta);
        rsDeConsultaSelect(consulta);
    }
    
    public void altas(FichaLibro fichLibro) {
        try {
        conectar();
        //Insert into libros(codigo, titulo, autor, editorial, asignatura, estado) values ('41', 'EjemploTitulo', 'Pepe', 'editorialEje', 'ejemploClase', 'Nuevo');
        String consulta = "Insert into libros(codigo, titulo, autor, editorial, asignatura, estado) values ('" + fichLibro.getCodigo() + "', '"
                + fichLibro.getTitulo() + "', '" + fichLibro.getAutor() + "', '" + fichLibro.getEditorial() + "', '" 
                + fichLibro.getAsignatura() + "', '" + fichLibro.getEstado() + "')";
        conexion.consultaConInsertUpdateODelete(consulta);
        } catch (Exception ex) {
            Logger.getLogger(NegocioLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void bajas(FichaLibro fichalibro) {
        conectar();
        String consulta = "delete from libros where codigo = " + fichalibro.getCodigo();
        conexion.consultaConInsertUpdateODelete(consulta);
                
        //if(conexion.consultaConInsertUpdateODelete(consulta) == 0){ //arreglar condicion. Que compruebe que se ha quitado un registro de la tabla
            //JOptionPane.showMessageDialog(null, "Registro eliminado");
        //}
    }
     
    public FichaLibro cargarDatosLibro() {
        FichaLibro fichalib = new FichaLibro();
        try { 
            fichalib.setCodigo(rs.getInt("codigo"));
            fichalib.setTitulo(rs.getString("Titulo"));
            fichalib.setAutor(rs.getString("Autor"));
            fichalib.setAsignatura(rs.getString("Asignatura"));
            fichalib.setEditorial(rs.getString("Editorial"));
            fichalib.setEstado(rs.getString("estado"));
        } catch (SQLException ex) {

        }
        return fichalib;
    }
    
    public int NumeroRegistros() throws Exception {
        int fila = -1;
        if (rs.last()) {
            fila = rs.getRow();
        }
        return fila;
    }

    //los metadatos empiezan en base 1, por eso +1
    public FichaLibro getLibro(int row) throws Exception {
        FichaLibro libro = null;
        if (rs.absolute(row)) {
            libro = new FichaLibro();

            int codigo = rs.getInt(COLUMN_LIBROS_CODIGO + 1);
            String titulo = rs.getString(COLUMN_LIBROS_TITULO + 1);
            String autor = rs.getString(COLUMN_LIBROS_AUTOR + 1);
            String editorial = rs.getString(COLUMN_LIBROS_EDITORIAL + 1);
            String asignatura = rs.getString(COLUMN_LIBROS_ASIGNATURA + 1);
            String estado = rs.getString(COLUMN_LIBROS_ESTADO + 1);
            
            libro.setCodigo(codigo);
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setAsignatura(asignatura);
            libro.setEstado(estado);
        }
        return libro;
    }

    
}

