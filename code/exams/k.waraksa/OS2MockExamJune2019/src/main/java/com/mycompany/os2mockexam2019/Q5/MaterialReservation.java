/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.os2mockexam2019.Q5;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author kazik
 */
public class MaterialReservation implements Runnable {
    private CountDownLatch cdl3;
    private CountDownLatch cdl1;
    
    public MaterialReservation(CountDownLatch cdl3, CountDownLatch cdl1){
        this.cdl3 = cdl3;
        this.cdl1 = cdl1;
    }
    
    @Override
    public void run() {
        try {
            cdl3.await();
            reserveMaterials();
            cdl1.countDown();
        } catch (InterruptedException ex){
            
        }
    }
}
