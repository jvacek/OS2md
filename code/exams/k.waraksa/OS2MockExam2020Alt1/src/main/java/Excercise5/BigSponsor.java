/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercise5;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author kazik
 */
public class BigSponsor implements Runnable {
    
    CountDownLatch cdl;
    
    public BigSponsor(CountDownLatch cdl){
        this.cdl = cdl;
    }
    
    @Override
    public void run() {
		
        donateBigAmountOfMoney();
    } 
}


