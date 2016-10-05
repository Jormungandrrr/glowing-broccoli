/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author Marc
 */
public class Run implements Runnable, Observer{

    KochFractal koch;
    String side;
    KochManager km;
    
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
    }
    
    }