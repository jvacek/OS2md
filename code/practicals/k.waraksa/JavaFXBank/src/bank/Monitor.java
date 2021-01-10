/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kazik
 */
public class Monitor {
    public synchronized void enterTransaction(Account a1, Account a2){
        while (a1.isUsed() || a2.isUsed()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void exitTransaction(Account a1, Account a2){
        a1.setInUse(false);
        a2.setInUse(false);
        notifyAll();
    }
}
