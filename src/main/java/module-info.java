module com.example.filehandling11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.filehandling11 to javafx.fxml;
    exports com.example.filehandling11;
}