/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static mainlibrary.AdminSuccess.ThisLogined;

/**
 *
 * @author lokyiec
 */
public class BookForm extends javax.swing.JFrame {
    
    public BookForm() {
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

        BookName = new javax.swing.JTextField();
        Publisher = new javax.swing.JTextField();
        Author = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Genre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(660, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        BookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookNameActionPerformed(evt);
            }
        });
        getContentPane().add(BookName);
        BookName.setBounds(220, 140, 290, 26);

        Publisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherActionPerformed(evt);
            }
        });
        getContentPane().add(Publisher);
        Publisher.setBounds(220, 230, 290, 26);

        Author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorActionPerformed(evt);
            }
        });
        getContentPane().add(Author);
        Author.setBounds(220, 180, 290, 26);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jButton1.setText("Dodaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 330, 110, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Wróć");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(300, 390, 75, 29);

        Genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenreActionPerformed(evt);
            }
        });
        getContentPane().add(Genre);
        Genre.setBounds(220, 270, 290, 26);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/lokyiec/Desktop/Biblioteka/background/add_book.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -20, 660, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookNameActionPerformed

    private void PublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublisherActionPerformed

    private void AuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ThisLogined.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String BookN = BookName.getText();
        String AuthorN = Author.getText();
        String PublisherN = Publisher.getText();
        String IsbnN = Genre.getText();
        
        if(BookDao.PublisherValidate(PublisherN)){}
        else {
            if(BookDao.AddPublisher(PublisherN)!=0){
                 // JOptionPane.showMessageDialog(BookForm.this, "Sorry, Publisher can't be added!","Publisher Error!", JOptionPane.ERROR_MESSAGE);
             }
        }
        if(BookDao.SaveBook(BookN,AuthorN,PublisherN,IsbnN)!=0) {
            JOptionPane.showMessageDialog(BookForm.this, "Ksiazka dodana pomyślnie!","Sukces", JOptionPane.ERROR_MESSAGE);
            BookName.setText("");
            Author.setText("");
            Publisher.setText("");
            Genre.setText("");
        }
        else
            JOptionPane.showMessageDialog(BookForm.this, "Nie mozna dodac ksiazki!","Error!", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void GenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenreActionPerformed

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
            java.util.logging.Logger.getLogger(BookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Author;
    private javax.swing.JTextField BookName;
    private javax.swing.JTextField Genre;
    private javax.swing.JTextField Publisher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
