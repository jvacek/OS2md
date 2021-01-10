/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jan2018;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author kazik
 */
public class Q3Father {
    private int money;
    private ReentrantLock lock = new ReentrantLock();
    private Condition HasMoney = lock.newCondition();

    public void receiveSalary(int salary) {
        lock.lock();
        try {
            money += salary;
            HasMoney.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public void givePocketMoney(int pocketMoney)
            throws InterruptedException {
        
        lock.lock();
        try {
            while (money < pocketmoney) {
                HasMoney.await();
            } 
            money -= pocketMoney;
        } finally {
            lock.unlock();
        }
    }
}
