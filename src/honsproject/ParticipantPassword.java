/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honsproject;

/**
 *
 * @author 1305997
 */
public class ParticipantPassword {
    
    //password objects represented as array of chars as more secure than Strings
    private char[] pass = new char[]{'p','a','s','s','w','o','r','d'};

    public ParticipantPassword() {
    }
    
    //method returns an array of chars representing the password for the Participant details screen
    public char[] getPassword(){
        return this.pass;
    }
    
    
    
}
