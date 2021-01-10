/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

/**
 *
 * @author kazik
 */
public class Broker implements Runnable {
    private final ICentralBank cb;
    private final int id;

    Broker(int i, ICentralBank cb) {
        this.id = i;
        this.cb = cb;
    }

    private void pay(int m, int from, int to) {
        Account a1 = cb.getAccount(from);
        Account a2 = cb.getAccount(to);
        Account aMin, aMax;
        
        if(a2.hashCode() > a1.hashCode()){
            aMin = a1;
            aMax = a2;
        } else {
            aMin = a2;
            aMax = a1;
        }
        
        synchronized (aMin){
            synchronized (aMax){
                int a1Balance = a1.getBalance();
                int a2Balance = a2.getBalance();

                a1Balance -= m;
                a2Balance += m;
                cb.transaction(from, to, a1Balance, a2Balance);
                a1.setBalance(a1Balance);
                a2.setBalance(a2Balance);             
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            // after some random time, this broker transfers a random
            // amount of money
            // from a random account to another random account


            //pay(amount, from, to);
        }
    }
}
