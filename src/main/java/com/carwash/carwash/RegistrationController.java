package com.carwash.carwash;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrationController {
    @FXML
    private TextField licensePlateNumberField;

    @FXML
    private TextField makeField;

    @FXML
    private TextField modelField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField currentMileageField;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    // Add event handlers for the add and cancel buttons
    // and any other logic you want to include in the controller
    @FXML
    public void submit() {
        // Get the values from the text fields
        String licensePlateNumber = licensePlateNumberField.getText();
        String make = makeField.getText();
        String model = modelField.getText();
        int year = Integer.parseInt(yearField.getText());
        int currentMilleage = Integer.parseInt(currentMileageField.getText());

        Database.insertCar(licensePlateNumber, make, model, year);
    }
}
