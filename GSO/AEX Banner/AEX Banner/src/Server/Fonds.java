/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.Serializable;

/**
 *
 * @author Marc
 */
public class Fonds implements Serializable{

    private String Naam;
    private double Koers;
    
    public Fonds(String naam , double koers) {
        this.Naam = naam;
        this.Koers = koers;
    }

    public String getNaam() {
      return this.Naam;
    }

    public double getKoers() {
       return this.Koers;
    }
    
    public void setKoers(double koers){
        this.Koers += koers;
    }
    
}
