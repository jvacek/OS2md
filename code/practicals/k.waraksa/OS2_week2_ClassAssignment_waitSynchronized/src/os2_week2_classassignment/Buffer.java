/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2_week2_classassignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 885233
 */
public class Buffer {
    int n; // the buffer can hold 1 integer
    boolean full = false;
    
    public synchronized int get()
    {
        if(!full){
            try {
                wait();
                        } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Got: " + n);
        full = false;
        notify();
        return n;
    }
    
    public synchronized void put(int n)
    {
        
        while(full){
            try {
                wait();
                        } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.n = n;
        System.out.println("Put: " + n);
        full = true;
        notifyAll();
    }
}
