package com.carwash.carwash;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    private Button registerOwnerButton;
    @FXML
    private Button registerCarButton;
    @FXML
    private Button createNewMembership;
    @FXML
    private Button checkMembershipsButton;
    @FXML
    private Button exitAppButton;

    @FXML
    private void initialize() {
        // add action listeners to the buttons
        registerOwnerButton.setOnAction(event -> {
            Stage stage = new Stage();
            Scene s = null;
            try {
                s = buildOwnerRegistration();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(s);
            stage.show();
        });
        registerCarButton.setOnAction(event -> {
            Stage stage = new Stage();
            Scene s = null;
            try {
                s = buildRegistration();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(s);
            stage.show();
        });
        createNewMembership.setOnAction(event -> {
            Stage stage = new Stage();
            Scene s = null;
            try {
                s = buildMembershipRegistration();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(s);
            stage.show();
        });
        checkMembershipsButton.setOnAction(event -> {
            Stage stage = new Stage();
            Scene s = null;
            try {
                s = buildManagement();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(s);
            stage.show();
        });
        exitAppButton.setOnAction(event -> {
            Platform.exit();
        });
    }

    Scene buildRegistration() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registration.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        return scene;
    }

    Scene buildOwnerRegistration() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ownerRegistration.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        return scene;
    }

    Scene buildMembershipRegistration() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("membershipRegistration.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        return scene;
    }

    Scene buildManagement() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("management.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        return scene;
    }
}
