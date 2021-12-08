package com.example.mutuelle_centralisee;

import javafx.scene.control.Alert;

public class Helpers {

    public static void ShowError(String title,String headerText,String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();

    }



    public static void ShowSuccess(String title,String headerText,String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();

    }


    // Valider la taille :
    public static boolean IsValidLength(String value,int length){
        return value.length()<=length;
    }

    // Valider CIN:
    public static boolean IsValidCIN(String value){
        return value.matches("^[a-zA-Z]{2}[0-9]{6}$");
    }

    // Valider Passport :
    public static boolean IsValidPASSPORT(String value){
        return value.matches("^[a-zA-Z]{2}[0-9]{7}$");
    }

    // Valider Phone :
    public static boolean IsValidPhone(String value){
        return value.matches("^(6|7)[0-9]{8}$");
    }

    // Valider Email :
    public static boolean IsValidEmail(String value){
        return value.matches("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z][a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$");
    }


}
