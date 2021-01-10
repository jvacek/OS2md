/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosophersfx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Joris
 */
public class Chopstick {
    private final Lock chopstickLock;
    private final int index;  // for debugging...
    private boolean used;
    
    public Chopstick(int i)
    {
        chopstickLock = new ReentrantLock();
        used = false;
        index = i;
    }
    
    public void get() {
        chopstickLock.lock();
        used = true;
        System.out.println("thread " + Thread.currentThread().getId() + ": get chopstick:" + index);
    }
    
    public void put() {
        System.out.println("thread " + Thread.currentThread().getId() + ": put chopstick:" + index);
        chopstickLock.unlock();
        used = false;
    }
    
    public boolean isUsed() {
        return (used);
    }
}
