/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatlocal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 885233
 */
public class ChatLocal extends Application {
    TextField textInput;
    ListView<String> listView;
    ObservableList<String> oList;
    
    @Override
    public void start(Stage primaryStage) {

        listView = new ListView<>();
        oList = FXCollections.observableArrayList();
        
        Label l = new Label();
        l.setText("Your text here:");
        
        textInput = new TextField();
        textInput.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String line = textInput.getText();
                oList.add("You: " + line);
                textInput.clear();
            }

        });
        
        listView.setItems(oList);        
        VBox vbox = new VBox();
        vbox.getChildren().add(listView);
        vbox.getChildren().add(l);
        vbox.getChildren().add(textInput);
        primaryStage.setScene(new Scene(vbox, 300, 250));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
