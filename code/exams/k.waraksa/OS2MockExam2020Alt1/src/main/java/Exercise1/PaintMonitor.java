package Exercise1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kazik
 */
public class PaintMonitor {
    
    Lock monLock = new ReentrantLock();
    Condition yellowMayGoOn = monLock.newCondition();
    Condition redMayGoOn = monLock.newCondition();
    Condition painterMayGoOn = monLock.newCondition();
    
    int nrOfSuppliersYellowWaiting;
    int nrOfSuppliersRedWaiting;
    int redLiters = 0;
    int yellowLiters = 0;
    boolean inCs = false;
    boolean painterWaiting = false;
    
    public void enterSupplierOfYellow (){
        monLock.lock();
        try {
            while ((yellowLiters == 250) || 
                   (yellowLiters > redLiters) && 
                   (nrOfSuppliersYellowWaiting > 0) ||
                   (inCs)) {
                
                try{
                    nrOfSuppliersYellowWaiting++;
                    wait(); 
                    nrOfSuppliersYellowWaiting--;
                } catch (InterruptedException ex) {
                    nrOfSuppliersYellowWaiting--;
                }  
                
            yellowLiters += 10;
            inCs = true;   
            }  
        } finally {
            monLock.unlock();
        }
    }
    
    public void exitSupplierOfYellow(){
        monLock.lock();
        try {
            inCs = false;
            if (yellowLiters == redLiters){
                if (painterWaiting){
                    painterMayGoOn.signal();
                } else {
                    yellowMayGoOn.signal();
                    redMayGoOn.signal();
                }
            } else {
                if (redLiters > yellowLiters){
                    if (nrOfSuppliersYellowWaiting > 0) {
                        yellowMayGoOn.signal();
                    } else {
                        redMayGoOn.signal();
                    }
                } else {
                    if (nrOfSuppliersRedWaiting > 0) {
                        redMayGoOn.signal();
                    } else {
                        yellowMayGoOn.signal();
                    }
                }
            }
            
        } finally {
            monLock.unlock();
        }
    }
    
    public void enterSupplierOfRed(){
        monLock.lock();
        try {
            while ((redLiters == 250) || 
                   (redLiters > yellowLiters) && 
                   (nrOfSuppliersRedWaiting > 0) ||
                   (inCs)) {
                
                try{
                    nrOfSuppliersRedWaiting++;
                    wait(); 
                    nrOfSuppliersRedWaiting--;
                } catch (InterruptedException ex) {
                    nrOfSuppliersRedWaiting--;
                }  
                
            redLiters += 10;
            inCs = true;   
            }  
        } finally {
            monLock.unlock();
        }
    }
    
    public void exitSupplierOfRed(){
        monLock.lock();
        try {
            inCs = false;
            if (redLiters == yellowLiters){
                if (painterWaiting){
                    painterMayGoOn.signal();
                } else {
                    yellowMayGoOn.signal();
                    redMayGoOn.signal();
                }
            } else {
                if (redLiters > yellowLiters){
                    if (nrOfSuppliersYellowWaiting > 0) {
                        yellowMayGoOn.signal();
                    } else {
                        redMayGoOn.signal();
                    }
                } else {
                    if (nrOfSuppliersRedWaiting > 0) {
                        redMayGoOn.signal();
                    } else {
                        yellowMayGoOn.signal();
                    }
                }
            }
            
        } finally {
            monLock.unlock();
        }
    }
    
    public void enterPainter(){
        monLock.lock();
        try {
            inCs = false;
            try {
                painterWaiting = true;
                wait();
                painterWaiting = false;
            } catch (InterruptedException ex) {
                painterWaiting = false;
            }  
            
            inCs = true;
            redLiters = 0;
            yellowLiters = 0;
        } finally {
            monLock.unlock();
        }
    }
    
    public void exitPainter(){
        monLock.lock();
        try {
            inCs = false;
            if (nrOfSuppliersYellowWaiting > 0){
                yellowMayGoOn.signal();
            }
            
            if (nrOfSuppliersRedWaiting > 0){
                redMayGoOn.signal();
            }
            
        } finally {
            monLock.unlock();
        }
    }
}
