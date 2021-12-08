package com.example.mutuelle_centralisee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ClientController implements Initializable {

    @FXML private TableView dataGrid;
    @FXML private TableColumn col_entreprise;
    @FXML private TableColumn col_date;
    @FXML private TableColumn col_nom;
    @FXML private TableColumn col_prenom;
    @FXML private TableColumn col_id;
    @FXML private TableColumn col_tel;
    @FXML private TableColumn col_email;
    @FXML private TableColumn col_adresse;




    //Client Attributes
    @FXML private TextField id;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField email;
    @FXML private ChoiceBox<String> country_list = new ChoiceBox<String>();
    @FXML private TextField tel;
    @FXML private TextField entreprise;
    @FXML private TextArea adresse;
    @FXML private DatePicker date;
    @FXML private RadioButton cin;
    @FXML private RadioButton pass;
    @FXML private TextField cinpass;
    @FXML private ToggleGroup choix;

    ObservableList<ArrayList> myClients = FXCollections.observableArrayList();
    //ArrayList myClients = new ArrayList();



    //get the dial_code from json file
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

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






        col_entreprise.setCellValueFactory(new PropertyValueFactory<ArrayList, String>("entreprise"));
        col_date.setCellValueFactory(new PropertyValueFactory<ArrayList, String>("date"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<ArrayList, String>("prenom"));
        col_nom.setCellValueFactory(new PropertyValueFactory<ArrayList, String>("nom"));
        col_id.setCellValueFactory(new PropertyValueFactory<ArrayList, String>("id"));
        col_tel.setCellValueFactory(new PropertyValueFactory<ArrayList, String>("tel"));
        col_email.setCellValueFactory(new PropertyValueFactory<ArrayList, String>("email"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<ArrayList, String>("adress"));

        dataGrid.setItems(myClients);
    }








    public void client(ActionEvent event) throws IOException {
        addClient();
    }

    //Add client function
    public void addClient() {

        Client client = new Client();
        ArrayList cl = new ArrayList();


        RadioButton selectedRadioButton = (RadioButton) choix.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();

        client.setId(this.id.getText());
        client.setNom(this.nom.getText());
        client.setPrenom(this.prenom.getText());
        client.setAdresse(this.adresse.getText());
        client.setEmail(this.email.getText());
        client.setEntreprise(this.entreprise.getText());
        client.setTel(this.tel.getText());
        client.setDate(this.date.getValue());
        client.setCountry_list(this.date.getEditor().getText());




        cl.add(client.getNom());
        cl.add(client.getPrenom());
        cl.add(client.getId());
        cl.add(client.getDate());
        cl.add(client.getTel());
        cl.add(client.getCountry_list());
        cl.add(client.getAdresse());
        cl.add(client.getEntreprise());
        cl.add(client.getEmail());


        myClients.add(cl);



/*

*/

        showClient();

    }



    public void showClient(){
        System.out.println(myClients);
    }


}
