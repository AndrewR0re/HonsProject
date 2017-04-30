/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honsproject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


/**
 *
 * @author Andrew John Rore 1305997
 * @version Mar 2017
 */
public class ParticipantDataGUI extends javax.swing.JFrame {
    
    public static Participant participant;
    public int selectedVisualisationMode = 0;
    public String pathRoot = "resources/";
    public static ImageIcon image1;
    public static ImageIcon image2;
    public static boolean dbUnlocked = false;
    public int pair;

    /**
     * Creates new form ParticipantData
     */
    public ParticipantDataGUI(Participant p) throws Exception {
        
        this.participant = p;
        initComponents();
        initialiseData();
        setDbUnlocked();
        btnRefresh.doClick();
    }
    
    public Participant getParticipant(){
        return this.participant;
    }
    
    public void initialiseData() throws Exception{
        
        this.jLabelParticipantName.setText("Showing Experimental Data of Participant : " + this.getParticipant().getName());
        
        this.radioGazePlot.setSelected(true);
        
        this.imagePairAnnotationField.setLineWrap(true);
        this.imagePairAnnotationField.setWrapStyleWord(true);
    }
    
    public static void setDbUnlocked(){
        
        ParticipantDataGUI.dbUnlocked = true;
    }
    
    public String readPairNotesFromFile() throws Exception{
        
        String text = "";
        
        FileReader file = new FileReader(pathRoot + this.participant.getName() + "/" + (this.selectedPair.getSelectedItem().toString()) + "/" + "imagePairNotes.txt");
        BufferedReader reader = new BufferedReader(file);
        String line = reader.readLine();
        
        while(line!=null){
            text+=line;
            line = reader.readLine();
        }
        reader.close();
        return text;
    }
    
    public void writePairNotesToFile() throws Exception{
        
        String text = this.imagePairAnnotationField.getText();
        
        File newFile = new File(pathRoot + this.participant.getName() + "/" + (this.selectedPair.getSelectedItem().toString()) + "/" + "imagePairNotes.txt");
        FileWriter fw = new FileWriter(newFile);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(text);
        bw.close();
    }
    
    public static ImageIcon resize(ImageIcon image, int width, int height){
        
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image.getImage(),0,0,width,height,null);
        g2d.dispose();
        return new ImageIcon(bi);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabelParticipantName = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        imageLabel2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selectedPair = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        radioGazePlot = new javax.swing.JRadioButton();
        radioHeatmap = new javax.swing.JRadioButton();
        btnRefresh = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        imageLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        imagePairAnnotationField = new javax.swing.JTextArea();
        btnEditImageAnnotation = new javax.swing.JButton();
        btnZoom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Experimental Data");

        jLabelParticipantName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelParticipantName.setText("Showing experimental data of Participant:");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        imageLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Select Image Pair:");

        selectedPair.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pair 1", "Pair 2", "Pair 3", "Pair 4", "Pair 5", "Pair 6", "Pair 7", "Pair 8", "Pair 9", "Pair 10", "Pair 11", "Pair 12" }));
        selectedPair.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectedPairItemStateChanged(evt);
            }
        });
        selectedPair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedPairActionPerformed(evt);
            }
        });

        jLabel3.setText("Select Visualisation Mode:");

        radioGazePlot.setText("Gaze Plot");
        radioGazePlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGazePlotActionPerformed(evt);
            }
        });

        radioHeatmap.setText("Heatmap");
        radioHeatmap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioHeatmapActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel4.setText("Image Pair Notes:");

        imageLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        imagePairAnnotationField.setColumns(20);
        imagePairAnnotationField.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        imagePairAnnotationField.setRows(5);
        jScrollPane2.setViewportView(imagePairAnnotationField);

        btnEditImageAnnotation.setText("Edit");
        btnEditImageAnnotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditImageAnnotationActionPerformed(evt);
            }
        });

        btnZoom.setText("Zoom");
        btnZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelParticipantName, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(radioGazePlot)
                                        .addComponent(radioHeatmap, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectedPair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditImageAnnotation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnZoom)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelParticipantName)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addComponent(imageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(selectedPair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(radioGazePlot))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioHeatmap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(btnRefresh)
                                    .addComponent(btnEditImageAnnotation))
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnZoom))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        ParticipantGUI participantGui = new ParticipantGUI();
        participantGui.setLocationRelativeTo(this);
        participantGui.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void radioGazePlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGazePlotActionPerformed
        
        if(this.radioGazePlot.isSelected()){
            this.radioHeatmap.setSelected(false);
            this.selectedVisualisationMode = 0;
        }
    }//GEN-LAST:event_radioGazePlotActionPerformed

    private void radioHeatmapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioHeatmapActionPerformed
        
        if(this.radioHeatmap.isSelected()){
            this.radioGazePlot.setSelected(false);
            this.selectedVisualisationMode = 1;
        }
    }//GEN-LAST:event_radioHeatmapActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        
        try {
            readPairNotesFromFile();
        } catch (Exception ex) {
            Logger.getLogger(ParticipantDataGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.pair = (this.selectedPair.getSelectedIndex()+1);
        String pairSelection = this.selectedPair.getSelectedItem().toString();
        String pairSelectionForPath = "";
        String image1Designation = "";
        String image2Designation = "";
        
        switch(pairSelection){
            case "Pair 1" : 
                pairSelectionForPath = "Pair 1";
                image1Designation = "1A";
                image2Designation = "2B";
                break;
            case "Pair 2" : 
                pairSelectionForPath = "Pair 2";
                image1Designation = "1A";
                image2Designation = "2A";
                break;
            case "Pair 3" : 
                pairSelectionForPath = "Pair 3";
                image1Designation = "1A";
                image2Designation = "2C";
                break;
            case "Pair 4" : 
                pairSelectionForPath = "Pair 4";
                image1Designation = "1A";
                image2Designation = "2E";
                break;
            case "Pair 5" : 
                pairSelectionForPath = "Pair 5";
                image1Designation = "1B";
                image2Designation = "3F";
                break;
            case "Pair 6" : 
                pairSelectionForPath = "Pair 6";
                image1Designation = "1B";
                image2Designation = "3A";
                break;
            case "Pair 7" : 
                pairSelectionForPath = "Pair 7";
                image1Designation = "1B";
                image2Designation = "3D";
                break;
            case "Pair 8" : 
                pairSelectionForPath = "Pair 8";
                image1Designation = "1B";
                image2Designation = "3B";
                break;
            case "Pair 9" : 
                pairSelectionForPath = "Pair 9";
                image1Designation = "1C";
                image2Designation = "4F";
                break;
            case "Pair 10" : 
                pairSelectionForPath = "Pair 10";
                image1Designation = "1C";
                image2Designation = "4D";
                break;
            case "Pair 11" : 
                pairSelectionForPath = "Pair 11";
                image1Designation = "1C";
                image2Designation = "4E";
                break;
            case "Pair 12" : 
                pairSelectionForPath = "Pair 12";
                image1Designation = "1C";
                image2Designation = "4C";
                break;
        default :
            pairSelectionForPath = "Pair 1";
            image1Designation = "";
            image2Designation = "";
            break;
        }
        
        String constructedPath1 = this.pathRoot;
        String constructedPath2 = this.pathRoot;
        
        constructedPath1 += this.getParticipant().getName() + "/" + pairSelectionForPath + "/" + image1Designation + "/" + Integer.toString(this.selectedVisualisationMode) + "/" + "img.png";
        constructedPath2 += this.getParticipant().getName() + "/" + pairSelectionForPath + "/" + image2Designation + "/" + Integer.toString(this.selectedVisualisationMode) + "/" + "img.png";
        
        this.image1 = new ImageIcon(constructedPath1);
        this.image2 = new ImageIcon(constructedPath2);
        
        this.imageLabel1.setIcon(resize(image1,442,331));
        this.imageLabel2.setIcon(resize(image2,442,331));     
        
        try {
            this.imagePairAnnotationField.setText(readPairNotesFromFile());
        } catch (Exception ex) {
            Logger.getLogger(ParticipantDataGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void selectedPairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedPairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedPairActionPerformed

    private void btnEditImageAnnotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditImageAnnotationActionPerformed
        Runtime rt = Runtime.getRuntime();
        
        String filePath = pathRoot + this.participant.getName() + "/" + (this.selectedPair.getSelectedItem().toString()) + "/" + "imagePairNotes.txt";
        
        try {
            Process p=rt.exec("notepad "+filePath);
        } catch (IOException ex) {
            Logger.getLogger(ParticipantDataGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditImageAnnotationActionPerformed

    private void selectedPairItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectedPairItemStateChanged
        this.btnRefresh.doClick();
    }//GEN-LAST:event_selectedPairItemStateChanged

    private void btnZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomActionPerformed
        
        ZoomedImagePairGUI zoom = new ZoomedImagePairGUI(this.participant,image1,image2);
        zoom.setLocationRelativeTo(this);
        zoom.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnZoomActionPerformed

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
            java.util.logging.Logger.getLogger(ParticipantDataGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParticipantDataGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParticipantDataGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParticipantDataGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ParticipantDataGUI(participant).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ParticipantDataGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditImageAnnotation;
    private static javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnZoom;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel imageLabel1;
    private javax.swing.JLabel imageLabel2;
    private javax.swing.JTextArea imagePairAnnotationField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelParticipantName;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioGazePlot;
    private javax.swing.JRadioButton radioHeatmap;
    private javax.swing.JComboBox<String> selectedPair;
    // End of variables declaration//GEN-END:variables
}
