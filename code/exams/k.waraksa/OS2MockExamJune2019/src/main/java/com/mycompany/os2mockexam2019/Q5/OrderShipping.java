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
public class OrderShipping implements Runnable {
    private CountDownLatch cdl1;
    private CountDownLatch cdl5;
    
    public OrderShipping(CountDownLatch cdl1, CountDownLatch cdl5){
        this.cdl1 = cdl1;
        this.cdl5 = cdl5;
    }
    
    @Override
    public void run() {
        try {
            cdl5.await();
            cdl1.await();
            shipOrder();
        } catch (InterruptedException ex){
            
        }
    }
}
