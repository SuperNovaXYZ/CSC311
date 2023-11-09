module com.example.uiaccessory {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uiaccessory to javafx.fxml;
    exports com.example.uiaccessory;
}