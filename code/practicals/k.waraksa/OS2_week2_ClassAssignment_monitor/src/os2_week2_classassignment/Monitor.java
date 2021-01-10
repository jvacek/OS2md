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
 * @author kazik
 */
public class Monitor {
    private boolean BufferFull = false;
    private boolean ProducerInCs = false;
    
    public synchronized void enterProducer(){
        while ((BufferFull) || (ProducerInCs)){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ProducerInCs = true;
    }
    
    public synchronized void exitProducer(){
        BufferFull = true;
        ProducerInCs = false;
        notifyAll();
    }
    
    public synchronized void enterConsumer(){
        if(!BufferFull){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void exitConsumer(){
        BufferFull = false;
        notify();
    }
}
