/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author kazik
 */
public class SharedCount {
    public Monitor m = null;
    public int count = 5;

    public SharedCount(Monitor m){
        this.m = m;
    }
    
    public void increase() {
        m.enterCS();
        count++;
        m.exitCS();
    }

    public void decrease() {
        m.enterCS();
        count--;
        m.exitCS();
    }
}
