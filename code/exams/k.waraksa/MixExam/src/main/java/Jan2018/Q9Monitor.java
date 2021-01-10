/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jan2018;

/**
 *
 * @author kazik
 */
public class Q9Monitor {
    private int nrOfConsumersInCS;
    private boolean bufferEmpty = true;
    
    public synchronized void EnterConsumer(){
        try {
            while (bufferEmpty || nrOfConsumersInCS < 1){
                wait();
            }
        } catch (Exception ex) {}
        nrOfConsumersInCS++;
    }
    
    public synchronized void ExitConsumer(){
        nrOfConsumersInCS--;
        bufferEmpty = true;
        notifyAll();
    }
}
