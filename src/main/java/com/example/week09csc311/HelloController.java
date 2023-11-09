package com.example.week09csc311;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;





public class HelloController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField dobField;
    @FXML
    private TextField zipCodeField;
    @FXML
    private Button addButton;
    @FXML
    private Label statusLabel;

    public void initialize() {
        addButton.setDisable(true); // Initially disable the "Add" button
    }

    public boolean validateFirstName(String firstName) {
        String nameRegex = "^[A-Za-z]{2,25}$";
        return firstName.matches(nameRegex);
    }

    public boolean validateLastName(String lastName) {
        String nameRegex = "^[A-Za-z]{2,25}$";
        return lastName.matches(nameRegex);
    }

    public boolean validateDateOfBirth(String dob) {
        String dobRegex = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d{2}$";
        return dob.matches(dobRegex);
    }

    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@farmingdale\\.edu$";
        return email.matches(emailRegex);
    }

    public boolean validateZipCode(String zip) {
        String zipRegex = "^\\d{5}$";
        return zip.matches(zipRegex);
    }

    public void validateFields() {
        boolean isValidFirstName = validateFirstName(firstNameField.getText());
        boolean isValidLastName = validateLastName(lastNameField.getText());
        boolean isValidDOB = validateDateOfBirth(dobField.getText());
        boolean isValidEmail = validateEmail(emailField.getText());
        boolean isValidZipCode = validateZipCode(zipCodeField.getText());

        addButton.setDisable(!(isValidFirstName && isValidLastName && isValidDOB && isValidEmail && isValidZipCode));

        if (isValidFirstName && isValidLastName && isValidDOB && isValidEmail && isValidZipCode) {
            statusLabel.setText("All fields are valid!");
        } else {
            statusLabel.setText("Please enter valid data in all fields.");
        }
    }


    public void navigateToNewUI() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\Rapto\\IdeaProjects\\UIAccessory\\src\\main\\resources\\com\\example\\uiaccessory\\hello-view.fxml").toURI().toURL());
            Parent root = loader.load();

            // Create a new scene with the new FXML content
            Scene scene = new Scene(root);

            // Get the stage from the existing UI
            Stage stage = (Stage) addButton.getScene().getWindow();

            // Set the new scene to the stage
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }



    @FXML
    private void onTextFieldKeyReleased() {
        validateFields();
    }


    @FXML
    public void onAddButtonClick() {
        if (!addButton.isDisabled()) {
            navigateToNewUI();
        }
    }
}
