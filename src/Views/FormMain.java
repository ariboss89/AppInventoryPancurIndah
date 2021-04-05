/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import Models.tb_pengguna;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FormMain extends javax.swing.JFrame {

    /**
     * Creates new form FormMain
     */
    public FormMain() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
        
        CheckPrevileges();
    }

    void CheckPrevileges(){
        String role = tb_pengguna.getRole();
        
        if(role == "SUPERADMIN"){
            menuProccess.setEnabled(false);
            menuReport.setEnabled(false);
            menuBarang.setEnabled(false);
            menuSupplier.setEnabled(false);
        }
        else{
            menuPengguna.setEnabled(false);
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

        background1 = new Images.Background();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuBarang = new javax.swing.JMenuItem();
        menuPengguna = new javax.swing.JMenuItem();
        menuSupplier = new javax.swing.JMenuItem();
        menuProccess = new javax.swing.JMenu();
        menuPemesanan = new javax.swing.JMenuItem();
        menuTambahStokBarang = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        menuLaporan = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1367, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );

        jMenu1.setText("INPUT");

        menuBarang.setText("FORM BARANG");
        menuBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarangActionPerformed(evt);
            }
        });
        jMenu1.add(menuBarang);

        menuPengguna.setText("FORM PENGGUNA");
        menuPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenggunaActionPerformed(evt);
            }
        });
        jMenu1.add(menuPengguna);

        menuSupplier.setText("FORM SUPPLIER");
        menuSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSupplierActionPerformed(evt);
            }
        });
        jMenu1.add(menuSupplier);

        jMenuBar1.add(jMenu1);

        menuProccess.setText("PROCCESS");

        menuPemesanan.setText("FORM PEMESANAN");
        menuPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPemesananActionPerformed(evt);
            }
        });
        menuProccess.add(menuPemesanan);

        menuTambahStokBarang.setText("FORM TAMBAH STOK BARANG");
        menuTambahStokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTambahStokBarangActionPerformed(evt);
            }
        });
        menuProccess.add(menuTambahStokBarang);

        jMenuItem1.setText("FORM PENJUALAN");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuProccess.add(jMenuItem1);

        jMenuBar1.add(menuProccess);

        menuReport.setText("REPORT");

        menuLaporan.setText("LAPORAN PEMESANAN");
        menuLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLaporanActionPerformed(evt);
            }
        });
        menuReport.add(menuLaporan);

        jMenuBar1.add(menuReport);

        jMenu3.setText("PENGATURAN");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu5.setText("LOG OUT");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarangActionPerformed
        // TODO add your handling code here:
        new FormBarang().show();
    }//GEN-LAST:event_menuBarangActionPerformed

    private void menuSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSupplierActionPerformed
        // TODO add your handling code here:
        new FormSupplier().show();
    }//GEN-LAST:event_menuSupplierActionPerformed

    private void menuPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPemesananActionPerformed
        // TODO add your handling code here:
        new FormPemesanan().show();
    }//GEN-LAST:event_menuPemesananActionPerformed

    private void menuTambahStokBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTambahStokBarangActionPerformed
        // TODO add your handling code here:
        new FormTambahStokBarang().show();
    }//GEN-LAST:event_menuTambahStokBarangActionPerformed

    private void menuLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLaporanActionPerformed
        // TODO add your handling code here:
        new FormLaporan().show();
    }//GEN-LAST:event_menuLaporanActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        new FormPengaturan().show();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apa Anda Ingin Keluar ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(ok==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void menuPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenggunaActionPerformed
        // TODO add your handling code here:
        new FormPengguna().show();
    }//GEN-LAST:event_menuPenggunaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new FormPenjualan().show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Images.Background background1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuBarang;
    private javax.swing.JMenuItem menuLaporan;
    private javax.swing.JMenuItem menuPemesanan;
    private javax.swing.JMenuItem menuPengguna;
    private javax.swing.JMenu menuProccess;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenuItem menuSupplier;
    private javax.swing.JMenuItem menuTambahStokBarang;
    // End of variables declaration//GEN-END:variables
}
