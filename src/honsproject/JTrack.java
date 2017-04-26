/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honsproject;

/**
 * @author Andrew John Rore 1305997
 * @version Feb 2017
 * 
 * This class is responsible for initiating user interaction with the JTrack
 * software by creating an instance of the first GUI element. 
 */
public class JTrack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        //Creating and spawning GUI objects
        ParticipantGUI mainGUI = new ParticipantGUI();
        mainGUI.pack();
        mainGUI.setLocationRelativeTo(null);
        mainGUI.setVisible(true);
    }
}
