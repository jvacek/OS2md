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
public class ReadTask implements Runnable {
    private int rtCount;
    private CountDownLatch CDL;

    public ReadTask(int rtCount, CountDownLatch CDL)
    {
        this.CDL = CDL;
	this.rtCount = rtCount;
    }
    
    @Override
    public void run() {
    	System.out.println("Hello I am read thread number " + rtCount);
	read();
        CDL.countDown();
    }

    private void read() {
        for (long i = 0; i < Math.round(Math.random() * 5000); i++) {
            try {
                Thread.currentThread().sleep(i);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Read thread " + rtCount + " finished reading");
    }
    
}
