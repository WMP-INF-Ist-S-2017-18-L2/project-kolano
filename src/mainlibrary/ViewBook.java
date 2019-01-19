/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lokyiec
 */
public class ViewBook extends javax.swing.JFrame {

    public ViewBook() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initComponents();
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();

        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select * from Books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colnum=rsmd.getColumnCount();
            NameRadio.setSelected(true);
            String Row[];
            Row = new String[colnum];
            
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    Row[i-1]=rs.getString(i);
                }
                model.addRow(Row);
            }
               
            Con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        NameRadio = new javax.swing.JRadioButton();
        AuthorRadio = new javax.swing.JRadioButton();
        ALL = new javax.swing.JRadioButton();
        Search = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Tytuł", "Autor", "Wydawca", "ISBN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(25, 161, 950, 251);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Zamknij");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 420, 95, 29);

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(SearchField);
        SearchField.setBounds(690, 120, 190, 26);

        NameRadio.setBackground(new java.awt.Color(255, 255, 255));
        NameRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameRadioActionPerformed(evt);
            }
        });
        getContentPane().add(NameRadio);
        NameRadio.setBounds(30, 120, 64, 23);

        AuthorRadio.setBackground(new java.awt.Color(255, 255, 255));
        AuthorRadio.setToolTipText("");
        AuthorRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorRadioActionPerformed(evt);
            }
        });
        getContentPane().add(AuthorRadio);
        AuthorRadio.setBounds(130, 120, 67, 23);

        ALL.setBackground(new java.awt.Color(255, 255, 255));
        ALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALLActionPerformed(evt);
            }
        });
        getContentPane().add(ALL);
        ALL.setBounds(690, 90, 28, 23);

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setText("Szukaj");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search);
        Search.setBounds(890, 120, 85, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/lokyiec/Desktop/Biblioteka/background/library.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1040, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code hereset
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void NameRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameRadioActionPerformed
        // TODO add your handling code here:
        AuthorRadio.setSelected(false);
        ALL.setSelected(false);
    }//GEN-LAST:event_NameRadioActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        
        while(model.getRowCount()>0)
            model.removeRow(model.getRowCount()-1);
        if(NameRadio.isSelected()) {
            String Search = "%"+SearchField.getText()+"%";
            
            try(Connection Con = DB.getConnection()) {
                PreparedStatement ps=Con.prepareStatement("select * from Books where BookName like ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ps.setString(1, Search);
                ResultSet rs= ps.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
  
                int colnum=rsmd.getColumnCount();
            
                String Row[];
                Row = new String[colnum];
                
                while(rs.next()) {
                    for(int i=1;i<=colnum;i++) {
                        Row[i-1]=rs.getString(i);
                    }
                model.addRow(Row);
                }
                int rowcount = model.getRowCount();
                System.out.println(rowcount);
                
                if(rowcount==0) {
                    String NoRow[];
                    NoRow = new String[7];
                    NoRow[3]="Brak";
                    NoRow[4]="Wyników";
                    NoRow[0]="";
                    NoRow[1]="";
                    NoRow[2]="";
                    NoRow[5]="";
                    NoRow[6]="";
                    model.addRow(NoRow);                
                }
                Con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        }
        
        else if(AuthorRadio.isSelected()) {
            String Search = "%"+SearchField.getText()+"%";
            
            try(Connection Con = DB.getConnection()) {
                PreparedStatement ps=Con.prepareStatement("select * from Books where Author like ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ps.setString(1, Search);
                ResultSet rs= ps.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
  
                int colnum=rsmd.getColumnCount();
            
                String Row[];
                Row = new String[colnum];
                
                while(rs.next()) {
                    for(int i=1;i<=colnum;i++) {
                        Row[i-1]=rs.getString(i);
                    }
                model.addRow(Row);
                }
                int rowcount = model.getRowCount();
                System.out.println(rowcount);
                
                if(rowcount==0) {
                    String NoRow[];
                    NoRow = new String[7];
                    NoRow[3]="Brak";
                    NoRow[4]="Wyników";
                    NoRow[0]="";
                    NoRow[1]="";
                    NoRow[2]="";
                    NoRow[5]="";
                    NoRow[6]="";
                    model.addRow(NoRow);                
                }
                Con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        }
        
        else{
            JOptionPane.showMessageDialog(ViewBook.this, "Wybierz tytuł lub autora","Error!", JOptionPane.ERROR_MESSAGE);
        }         
    }//GEN-LAST:event_SearchActionPerformed

    private void AuthorRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorRadioActionPerformed
        // TODO add your handling code here:
        NameRadio.setSelected(false);
        ALL.setSelected(false);
    }//GEN-LAST:event_AuthorRadioActionPerformed

    private void ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALLActionPerformed
        // TODO add your handling code here:
        NameRadio.setSelected(false);
        AuthorRadio.setSelected(false);
        SearchField.setText("");
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        
        while(model.getRowCount()>0)
            model.removeRow(model.getRowCount()-1);

        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select * from Books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colnum=rsmd.getColumnCount();
            String Row[];
            Row = new String[colnum];
            
            while(rs.next()) {
                for(int i=1;i<=colnum;i++){
                    Row[i-1]=rs.getString(i);
                }
                model.addRow(Row);
            }
            Con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_ALLActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewBook().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ALL;
    private javax.swing.JRadioButton AuthorRadio;
    private javax.swing.JRadioButton NameRadio;
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchField;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


}
