package com.example.mutuelle_centralisee;

import javafx.beans.property.SimpleStringProperty;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;


public class ClientController implements Initializable {



    @FXML private TableView<Client> dataGrid;

    @FXML private TableColumn<Client, String>  col_id;
    @FXML private TableColumn<Client, String>  col_nom;
    @FXML private TableColumn<Client, String>  col_prenom;
    @FXML private TableColumn<Client, String>  col_tel;
    @FXML private TableColumn<Client, String>  col_email;
    @FXML private TableColumn<Client, String>  col_adresse;
    @FXML private TableColumn<Client, String> col_entreprise;
    @FXML private TableColumn<Client, String>  col_date;




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
    @FXML private ToggleGroup choix;
    @FXML private RadioButton cin;
    @FXML private RadioButton pass;



    Client client = new Client();
    ObservableList<ArrayList> myClients = FXCollections.observableArrayList();
    ArrayList<Client> clientsG = new ArrayList<Client>();





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

    }













    //Add client function
    public void addClient(ActionEvent event) throws IOException {


        //RadioButton selectedRadioButton = (RadioButton) choix.getSelectedToggle();


        if (Validation()) {

            client.setId(this.id.getText());
            client.setNom(this.nom.getText());
            client.setPrenom(this.prenom.getText());
            client.setAdresse(this.adresse.getText());
            client.setEmail(this.email.getText());
            client.setEntreprise(this.entreprise.getText());
            client.setTel("(" + this.country_list.getSelectionModel().getSelectedItem() +") "+ this.tel.getText());
            client.setDate(this.date.getValue());
            //client.setCountry_list(this.country_list.getSelectionModel().getSelectedItem());

            clientsG.add(client);



            col_id.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
            col_nom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
            col_tel.setCellValueFactory(new PropertyValueFactory<Client, String>("tel"));
            col_email.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
            col_adresse.setCellValueFactory(new PropertyValueFactory<Client, String>("Adresse"));
            col_entreprise.setCellValueFactory(new PropertyValueFactory<Client, String>("entreprise"));
            col_date.setCellValueFactory(new PropertyValueFactory<Client, String>("date"));

            dataGrid.getItems().setAll(clientsG);



            ClearTable();
        }



    }










    private boolean Validation() {


        if(!Helpers.LengthValidation(entreprise.getText(),50)){
            Helpers.Error("Erreur de validation", "Longueur incorrect.", "champ nameCompany.");
            return  false;
        }

        if(!Helpers.LengthValidation(nom.getText(),50)){
            Helpers.Error("Erreur de validation", "Longueur incorrect.", "champ first name.");
            return  false;
        }


        if(!Helpers.LengthValidation(prenom.getText(),50)){
            Helpers.Error("Erreur de validation", "Longueur incorrect.", "champ last name.");
            return  false;
        }



        if(cin.isSelected()){
            if(!Helpers.CinValidation(id.getText())){
                Helpers.Error("Erreur de validation", "format CIN incorrect.", "example CIN: AA000");
                return  false;
            }
        }else{
            if(!Helpers.PassValidation(id.getText())){
                Helpers.Error("Erreur de validation", "format PASSPORT incorrect.", "example PASSPORT: AA00000");
                return  false;
            }
        }

        if(!Helpers.PhoneValidation(tel.getText())){
            Helpers.Error("Erreur de validation", "format Phone incorrect.", "examples : 60000 or 70000. ");
            return  false;
        }

        if(!Helpers.EmailValidation(email.getText())){
            Helpers.Error("Erreur de validation", "format Email incorrect.", "example: prenom@domaine.com");
            return  false;
        }



        return true;
    }












    public void ClearTable() {

        this.id.setText("");
        this.nom.setText("");
        this.prenom.setText("");
        this.country_list.setValue(null);
        this.tel.setText("");
        this.email.setText("");
        this.adresse.setText("");
        this.entreprise.setText("");
        this.date.setValue(null);

    }

}
