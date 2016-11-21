/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Platform;
import javafx.concurrent.Task;


/**
 *
 * @author Jorrit
 */
public class Run extends Task<ArrayList<Edge>> implements Runnable, Observer{

    private KochFractal koch;
    private String side;
    private KochManager km;
    private int count = 0;
    
    public Run(KochFractal koch , String side, int lvl, KochManager km) {
        this.koch = koch;   
        this.side = side;
        this.koch.setLevel(lvl);
        this.koch.addObserver(this);
        this.km = km;
    }
  
    
    @Override
    public void  run() {
       
        switch(side){
            case "l": 
                koch.generateLeftEdge(); 
                km.ReqDraw();
                break;
            case "b":
                koch.generateBottomEdge();
                km.ReqDraw();
                break;
            case "r": 
                koch.generateRightEdge();
                km.ReqDraw();
                break;
            default:
                break;
        }      
            
    }

    @Override
    public void update(Observable o, Object arg) {
      km.UpdateEdges((Edge) arg);
      final Edge e = (Edge) arg;
       Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                count++;
                updateProgress(count, koch.getNrOfEdges() / 3);
                updateMessage(count + "/" + (koch.getNrOfEdges() / 3));
                km.drawWhiteEdge(e);
            }
        });
       
       try{
       switch(side){
            case "l": 
               Thread.sleep(1);
                break;
            case "b":
                Thread.sleep(1);
                break;
            case "r": 
                Thread.sleep(1);
                break;
            default:
                break;
        }      
       
       }
        catch (Exception exc) {Thread.currentThread().interrupt();}
      
    }

    @Override
    protected ArrayList<Edge> call() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
   }
    
}