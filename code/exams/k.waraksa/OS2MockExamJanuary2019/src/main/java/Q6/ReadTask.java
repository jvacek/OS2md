/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author kazik
 */
public class ReadTask implements Runnable {
    public CountDownLatch cdl = null;
    
    public ReadTask(CountDownLatch cdl){
        this.cdl = cdl;
    }
    
    @Override
    public void run() {
        System.out.println("Hello I am a read thread");
        read();
        cdl.countDown();
    }

    private void read() {
        System.out.println("Read thread finished reading");
    }
}
