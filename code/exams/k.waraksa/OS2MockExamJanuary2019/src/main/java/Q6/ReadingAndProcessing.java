/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author kazik
 */


public class ReadingAndProcessing {
    private static ExecutorService tp = Executors.newFixedThreadPool(5);  
    private static CountDownLatch cdl = new CountDownLatch(4);
    
    public static void main(String[] args) { 
        Runnable r = null;

        for (int i = 0; i < 4; i++) {
            r = new ReadTask(cdl);   
            tp.execute(r);
            
            r = new ProcessingTask(cdl);
            tp.execute(r);
        }
    }
}
