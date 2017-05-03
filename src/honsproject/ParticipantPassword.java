/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honsproject;

/**
 *
 * @author Andrew John Rore 1305997
 * @version Feb 2017
 */
public class ParticipantPassword {
    
    //password objects represented as array of chars as more secure than Strings
    private char[] pass = new char[]{'P','a','l','l','a','d','i','u','m','1'};

    public ParticipantPassword() {
    }
    
    //method returns an array of chars representing the password for the Participant details screen
    public char[] getPassword(){
        return this.pass;
    }
    
    
    
}
