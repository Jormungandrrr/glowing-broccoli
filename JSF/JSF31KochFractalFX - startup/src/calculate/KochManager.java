/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import jsf31kochfractalfx.JSF31KochFractalFX;
import timeutil.TimeStamp;

/**
 *
 * @author Marc
 */
public class KochManager implements Observer{

    private JSF31KochFractalFX application;
    KochFractal koch;
    private List<Edge> EdgeList;
    
    public KochManager(JSF31KochFractalFX application) {
    this.application = application;
    EdgeList = new ArrayList<Edge>();
    }

    @Override
    public void update(Observable o, Object arg) {
        koch = (KochFractal) o;
        application.drawEdge((Edge)arg);
        EdgeList.add((Edge)arg);
    }

    
    public synchronized void drawEdges() {
    application.clearKochPanel();

    for (Edge e: EdgeList)
    {
    application.drawEdge(e);
    
    }
    
    }
    


    public synchronized void changeLevel(int nxt) {
    EdgeList.clear();
    TimeStamp drawprocess = new TimeStamp();
    drawprocess.setBegin("begin process");
    System.out.println("begin process");


    koch.setLevel(nxt);
    
    Run runl = new Run(koch , "l");
    Run runb = new Run(koch , "b");
    Run runr = new Run(koch , "r");
    
    Thread threadl = new Thread(runl);
    Thread threadb = new Thread(runb);
    Thread threadr = new Thread(runr);
    
    threadl.start();
    threadb.start();
    threadr.start();
    
    drawEdges();
    
 
    application.setTextNrEdges(String.valueOf(koch.getNrOfEdges()));
    drawprocess.setEnd("end of process");
    System.out.println("end of process");
    application.setTextCalc(drawprocess.toString());
}

    //vragen
    // 9
    // ja werkt
    // 
    //10
    //GUI thread
    
}
