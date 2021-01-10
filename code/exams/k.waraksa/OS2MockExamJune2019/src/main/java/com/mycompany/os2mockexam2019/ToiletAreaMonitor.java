/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.os2mockexam2019;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kazik
 */
public class ToiletAreaMonitor {
    private Lock myLock = new ReentrantLock();
    private int nrOfStudentsIn = 0;
    private boolean cleaningPersonIn = false;
    private boolean cleaningPersonWaiting = false;
    
    private Condition studentMayEnter = myLock.newCondition();
    private Condition cleaningPersonMayEnter = myLock.newCondition();
        
    
    public void enterStudent(){
       myLock.lock();
       try{
           while((nrOfStudentsIn >= 10) ||
                 (cleaningPersonIn) ||
                 (cleaningPersonWaiting)){
               try {
                   studentMayEnter.await();
               } catch (InterruptedException ex) {
                   Logger.getLogger(ToiletAreaMonitor.class.getName()).log(Level.SEVERE, null, ex);
               }
               nrOfStudentsIn++;
           }
       } finally {
           myLock.unlock();
       }
    }
    
    public void exitStudent(){
       myLock.lock();
       try{
           nrOfStudentsIn--;
           if ((cleaningPersonWaiting && nrOfStudentsIn == 0))
               cleaningPersonMayEnter.signal();
           if ((nrOfStudentsIn == 9) && (cleaningPersonWaiting))
               studentMayEnter.signal();
           
           
       } finally {
           myLock.unlock();
       }
    }
    
    public void enterCleaningPerson(){
       myLock.lock();
       try{
           while(nrOfStudentsIn > 0){
               try {
                   cleaningPersonWaiting = true;
                   cleaningPersonMayEnter.await();
                   cleaningPersonWaiting = false;
               } catch (InterruptedException ex) {
                   Logger.getLogger(ToiletAreaMonitor.class.getName()).log(Level.SEVERE, null, ex);
               }
               cleaningPersonIn = true;
           }
       } finally {
           myLock.unlock();
       }
    }
    
    public void exitCleaningPerson(){
       myLock.lock();
       try{
           cleaningPersonIn = false;
           studentMayEnter.signalAll();
           
       } finally {
           myLock.unlock();
       }
    }
}
