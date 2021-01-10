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
public class Producer implements Runnable {
    private Buffer buffer;
    private int startValue; // first value to be produced
    private int nrOfValues; // number of values to produce
    private Monitor m;
    
    public Producer(Buffer b, int startValue, int nrOfValues, Monitor m)
    {
        this.buffer = b;
        this.startValue = startValue;
        this.nrOfValues = nrOfValues;
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < nrOfValues; i++) {
            m.enterProducer();
            buffer.put(i+startValue);
            m.exitProducer();
        }
    }    
}
