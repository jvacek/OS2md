/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kazik
 */
public class Monitor {
    private int nrOfConsumersInCS;
    private boolean bufferEmpty = true;
    
    public synchronized void enterConsumer() throws InterruptedException{
        while(bufferEmpty|| nrOfConsumersInCS > 0){
            wait();
        }
        nrOfConsumersInCS++;
    }
    
    public synchronized void exitConsumer(){
        bufferEmpty = true;
        nrOfConsumersInCS--;
        notifyAll();
    }
}
