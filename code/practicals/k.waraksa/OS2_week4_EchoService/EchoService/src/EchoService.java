/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaapg
 */
public class EchoService {

    private static final int PORT = 1974;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;
        
        try {
            ss = new ServerSocket(PORT);
            socket = ss.accept();


        /* Setup an incoming socket here */
        /* Read messages from the socket and bounce them back */
            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
            Scanner socketScanner = new Scanner(socket.getInputStream());
            
            boolean quit = false;
            String line = socketScanner.nextLine();
            
            if (line.equals("QUIT")){
                quit = true;
            }
            
            while (!quit) {
                socketWriter.println(line);
                socketWriter.flush();
                line = socketScanner.nextLine();
                
                if (line.equals("QUIT")) {
                    quit = true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EchoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (ss != null){
                    ss.close();
                }

                if (socket != null){
                    socket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(EchoService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
