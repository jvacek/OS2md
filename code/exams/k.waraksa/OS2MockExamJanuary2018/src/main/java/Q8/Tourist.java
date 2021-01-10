/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kazik
 */
public class Tourist implements Runnable {
    private String destination;
    private String touristType;
    private CyclicBarrier cb;
    
    public Tourist(String destination, String touristType, CyclicBarrier cb) {
        this.destination = destination;
        this.touristType = touristType;
        this.cb = cb;
    }

    @Override
    public void run() throws InterruptedException {
        Fly();
        ArriveAtAirport();   
        try {
                cb.await();
            } catch (BrokenBarrierException ex) {}
            RideFromAirportToHotel(destination);
            EnjoyHoliday();        
        }
    }
}
