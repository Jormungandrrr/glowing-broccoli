/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatekoch;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorrit
 */
public class GenerateKoch{

    /**
     * @param args the command line arguments
     * 
     */
    public static List<Edge> EdgeList = new ArrayList<>();
    
    public static void main(String[] args) {
        KochFractal koch = new KochFractal();
        //koch.setLevel(Integer.parseInt(args[0]));
        koch.setLevel(1);
        koch.generateBottomEdge();
        koch.generateLeftEdge();
        koch.generateRightEdge();
        
            try {
                FileOutputStream fileOut = new FileOutputStream("edges.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(EdgeList);
                out.close();
                fileOut.close();
                }
                catch(IOException i) {
                i.printStackTrace();
                }
    }
    
}
