package com.example.mutuelle_centralisee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;





public class MutualApplication extends Application {





    private static Stage stg;


    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MutualApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 832, 500);
        stage.setTitle("Mutual Application");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MutualApplication.class.getResource(fxml));
        stg.setScene(new Scene(fxmlLoader.load()));
    }

    public static void main(String[] args) {
        launch();
    }
}