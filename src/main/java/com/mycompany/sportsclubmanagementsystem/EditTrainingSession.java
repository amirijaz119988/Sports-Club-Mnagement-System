/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sportsclubmanagementsystem;

import com.mycompany.sportsclubmanagementsystem.Entity.Team;
import com.mycompany.sportsclubmanagementsystem.Entity.Tournament;
import com.mycompany.sportsclubmanagementsystem.Entity.TrainingSession;
import com.mycompany.sportsclubmanagementsystem.Entity.Venue;
import static com.mycompany.sportsclubmanagementsystem.LoginCredentials.password;
import static com.mycompany.sportsclubmanagementsystem.LoginCredentials.username;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Anum
 */
public class EditTrainingSession extends javax.swing.JFrame {

    public ArrayList<Venue> VenueList = new ArrayList();
    public ArrayList<Team> TeamList = new ArrayList();

    /**
     * Creates new form EditTrainingSession
     */
    public EditTrainingSession() {
        initComponents();
        TrainingSessionCBFillData();
        VenueCBFillData();
        TeamCBFillData();
        TrainerCBFillData();

    }
    //to show TrainingSession data in combo box

    private void TrainingSessionCBFillData() {
        try {
            System.out.println("--------------1");

            Connection mycon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", username, password);
            String selectQuery = "select ts.tr_id from Training_Session ts";
            PreparedStatement mystmt = mycon.prepareStatement(selectQuery);
            ResultSet results = mystmt.executeQuery();
            while (results.next()) {
                jComboBox4.addItem(String.valueOf(results.getInt("tr_id")));
            }
            mycon.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //to show data in venue combo box
    private void VenueCBFillData() {

        try {
            String trainingSessionId = jComboBox4.getItemAt(0);
            Connection mycon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521 ", "HR", "hr");
            String selectQuery = "select * from venue";
            PreparedStatement stmt = mycon.prepareStatement(selectQuery);
            //stmt.setInt(1, Integer.valueOf(trainingSessionId));

            ResultSet results = stmt.executeQuery();
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
            String trainingSessionId = jComboBox4.getItemAt(0);
            Connection mycon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521 ", "HR", "hr");
            String selectQuery = "select * from team";
            PreparedStatement stmt = mycon.prepareStatement(selectQuery);
            //stmt.setInt(1, Integer.valueOf(trainingSessionId));

            ResultSet results = stmt.executeQuery();
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
            String trainingSessionId = jComboBox4.getItemAt(0);
            Connection mycon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521 ", "HR", "hr");
            String selectQuery = "select * from trainer";
            PreparedStatement stmt = mycon.prepareStatement(selectQuery);
            // stmt.setInt(1, Integer.valueOf(trainingSessionId));

            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                jComboBox1.addItem(results.getString("p_id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //to show data in game combo box
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Trainer by ID");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Edit");
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
        jLabel5.setText("Edit Training Session Details");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Training Session No ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Select Venue");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Select Team");

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, 0, 168, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.LEADING, 0, 168, Short.MAX_VALUE))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            /// get venue id
            String venueName = jComboBox2.getSelectedItem().toString();
            int venueId = VenueList.get(0).id;
            for (int i = 0; i < VenueList.size(); i++) {
                Venue t = VenueList.get(i);
                if (t.name.equals(venueName)) {
                    venueId = t.id;
                }
            }
            /// get team id
            String teamName = jComboBox3.getSelectedItem().toString();
            int teamId = TeamList.get(0).id;
            for (int i = 0; i < TeamList.size(); i++) {
                Team t = TeamList.get(i);
                if (t.name.equals(teamName)) {
                    teamId = t.id;
                }
            }
            String trainerId = jComboBox1.getSelectedItem().toString();
            String trainingSessionId = jComboBox4.getSelectedItem().toString();

            //get old trainerId associated with a trainingSession
            int oldTrainerId = 0;
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521 ", "HR", "hr");
            PreparedStatement stmt = con.prepareStatement("select ts.trainer_p_id from training_session ts\n"
                    + "where ts.tr_id = ?");
            stmt.setInt(1, Integer.valueOf(trainingSessionId));

            ResultSet results = stmt.executeQuery();
            System.out.println("rtyyuii");
            while (results.next()) {
                oldTrainerId = results.getInt("trainer_p_id");
            }

            //get old teamId associated with a trainingSession
            int oldTeamId = 0;
            stmt = con.prepareStatement("select team_te_id\n"
                    + "from trains \n"
                    + "where training_session_tr_id =?");
            stmt.setInt(1, Integer.valueOf(trainingSessionId));

            results = stmt.executeQuery();
            System.out.println("mnbvcxx");
            while (results.next()) {
                oldTeamId = results.getInt("team_te_id");
            }

            //update training session
            System.out.println("llllo");
            stmt = con.prepareStatement("update training_session ts\n"
                    + "set  ts.trainer_p_id = ? ,  ts.venue_v_id =? \n"
                    + "where ts.tr_id = ?");
  
            stmt.setInt(1, Integer.valueOf(trainerId));
            stmt.setInt(2, venueId);
            stmt.setInt(3, Integer.valueOf(trainingSessionId));
            System.out.println("ppppppppp");
            int i = stmt.executeUpdate();
            
            System.out.println(i + "trainigSession record updated");

            //update trains
            stmt = con.prepareStatement("update trains ts\n"
                    + "set ts.team_te_id=?\n"
                    + "where ts.training_session_tr_id = ?");
            stmt.setInt(1, teamId);
            stmt.setInt(2, Integer.valueOf(trainingSessionId));
            i = stmt.executeUpdate();
            System.out.println(i + "trains record updated");

            //update trained by
            stmt = con.prepareStatement("update trained_by tb\n"
                    + "set tb.trainer_p_id =? , tb.team_te_id =?\n"
                    + "where tb.trainer_p_id =? and tb.team_te_id =?");
            System.out.println("oldTrainerId"+oldTrainerId);
            System.out.println("oldTeamId"+oldTeamId);
            stmt.setInt(1, Integer.valueOf(trainerId));
            stmt.setInt(2, teamId);
            stmt.setInt(3, oldTrainerId);
            stmt.setInt(4, oldTeamId);
            i = stmt.executeUpdate();
            System.out.println(i + "trainedby record updated");
            
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Training session has been Updated.\nTHANKS!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here
        AdminTrainingSession jf8 = new AdminTrainingSession();
        jf8.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox4ActionPerformed

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
            java.util.logging.Logger.getLogger(EditTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditTrainingSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
