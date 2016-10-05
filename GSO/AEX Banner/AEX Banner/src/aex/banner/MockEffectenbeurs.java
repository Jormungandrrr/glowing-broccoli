/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.banner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Marc
 */
public class MockEffectenbeurs implements IEffectenbeurs{
    
    Random rn = new Random();
    private List<Fonds> fondslist = new ArrayList<>();
    Timer timer = new Timer();
    
    public MockEffectenbeurs() {
        fondslist.add(new Fonds("Banaan", 100));
        fondslist.add(new Fonds("Aarbei", 150));
        fondslist.add(new Fonds("Kiwi", 200));       
        this.timer.schedule(new fondsupdate(), 0 ,2000);
    }
    
    @Override
    public List<Fonds> getKoersen() {
       return fondslist;
    }
    
    public void stop(){
       timer.cancel();
    }
    
    
    public void Update(){
        for(Fonds f : fondslist){
        f.setKoers(rn.nextDouble());
        }
    }
    class fondsupdate extends TimerTask{
    
    @Override
    public void run() {
         Update();
    }
    }
}