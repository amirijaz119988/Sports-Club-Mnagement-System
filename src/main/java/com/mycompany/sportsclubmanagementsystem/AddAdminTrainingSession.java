/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sportsclubmanagementsystem;

import com.mycompany.sportsclubmanagementsystem.Entity.Game;
import com.mycompany.sportsclubmanagementsystem.Entity.Team;
import com.mycompany.sportsclubmanagementsystem.Entity.Venue;
import static com.mycompany.sportsclubmanagementsystem.LoginCredentials.password;
import static com.mycompany.sportsclubmanagementsystem.LoginCredentials.username;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;



/**
 *
 * @author Anum
 */
public class AddAdminTrainingSession extends javax.swing.JFrame {

    public ArrayList<Venue> VenueList = new ArrayList();
    public ArrayList<Team> TeamList = new ArrayList();


    /**
     * Creates new form AddAdminTrainingSession
     */
    public AddAdminTrainingSession() {

        
        
        initComponents();

         
         
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        jFormattedTextField1 = new JFormattedTextField(df);

    
        VenueCBFillData();
        TeamCBFillData();
        TrainerCBFillData();
      

//        jFormattedTextField1.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e) {
//                System.out.println("hhhhh");
//                char c = e.getKeyChar();
//                if (!((c >= '0') && (c <= '9')
//                        || (c == KeyEvent.VK_BACK_SPACE)
//                        || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
//                    JOptionPane.showMessageDialog(null, "Please Enter Valid");
//                    e.consume();
//                }
//            }
//        });

    }

    //to show data in venue combo box
    private void VenueCBFillData() {
        try {
            Connection mycon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521 ", "HR", "hr");
            Statement mystmt = mycon.createStatement();
            String selectQuery = "select v_id, v_name from Venue";
            ResultSet results = mystmt.executeQuery(selectQuery);
            while (results.next()) {
                Venue veu = new Venue(results.getInt("v_id"), results.getString("v_name"));
                VenueList.add(veu);
                jComboBox2.addItem(results.getString("v_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //to show data in team combo box
    private void TeamCBFillData() {
        try {
            Connection mycon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", username, password);
            Statement mystmt = mycon.createStatement();
            String selectQuery = "select te_id, te_name from Team";
            ResultSet results = mystmt.executeQuery(selectQuery);
            while (results.next()) {
                Team team = new Team(results.getInt("te_id"), results.getString("te_name"));
                TeamList.add(team);
                jComboBox3.addItem(results.getString("te_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //to show data in trainer combo box
    private void TrainerCBFillData() {
        try {
            Connection mycon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521 ", "HR", "hr");
            Statement mystmt = mycon.createStatement();
            String selectQuery = "select P_id from Trainer";
            ResultSet results = mystmt.executeQuery(selectQuery);
            while (results.next()) {
                jComboBox1.addItem(Integer.toString(results.getInt("P_id")));
            }
        } catch (Exception e) {
            System.out.println(e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Trainer by id");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add Training Session Details");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Training Session No ");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Select Venue");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Select Team");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Train till");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox1, 0, 189, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox3, 0, 189, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here
        AdminTrainingSession jf8 = new AdminTrainingSession();
        jf8.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String VenueName = jComboBox2.getSelectedItem().toString();
            int venueId = VenueList.get(0).id;
            for (int i = 0; i < VenueList.size(); i++) {
                Venue v = VenueList.get(i);
                if (v.name.equals(VenueName)) {
                    venueId = v.id;
                }
            }
            String teamName = jComboBox3.getSelectedItem().toString();
            int teamId = TeamList.get(0).id;
            for (int i = 0; i < TeamList.size(); i++) {
                Team t = TeamList.get(i);
                if (t.name.equals(teamName)) {
                    teamId = t.id;
                }
            }



            String trainerId = jComboBox1.getSelectedItem().toString();
            String sDate1 = jTextField2.getText();
      //      Date date1=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            
            
            
            Date currentDate = Date.valueOf(LocalDate.now());
            int trainingSessionId = Integer.valueOf(jTextField1.getText());
            
            

            Connection mycon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521 ", "HR", "hr");
            //validate training session id
                        PreparedStatement stmt = mycon.prepareStatement("select *\n"
                    + "from training_session tb\n"
                    + "where tr_id=?");
            stmt.setInt(1, trainingSessionId);
            System.out.println(trainingSessionId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"This Training Session already exist");
                return;
            }
            
            
            //validate trainer not already assign to the selected team
            stmt = mycon.prepareStatement("select *\n"
                    + "from trained_by tb\n"
                    + "where tb.team_te_id = ? and tb.trainer_p_id=?");
            stmt.setInt(1, teamId);
            stmt.setInt(2, Integer.valueOf(trainerId));
            results = stmt.executeQuery();
            
            

            if (results.next()) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"Ooops! This Trainer has already been booked by another team. Try adding new trainer");
                return;
            }

            //insert into training session
             stmt = mycon.prepareStatement("insert into training_session values(?,?,?,?)");
            stmt.setInt(1, trainingSessionId);
            stmt.setString(2, sDate1);
            stmt.setInt(3, venueId);
            stmt.setInt(4, Integer.valueOf(trainerId));
            int i = stmt.executeUpdate();
            System.out.println(i + "training session added");

            //insert into trains
            stmt = mycon.prepareStatement("insert into trains values(?,?)");
            stmt.setInt(1, teamId);
            stmt.setInt(2, trainingSessionId);
            i = stmt.executeUpdate();
            System.out.println(i + "trains added");

            //insert into trained by
            stmt = mycon.prepareStatement("insert into trained_by values(?,?,?,?)");
            stmt.setInt(1, teamId);
            stmt.setInt(2, Integer.valueOf(trainerId));
            stmt.setString(3, sDate1);
            //stmt.setDate(4, Date.valueOf(jFormattedTextField1.getText()));
            stmt.setDate(4, currentDate);
            i = stmt.executeUpdate();
            System.out.println(i + "trained by added");

            mycon.close();

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Training session has been added.\nTHANKS!");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        //Clearing text field
        jTextField1.setText("");


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddAdminTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAdminTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAdminTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAdminTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAdminTrainingSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
