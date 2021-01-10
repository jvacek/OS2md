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
public class Buffer {
    int n; // the buffer can hold 1 integer
    
    public int get()
    {   
        System.out.println("Got: " + n);
        return n;
    }
    
    public synchronized void put(int n)
    {
        this.n = n;
        System.out.println("Put: " + n);
    }
}
