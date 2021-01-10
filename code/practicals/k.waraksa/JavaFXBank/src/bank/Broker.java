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
 * @author Joris
 */
public class Broker implements Runnable {

    private final ICentralBank cb;
    private final int id;
    private Monitor monitor;

    Broker(int i, ICentralBank cb, Monitor monitor) {
        this.id = i;
        this.cb = cb;
        this.monitor = monitor;
    }

    private void pay(int m, int from, int to) {
        Account a1 = cb.getAccount(from);
        Account a2 = cb.getAccount(to);
        
        monitor.enterTransaction(a1,a2);
        
        int a1Balance = a1.getBalance();
        int a2Balance = a2.getBalance();

        // transfer the money:
        a1Balance -= m;
        a2Balance += m;
        cb.transaction(from, to, a1Balance, a2Balance);

        a1.setBalance(a1Balance);
        a2.setBalance(a2Balance);
        
        monitor.exitTransaction(a1,a2);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
            while (true) {
                // after some random time, this broker transfers a random amount of money
                // from a random account to another random account
                Thread.sleep(1 + (int) (Math.random() * 2));
                int from = (int) (Math.random() * cb.getNrofAccounts());
                int to = (int) (Math.random() * cb.getNrofAccounts());
                int amount = (int) (Math.random() * 100);

                while (from == to) {
                    // make sure that both accounts are different
                    to = (int) (Math.random() * cb.getNrofAccounts());
                    Thread.sleep(1);
                }

                // transfer!
                pay(amount, from, to);
            }
        } catch (InterruptedException ex) {
            System.out.println("Broker-" + id + ":" + ex.toString());
        }
        System.out.println("Broker-" + id + ":ready");
    }

}
