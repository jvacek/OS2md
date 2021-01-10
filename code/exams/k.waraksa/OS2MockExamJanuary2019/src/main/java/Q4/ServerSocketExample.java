/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author kazik
 */
public class ServerSocketExample {
    try {
        ServerSocket ss = new ServerSocket(8100);
        Socket s = ss.accept();
    } catch (IOException ex) 
    {}
}
