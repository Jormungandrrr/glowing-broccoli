/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.Fonds;
import Shared.IEffectenbeurs;
import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc
 */
public class MockEffectenbeurs extends UnicastRemoteObject implements IEffectenbeurs{
    
    Random rn = new Random();
    private List<Fonds> fondslist = new ArrayList<>();
    Timer timer = new Timer();
    
    public MockEffectenbeurs() throws RemoteException{
        fondslist.add(new Fonds("Banaan", 100));
        fondslist.add(new Fonds("Aarbei", 150));
        fondslist.add(new Fonds("Kiwi", 200));       
        this.timer.schedule(new fondsupdate(), 0 ,2000);
    }
    
    @Override
    public List<Fonds> getKoersen() throws RemoteException {
       return fondslist;
    }
    
    public int getNumberOfFonds() throws RemoteException {
        System.out.println("StudentAdmin: Request for number of students");
        return fondslist.size();
    }
    
    public Fonds getFond(int nr) throws RemoteException {
        System.out.println("StudentAdmin: Request for student with number " + nr);
        if (nr >= 0 && nr < fondslist.size()) {
            return fondslist.get(nr);
        }
        else {
            return null;
        }
    }
    
    public Fonds addFond(String name, int koers) throws RemoteException {
        Fonds student = new Fonds(name,koers);
        fondslist.add(student);
        System.out.println("StudentAdmin: Student " + student.toString() + " added to student administration");
        return student;
    }
    
    public void stop() throws RemoteException{
       timer.cancel();
    }
    
    public void Update()throws RemoteException{
        for(Fonds f : fondslist){
        f.setKoers(rn.nextDouble());
        }
    }
    class fondsupdate extends TimerTask{
    
    @Override
    public void run() {
        try {
            Update();
        } catch (RemoteException ex) {
            Logger.getLogger(MockEffectenbeurs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}