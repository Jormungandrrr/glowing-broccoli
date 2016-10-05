/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.banner;

/**
 *
 * @author Marc
 */
public class Fonds implements IFonds{

    private String Naam;
    private double Koers;
    
    public Fonds(String naam , double koers) {
        this.Naam = naam;
        this.Koers = koers;
    }

    @Override
    public String getNaam() {
      return this.Naam;
    }

    @Override
    public double getKoers() {
       return this.Koers;
    }
    
    public void setKoers(double koers){
        this.Koers += koers;
    }
    
}
