/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tela;

import Medico.BdMedico;
import Medico.Medico;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class TabelaMedicos extends javax.swing.JFrame {

    /**
     * Creates new form TabelaMedicos
     */
   BdMedico bd;
    public TabelaMedicos() {
        URL url = this.getClass().getResource("/img/icon.png");  
       Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
       this.setIconImage(imagemTitulo); 
        initComponents();
        
        preencheTabela();
    }
    private void preencheTabela() {
      DefaultTableModel modelo = (DefaultTableModel) jAssociado.getModel();
        int i = modelo.getRowCount();
        while (i--> 0) {
            modelo.removeRow(i);
        }
        bd = new BdMedico();
        List c = bd.relatorio(tFiltro.getText());
        for (Iterator it = c.iterator(); it.hasNext();) {
            Medico a = (Medico) it.next();
            modelo.addRow(new Object[]{a.getNome(), a.getRG(), a.getCPF()});

        }
        bd.fecha();
    }

     private void preencheTabelapesquisa() {
      DefaultTableModel modelo = (DefaultTableModel) jAssociado.getModel();
        int i = modelo.getRowCount();
        while (i--> 0) {
            modelo.removeRow(i);
        }
        bd = new BdMedico();
        List c = bd.pesquisa(tFiltro.getText());
        for (Iterator it = c.iterator(); it.hasNext();) {
            Medico a = (Medico) it.next();
            modelo.addRow(new Object[]{a.getNome(), a.getRG(), a.getCPF()});

        }
        bd.fecha();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tFiltro = new javax.swing.JTextField();
        bFiltro = new javax.swing.JButton();
        bNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAssociado = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Médicos");

        jLabel1.setText("Procurar:");

        bFiltro.setText("Ok");
        bFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltroActionPerformed(evt);
            }
        });

        bNovo.setText("Cadastrar novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        jAssociado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "RG", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jAssociado.getTableHeader().setReorderingAllowed(false);
        jAssociado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAssociadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jAssociado);

        jButton2.setText("Cancelar");

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bNovo))
                            .addComponent(jLabel2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bFiltro)
                    .addComponent(bNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(503, 448));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltroActionPerformed
        preencheTabelapesquisa();        // TODO add your handling code here:
    }//GEN-LAST:event_bFiltroActionPerformed

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        CadastroMedico t = new CadastroMedico();
        t.setVisible(true); 
    }//GEN-LAST:event_bNovoActionPerformed

    private void jAssociadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAssociadoMouseClicked
        if(evt.getClickCount() == 2){
            Point p = evt.getPoint();
            int row = jAssociado.rowAtPoint(p);
            DefaultTableModel modelo = (DefaultTableModel) jAssociado.getModel();
            String CPF =(String)  modelo.getValueAt(row, 2);
           CadastroMedico t = new CadastroMedico();
            t.setNovo(false);
            bd = new BdMedico();
            t.setMedico(bd.localiza(CPF));
            bd.fecha();
            t.setVisible(true);       // TODO add your handling code her
        }
    }//GEN-LAST:event_jAssociadoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(TabelaMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFiltro;
    private javax.swing.JButton bNovo;
    private javax.swing.JTable jAssociado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tFiltro;
    // End of variables declaration//GEN-END:variables
}
