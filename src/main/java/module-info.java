module com.example.week09csc311 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week09csc311 to javafx.fxml;
    exports com.example.week09csc311;
}