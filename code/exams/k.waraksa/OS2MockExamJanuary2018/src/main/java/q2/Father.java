/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author kazik
 */
public class Father {
    private final ReentrantLock rl = new ReentrantLock();
    private final Condition HasEnoughMoneyCondition = rl.newCondition();
    private int money;
    private int pocketmoney;

    public void receiveSalary(int salary) {
        rl.lock();
        try { 
            money += salary;
            HasEnoughMoneyCondition.signalAll();
        }
        finally {
            rl.unlock();
        }
    }

    public void givePocketMoney(int pocketMoney) throws InterruptedException {
        rl.lock();
        try {
            while (money < pocketmoney){
                HasEnoughMoneyCondition.await();
            } 
            money -= pocketMoney;
        } finally {
            rl.unlock();
        }
    }
}
