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
public class OrderShippingCompany {
    public static void main(String args[]) {   
        final int MAXORDERS = 20;

        for (int i = 0; i < MAXORDERS; i++) {
            
            /*
            CDL3 is used to count 3 payments (60% of payment)
            CDL5 is used to count 5 payments (100% of the payment)
            CDL1 is used to count 1 material reservation
            */
            
            CountDownLatch cdl1 = new CountDownLatch(1);
            CountDownLatch cdl3 = new CountDownLatch(3);
            CountDownLatch cdl5 = new CountDownLatch(4);
            
            new Thread(new OrderPayment(cdl3,cdl5)).start();
            new Thread(new MaterialReservation(cdl1,cdl3)).start();
            new Thread(new OrderShipping(cdl1,cdl5)).start();
        }
    }
}
