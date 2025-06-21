/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.serializador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class JF_Serializador extends javax.swing.JFrame {
    private String rutaEntrada = "";
    private String rutaSalida = "";
    private JFileChooser selector ;
    private Serializacion serializacion;

    public JF_Serializador() {
        initComponents();
        selector = new JFileChooser();
        serializacion = new Serializacion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_serializar = new javax.swing.JButton();
        btn_archivo = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        cbx_formatoSerializacion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA_archivoSerializado = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_archivoTXT = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_serializar.setText("Serializar");
        btn_serializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_serializarActionPerformed(evt);
            }
        });

        btn_archivo.setText("Cargar Archivo");
        btn_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_archivoActionPerformed(evt);
            }
        });

        btn_salida.setText("Ruta De Salida");
        btn_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salidaActionPerformed(evt);
            }
        });

        cbx_formatoSerializacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "archivo.avro", "archivo.parquet" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Formato de Serializacion");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Archivo Serializado");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Archivo a Serializar");

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 300));

        txtA_archivoSerializado.setColumns(20);
        txtA_archivoSerializado.setRows(5);
        jScrollPane2.setViewportView(txtA_archivoSerializado);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 300));

        txtA_archivoTXT.setColumns(20);
        txtA_archivoTXT.setRows(5);
        jScrollPane1.setViewportView(txtA_archivoTXT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_serializar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbx_formatoSerializacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbx_formatoSerializacion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_serializar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_archivoActionPerformed
        int resultado = selector.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = selector.getSelectedFile();
            String ruta = archivo.getAbsolutePath(); 
            this.rutaEntrada = ruta;
            System.out.println("Ruta del archivo: " + ruta);
            mostrarArchivoEnPanel(archivo, txtA_archivoTXT);
        }
    }//GEN-LAST:event_btn_archivoActionPerformed

    
    public void mostrarArchivoEnPanel(File archivo, JTextArea areaTexto) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            areaTexto.setText(""); 
            String linea;
            while ((linea = br.readLine()) != null) {
                areaTexto.append(linea + "\n");
            }
        } catch (IOException e) {
            areaTexto.setText("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    

    private void btn_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salidaActionPerformed
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        int resultado = selector.showOpenDialog(null);
 
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File carpeta = selector.getSelectedFile();
            String ruta = carpeta.getAbsolutePath(); 
            System.out.println("Ruta de la carpeta: " + ruta);
            this.rutaSalida = ruta;
        }
    }//GEN-LAST:event_btn_salidaActionPerformed

    private void btn_serializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_serializarActionPerformed
        
        if(!verificadorDeSeleccionDeRutas()){
           return ; 
        }
        
        String rutaSalidaConFormato = crearRutaSalidaConFormato();
        String tipo = cbx_formatoSerializacion.getSelectedItem().toString();
        boolean estaSerializado = serializacion.serializar(tipo, rutaEntrada, rutaSalidaConFormato);
        if(estaSerializado){
            JOptionPane.showMessageDialog(null, "Serializado Correctamente");
        }
        
        File archivoAvro = new File(rutaSalidaConFormato);
        mostrarArchivoComoBinario(archivoAvro);

    }//GEN-LAST:event_btn_serializarActionPerformed
    
    private boolean verificadorDeSeleccionDeRutas(){
        if(rutaEntrada.isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione una ruta de salida");
            return false;
        } else if(rutaSalida.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Seleccione una ruta de salida");
            return false;
        }
        return false;
    }
    
    private String crearRutaSalidaConFormato(){
        String rutaSalidaConFormato= "";
        txtA_archivoSerializado.setText("");
        String formato = cbx_formatoSerializacion.getSelectedItem().toString();
        rutaSalidaConFormato = rutaSalida + "\\" + formato;
        System.out.println(rutaSalidaConFormato);
        return rutaSalidaConFormato;
    }
    
    public void mostrarArchivoComoBinario(File archivo) {
        ConvertidorArchivoBinario convertidor = new ConvertidorArchivoBinario();
        StringBuilder builder = convertidor.convertir(archivo);
        txtA_archivoSerializado.setText(builder.toString());
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Serializador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_archivo;
    private javax.swing.JButton btn_salida;
    private javax.swing.JButton btn_serializar;
    private javax.swing.JComboBox<String> cbx_formatoSerializacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtA_archivoSerializado;
    private javax.swing.JTextArea txtA_archivoTXT;
    // End of variables declaration//GEN-END:variables
}
