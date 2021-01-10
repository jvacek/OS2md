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
public class Monitor {
    private Boolean inCS = false;
    
    public synchronized void enterCS(){
        if(inCS){
            try{
                wait();
            } catch (InterruptedException ex){
            }
            inCS = true;
        }
    }
    
    public synchronized void exitCS(){
        inCS = false;
        notify();
    }
}
