/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honsproject;

/**
 *
 * @author 1305997
 * @version Feb 2017
 */
public class HonsProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        //Creating and spawning GUI objects
        MainGUI mainGUI = new MainGUI();
        mainGUI.pack();
        mainGUI.setLocationRelativeTo(null);
        mainGUI.setVisible(true);
    }
    
}
