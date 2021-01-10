/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

/**
 *
 * @author kazik
 */
public class BusDriver implements Runnable {
    private String destination;

    public BusDriver(String destination) {
        this.destination = destination;
    }

    @Override
    public void run() throws InterruptedException {
        DoSomeThings();
        DriveFromAirportToHotel(destination);
        DoOtherThings();
    }
}
