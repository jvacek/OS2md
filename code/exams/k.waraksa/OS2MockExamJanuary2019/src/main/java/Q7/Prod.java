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
public class Prod implements Runnable{
    @Override
    public void run() {
        Buffer buffer = new Buffer();
        for (int i = 0; i < 5; i++) {
            buffer.putFirst(2 * i);
            buffer.putSecond(2 * i + 1);
        }
    }
}
