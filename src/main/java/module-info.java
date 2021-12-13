module com.example.mutuelle_centralisee {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires json.simple;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.mutuelle_centralisee to javafx.base, javafx.fxml;
    exports com.example.mutuelle_centralisee;
}