package com.carwash.carwash;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class OwnerRegistrationController {
    @FXML
    private TextField lastNameField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField emailField;

    @FXML
    private Button submitButton;

    @FXML
    public void submit() {
        // Get the values from the text fields
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String email = emailField.getText();

        // Create a new Owner object
        Owner owner = new Owner(firstName, lastName, email);

        Database.insertOwner(firstName, lastName, email);
    }
}
