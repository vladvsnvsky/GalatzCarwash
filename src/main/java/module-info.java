module com.carwash.carwash {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.carwash.carwash to javafx.fxml;
    exports com.carwash.carwash;
}