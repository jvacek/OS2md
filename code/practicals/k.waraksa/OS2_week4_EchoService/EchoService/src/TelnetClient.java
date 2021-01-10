
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jaapg
 */
public class TelnetClient {

    private static final int PORT = 1974;
    private static final String HOST = "localhost";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Socket socket = null;
        try {
            socket = new Socket(HOST,PORT);
        
        
        /* Code to send lines from the console to the socket
           and read lines from the scoket and display on the console */
            
            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
            Scanner socketScanner = new Scanner(socket.getInputStream());
            Scanner consoleScanner = new Scanner(System.in);

            while (true) {
                String line = consoleScanner.nextLine();
                socketWriter.println(line);
                socketWriter.flush();

                if (line.equals("QUIT")){
                    break;
                }

                String reply = socketScanner.nextLine();
                System.out.println("From server: " + reply);
            }
        }
        
        catch (IOException ex) {
            Logger.getLogger(TelnetClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(TelnetClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}