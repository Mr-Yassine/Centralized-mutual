package com.example.mutuelle_centralisee;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Client {


    private String id;
    private String nom;
    private String prenom;
    private String country_list;
    private String tel;
    private String entreprise;
    private String Adresse;
    private LocalDate date;
    private String email;



    public Client(){}

    public Client(String nom, String prenom, String id, String email, String country_list, String tel, String entreprise, String Adresse, LocalDate date){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.entreprise = entreprise;
        this.Adresse = Adresse;
        this.date = date;
        this.country_list = country_list;
    }

    public Client(String nom, String prenom, String id, String country_list, String tel, String entreprise, String Adresse, LocalDate date, String cin, String pass, String email){

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.country_list = country_list;
        this.tel = tel;
        this.entreprise = entreprise;
        this.Adresse = Adresse;
        this.date = date;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCountry_list() {
        return country_list;
    }
    public void setCountry_list(String country_list) {
        this.country_list = country_list;
    }

    public String getTel() {return tel;}
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEntreprise() {
        return entreprise;
    }
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getAdresse() {
        return Adresse;
    }
    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}






    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MutualApplication.class.getResource("client-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 740, 647);
        stage.setTitle("Add Client");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }





}
