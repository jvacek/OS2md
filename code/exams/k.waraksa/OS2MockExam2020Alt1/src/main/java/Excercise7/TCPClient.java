/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercise7;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author kazik
 */
public class TCPClient {

    public static void main(String[] args) {
        Socket sock = null;
        try {
            sock = new Socket("localhost", 2020);

	          // code to use socket for communication
	          // …

        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }
        finally {
            try {
                if (sock != null)
                    sock.close();
            } catch (IOException ex) {
                // handle exception
            }
        }
    }    
}

