/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import javax.swing.table.DefaultTableModel;
import controlador.SuscripcionDAO;
import modelo.Suscripcion;     
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Date;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
/**
 *
 * @author angel
 */
public class vistasuscripcion extends javax.swing.JFrame {
    
    private SuscripcionDAO dao = new SuscripcionDAO();
    private DefaultTableModel modeloTabla;
    // La variable para guardar el ID de la fila seleccionada (para Update/Delete)
    private int idSeleccionado = 0; 
private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(vistasuscripcion.class.getName());


   public vistasuscripcion() {
       
initComponents();
    this.setLocationRelativeTo(null);
    
    // Colores definidos
    Color azulGeneral = new Color(50, 115, 187); // #3273bb
    Color azulMarinoTabla = new Color(0, 51, 102);
    
    // 1. Pinta el FONDO GENERAL (ContentPane)
    this.getContentPane().setBackground(azulGeneral);
        
        
        jComboBox2.removeAllItems(); 
        jComboBox2.addItem("ACTIVA");
        jComboBox2.addItem("CANCELADA");
        jComboBox2.addItem("EXPIRADA");
        
        
        cargarTablaSuscripciones(); 
      
        // --- INICIO: CÓDIGO PARA AZUL MARINO ---
    Color azulMarino = new Color(0, 51, 102); // Tono de azul marino oscuro
    
    // 1. Fondo y texto de la tabla
    jTable1.setBackground(azulMarino);
    jTable1.setForeground(Color.WHITE);
    
    // 2. Fondo del Viewport (contenedor de la tabla)
    // Esto es crucial para que se vea bien si no hay muchas filas
    jTable1.getParent().setBackground(azulMarino); 
    
    // 3. Cabecera (Header) de la tabla
    jTable1.getTableHeader().setBackground(new Color(0, 30, 60));
    jTable1.getTableHeader().setForeground(Color.WHITE);
    
    //Aqui termina el color azul marino.
    
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                    seleccionarFila();
                }
            }
        });
   
   }
        
private void limpiarCampos() {
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    // Se asume que el primer ítem es el estado predeterminado
    jComboBox2.setSelectedIndex(0); 
    idSeleccionado = 0; // Reinicia el ID de la fila seleccionada
}

public void cargarTablaSuscripciones() {
    String[] columnas = {"ID Susc.", "ID Cliente", "ID Plan", "F. Inicio", "F. Fin", "Estado"};
    modeloTabla = new DefaultTableModel(null, columnas);
    
    try {
        // Llama al DAO para obtener la lista
        List<Suscripcion> listaSuscripciones = dao.listar();
        
        for (Suscripcion s : listaSuscripciones) {
            Object[] fila = {
                s.getIdSuscripcion(),
                s.getIdCliente(),
                s.getIdPlan(),
                s.getFechaInicio(),
                s.getFechaFin(),
                s.getEstado()
            };
            modeloTabla.addRow(fila);
        }
    } catch (Exception e) {
        logger.log(java.util.logging.Level.SEVERE, "Error al cargar suscripciones", e);
        JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
    }
    
    jTable1.setModel(modeloTabla);
    limpiarCampos(); // Limpia el formulario después de cargar
}
private void seleccionarFila() {
    int fila = jTable1.getSelectedRow();
    if (fila >= 0) {
        try {
            // Columna 0 es el ID Suscripción
            idSeleccionado = (int) jTable1.getValueAt(fila, 0); 
            
            // Cargar datos a los campos
            jTextField1.setText(String.valueOf(idSeleccionado)); 
            jTextField2.setText(jTable1.getValueAt(fila, 1).toString()); // ID Cliente
            jTextField3.setText(jTable1.getValueAt(fila, 2).toString()); // ID Plan
            jTextField4.setText(jTable1.getValueAt(fila, 3).toString()); // Fecha Inicio (Formato YYYY-MM-DD)
            jTextField5.setText(jTable1.getValueAt(fila, 4).toString()); // Fecha Fin (Formato YYYY-MM-DD)
            
            // Cargar el estado al JComboBox (Columna 5)
            String estado = jTable1.getValueAt(fila, 5).toString();
            jComboBox2.setSelectedItem(estado);
            
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error al cargar datos de la fila seleccionada.", ex);
            JOptionPane.showMessageDialog(this, "Error al seleccionar fila: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}





    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SUSCRIPCIÓN");

        jLabel2.setText("CLIENTE");

        jLabel3.setText("PLAN");

        jLabel4.setText("FECHA DE INICIO");

        jLabel5.setText("FECHA FIN ");

        jLabel6.setText("ESTADO");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel5))
                                            .addGap(19, 19, 19))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(43, 43, 43)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(149, 149, 149))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        // Validación y obtención de datos
        int idCliente = Integer.parseInt(jTextField2.getText());
        int idPlan = Integer.parseInt(jTextField3.getText());
        Date fechaInicio = Date.valueOf(jTextField4.getText());
        Date fechaFin = Date.valueOf(jTextField5.getText());
        String estado = jComboBox2.getSelectedItem().toString();

        // Crear objeto y llamar al DAO para INSERTAR
        Suscripcion nuevaSuscripcion = new Suscripcion(idCliente, idPlan, fechaInicio, fechaFin, estado);
        int registros = dao.insertar(nuevaSuscripcion);

        if (registros > 0) {
            JOptionPane.showMessageDialog(this, "Suscripción guardada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaSuscripciones();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo guardar la suscripción.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar (Verifique formatos): " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        logger.log(java.util.logging.Level.SEVERE, "Error al guardar", e);
    }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (idSeleccionado == 0) {
        JOptionPane.showMessageDialog(this, "Primero debe seleccionar una fila para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // Obtener datos, usando el idSeleccionado
        int idCliente = Integer.parseInt(jTextField2.getText());
        int idPlan = Integer.parseInt(jTextField3.getText());
        Date fechaInicio = Date.valueOf(jTextField4.getText());
        Date fechaFin = Date.valueOf(jTextField5.getText());
        String estado = jComboBox2.getSelectedItem().toString();

        // Crear objeto con ID y llamar al DAO para ACTUALIZAR
        Suscripcion suscripcionActualizada = new Suscripcion(idSeleccionado, idCliente, idPlan, fechaInicio, fechaFin, estado);
        int registros = dao.actualizar(suscripcionActualizada);

        if (registros > 0) {
            JOptionPane.showMessageDialog(this, "Suscripción actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaSuscripciones();
        } else {
            JOptionPane.showMessageDialog(this, "No hubo cambios o el ID no existe.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        logger.log(java.util.logging.Level.SEVERE, "Error al actualizar", e);
    }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                                         
        if (idSeleccionado == 0) {
            JOptionPane.showMessageDialog(this, "Primero debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea eliminar la suscripción ID " + idSeleccionado + "?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                int registros = dao.eliminar(idSeleccionado);
                if (registros > 0) {
                    JOptionPane.showMessageDialog(this, "Suscripción eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarTablaSuscripciones();
                    limpiarCampos(); 
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la suscripción para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                logger.log(java.util.logging.Level.SEVERE, "Error al eliminar", e);
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new vistasuscripcion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

}
