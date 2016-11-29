/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
        if (args.length == 1) {
            koch.setLevel(Integer.parseInt(args[0]));
        }
        else{koch.setLevel(5);}
        koch.generateBottomEdge();
        koch.generateLeftEdge();
        koch.generateRightEdge();
        
            try {
                FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Jorrit\\Documents\\GitHub\\glowing-broccoli\\JSF\\JSF32week12\\edges.ser");
                OutputStream buffer = new BufferedOutputStream( fileOut );
                ObjectOutputStream out = new ObjectOutputStream(buffer);
                out.writeObject(EdgeList);
                out.close();
                fileOut.close();
                }
                catch(IOException i) {
                i.printStackTrace();
                }
    }
    
}
