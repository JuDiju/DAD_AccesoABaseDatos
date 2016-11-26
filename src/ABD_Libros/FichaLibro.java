package ABD_Libros;

/**
 *
 * @author 2DAM - Judit
 */
public class FichaLibro {
    private int Codigo;
    private String Titulo;
    private String Autor;
    private String Asignatura;
    private String Editorial;
    private String Estado;
    
    public FichaLibro() {
    }
    
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Título) {
        this.Titulo = Título;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String Asignatura) {
        this.Asignatura = Asignatura;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

  
}
