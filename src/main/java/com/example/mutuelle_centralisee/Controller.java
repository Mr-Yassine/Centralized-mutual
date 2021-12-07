package com.example.mutuelle_centralisee;
import java.io.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Controller {

    @FXML
    private Button button;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label message;





    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }



    public void checkLogin() throws IOException {


        MutualApplication m = new MutualApplication();
        JSONParser jsonParser = new JSONParser();



        try (FileReader reader = new FileReader("D:\\Java Project\\Mutuelle centralisee\\src\\main\\resources\\JSON\\fonctionnaires.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);



            for (Object o : employeeList) {

                JSONObject employee = (JSONObject) o;
                String email = (String) employee.get("email");
                String password = (String) employee.get("password");


                if ((this.email.getText().isEmpty() || this.password.getText().isEmpty())) {
                    message.setText("Please fill all the fields");
                    break;
                } else if (email.equals(this.email.getText()) && password.equals(this.password.getText())) {
                    message.setText("Success!");
                    m.changeScene("Client-view.fxml");
                    break;
                } else {
                    message.setText("Wrong email or password");
                }
            }


        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }



}