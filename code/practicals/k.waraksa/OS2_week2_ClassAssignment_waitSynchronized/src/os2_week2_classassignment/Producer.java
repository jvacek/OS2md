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
    
    public Producer(Buffer b, int startValue, int nrOfValues)
    {
        this.buffer = b;
        this.startValue = startValue;
        this.nrOfValues = nrOfValues;
    }

    @Override
    public void run() {
        for (int i = 0; i < nrOfValues; i++) {
            buffer.put(i+startValue);
        }
    }    
}
