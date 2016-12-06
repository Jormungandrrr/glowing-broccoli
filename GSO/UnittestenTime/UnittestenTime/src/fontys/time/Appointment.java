/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Marc
 */
public class Appointment {
    
    private String subject;
    private ITimeSpan timeSpan;
    public List<Contact> invitees = new ArrayList<>();

    public Appointment(String subject , ITimeSpan timeSpan) {
        this.subject = subject;
        this.timeSpan = timeSpan;
    }
    
    public String getSubject(){
        return subject;
    }
    
    public ITimeSpan getTimeSpan(){
        return timeSpan;
    }
    
    public Iterator<Contact> invitees(){
    return invitees.iterator();
    }
    
    public boolean addContact(Contact c){
        if (invitees.contains(c)) {
            System.out.println("er is al een zelfde contact aanwezig");
            return false;
        }
        else{
        invitees.add(c);
        return true;
        }

    }
    
    public void removeContact(Contact c){
        invitees.remove(c);
    }
    
    
    
}
