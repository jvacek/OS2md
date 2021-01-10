/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import static java.lang.System.console;

/**
 *
 * @author kazik
 */
public class RaceConditionExample {
    public static void main(String[] args) {
        Monitor m = new Monitor();
        final SharedCount s = new SharedCount(m);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {                  
                    s.increase();             
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    s.decrease();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) { }
        System.out.println(s.count);
    }
}