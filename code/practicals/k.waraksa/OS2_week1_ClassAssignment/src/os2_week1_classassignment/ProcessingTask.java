/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2_week1_classassignment;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author 885233
 */
public class ProcessingTask implements Runnable {
    private int ptCount;
    private CountDownLatch CDL;

    public ProcessingTask(int ptCount)
    {
	this.ptCount = ptCount;
    }
    
    @Override
    public void run() {
    	System.out.println("Hello I am processing thread number " + ptCount);        
        processing1();
	processing2();
    }

    private void processing1() {
       // loop to simulate calculations
        for (long i = 0; i < Math.round(Math.random() * 2500); i++) {
            try {
                Thread.currentThread().sleep(i);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Processing thread " + ptCount + " finished processing 1");
    }  
    
    private void processing2() {
       // loop to simulate calculations
        for (long i = 0; i < Math.round(Math.random() * 2500); i++) {
            try {
                Thread.currentThread().sleep(i);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Processing thread " + ptCount + " finished processing 2");
    }        
}
