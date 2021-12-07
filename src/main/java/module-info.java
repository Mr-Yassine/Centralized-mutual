module com.example.mutuelle_centralisee {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires json.simple;

    opens com.example.mutuelle_centralisee to javafx.fxml;
    exports com.example.mutuelle_centralisee;
}