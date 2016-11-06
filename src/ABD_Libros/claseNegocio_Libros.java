package ABD_Libros;

import java.sql.SQLException;

/**
 *
 * @author 2DAM - Judit
 */
public class claseNegocio_Libros {
    
    private final claseConexion_Libros conexionLibros;

    public claseNegocio_Libros(claseConexion_Libros conn) {
        conexionLibros = conn;
    }

    public void conectar() {
        claseConexion_Libros.crearConexion();
    }
    
    public FichaLibros cargarDatosLibro() {
        FichaLibros fichalib = new FichaLibros();
        try {
            fichalib.setCodigo(conexionLibros.getRs().getString("Codigo"));
            fichalib.setTitulo(conexionLibros.getRs().getString("Titulo"));
            fichalib.setAutor(conexionLibros.getRs().getString("Autor"));
            fichalib.setAsignatura(conexionLibros.getRs().getString("Asignatura"));
            fichalib.setEditorial(conexionLibros.getRs().getString("Editorial"));
            fichalib.setEstado(conexionLibros.getRs().getString("Estado"));
        } catch (SQLException ex) {

        }
        return fichalib;
    }
    
     public void buscar() {
        conectar(); 
        String consulta = "Select * from libros";
        conexionLibros.consultaConInsertUpdateODelete(consulta);
    }
    
     public void altas(FichaLibros fichLibro) {
        conectar();
        //Insert into libros(codigo, titulo, autor, editorial, asignatura, estado) values ('41', 'EjemploTitulo', 'Pepe', 'editorialEje', 'ejemploClase', 'Nuevo');
        String consulta = "Insert into libros(codigo, titulo, autor, editorial, asignatura, estado) values ('" + fichLibro.getCodigo() + "', '"
                + fichLibro.getTitulo() + "', '" + fichLibro.getAutor() + "', '" + fichLibro.getEditorial() + "', '" 
                + fichLibro.getAsignatura() + "', '" + fichLibro.getEstado() + "')";
        conexionLibros.consultaConSelect(consulta);
    }
}

