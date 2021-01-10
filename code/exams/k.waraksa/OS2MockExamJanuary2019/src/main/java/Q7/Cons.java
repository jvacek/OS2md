/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

/**
 *
 * @author kazik
 */
public class Cons implements Runnable {
    Buffer buffer = new Buffer();
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            result[i] = buffer.getBoth();
        }
    }
}
