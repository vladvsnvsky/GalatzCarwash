package com.carwash.carwash;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CarwashApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene s = buildDashboard();
        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }

    Scene buildDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        return scene;
    }
}