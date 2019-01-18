/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import static mainlibrary.AdminSuccess.ThisLogined;

/**
 *
 * @author lokyiec
 */
public class IssueBookForm extends javax.swing.JFrame {

    public IssueBookForm() {
        initComponents();
        int year;
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        String TodayYear;
        TodayYear = String.valueOf(year);
        IYear.setText(TodayYear);
        String TodayMonth = String.valueOf(cal.get(Calendar.MONTH)+1);
        IMonth.setText(TodayMonth);
        String TodayDate = String.valueOf(cal.get(Calendar.DATE));
        IDate.setText(TodayDate);
        
        Calendar addcal = null;
        addcal = cal;
        addcal.add(Calendar.DAY_OF_YEAR,15);

        RDate.setText(String.valueOf(addcal.get(Calendar.DATE)));
        RMonth.setText(String.valueOf(addcal.get(Calendar.MONTH)+1));
        RYear.setText(String.valueOf(addcal.get(Calendar.YEAR)));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        UserID = new javax.swing.JTextField();
        BookID = new javax.swing.JTextField();
        IMonth = new javax.swing.JTextField();
        RMonth = new javax.swing.JTextField();
        IYear = new javax.swing.JTextField();
        IDate = new javax.swing.JTextField();
        RYear = new javax.swing.JTextField();
        RDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(121, 22, 127));
        setForeground(new java.awt.Color(30, 51, 252));
        setPreferredSize(new java.awt.Dimension(660, 480));
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jButton1.setText("Potwierdź");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 310, 130, 43);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton2.setText("Wróć");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(280, 360, 86, 30);

        UserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIDActionPerformed(evt);
            }
        });
        getContentPane().add(UserID);
        UserID.setBounds(220, 170, 300, 30);

        BookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookIDActionPerformed(evt);
            }
        });
        getContentPane().add(BookID);
        BookID.setBounds(220, 120, 300, 30);

        IMonth.setEditable(false);
        IMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMonthActionPerformed(evt);
            }
        });
        getContentPane().add(IMonth);
        IMonth.setBounds(270, 210, 40, 30);
        getContentPane().add(RMonth);
        RMonth.setBounds(270, 260, 40, 30);

        IYear.setEditable(false);
        getContentPane().add(IYear);
        IYear.setBounds(330, 210, 59, 30);

        IDate.setEditable(false);
        IDate.setToolTipText("");
        IDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDateActionPerformed(evt);
            }
        });
        getContentPane().add(IDate);
        IDate.setBounds(220, 210, 40, 30);

        RYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RYearActionPerformed(evt);
            }
        });
        getContentPane().add(RYear);
        RYear.setBounds(330, 260, 59, 30);
        getContentPane().add(RDate);
        RDate.setBounds(220, 260, 40, 30);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("/Users/lokyiec/Desktop/Biblioteka/background/issue_book.png")); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, -40, 690, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int BookIDV;
        BookIDV = Integer.parseInt(BookID.getText());
        int UserIDV;
        UserIDV = Integer.parseInt(UserID.getText());
        
        String IFDate = IYear.getText() + "-"+IMonth.getText()+"-"+IDate.getText();
        String RFDate = RYear.getText() + "-"+RMonth.getText()+"-"+RDate.getText();
        System.out.println(IFDate);
        
        //Date IFDDate = cal.getDate();
        
     
        
        if(TransBookDao.BookValidate(BookID.getText()) && TransBookDao.UserValidate(UserID.getText())) {
          
            if(TransBookDao.Check(UserIDV)==0)
               JOptionPane.showMessageDialog(IssueBookForm.this, "Uzytkownik przekroczyl limit","WypozyczanieError!", JOptionPane.ERROR_MESSAGE); 
            else {
            if(TransBookDao.IssueBook(BookIDV, UserIDV, IFDate, RFDate)!=0) {
                JOptionPane.showMessageDialog(IssueBookForm.this, "Ksiazka wypozyczona!","Sukces!", JOptionPane.ERROR_MESSAGE);
                BookID.setText("");
                UserID.setText("");
            }
            else
              JOptionPane.showMessageDialog(IssueBookForm.this, "Nie mozna wypozyczyc ksiazki!","Error!", JOptionPane.ERROR_MESSAGE);
            }
            
            
        } else {
            if(TransBookDao.UserValidate(UserID.getText()))
                JOptionPane.showMessageDialog(IssueBookForm.this, "Ksiazka jest niedostepna w zbiorze!","Error!", JOptionPane.ERROR_MESSAGE);
            else
                if(TransBookDao.BookValidate(BookID.getText()))
                    JOptionPane.showMessageDialog(IssueBookForm.this, "Uzytkownik niedostepny!","Error!", JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(IssueBookForm.this, "Ksiazka i uzytkownik niedostepne!","Error!", JOptionPane.ERROR_MESSAGE);
        }
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ThisLogined.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void UserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserIDActionPerformed

    private void IDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDateActionPerformed

    private void IMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IMonthActionPerformed

    private void RYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RYearActionPerformed

    private void BookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookIDActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBookForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookID;
    private javax.swing.JTextField IDate;
    private javax.swing.JTextField IMonth;
    private javax.swing.JTextField IYear;
    private javax.swing.JTextField RDate;
    private javax.swing.JTextField RMonth;
    private javax.swing.JTextField RYear;
    private javax.swing.JTextField UserID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
