/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto_a;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author az
 */
public class RegistroVentas extends javax.swing.JFrame {
    public Usuario usuarioActual;
    private regisVen RegistroVenta;
        
    /**
     * Creates new form RegistroVentas
     */
    public RegistroVentas(Usuario usuario) {
        initComponents();
        usuarioActual =usuario;
        jTextField1.setText(usuarioActual.nombre);
        
        cargarComboBoxOpciones();
  
        pintarTabla();
    }
    private void cargarComboBoxOpciones(){
          
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        
            for (libro Libro : Proyecto_A.inventarioLibros) {
                if (Libro.cantidadStock > 0) {
                    model.addElement(Libro.titulo + " - Stock: " + Libro.cantidadStock);
                }
            }
        jComboBox1.setModel(model);
    }
    
 
    
    private void actualizarTotalCompra(){
        double total = 0.0;
        
        if (Proyecto_A.RegistroVenta != null) {
            for (regisVen venta: Proyecto_A.RegistroVenta) {
                total += venta.total;
            }
        }
        jTextField10.setText(String.format("%.2f", total));
    }
    private double totalAcumulado = 0.0;
    
    private void pintarTabla(){
        String [] encabezados ={"Libro","Cantidad","Precio Total"};
        DefaultTableModel model = new DefaultTableModel(encabezados, Proyecto_A.RegistroVenta.size());
        jTable1.setModel(model);
        TableModel tabla=jTable1.getModel();
        
        double subtotalSinIVA = 0.0;
        
        for (int i = 0; i < Proyecto_A.RegistroVenta.size(); i++) {
         regisVen r=Proyecto_A.RegistroVenta.get(i);
         
         tabla.setValueAt(r.libro, i, 0);
         tabla.setValueAt(r.cantidad, i, 1);
         tabla.setValueAt(r.total, i, 2);
         
         subtotalSinIVA += (r.total / r.cantidad / 1.12) * r.cantidad;
        }
       
            jTextField4.setText(String.format("%.2f", subtotalSinIVA));
        
        actualizarTotalCompra();
    }
    private double descuentoAplicado = 0.0;
    private String codigoCuponAplicado = "";
    
    private void aplicarCupon(){
        String codigoCupon = jTextField2.getText().trim();
        
        if(codigoCupon.isEmpty()){
         JOptionPane.showMessageDialog(this, "Ingese un codigo de cupon", "Error", JOptionPane.ERROR_MESSAGE);
         return;
        }
        
        Cupon cuponEncontrado = null;
        for (Cupon cupon : Proyecto_A.cuponesdescuento) {
            if (cupon.CodigoCupon.equalsIgnoreCase(codigoCupon)) {
                cuponEncontrado = cupon;
                break;
            }
        }
        
        if (cuponEncontrado == null) {
            JOptionPane.showMessageDialog(this, "Cupon no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (cuponEncontrado.Fechavencimiento.before(new Date())) {
            JOptionPane.showMessageDialog(this, "Cupon vencido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        double subtotalSinIVA = Double.parseDouble(jTextField4.getText());
        
        if (cuponEncontrado.esPorcentaje) {
            descuentoAplicado = subtotalSinIVA *(cuponEncontrado.Valordescuento / 100);
        }else{
            descuentoAplicado = Math.min(cuponEncontrado.Valordescuento, subtotalSinIVA);
        }
        
       
        
        codigoCuponAplicado = cuponEncontrado.CodigoCupon;
        actualizarTotales();
        
        JOptionPane.showMessageDialog(this, 
                "Cupon aplicado: " + codigoCuponAplicado + "\n" + 
                "Descuento: " + String.format("%.2f", descuentoAplicado), 
                "Cupon aplicado", JOptionPane.INFORMATION_MESSAGE);
        }
    
        private void actualizarTotales(){
            double subtotalSinIva =Double.parseDouble(jTextField4.getText());
            double subtotalConDescuento = subtotalSinIva - descuentoAplicado;
            double iva = subtotalConDescuento * 0.12;
            double totalFinal = subtotalConDescuento + iva;

         // Actualizar campos (el campo de descuento mostrará 0.00 si no hay cupón)
         jTextField5.setText(String.format("%.2f", descuentoAplicado));
         jTextField6.setText(String.format("%.2f", iva));
         jTextField10.setText(String.format("%.2f", totalFinal));
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Vendedor :");

        jLabel2.setText("Libro: ");

        jLabel3.setText("Cantidad: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel4.setText("Datos de Compra ");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel5.setText("Datos cliente ");

        jLabel6.setText("NIT:");

        jLabel7.setText("Nombre: ");

        jLabel8.setText("Direccion: ");

        jLabel9.setText("Venta Libro ");

        jLabel10.setText("Total de la compra ");

        jButton3.setText("Registro venta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Cupones");

        jLabel12.setText("Añadir Cupon:");

        jButton4.setText("Guardar Cupon");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setText("SubTotal");

        jLabel14.setText("Descuento");

        jLabel15.setText("IVA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(26, 26, 26)
                                .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jTextField7)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(103, 103, 103)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jButton2))))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       try {
        // 1. Obtener los valores del formulario
        String opcionSeleccionada = (String) jComboBox1.getSelectedItem();
        String cantidadTexto = jTextField9.getText().trim();
        String nitCliente = jTextField3.getText().trim();
        String nombreCliente = jTextField7.getText().trim();
        String direccionCliente = jTextField8.getText().trim();
        
        // 2. Validar campos
        if (cantidadTexto.isEmpty() || nitCliente.isEmpty() || nombreCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad, NIT y nombre del cliente", "Datos Incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        String[] partes = opcionSeleccionada.split(" - Stock: ");

        // Validar que el split devuelva 2 partes (nombre y stock)
            if (partes.length != 2) {
         JOptionPane.showMessageDialog(this, 
        "Formato de libro inválido. Contacte al administrador.", 
        "Error", JOptionPane.ERROR_MESSAGE);
              return;
            }

        String nombreLibro = partes[0].trim();
        int stockDisponible = Integer.parseInt(partes[1].trim());
        
         int cantidad = Integer.parseInt(cantidadTexto);
           if (cantidad <= 0) {
               throw new NumberFormatException();
           }
        
           if (cantidad > stockDisponible) {
               JOptionPane.showMessageDialog(this,
                       "Stock insuficiente" + stockDisponible + "unidades",
                       "Error", JOptionPane.ERROR_MESSAGE);
               return;
           }
        
        libro libroVendido = null; 
        
           for (libro Libro : Proyecto_A.inventarioLibros) {
               if (Libro.titulo.equals(nombreLibro)) {
                   libroVendido = Libro;
                   break;
               }
           }
           if (libroVendido == null || libroVendido.cantidadStock < cantidad) {
               JOptionPane.showMessageDialog(this, "Stock insuficiente para '" + nombreLibro + "'",
                       "Error", JOptionPane.ERROR_MESSAGE);
           }
        
        libroVendido.cantidadStock -= cantidad;
        
        double precioUnitario = libroVendido.precio;
        double totalConIva = cantidad * precioUnitario * 1.12; // Asumiendo 12% IVA
        
        regisVen nuevaVenta = new regisVen();
        nuevaVenta.fecha = new Date();
        nuevaVenta.libro = nombreLibro;
        nuevaVenta.cantidad = cantidad;
        nuevaVenta.total = totalConIva;
        Proyecto_A.RegistroVenta.add(nuevaVenta);
        
        // 7. Actualizar interfaz
        pintarTabla();
        jTextField9.setText("");
        jTextField10.setText(String.format("%.2f", totalAcumulado += totalConIva));
        
        JOptionPane.showMessageDialog(this, "Venta registrada. Stock actualizado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
           
    } catch(NumberFormatException e){
        JOptionPane.showMessageDialog(this, "Cantidad debe ser un número positivo", "Erro",JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nit = jTextField3.getText().trim();
        String nombreCliente = jTextField7.getText().trim();
        String direccion = jTextField8.getText().trim();
        
        if (nit.isEmpty() || nombreCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIT y nombre del cliente son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double totalConIVA = Double.parseDouble(jTextField10.getText());
        double totalSinIVA = totalConIVA / 1.12;
        double IVA = totalConIVA - totalSinIVA;
        
        Calendar calendario = Calendar.getInstance(); 
        SimpleDateFormat formatoFecha = new SimpleDateFormat();
        String fechaHora = formatoFecha.format(calendario.getTime());
        
        VentaCompleta nuevaVenta = new VentaCompleta(nit, nombreCliente, direccion, totalConIVA, totalSinIVA);
        nuevaVenta.setDescuento(descuentoAplicado);
        nuevaVenta.setCodigoCupon(codigoCuponAplicado);
        Proyecto_A.ConsultaVenta.add(nuevaVenta);
        pintarTabla();
        
        
        String mensaje = "=== Registro de Venta === \n\n" + 
                "Vendedor: " + usuarioActual.nombre + "\n"+
                "Fecha y Hora: " + fechaHora + "\n\n"+
                "== Datos del Cliente === \n"+
                 "Nombre: " + nombreCliente + "\n" +
                     "NIT: " + nit + "\n" +
                     "Dirección: " + direccion + "\n\n" +
                     "=== TOTALES ===\n" +
                     "Subtotal (sin IVA): " + String.format("%.2f", totalSinIVA) + "\n";
                     if (descuentoAplicado > 0) {
                     mensaje += "Descuento (" + codigoCuponAplicado + "): -" + 
                  String.format("%.2f", descuentoAplicado) + "\n" +
                  "Subtotal con descuento: " + 
                  String.format("%.2f", totalSinIVA - descuentoAplicado) + "\n";
                        }

                 mensaje += "IVA (12%): " + String.format("%.2f", IVA) + "\n" +
               "TOTAL: " + String.format("%.2f", totalConIVA);
                     
                   
        
        if (!codigoCuponAplicado.isEmpty()) {
            mensaje += "\n\nCupon aplicado:" + codigoCuponAplicado;
        }
        
        JOptionPane.showMessageDialog(this, mensaje,"Registro de Venta", JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        aplicarCupon();
    }//GEN-LAST:event_jButton4ActionPerformed
   
    private void limpiarCampos(){
        jTextField3.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField2.setText("");
        jTextField4.setText("0.00");
        jTextField5.setText("0.00");
        jTextField6.setText("0.00");
        jTextField10.setText("0.00");
        descuentoAplicado = 0.0;
        codigoCuponAplicado = "";
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables

    
}
