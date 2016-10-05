/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.banner;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author Marc
 */
public class BannerController {
    
    private AEXBanner banner;
    private MockEffectenbeurs effectenbeurs;
    private Timer pollingTimer;
    private String koers;

    public BannerController(AEXBanner banner) {

        this.banner = banner;
        this.effectenbeurs = new MockEffectenbeurs();
        pollingTimer = new Timer();
        pollingTimer.schedule(new fondsset(), 0 , 2000);
    }

    public void stop() {
        pollingTimer.cancel();
        effectenbeurs.stop();
    }
    
     public void UpdateKoers(){
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
       UpdateKoers();
       Platform.runLater(new Runnable(){
           @Override
           public void run(){
               banner.setKoersen(koers);
           }
       });
    }

}

}
