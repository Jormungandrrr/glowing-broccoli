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
    int threadcount;
    public TimeStamp ts1;
    public TimeStamp ts2;
    
    public KochManager(JSF31KochFractalFX application) {
    this.application = application;
    this.koch = new KochFractal();
    EdgeList = new ArrayList<Edge>();
    }

    @Override
    public void update(Observable o, Object arg) {
        EdgeList.add((Edge)arg);
    }

    
    public synchronized void drawEdges() {
    application.setTextNrEdges(String.valueOf(koch.getNrOfEdges()));
    application.setTextCalc(ts1.toString());
    application.clearKochPanel();
    ts2 = new TimeStamp();
    ts2.setBegin();
    
    for (Edge e: EdgeList)
    {
    application.drawEdge(e);
    
    }
    ts2.setEnd();
    application.setTextDraw(ts2.toString());
    }
    
    public synchronized void UpdateEdges(Edge e){
        EdgeList.add(e);
    }
     
    public synchronized void ReqDraw()
    {
        threadcount++;
        application.requestDrawEdges();
        if (threadcount == 3) {
            ts1.setEnd();
        }
    }


    public synchronized void changeLevel(int nxt) {
    koch.setLevel(nxt);
    EdgeList.clear();
    ts1 = new TimeStamp();
    ts1.setBegin();
    System.out.println("begin process");
    threadcount = 0;
    Thread threadl = new Thread(new Run(new KochFractal() , "l", nxt, this));
    Thread threadb = new Thread(new Run(new KochFractal() , "b", nxt, this));
    Thread threadr = new Thread(new Run(new KochFractal() , "r", nxt, this));
    
    threadl.start();
    threadb.start();
    threadr.start();
}
    
}
