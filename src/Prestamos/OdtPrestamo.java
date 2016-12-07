/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos;

import java.sql.Date;

/**
 *
 * @author 2DAM - Judit
 */
public class OdtPrestamo {
     private int id;
    private int codAlumno;
    private int codLibro;
    private Date fecPrestamo;
    private Date fecDevolucion;
    private String estado;
    //private String titulo;
    //private String autor;

    public OdtPrestamo() {
           id = -1;
        codAlumno = -1;
        codLibro = -1;
        java.util.Date utilDate = new java.util.Date();
        fecPrestamo = new Date(utilDate.getTime());
        fecDevolucion = new Date(0);
        estado = "";
        //titulo = "";
        //autor = "";
    }
    
    public OdtPrestamo(int id, int codAlumno, int codLibro, Date fecPrestamo, Date fecDevolucion, String estado/*, String titulo, String autor*/) {
        this.id = id;
        this.codAlumno = codAlumno;
        this.codLibro = codLibro;
        this.fecPrestamo = fecPrestamo;
        this.fecDevolucion = fecDevolucion;
        this.estado = estado;
        //this.titulo = titulo;
        //this.autor = autor;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int idPrest) {
        id = idPrest;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlu) {
        this.codAlumno = codAlu;
    }

    public int getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(int codLib) {
        this.codLibro = codLib;
    }

    public Date getFecPrestamo() {
        return fecPrestamo;
    }

    public void setFecPrestamo(Date fecPrest) {
        this.fecPrestamo = fecPrest;
    }

    public Date getFecDevolucion() {
        return fecDevolucion;
    }

    public void setFecDevolucion(Date fecDev) {
        this.fecDevolucion = fecDev;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estad) {
        this.estado = estad;
    }

  /*  public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titu) {
        this.titulo = titu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String aut) {
        this.autor = aut;
    }*/
}
