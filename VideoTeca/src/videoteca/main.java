/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;


import java.awt.Dialog;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Manzano López
 */
public class main extends javax.swing.JFrame {
        List basedatos = new List();
    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        getRootPane().setDefaultButton(jButtonsave);
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/icono.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldtitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFielddirector = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldyear = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonsave = new javax.swing.JButton();
        jButtonshow = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldposition = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtondelete = new javax.swing.JButton();
        jButtonfind = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1modify = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Título:");

        jLabel2.setText("Director:");

        jLabel3.setText("Año:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonsave.setText("Guardar");
        jButtonsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsaveActionPerformed(evt);
            }
        });

        jButtonshow.setText("Mostrar");
        jButtonshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonshowActionPerformed(evt);
            }
        });

        jLabel4.setText("Posición:");

        jLabel5.setText("Resultado:");

        jButtondelete.setText("Suprimir");
        jButtondelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondeleteActionPerformed(evt);
            }
        });

        jButtonfind.setText("Buscar");
        jButtonfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonfindActionPerformed(evt);
            }
        });

        jButton5.setText("Borrar lista");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1modify.setText("Modificar");
        jButton1modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1modifyActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1modify, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtondelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldtitle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFielddirector, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldyear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jButtonsave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonshow, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonfind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldposition, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 155, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFielddirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(1, 1, 1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonsave)
                            .addComponent(jTextFieldposition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonshow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtondelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1modify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonfind))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonfindActionPerformed
        
        if(-1!=basedatos.getFind(jTextFieldtitle.getText())) { 
            jTextArea1.setText("");
            jTextArea1.setText(basedatos.getShow(basedatos.getFind(jTextFieldtitle.getText())).toString());
                    
        }else{
            JOptionPane.showMessageDialog(this, "Objeto no encontrado", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonfindActionPerformed

    private void jButtonsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsaveActionPerformed
        try {
            if (jTextFieldposition.getText().isEmpty()) {
                basedatos.setSave(jTextFieldtitle.getText(), jTextFielddirector.getText()
                        ,jTextFieldyear.getText());
            } else {
                if (!(basedatos.getShow(Integer.valueOf(jTextFieldposition.getText())) == null)) {
                    basedatos.setSave(Integer.valueOf(jTextFieldposition.getText()),
                            jTextFieldtitle.getText(), jTextFielddirector.getText()
                        ,jTextFieldyear.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Esta posición está ocupada",
                            "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldposition.setText("");
                    jTextFieldposition.requestFocus();
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Introduce un valor válido"
                    + "Se acepta números:\n"
                    + "No se admite letras o símbolos.", "Caracter no válido.",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonsaveActionPerformed

    private void jButtonshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonshowActionPerformed
        try{
            if (!(basedatos.getShow(Integer.valueOf(jTextFieldposition.getText())) == null)){
                   jTextArea1.setText(basedatos.getShowString(Integer.valueOf(
                           jTextFieldposition.getText())));     
            }else{
                JOptionPane.showMessageDialog(this, "Esta posición está vacia",
                            "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Introduce un valor válido"
                    + "Se acepta números:\n"
                    + "No se admite letras o símbolos.", "Caracter no válido.",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonshowActionPerformed

    private void jButtondeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondeleteActionPerformed
        try{
            if (!(basedatos.getShow(Integer.valueOf(jTextFieldposition.getText())) == null)){
                    JOptionPane.showConfirmDialog(this, "Se dispone a borrar la película.",
                            "Atención", JOptionPane.OK_OPTION);
                   basedatos.setDelete(Integer.valueOf(jTextFieldposition.getText()));     
            }else{
                JOptionPane.showMessageDialog(this, "Esta posición está vacia",
                            "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Introduce un valor válido"
                    + "Se acepta números:\n"
                    + "No se admite letras o símbolos.", "Caracter no válido.",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtondeleteActionPerformed

    private void jButton1modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1modifyActionPerformed
       
        try{
            if (!(basedatos.getShow(Integer.valueOf(jTextFieldposition.getText())) == null)){
                basedatos.setModify(Integer.valueOf(jTextFieldposition.getText()),
                        jTextFieldtitle.getText(), jTextFielddirector.getText(),
                            jTextFieldyear.getText());
            }
            
        }catch(NumberFormatException e){
            e.printStackTrace();
        
        }
        
    }//GEN-LAST:event_jButton1modifyActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       jTextArea1.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextArea1.setText("");
        jTextArea1.append(basedatos.getAll());
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1modify;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtondelete;
    private javax.swing.JButton jButtonfind;
    private javax.swing.JButton jButtonsave;
    private javax.swing.JButton jButtonshow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFielddirector;
    private javax.swing.JTextField jTextFieldposition;
    private javax.swing.JTextField jTextFieldtitle;
    private javax.swing.JTextField jTextFieldyear;
    // End of variables declaration//GEN-END:variables
}
