/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author lokyiec
 */
public class UserForm extends javax.swing.JFrame {

    public UserForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserName = new javax.swing.JTextField();
        Position = new javax.swing.JTextField();
        Year = new javax.swing.JTextField();
        Program = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Email = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(660, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });
        getContentPane().add(UserName);
        UserName.setBounds(220, 140, 300, 26);

        Position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionActionPerformed(evt);
            }
        });
        getContentPane().add(Position);
        Position.setBounds(220, 230, 300, 26);

        Year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearActionPerformed(evt);
            }
        });
        getContentPane().add(Year);
        Year.setBounds(220, 360, 68, 26);

        Program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgramActionPerformed(evt);
            }
        });
        getContentPane().add(Program);
        Program.setBounds(220, 320, 68, 26);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jButton1.setText("Dodaj ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 390, 110, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Wróć");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(330, 440, 75, 29);

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        getContentPane().add(Email);
        Email.setBounds(220, 270, 300, 26);
        getContentPane().add(Password);
        Password.setBounds(220, 180, 300, 26);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("/Users/lokyiec/Desktop/Biblioteka/background/add_student.png")); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 760, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

    private void PositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PositionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AdminSuccess.ThisLogined.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String User = UserName.getText();
        if(UsersDao.CheckIfAlready(User)){
             JOptionPane.showMessageDialog(UserForm.this, "Nazwa zajeta!","Error!", JOptionPane.ERROR_MESSAGE);
        }
        else {
            User = UserName.getText();
            String UserPass = String.valueOf(Password.getPassword());
            String UserEmail = Email.getText();
            Calendar cal = Calendar.getInstance();
            String Date;
            String RDate = String.valueOf(cal.get(Calendar.DATE));
            String RMonth =  String.valueOf(cal.get(Calendar.MONTH)+1);
            String RYear= String.valueOf(cal.get(Calendar.YEAR));
            Date = RYear+"-"+RMonth+"-"+RDate;
                
            if(UsersDao.AddUser(User,UserPass,UserEmail,Date)!=0) {
                JOptionPane.showMessageDialog(UserForm.this, "Uzytkownik pomyślnie dodany","Adding New User!", JOptionPane.ERROR_MESSAGE);
                UserName.setText("");
                Password.setText("");
                Email.setText("");
                Position.setText("");
                Program.setText("");
                Year.setText("");
            }
            else
                JOptionPane.showMessageDialog(UserForm.this, "Nie dodano","Error!", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void YearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearActionPerformed

    private void ProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProgramActionPerformed

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
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Position;
    private javax.swing.JTextField Program;
    private javax.swing.JTextField UserName;
    private javax.swing.JTextField Year;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

    private void setVisible() {
        throw new UnsupportedOperationException("Not supported"); //To change body of generated methods, choose Tools | Templates.
    }
}