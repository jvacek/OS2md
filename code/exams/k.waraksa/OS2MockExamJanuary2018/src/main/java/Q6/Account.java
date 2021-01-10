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
public class Account {
    private int balance;
    
    public Account(int money) {
        this.balance = money;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int money) {
        this.balance = money;
    }
}
