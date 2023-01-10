package com.carwash.carwash;

import java.sql.SQLException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class MembershipRegistrationController {
    @FXML
    private TextField emailField;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TextField licensePlateField;
    @FXML
    private Button submitButton;

    public void submit() throws SQLException {
        String email = emailField.getText();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        String licensePlate = licensePlateField.getText();

        // Create a new Membership object with the data
        Membership membership = new Membership(email, startDate, endDate);

        // Save the membership to the database or whatever else you need to do
        // with the membership object here
        Database.insertMembership(licensePlate, email, startDate, endDate);
    }
}
