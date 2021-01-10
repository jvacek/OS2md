/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercise7;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kazik
 */
public class TCPServer {
    public static void main(String[] args) {
        
        try {
            boolean done = false;
            ServerSocket ss = new ServerSocket(2020);
            Socket sock = ss.accept();
            InputStream is = sock.getInputStream();
            OutputStream os = sock.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object obj = ois.readObject();
            
            if (obj instanceof String){
                String s = (String)obj;
                if(!s.equals("Persons")) done = true;
            } else {
                done = true;
            }
            
            if (!done){
                //recieve Person Object
                obj = ois.readObject();
                if (obj instanceof Person){
                    Person p = (Person)obj;
                    oos.writeObject(p);
                    System.out.println(p.toString());
                } else {
                    done = true;
                }
            }
            
            
            while (!done){
                obj = ois.readObject();
                if (obj instanceof Person){
                    Person p = (Person)obj;
                    oos.writeObject(p);
                    System.out.println(p.toString());
                } else if (obj instanceof String) {
                        String s = (String)obj;
                        if (s.equals("End")) done = true;
                    }
            } 
          
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }
        finally {
            try {
                if (sock != null)
                    sock.close();

            } catch (IOException ex) {
                // handle exception
            }
        }
    }    
}

