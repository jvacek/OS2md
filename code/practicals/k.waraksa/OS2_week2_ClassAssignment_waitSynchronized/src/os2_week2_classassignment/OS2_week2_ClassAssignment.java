/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2_week2_classassignment;

/**
 *
 * @author 885233
 */
public class OS2_week2_ClassAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t;
        Buffer b = new Buffer();
        // Create two producers and one consumer
        Producer p1 = new Producer(b,1,10); // p1 produces 10 values starting from 1
        Producer p2 = new Producer(b,11,20); // p2 produces 20 values starting from 11
        Consumer c = new Consumer(b,30); // c consumes 30 values
        
        t = new Thread(p1);
        t.start();
        t = new Thread(p2);
        t.start();
        t = new Thread(c);
        t.start();
    }
    
}
