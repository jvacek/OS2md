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
public class OrderPayment implements Runnable {
    private CountDownLatch cdl3;
    private CountDownLatch cdl5;
    
    public OrderPayment(CountDownLatch cdl3, CountDownLatch cdl5){
        this.cdl3 = cdl3;
        this.cdl5 = cdl5;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) // the method below waits until 20% of payment is received
        {
            receivePayment();
            cdl3.countDown();
            cdl5.countDown();
        }
    }
}

