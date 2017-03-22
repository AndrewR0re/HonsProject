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
public class Participant {
    
    private String id;
    private String name;
    private String email;

    public Participant(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    
    //Methods handling retreival and assignment of Participant ID field
    
    //Method sets value of Participant ID field
    public void setID(String id){
        this.id = id;
    }
    
    //Method returns value of Participant ID field
    public String getID(){
        return this.id;
    }
    
    
    //Methods handling retreival and assignment of Participant Name field
    
    //Method sets value of Participant Name field
    public void setName(String name){
        this.name = name;
    }
    
    //Method returns value of Participant Name field
    public String getName(){
        return this.name;
    }
    
    
    //Methods handling retreival and assignment of Participant Email field
    
    //Method sets value of Participant Email field
    public void setEmail(String email){
        this.email = email;
    }
    
    //Method returns value of Participant Email field
    public String getEmail(){
        return this.email;
    }
}