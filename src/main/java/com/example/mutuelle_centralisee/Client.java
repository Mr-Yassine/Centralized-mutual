package com.example.mutuelle_centralisee;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Client {



    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MutualApplication.class.getResource("client-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 740, 647);
        stage.setTitle("Add Client");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
