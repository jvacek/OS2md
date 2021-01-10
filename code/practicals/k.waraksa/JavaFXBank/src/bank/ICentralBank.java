/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import bank.Account;

/**
 *
 * @author Joris
 */
public interface ICentralBank {
    
    int getNrofAccounts();
    Account getAccount(int clientId);
    void transaction (int from, int to, int balanceFrom, int balanceTo);
    
}

