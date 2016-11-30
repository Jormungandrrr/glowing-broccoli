/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import jsf31kochfractalfx.JSF31KochFractalFX;
import timeutil.TimeStamp;
/**
 *
 * @author Jorrit
 */
public class KochManager implements Observer{

    private JSF31KochFractalFX application;
    KochFractal koch;
    public List<Edge> EdgeList;
    int threadcount;
    public TimeStamp ts1;
    public TimeStamp ts2;
    private ExecutorService execService;
    private Task tl = null;
    private Task tb = null;
    private Task tr = null;
    
    public KochManager(JSF31KochFractalFX application) {
    this.application = application;
    this.koch = new KochFractal();
    EdgeList = new ArrayList<Edge>();
    this.execService = Executors.newFixedThreadPool(3);
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
    
    public void drawWhiteEdge(Edge e) {
        application.drawWhiteEdge(e);
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
    
    public synchronized void LoadLevel(){
        EdgeList.clear();
        try {
            FileInputStream fileIn = new FileInputStream("edges.ser");
            InputStream buffer = new BufferedInputStream(fileIn);
            ObjectInputStream in = new ObjectInputStream(buffer);
            EdgeList =(ArrayList<Edge>)in.readObject();
            in.close();
            fileIn.close();
            application.requestDrawEdges();
            } 
        catch (Exception ex) {
            Logger.getLogger(KochManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public synchronized void BinaryLoadLevel(){
        EdgeList.clear();
        try {
            Path filepath = Paths.get("edges.txt");
            byte[] data = Files.readAllBytes(filepath);
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            InputStream buffer = new BufferedInputStream(bis);
            ObjectInput in = new ObjectInputStream(buffer);
            EdgeList =(ArrayList<Edge>)in.readObject();
            in.close();
            bis.close();
            application.requestDrawEdges();
            } 
        catch (Exception ex) {
            Logger.getLogger(KochManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public synchronized void changeLevel(int nxt) {
    koch.setLevel(nxt);
    EdgeList.clear();
    ts1 = new TimeStamp();
    ts1.setBegin();
    System.out.println("begin process");
    threadcount = 0;
    //Thread threadl = new Thread(new Run(new KochFractal() , "l", nxt, this));
    //Thread threadb = new Thread(new Run(new KochFractal() , "b", nxt, this));
    //Thread threadr = new Thread(new Run(new KochFractal() , "r", nxt, this));
    //threadl.start();
    //threadb.start();
    //threadr.start();
    Tasks(nxt);
    this.execService.submit(tl);
    this.execService.submit(tr);
    this.execService.submit(tb);
    
    if (tl != null && tr != null && tb != null)
        {
           tl.cancel();
           tr.cancel();
           tb.cancel();
           koch.cancel();
        }
    
    
}
    public void Tasks(int lvl)
    {
         if (tl != null) {
            application.getProgressBarL().progressProperty().unbind();
            application.getLblCalcLeft().textProperty().unbind();
        }
        if (tr != null) {
            application.getProgressBarR().progressProperty().unbind();
            application.getLblCalcRight().textProperty().unbind();
        }
        if (tb != null) {
            application.getProgressBarB().progressProperty().unbind();
            application.getLblCalcBottom().textProperty().unbind();
        }

        tl = new Run(new KochFractal() , "l", lvl, this);
        tr = new Run(new KochFractal() , "r", lvl, this);
        tb = new Run(new KochFractal() , "b", lvl, this);
        
        application.getProgressBarL().setProgress(0);
        application.getProgressBarL().progressProperty().bind(tl.progressProperty());
        application.getLblCalcLeft().textProperty().bind(tl.messageProperty());

        application.getProgressBarR().setProgress(0);
        application.getProgressBarR().progressProperty().bind(tr.progressProperty());
        application.getLblCalcRight().textProperty().bind(tr.messageProperty());

        application.getProgressBarB().setProgress(0);
        application.getProgressBarB().progressProperty().bind(tb.progressProperty());
        application.getLblCalcBottom().textProperty().bind(tb.messageProperty());
    }
    
}
