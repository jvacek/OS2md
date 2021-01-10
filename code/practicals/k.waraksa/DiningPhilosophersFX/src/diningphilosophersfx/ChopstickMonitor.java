/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosophersfx;

/**
 *
 * @author P. Boots
 */
public class ChopstickMonitor {

    // Pick up two chopsticks
    public synchronized void get(Chopstick left, Chopstick right) throws InterruptedException {
        while (left.isUsed() || right.isUsed()){
            wait();
        }
        
        //take both chopsticks
        left.get();
        right.get();
    }

    // Lay down two chopsticks
    public synchronized void put(Chopstick left, Chopstick right) {
        left.put();
        right.put();
        notifyAll();
    }
}
