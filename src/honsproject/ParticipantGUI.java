/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honsproject;

/**
 * @author Andrew John Rore 1305997
 * @version Mar 2017
 */
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ParticipantGUI extends javax.swing.JFrame {

    private static ArrayList<Participant> listOfParticipants = new ArrayList<>();
    private ArrayList<JTextField> idList = new ArrayList<>();
    private ArrayList<JTextField> nameList = new ArrayList<>();
    private ArrayList<JTextField> emailList = new ArrayList<>();
    public static DefaultTableModel model;
    public static ArrayList<Participant> participantArray = new ArrayList<>();
    public static boolean allowedDeeperAccess = false;

    /**
     * Creates new form ParticipantGUI
     */
    public ParticipantGUI() {
        initComponents();
        model = (DefaultTableModel) participantDetailTable.getModel();
        participantDetailTable.setModel(model);
        wipeParticipantList();
        initialiseParticipants();
    }

    public static void updateTable() {

        try {
            model.setRowCount(0);
            //Instantiation of String and char[] variables representing host, username and password for Database
            String host = "jdbc:derby://localhost:1527/HonsProjectDatabase";
            String username = "andrew";
            char[] passwordArray = new char[]{'P', 'a', 'l', 'l', 'a', 'd', 'i', 'u', 'm', '1'};
            String password = "";

            for (char currentChar : passwordArray) {
                password += currentChar;
            }

            //Statement initiates connection with Database
            Connection con = DriverManager.getConnection(host, username, password);

            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM PARTICIPANTDETAILS");

            while (rs.next()) {
                int current_ID = rs.getInt("ID");
                String current_FName = rs.getString("FIRST_NAME");
                String current_SName = rs.getString("LAST_NAME");
                String current_Email = rs.getString("EMAIL");

                Object[] row = new Object[]{current_ID, current_FName + " " + current_SName, current_Email};

                model.addRow(row);
            }
        } 
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
    public int countParticipants(){
        int participantCount = 0;
        
        try {
            //Instantiation of String and char[] variables representing host, username and password for Database
            String host = "jdbc:derby://localhost:1527/HonsProjectDatabase";
            String username = "andrew";
            char[] passwordArray = new char[]{'P', 'a', 'l', 'l', 'a', 'd', 'i', 'u', 'm', '1'};
            String password = "";

            for (char currentChar : passwordArray) {
                password += currentChar;
            }

            //Statement initiates connection with Database
            Connection con = DriverManager.getConnection(host, username, password);

            Statement rowCountStatement = con.createStatement();

            ResultSet rowCountResult = rowCountStatement.executeQuery("SELECT COUNT(*) FROM PARTICIPANTDETAILS");

            rowCountResult.next();
            participantCount= rowCountResult.getInt(1);
            rowCountStatement.close();

        }

        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
      
        return participantCount;
    }
    
    public static void wipeParticipantList(){
        
        participantArray.clear();
    }
    
    public void initialiseParticipants(){
        
        int participantCount = countParticipants();
        
        //for(int i=0 ; i<participantCount ; i++){
            
            try {
                //Instantiation of String and char[] variables representing host, username and password for Database
                String host = "jdbc:derby://localhost:1527/HonsProjectDatabase";
                String username = "andrew";
                char[] passwordArray = new char[]{'P', 'a', 'l', 'l', 'a', 'd', 'i', 'u', 'm', '1'};
                String password = "";

                for (char currentChar : passwordArray) {
                    password += currentChar;
                }

                //Statement initiates connection with Database
                Connection con = DriverManager.getConnection(host, username, password);

                Statement statement = con.createStatement();

                ResultSet rs = statement.executeQuery("SELECT * FROM PARTICIPANTDETAILS");

                while (rs.next()) {
                    int current_ID = rs.getInt("ID");

                    String current_Name = rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME");
                    String current_Email = rs.getString("EMAIL");

                    participantArray.add(new Participant(Integer.toString(current_ID), current_Name, current_Email));
                }
            } 
        
            catch (SQLException err) {
                System.out.println(err.getMessage());
            }   
        //}
    }
    
    public static void liftDbRestriction(){
        
        allowedDeeperAccess = true;
    }
    
    public static void engageDbRestriction(){
        
        wipeParticipantList();
        allowedDeeperAccess= false;
    }
    
    public static ArrayList getParticipantArrayList(){
        
        ArrayList<Participant> participantArrayList = new ArrayList<>();
        
        
        for(int i = 0 ; i<participantArray.size() ; i++){
            participantArrayList.add(participantArray.get(i));
        }
        
        return participantArrayList;
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
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        participantExitBtn = new javax.swing.JButton();
        jLabelInfo = new javax.swing.JLabel();
        btnAddParticipant = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        participantDetailTable = new javax.swing.JTable();
        btnViewData = new javax.swing.JButton();
        btnLoadDatabase = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to JTrack");
        setBounds(new java.awt.Rectangle(100, 0, 0, 0));

        participantExitBtn.setText("Exit");
        participantExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantExitBtnActionPerformed(evt);
            }
        });

        jLabelInfo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelInfo.setText("List of Participants assisting in experiments:");

        btnAddParticipant.setText("Add Participant");
        btnAddParticipant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddParticipantActionPerformed(evt);
            }
        });

        participantDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Email Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(participantDetailTable);
        if (participantDetailTable.getColumnModel().getColumnCount() > 0) {
            participantDetailTable.getColumnModel().getColumn(0).setMinWidth(10);
            participantDetailTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            participantDetailTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        btnViewData.setText("View Eye Tracking Data");
        btnViewData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDataActionPerformed(evt);
            }
        });

        btnLoadDatabase.setText("Load Database");
        btnLoadDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDatabaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelInfo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(participantExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAddParticipant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnViewData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLoadDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelInfo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoadDatabase)
                        .addGap(20, 20, 20)
                        .addComponent(btnAddParticipant)
                        .addGap(20, 20, 20)
                        .addComponent(btnViewData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(participantExitBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void participantExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantExitBtnActionPerformed
        
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to Exit?","Exit?", JOptionPane.OK_CANCEL_OPTION);

        if (result==0){
            System.exit(0);
        }

    }//GEN-LAST:event_participantExitBtnActionPerformed

    private void btnAddParticipantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddParticipantActionPerformed
        
        if(allowedDeeperAccess){
        
            JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

            JLabel firstNameLabel = new JLabel("First name: ");
            JTextField newParticipantFNameField = new JTextField(10);

            panel.add(firstNameLabel);
            panel.add(newParticipantFNameField);

            JLabel secondNameLabel = new JLabel("Second name: ");
            JTextField newParticipantSNameField = new JTextField(10);

            panel.add(secondNameLabel);
            panel.add(newParticipantSNameField);

            JLabel emailLabel = new JLabel("Email address: ");
            JTextField newParticipantEmailField = new JTextField(10);

            panel.add(emailLabel);
            panel.add(newParticipantEmailField);

            int value = JOptionPane.showConfirmDialog(null, panel, "Enter New Participant Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (value == JOptionPane.OK_OPTION) {

                String newParticipantFirstName = newParticipantFNameField.getText();
                String newParticipantSecondName = newParticipantSNameField.getText();
                String newParticipantName = newParticipantFNameField.getText() + newParticipantSNameField.getText();
                String newParticipantEmail = newParticipantEmailField.getText();

                boolean nullValueFailsafe = true;

                if(newParticipantFirstName.equals("") || newParticipantSecondName.equals("") || newParticipantEmail.equals("")){
                    nullValueFailsafe = false;
                }

                if(nullValueFailsafe){
                    try {

                        //Instantiation of String and char[] variables representing host, username and password for Database
                        String host = "jdbc:derby://localhost:1527/HonsProjectDatabase";
                        String username = "andrew";
                        char[] passwordArray = new char[]{'P', 'a', 'l', 'l', 'a', 'd', 'i', 'u', 'm', '1'};
                        String password = "";

                        for (char currentChar : passwordArray) {
                            password += currentChar;
                        }

                        //Statement initiates connection with Database

                        Connection con = DriverManager.getConnection(host, username, password);

                        int rowCount = countParticipants();

                        Statement insertStatement = con.createStatement();

                        rowCount++;

                        int c = insertStatement.executeUpdate("INSERT INTO PARTICIPANTDETAILS (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (" + rowCount + ",'" + newParticipantFirstName + "','" + newParticipantSecondName + "','" + newParticipantEmail + "')");

                        insertStatement.close();
                        con.close();

                        updateTable();

                        participantArray.add(new Participant(Integer.toString(countParticipants()), newParticipantFirstName + " " + newParticipantSecondName, newParticipantEmail));

                        initialiseParticipants();
                    }

                    catch (SQLException err) {
                        System.out.println(err.getMessage());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incomplete Participant details" + "\n" + "Enter full details", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null,"Access to Database Retricted." + "\n" + "Load Database to Lift Restrictions.", "Error!", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnAddParticipantActionPerformed

    private void btnViewDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDataActionPerformed
        
        if(allowedDeeperAccess){
            ChooseParticipantDataGUI choice = new ChooseParticipantDataGUI();
            choice.setLocationRelativeTo(this);
            choice.setVisible(true);
        }
        
        else{
            JOptionPane.showMessageDialog(null,"Access to Database Retricted." + "\n" + "Load Database to Lift Restrictions.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnViewDataActionPerformed

    private void btnLoadDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDatabaseActionPerformed
        
        DbPasswordCheck passwordCheck = new DbPasswordCheck();
        
        passwordCheck.setLocationRelativeTo(this);
        passwordCheck.setVisible(true);
    }//GEN-LAST:event_btnLoadDatabaseActionPerformed

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
            java.util.logging.Logger.getLogger(ParticipantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParticipantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParticipantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParticipantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParticipantGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddParticipant;
    private javax.swing.JButton btnLoadDatabase;
    private javax.swing.JButton btnViewData;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable participantDetailTable;
    private javax.swing.JButton participantExitBtn;
    // End of variables declaration//GEN-END:variables
}
