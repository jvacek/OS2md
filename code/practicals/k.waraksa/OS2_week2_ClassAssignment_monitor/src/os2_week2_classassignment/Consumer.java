/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2_week2_classassignment;

/**
 *
 * @author 885233
 */
public class Consumer implements Runnable {
    private Buffer buffer;
    private int nrOfValues; // number of values to read
    private Monitor m;
    
    public Consumer(Buffer b, int nrOfValues, Monitor m)
    {
        this.buffer = b;
        this.nrOfValues = nrOfValues;
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < nrOfValues; i++) {
            m.enterConsumer();
            buffer.get();
            m.exitConsumer();
        }
    }        
}
