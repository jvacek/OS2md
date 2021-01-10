/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author kazik
 */
class Buffer {
    private boolean ConsumerMustWait = true;
    private boolean ProducerMustWait = false;
    private int n1, n2;
    ReentrantLock rl = new ReentrantLock();
    private final Condition ProducerMustWaitCondition = rl.newCondition();
    private final Condition ConsumerMustWaitCondition = rl.newCondition();

    public void putFirst(int n1) {
        rl.lock();
        try {
            while (ProducerMustWait) {
                try {
                    ProducerMustWaitCondition.await();
                } catch (InterruptedException ex) {
                }
            }
            ProducerMustWait = true;
            System.out.println("Put: " + n1);
            this.n1 = n1;
        } finally {
            rl.unlock();
        }
    }

    public void putSecond(int n2) {
        rl.lock();
        try {
            System.out.println("Put: " + n2);
            this.n2 = n2;
            ConsumerMustWait = false;
            ConsumerMustWaitCondition.signal();
        } finally {
            rl.unlock();
        }
    }

    public int getBoth() {
        rl.lock();
        try {
            while (ConsumerMustWait) {
                try {
                    ConsumerMustWaitCondition.await();
                } catch (InterruptedException Ex) {
                }
                System.out.println("Got: " + n1 + " and " + n2);
                ConsumerMustWait = true;
                ProducerMustWait = false;
                ProducerMustWaitCondition.signal();
            } 
        } finally {
            rl.unlock();
        }
        
        return n1 + n2;
    }
}
