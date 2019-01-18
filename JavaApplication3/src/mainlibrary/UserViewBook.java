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
public class UserViewBook extends javax.swing.JFrame {
    
    public UserViewBook() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        initComponents();
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        
        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select Books.BookID, Books.BookName, Books.Publisher, Books.ISBN, Books.Author, IssuedBook.UserID from Books left outer join IssuedBook on Books.BookID= IssuedBook.BookID;",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
        
            String Row[];
            String Check="";
            Row = new String[colnum];
            while(rs.next()) {
                for(int i=1;i<=colnum;i++){
                    if(i==colnum) {
                        if(rs.getString(i)==null)
                            Row[i-1]="Dostępna";
                        else
                            Row[i-1]="Nie dostępna";
                        System.out.println(rs.getString(i));
                    }
                    else
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        NameRadio = new javax.swing.JRadioButton();
        AuthorRadio = new javax.swing.JRadioButton();
        ALL = new javax.swing.JRadioButton();
        NotIssued = new javax.swing.JRadioButton();
        SearchField = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        ShowALL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Tytuł", "ISBN", "Autor", "Wydawca", "Dostępność"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false,  false,false
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
        jScrollPane1.setBounds(40, 176, 920, 240);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Zamknij");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 430, 95, 29);

        NameRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameRadioActionPerformed(evt);
            }
        });
        getContentPane().add(NameRadio);
        NameRadio.setBounds(30, 140, 73, 23);

        AuthorRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorRadioActionPerformed(evt);
            }
        });
        getContentPane().add(AuthorRadio);
        AuthorRadio.setBounds(130, 140, 67, 23);

        ALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALLActionPerformed(evt);
            }
        });
        getContentPane().add(ALL);
        ALL.setBounds(610, 110, 95, 23);

        NotIssued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotIssuedActionPerformed(evt);
            }
        });
        getContentPane().add(NotIssued);
        NotIssued.setBounds(750, 110, 141, 23);
        getContentPane().add(SearchField);
        SearchField.setBounds(620, 140, 250, 26);

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setText("Szukaj");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search);
        Search.setBounds(880, 140, 85, 29);

        ShowALL.setBackground(new java.awt.Color(255, 255, 255));
        ShowALL.setText("Pokaż wszystkie");
        ShowALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowALLActionPerformed(evt);
            }
        });
        getContentPane().add(ShowALL);
        ShowALL.setBounds(430, 140, 140, 29);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/lokyiec/Desktop/Biblioteka/background/user_list_book.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code hereset
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        if(SearchField.getText()=="")
            JOptionPane.showMessageDialog(UserViewBook.this, "Pole szukania jest puste","Error!", JOptionPane.ERROR_MESSAGE);

        if(!ALL.isSelected())
            if(!NotIssued.isSelected())
                ALL.setEnabled(true);
        
        int flag=0;
        
        if(ALL.isSelected())
            flag=0;
        if(NotIssued.isSelected())
            flag=1;
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        
        while(model.getRowCount()>0){
            model.removeRow(model.getRowCount()-1);
        }
        if(NameRadio.isSelected()) {
            String Search = "%"+SearchField.getText()+"%";
            
        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select A.BookID, A.BookName,A.ISBN,A.Author,A.Publisher, IssuedBook.UserID from (select * from Books where BookName like ?) as A left outer join IssuedBook on A.BookID= IssuedBook.BookID",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Search);
            ResultSet rs= ps.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();

            String Row[];
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    if(i==colnum) {
                        if(rs.getString(i)==null) {
                            Row[i-1]="Dostępna";
                            model.addRow(Row);
                        }
                        else {
                            if(flag==1)
                                continue;
                            Row[i-1]="Nie dostępna";
                            model.addRow(Row);
                        }
                        System.out.println(rs.getString(i));
                    }
                    else
                        Row[i-1]=rs.getString(i);
                
                        
                }
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
                PreparedStatement ps=Con.prepareStatement("select A.BookID, A.BookName,A.ISBN,A.Author,A.Publisher, IssuedBook.UserID from (select * from Books where Author like ?) as A left outer join IssuedBook on A.BookID= IssuedBook.BookID",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ps.setString(1, Search);
                ResultSet rs= ps.executeQuery();
            
                ResultSetMetaData rsmd = rs.getMetaData();
  
                int colnum=rsmd.getColumnCount();

                String Row[];
                Row = new String[colnum];
                while(rs.next()){
                    for(int i=1;i<=colnum;i++){
                        if(i==colnum) {
                            if(rs.getString(i)==null) {
                                Row[i-1]="Dostępna";
                                model.addRow(Row);
                            }
                            else {
                                if(flag==1)
                                    continue;
                                Row[i-1]="Nie dostępna";
                                model.addRow(Row);
                            }
                        System.out.println(rs.getString(i));
                        }
                        else
                            Row[i-1]=rs.getString(i);
                    }
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
        else {
            JOptionPane.showMessageDialog(UserViewBook.this, "Select Name or Author","No Selection!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void AuthorRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorRadioActionPerformed
        // TODO add your handling code here:
        NameRadio.setSelected(false);
    }//GEN-LAST:event_AuthorRadioActionPerformed

    private void NameRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameRadioActionPerformed
        // TODO add your handling code here:
        AuthorRadio.setSelected(false);
    }//GEN-LAST:event_NameRadioActionPerformed

    private void ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALLActionPerformed
        // TODO add your handling code here:
        NotIssued.setSelected(false);
      
    }//GEN-LAST:event_ALLActionPerformed

    private void NotIssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotIssuedActionPerformed
        // TODO add your handling code here:
        ALL.setSelected(false);
        
    }//GEN-LAST:event_NotIssuedActionPerformed

    private void ShowALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowALLActionPerformed
        // TODO add your handling code here:
        AuthorRadio.setSelected(false);
        NameRadio.setSelected(false);
        DefaultTableModel model;
        model = (DefaultTableModel)jTable1.getModel();
        while(model.getRowCount()>0){
            model.removeRow(model.getRowCount()-1);
        }
         
        if(!ALL.isSelected()&&!NotIssued.isSelected()) {
            ALL.setSelected(true);
        }

        int flag=0;
        
        if(ALL.isSelected())
            flag=0;
        if(NotIssued.isSelected())
            flag=1;

        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select Books.BookID, Books.BookName,Books.ISBN,Books.Author,Books.Publisher, IssuedBook.UserID from Books left outer join IssuedBook on Books.BookID= IssuedBook.BookID;",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
        
            String Row[];
            String Check="";
            Row = new String[colnum];
            
            while(rs.next()) {
                for(int i=1;i<=colnum;i++){
                    if(i==colnum) {
                        if(rs.getString(i)==null) {
                            Row[i-1]="Dostępna";
                            model.addRow(Row);
                        }
                        else {
                            if(flag==1)
                                continue;
                            Row[i-1]="Nie dostępna";
                            model.addRow(Row);
                        }
                        System.out.println(rs.getString(i));
                    }
                    else
                        Row[i-1]=rs.getString(i);
            
                }
                  
            }
            Con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_ShowALLActionPerformed

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
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UserViewBook().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UserViewBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ALL;
    private javax.swing.JRadioButton AuthorRadio;
    private javax.swing.JRadioButton NameRadio;
    private javax.swing.JRadioButton NotIssued;
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton ShowALL;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


}
