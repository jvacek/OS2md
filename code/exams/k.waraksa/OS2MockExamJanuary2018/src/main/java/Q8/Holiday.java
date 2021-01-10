/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author kazik
 */
public class Holiday {
    private static CyclicBarrier cb1 = new CyclicBarrier(30);
    private static CyclicBarrier cb2 = new CyclicBarrier(30);
    
    public static void main(String args[]) {
        Thread busDriverA = new Thread(new BusDriver("A"));
        Thread busDriverB = new Thread(new BusDriver("B"));
        
        busDriverA.start();
        busDriverB.start();

        Thread t;
        for (int i = 0; i < 30; i++) {
            t = new Thread(new Tourist("A",cb1));
            t.start();

            t = new Thread(new Tourist("B",cb2));
            t.start();
        }
    }
}
