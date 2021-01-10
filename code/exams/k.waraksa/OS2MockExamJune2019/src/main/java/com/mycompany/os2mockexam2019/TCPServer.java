/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.os2mockexam2019;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import jdk.net.Sockets;

/**
 *
 * @author kazik
 */
public class TCPServer {

    public static void main(String[] args) {
        Socket sock = null;
        List sockets = new ArrayList<Socket>();
        ServerSocket ss = null;

        try {
            while (true) {
                ss = new ServerSocket(2019);
                sock = ss.accept();
                sockets.add(sock);
                /*Thread t = new Thread(new Runnable(){
                    
                });
                t.start();*/
            }
        } catch (Exception ex){}
        finally {
            for (Socket s ){
                try {
                    if(s != null)
                        try {
                            s.close();
                        } catch (Exception ex){}
                    if(ss != null){
                        try{
                            ss.close();
                        } catch (Exception ex){}
                    }
                }
            }
        }
    }
}

/*

Scanner sc = new Scanner(sock.getInputStream());

or:

InputStream is = sock.getInputStream();
Scanner sc = new Scanner(is)

PrintWriterpw = new PrintWriter(sock.getOutputStream(), true);
pw.println("request");
String str = sc.Next();
System.out.printLn(str);


*/