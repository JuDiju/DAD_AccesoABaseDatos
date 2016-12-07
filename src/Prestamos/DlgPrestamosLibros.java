/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author 2DAM - Judit
 */
public class DlgPrestamosLibros extends javax.swing.JDialog {

    public DlgPrestamosLibros(java.awt.Frame parent, boolean modal, ClaseEventosPrestamosLibros cleventos) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        BtnAceptar.addActionListener(cleventos);
        BtnBuscarAlu.addActionListener(cleventos);
        BtnCerrarLibros.addActionListener(cleventos);
     
    }

    DlgPrestamosLibros(DlgPrestamos dlgPrestamos, boolean b, ClaseEventosPrestamosLibros aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPnDatos = new javax.swing.JPanel();
        TxtEditorial = new javax.swing.JTextField();
        jLbEditorial = new javax.swing.JLabel();
        jLbTitulo = new javax.swing.JLabel();
        TxtTitulo = new javax.swing.JTextField();
        jLbAsignatura = new javax.swing.JLabel();
        TxtAsignatura = new javax.swing.JTextField();
        jLbAutor = new javax.swing.JLabel();
        TxtAutor = new javax.swing.JTextField();
        jLbCodigo = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLbEstado = new javax.swing.JLabel();
        TxtEstado = new javax.swing.JTextField();
        jPnFechasPrestamo = new javax.swing.JPanel();
        jLbFechaPrestamo = new javax.swing.JLabel();
        jLbFechaDevolucion = new javax.swing.JLabel();
        jLbEstadoPrestamo = new javax.swing.JLabel();
        TxtFechaPrestamo = new javax.swing.JTextField();
        TxtFechaDevolucion = new javax.swing.JTextField();
        TxtEstadoLibro = new javax.swing.JTextField();
        jPnBotones1 = new javax.swing.JPanel();
        BtnAceptar = new javax.swing.JButton();
        BtnBuscarAlu = new javax.swing.JButton();
        BtnCerrarLibros = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPnDatos.setBackground(new java.awt.Color(0, 0, 255));
        jPnDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del alumno:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLbEditorial.setForeground(new java.awt.Color(255, 255, 255));
        jLbEditorial.setText("Editorial:");

        jLbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLbTitulo.setText("Título:");

        jLbAsignatura.setForeground(new java.awt.Color(255, 255, 255));
        jLbAsignatura.setText("Asignatura:");

        jLbAutor.setForeground(new java.awt.Color(255, 255, 255));
        jLbAutor.setText("Autor:");

        jLbCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLbCodigo.setText("Código:");

        jLbEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLbEstado.setText("Estado:");

        javax.swing.GroupLayout jPnDatosLayout = new javax.swing.GroupLayout(jPnDatos);
        jPnDatos.setLayout(jPnDatosLayout);
        jPnDatosLayout.setHorizontalGroup(
            jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnDatosLayout.createSequentialGroup()
                        .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbTitulo)
                            .addComponent(jLbAsignatura)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnDatosLayout.createSequentialGroup()
                        .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtTitulo)
                            .addGroup(jPnDatosLayout.createSequentialGroup()
                                .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLbAutor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPnDatosLayout.createSequentialGroup()
                                        .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLbEditorial)
                                            .addComponent(TxtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(119, 119, 119)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLbCodigo)
                                    .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TxtAutor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtAsignatura, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(84, 84, 84))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnDatosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLbEstado)
                .addGap(33, 33, 33)
                .addComponent(TxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnDatosLayout.setVerticalGroup(
            jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbEditorial)
                    .addComponent(jLbCodigo))
                .addGap(7, 7, 7)
                .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCodigo)
                    .addComponent(TxtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLbAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLbAsignatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbEstado))
                .addGap(11, 11, 11)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        jPnFechasPrestamo.setBackground(new java.awt.Color(0, 0, 255));
        jPnFechasPrestamo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLbFechaPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        jLbFechaPrestamo.setText("Fecha de préstamo:");

        jLbFechaDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        jLbFechaDevolucion.setText("Fecha de devolución:");

        jLbEstadoPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        jLbEstadoPrestamo.setText("Estado del libro:");

        javax.swing.GroupLayout jPnFechasPrestamoLayout = new javax.swing.GroupLayout(jPnFechasPrestamo);
        jPnFechasPrestamo.setLayout(jPnFechasPrestamoLayout);
        jPnFechasPrestamoLayout.setHorizontalGroup(
            jPnFechasPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnFechasPrestamoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnFechasPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnFechasPrestamoLayout.createSequentialGroup()
                        .addComponent(jLbFechaPrestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLbFechaDevolucion)
                        .addGap(18, 18, 18)
                        .addComponent(TxtFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnFechasPrestamoLayout.createSequentialGroup()
                        .addComponent(jLbEstadoPrestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtEstadoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPnFechasPrestamoLayout.setVerticalGroup(
            jPnFechasPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnFechasPrestamoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPnFechasPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbFechaPrestamo)
                    .addComponent(TxtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbFechaDevolucion)
                    .addComponent(TxtFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnFechasPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbEstadoPrestamo)
                    .addComponent(TxtEstadoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPnBotones1.setBackground(new java.awt.Color(0, 0, 255));
        jPnBotones1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BtnAceptar.setText("Aceptar");

        BtnBuscarAlu.setText("Buscar");

        javax.swing.GroupLayout jPnBotones1Layout = new javax.swing.GroupLayout(jPnBotones1);
        jPnBotones1.setLayout(jPnBotones1Layout);
        jPnBotones1Layout.setHorizontalGroup(
            jPnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnBotones1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(BtnBuscarAlu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPnBotones1Layout.setVerticalGroup(
            jPnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnBotones1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnBuscarAlu)
                .addGap(18, 18, 18)
                .addComponent(BtnAceptar)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        BtnCerrarLibros.setText("Cerrar Ventana");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/IconLibros.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPnFechasPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCerrarLibros)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPnDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPnBotones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel3)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPnDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(64, 64, 64)
                        .addComponent(jPnBotones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPnFechasPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(BtnCerrarLibros)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JButton BtnBuscarAlu;
    private javax.swing.JButton BtnCerrarLibros;
    private javax.swing.JTextField TxtAsignatura;
    private javax.swing.JTextField TxtAutor;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtEditorial;
    private javax.swing.JTextField TxtEstado;
    private javax.swing.JTextField TxtEstadoLibro;
    private javax.swing.JTextField TxtFechaDevolucion;
    private javax.swing.JTextField TxtFechaPrestamo;
    private javax.swing.JTextField TxtTitulo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLbAsignatura;
    private javax.swing.JLabel jLbAutor;
    private javax.swing.JLabel jLbCodigo;
    private javax.swing.JLabel jLbEditorial;
    private javax.swing.JLabel jLbEstado;
    private javax.swing.JLabel jLbEstadoPrestamo;
    private javax.swing.JLabel jLbFechaDevolucion;
    private javax.swing.JLabel jLbFechaPrestamo;
    private javax.swing.JLabel jLbTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPnBotones1;
    private javax.swing.JPanel jPnDatos;
    private javax.swing.JPanel jPnFechasPrestamo;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAceptar() {
        return BtnAceptar;
    }

    public void setBtnAceptar(JButton BtnAceptar) {
        this.BtnAceptar = BtnAceptar;
    }

    public JButton getBtnBuscarAlu() {
        return BtnBuscarAlu;
    }

    public void setBtnBuscarAlu(JButton BtnBuscarAlu) {
        this.BtnBuscarAlu = BtnBuscarAlu;
    }

    public JButton getBtnCerrarLibros() {
        return BtnCerrarLibros;
    }

    public void setBtnCerrarLibros(JButton BtnCerrarLibros) {
        this.BtnCerrarLibros = BtnCerrarLibros;
    }

    public JTextField getTxtAsignatura() {
        return TxtAsignatura;
    }

    public void setTxtAsignatura(JTextField TxtAsignatura) {
        this.TxtAsignatura = TxtAsignatura;
    }

    public JTextField getTxtAutor() {
        return TxtAutor;
    }

    public void setTxtAutor(JTextField TxtAutor) {
        this.TxtAutor = TxtAutor;
    }

    public JTextField getTxtCodigo() {
        return TxtCodigo;
    }

    public void setTxtCodigo(JTextField TxtCodigo) {
        this.TxtCodigo = TxtCodigo;
    }

    public JTextField getTxtEditorial() {
        return TxtEditorial;
    }

    public void setTxtEditorial(JTextField TxtEditorial) {
        this.TxtEditorial = TxtEditorial;
    }

    public JTextField getTxtEstado() {
        return TxtEstado;
    }

    public void setTxtEstado(JTextField TxtEstado) {
        this.TxtEstado = TxtEstado;
    }

    public JTextField getTxtEstadoLibro() {
        return TxtEstadoLibro;
    }

    public void setTxtEstadoLibro(JTextField TxtEstadoLibro) {
        this.TxtEstadoLibro = TxtEstadoLibro;
    }

    public JTextField getTxtFechaDevolucion() {
        return TxtFechaDevolucion;
    }

    public void setTxtFechaDevolucion(JTextField TxtFechaDevolucion) {
        this.TxtFechaDevolucion = TxtFechaDevolucion;
    }

    public JTextField getTxtFechaPrestamo() {
        return TxtFechaPrestamo;
    }

    public void setTxtFechaPrestamo(JTextField TxtFechaPrestamo) {
        this.TxtFechaPrestamo = TxtFechaPrestamo;
    }

    public JTextField getTxtTitulo() {
        return TxtTitulo;
    }

    public void setTxtTitulo(JTextField TxtTitulo) {
        this.TxtTitulo = TxtTitulo;
    }

   
}
