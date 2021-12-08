package com.example.mutuelle_centralisee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ClientController {


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
    private TextField email;
    @FXML
    private ChoiceBox<String> country_list = new ChoiceBox<String>();
    @FXML
    private TextField tel;
    @FXML
    private TextField entreprise;
    @FXML
    private TextArea adresse;
    @FXML
    private DatePicker date;
    @FXML
    private RadioButton cin;
    @FXML
    private RadioButton pass;







    //get the dial_code from json file
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






    ArrayList<ArrayList<String>> myClients = new ArrayList<ArrayList<String>>();

    public void client(ActionEvent event) throws IOException {
        addClient();
    }

    //Add client function
    public void addClient() {

        Client client = new Client();
        ArrayList<String> cl = new ArrayList<String>();

        client.setNom(this.nom.getText());
        client.setPrenom(this.prenom.getText());
        client.setId(this.id.getText());
        client.setAdresse(this.adresse.getText());
        client.setEmail(this.email.getText());
        client.setEntreprise(this.entreprise.getText());
        client.setTel(Integer.parseInt(this.tel.getText()));



        cl.add(client.getNom());
        cl.add(client.getPrenom());
        cl.add(client.getId());
        cl.add(String.valueOf(client.getDate()));
        cl.add(client.getCountry_list());
        cl.add(client.getAdresse());
        cl.add(String.valueOf(client.getTel()));
        cl.add(client.getEntreprise());
        cl.add(client.getEmail());



        myClients.add(cl);
        showClient();

    }


    public void showClient(){
        System.out.println(myClients);
    }


}
