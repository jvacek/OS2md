/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jan2018;

/**
 *
 * @author kazik
 */
public class Q6Bank {
    private final ICentralBank cb;
    private final int id;
    private Account aMax;
    private Account aMin;
    
    
    Q6Bank(int i, ICentralBank cb) {
        this.id = i;
        this.cb = cb;
    }

    private void pay(int m, int from, int to) {
        Account a1 = cb.getAccount(from);
        Account a2 = cb.getAccount(to);
        
        if (a1.hashCode() > a2.hashCode()){
            aMax = a2;
            aMin = a1;
        } else {
            aMax = a1;
            aMin = a2;
        }
        
        synchronized(aMax) {
            synchronized(aMin) {
                int a1Balance = a1.getBalance();
                int a2Balance = a2.getBalance();

        // transfer the money:
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
            //pay(amount, from, to);
        }
    }
}



