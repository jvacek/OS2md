/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kazik
 */
public class ProcessingTask implements Runnable {
    public CountDownLatch cdl = null;
    
    public ProcessingTask(CountDownLatch cdl){
        this.cdl = cdl;
    }
    
    @Override
    public void run() {
        System.out.println(
        "Hello I am a processing thread");
        processing1();
        
        try {
            cdl.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcessingTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        processing2();
    }

    private void processing1() {
        System.out.println("Finished processing task part 1");
    }

    private void processing2() {
        System.out.println("Finished processing task part 2");
    }
}
