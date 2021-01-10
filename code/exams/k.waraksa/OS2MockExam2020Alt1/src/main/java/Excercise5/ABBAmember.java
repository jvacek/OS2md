/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercise5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author kazik
 */
public class ABBAmember implements Runnable {
    
    CountDownLatch cdl;
    CyclicBarrier cb;
    
    public ABBAmember(CountDownLatch cdl, CyclicBarrier cb){
        this.cdl = cdl;
        this.cb = cb;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                // the group member waits until 10 big sponsors have 
                // donated money
                cdl.await();
                travelToConcertHall();
                
                // the group member waits until the other members are
                // present
                
                cb.await();
                playConcert(); 
            }
        } catch (Exception ex){
            //Do something
        }		
    } 
} 

