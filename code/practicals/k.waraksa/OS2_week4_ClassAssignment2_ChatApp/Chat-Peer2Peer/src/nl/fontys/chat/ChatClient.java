/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.chat;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author jaapg
 */
public class ChatClient extends Application {

    private final int RECONNECT_DELAY = 1000;

    TextField textInput;
    ListView<String> listView;
    ObservableList<String> oList;

    private static String name = "Marc";
    private static String hostname = "localhost";
    private static int port = 1974;

    // Use this to connect to the server
    InetSocketAddress endpoint = new InetSocketAddress(hostname, port);

    // Scanner and PrintWriter to read and send strings from/to a socket
    Scanner scanSock = null;
    PrintWriter pw = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("My Chat - client");
        textInput = new TextField();
        textInput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                sendText(textInput.getText());
            }
        });

        listView = new ListView<>();
        oList = FXCollections.observableArrayList();

        listView.setItems(oList);

        BorderPane root = new BorderPane();
        root.setCenter(listView);
        root.setBottom(textInput);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        /* TODO: create a thread which runs handleNetwork() */
    }

    public void sendText(String line) {
        /* TODO: Send the string to the socket */
    }

    public void handleNetwork() {
        /* TODO: This method should run as a thread */

 /* TODO: setup the connection */
 /* TODO: Once connected create the PrintWriter & Scanner */
 /* TODO: read data from the socket and show it on the UI */
    }

    @Override
    public void stop() {
        /* TODO: stop the thread and close the socket */
    }
}

