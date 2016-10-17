/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import Client.AEXBanner;
import Server.MockEffectenbeurs;
import Server.Fonds;
import Shared.IEffectenbeurs;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author Marc
 */
public class BannerController {
    
    private AEXBanner banner;
    private IEffectenbeurs effectenbeurs;
    private Timer pollingTimer;
    private String koers;

    public BannerController(AEXBanner banner, IEffectenbeurs meb) throws RemoteException {

        this.banner = banner;
        this.effectenbeurs = meb;
        pollingTimer = new Timer();
        pollingTimer.schedule(new fondsset(), 0 , 2000);
    }

    public void stop() throws RemoteException {
        pollingTimer.cancel();
        effectenbeurs.stop();
    }
    
     public void UpdateKoers() throws RemoteException{
         koers = "";
         for (Fonds f : effectenbeurs.getKoersen()) {
         koers += f.getNaam() + " : ";
         koers += f.getKoers() + ", ";
         }
    }

    public String getKoers() {
        return koers;
    }
     
     
    
    class fondsset extends TimerTask{
        
    @Override
    public void run() {
        try {
            UpdateKoers();
            Platform.runLater(new Runnable(){
                @Override
                public void run(){
                    banner.setKoersen(koers);
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

}
