/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import timeutil.TimeStamp;

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
    public static String uri = "C:\\Users\\Jorrit\\Documents\\GitHub\\glowing-broccoli\\JSF\\JSF32week12\\";
    public static TimeStamp ts1;
    
    public static void main(String[] args) {
        KochFractal koch = new KochFractal();
        if (args.length == 1) {
            koch.setLevel(Integer.parseInt(args[0]));
        }
        else{koch.setLevel(5);}
        koch.generateBottomEdge();
        koch.generateLeftEdge();
        koch.generateRightEdge();
        ts1 = new TimeStamp();
        ts1.setBegin();
        FileBufferOutput();
        //FileOutput();
        //BinaryOutput();
        BinaryBufferOutput();
        ts1.setEnd();
        System.out.println(ts1.toString());
    }
    
    public static void FileBufferOutput(){
        try {
            FileOutputStream fileOut = new FileOutputStream(uri + "edges.ser");
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
    
    public static void FileOutput(){
        try {
            FileOutputStream fileOut = new FileOutputStream(uri + "edges.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(EdgeList);
            out.close();
            fileOut.close();
        }
        catch(IOException i) {
        i.printStackTrace();
        }
    }
    
    public static void BinaryOutput(){
        try {
            FileOutputStream fileOut = new FileOutputStream(uri + "edges.txt");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutput os = new ObjectOutputStream(out);  
            os.writeObject(EdgeList);
            os.flush();
            out.writeTo(fileOut);
        }
        catch(IOException i) {
        i.printStackTrace();
        }
    }
    
    public static void BinaryBufferOutput(){
        try {
            FileOutputStream fileOut = new FileOutputStream(uri + "edges.txt");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            OutputStream buffer = new BufferedOutputStream(out);
            ObjectOutput os = new ObjectOutputStream(buffer);  
            os.writeObject(EdgeList);
            os.flush();
            out.writeTo(fileOut);
        }
        catch(IOException i) {
        i.printStackTrace();
        }
    }
}
