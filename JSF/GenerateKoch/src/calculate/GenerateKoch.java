/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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
    public static TimeStamp fileoutput;
    public static TimeStamp bufferedfileoutput;
    public static TimeStamp binaryoutput;
    public static TimeStamp bufferedbinaryoutput;
    public static TimeStamp mapped;
    
    public static void main(String[] args) {
        KochFractal koch = new KochFractal();
        if (args.length == 1) {
            koch.setLevel(Integer.parseInt(args[0]));
        }
        else{koch.setLevel(5);}
        koch.generateBottomEdge();
        koch.generateLeftEdge();
        koch.generateRightEdge();
        
        fileoutput = new TimeStamp();
        bufferedfileoutput = new TimeStamp();
        binaryoutput = new TimeStamp();
        bufferedbinaryoutput = new TimeStamp();
        mapped = new TimeStamp();
        
        fileoutput.setBegin();
        FileOutput();
        fileoutput.setEnd();
        
        bufferedfileoutput.setBegin();
        FileBufferOutput();
        bufferedfileoutput.setEnd();
        
        binaryoutput.setBegin();
        BinaryOutput();
        binaryoutput.setEnd();
        
        bufferedbinaryoutput.setBegin();
        BinaryBufferOutput();
        bufferedbinaryoutput.setEnd();
        
        mapped.setBegin();
        writeMapped();
        mapped.setEnd();
        
        
        System.out.println("Fileoutput: " +fileoutput.toString());
        System.out.println("bufferedFileoutput: " +bufferedfileoutput.toString());
        System.out.println("binaryoutput: " +binaryoutput.toString());
        System.out.println("bufferedbinaryoutput: " +bufferedbinaryoutput.toString());
        System.out.println("mapped: " +mapped.toString());
    }
    
    public static void FileOutput(){
        try {
            FileWriter fw = new FileWriter(uri + "textedges.txt");
            for (Edge e : EdgeList) {
                fw.write(String.valueOf(e.X1) + ";");
                fw.write(String.valueOf(e.Y1) + ";");
                fw.write(String.valueOf(e.X2) + ";");
                fw.write(String.valueOf(e.Y2) + ";");
                fw.write(String.valueOf(e.color) + ";");
            }
            fw.close();

        }
        catch(IOException i) {
        i.printStackTrace();
        }
    }
    
    public static void FileBufferOutput(){
        try {
           FileWriter fw = new FileWriter(uri + "textedges.txt");
           BufferedWriter bw = new BufferedWriter(fw);
           for (Edge e : EdgeList) {
                bw.write(String.valueOf(e.X1) + ";");
                bw.write(String.valueOf(e.Y2) + ";");
                bw.write(String.valueOf(e.X2) + ";");
                bw.write(String.valueOf(e.Y2) + ";");
                bw.write(String.valueOf(e.color) + ";");
            }
           bw.close();
           
           //PrintWriter out = new PrintWriter("edges.txt");
           // for (Edge e : EdgeList) {
           //     out.println(e.X1);
           //     out.println(e.X2);
           //     out.println(e.Y1);
           //     out.println(e.Y2);
           //     out.println(e.color);
           // }
           
           // BufferedWriter writer = new BufferedWriter( new FileWriter("edges.txt"));
           // for (Edge e : EdgeList) {
           //     writer.write(String.valueOf(e.X1) + ";");
           //     writer.write(String.valueOf(e.X2) + ";");
           //     writer.write(String.valueOf(e.Y1) + ";");
           //     writer.write(String.valueOf(e.Y2) + ";");
           //     writer.write(String.valueOf(e.color) + ";");
           // }
           
        }
        catch(IOException i) {
        i.printStackTrace();
        }
    }
    
    public static void BinaryOutput(){
        try {          
            FileOutputStream fileOut = new FileOutputStream(uri + "binaryedges.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(EdgeList);
            out.close();
            fileOut.close();
        }
        catch(IOException i) {
        i.printStackTrace();
        }
    }
    
    public static void BinaryBufferOutput(){
        try {
            FileOutputStream fileOut = new FileOutputStream(uri + "binaryedges.ser");
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
    
     public static void writeMapped(){
        try
        {
           RandomAccessFile memoryMappedFile = new RandomAccessFile(uri + "mapped", "rw");
           MappedByteBuffer out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 80000);
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           ObjectOutputStream oos = new ObjectOutputStream(baos);
           oos.writeObject(EdgeList);
           oos.flush();
           out.put(baos.toByteArray());
           oos.close();
           baos.flush();
           baos.close();

        } catch (Exception ex)
        {
        } 
     }
}
