package com.example.mutuelle_centralisee;
import java.io.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Controller {

    //Login Attributes
    @FXML
    private Button button;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label message;








    //Client Attributes
    @FXML
    private Button submit;
    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private ChoiceBox<String> country_list=new ChoiceBox<String>();
    @FXML
    private TextField tel;
    @FXML
    private TextField entreprise;
    @FXML
    private TextArea Adresse;
    @FXML
    private DatePicker date;
    @FXML
    private RadioButton cin;
    @FXML
    private RadioButton pass;





    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }
    public void client(ActionEvent event) throws IOException {
        addClient();
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
                    m.changeScene("client-view.fxml");
                    break;
                } else {
                    message.setText("Wrong email or password");
                }
            }


        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }





    public void addClient() {

        Client client = new Client();


        ArrayList<String> myClients = new ArrayList<String>();




    }









    public void initialize(){

        JSONParser jsonParser = new JSONParser();



        try (FileReader reader = new FileReader("D:\\Java Project\\Mutuelle centralisee\\src\\main\\resources\\JSON\\Code Pays.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray country = (JSONArray) obj;


            for (Object o : country) {
                JSONObject country_obj = (JSONObject) o;
                String country_code = (String) country_obj.get("dial_code");
//System.out.println(country_code);
                country_list.getItems().add(country_code);
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }



}