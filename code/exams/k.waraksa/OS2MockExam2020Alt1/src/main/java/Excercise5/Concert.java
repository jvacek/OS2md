/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercise5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author kazik
 */
public class Concert {
    public static void main(String args[]) {
        
        
       ExecutorService pool = Executors.newFixedThreadPool(5);
        
       CountDownLatch cdl = new CountDownLatch(10);
       CyclicBarrier cb = new CyclicBarrier(4);

       final int NROFBIGSPONSORS = 20;
       for (int i = 0; i< NROFBIGSPONSORS; i++)
       {
           //new Thread(new BigSponsor(cdl)).start();
           pool.execute(new BigSponsor(cdl));
       }
       final int NROFABBAMEMBERS = 4;
       for (int i = 0; i< NROFABBAMEMBERS; i++)
       {
	   //new Thread(new ABBAmember(cdl)).start();
           pool.execute(new ABBAmember(cdl, cb));
       }
       
       pool.shutdown();
    }
}

