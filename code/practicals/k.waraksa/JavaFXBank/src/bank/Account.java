/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author Joris
 */
public class Account {

    private int balance;
    private boolean inUse = false;

    public Account(int money) {
        this.balance = money;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int money) {
        this.balance = money;
    }
    
    public boolean isUsed() {
        return this.inUse;
    }
    
    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}

