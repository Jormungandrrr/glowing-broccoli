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
public class Contact {
    private String name;
    public List<Appointment> agenda = new ArrayList<>();

    public Contact(String name) {
        this.name = name;
    }
    
    
    public String getName(){
    return name;
    }
    
    public boolean addAppointment(Appointment a){
        if (agenda.contains(a)) {
            System.out.println("er is al een zelfde afspraak aanwezig");
            return false;
        }
        else{
        agenda.add(a);
        return true;
        }

    }
    
    public boolean removeAppointment(Appointment a){
        if (agenda.contains(a)) {
                agenda.remove(a);
                return true;
        }
        else{
                System.out.println("beschreven afspraak is niet aanwezig");
                return false;
        }
    }
    
    public Iterator<Appointment> appointments(){
        Iterator itr = agenda.iterator();
        return itr;
    }
        
    
}
