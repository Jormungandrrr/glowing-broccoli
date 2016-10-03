/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;


/**
 *
 * @author Marc
 */
public class Run implements Runnable{

    KochFractal koch;
    String side;
    
    public Run(KochFractal koch , String side) {
        this.koch = koch;   
        this.side = side;
    }
  
    
    @Override
    public synchronized void  run() {
       
        switch(side){
            case "l": 
                koch.generateLeftEdge();                 
                break;
            case "b":
                koch.generateBottomEdge();
                break;
            case "r": 
                koch.generateRightEdge();
                break;
            default:
                break;
        }      
            
    }
    }