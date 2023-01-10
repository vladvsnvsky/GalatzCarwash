package com.carwash.carwash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ManagementController {
    @FXML
    public TableView<Membership> membershipTable;

    @FXML
    public TableColumn<Membership, Integer> IDColumn = new TableColumn<>("Id");

    @FXML
    public TableColumn<Membership, String> emailColumn = new TableColumn<>("Email");

    @FXML
    public TableColumn<Membership, String> licensePlateColumn = new TableColumn<>("License Plate:");
    @FXML
    public TableColumn<Membership, LocalDate> startDateColumn = new TableColumn<>("Start Date");
    @FXML
    public TableColumn<Membership, LocalDate> endDateColumn = new TableColumn<>("End Date");
    @FXML
    public TableColumn<Membership, String> availabilityColumn = new TableColumn<>("Availability");
    public TextField searchTextField;
    public Button searchByEmailButton;
    public Button searchByPlatesButton;
    public Button showActiveMembershipsButton;
    public Button showExpiredMembershipsButton;

    ObservableList<Membership> obsList;

    public List<Membership> loadMembershipsFromDB() throws SQLException {
        List<Membership> memberships = Database.getAllMemberships();
        return memberships;
    }

    @FXML
    public void initialize(){
        this.IDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.licensePlateColumn.setCellValueFactory(new PropertyValueFactory<>("licensePlateNumber"));
        this.startDateColumn.setCellValueFactory(new PropertyValueFactory<>("membershipStartDate"));
        this.endDateColumn.setCellValueFactory(new PropertyValueFactory<>("membershipEndDate"));
        this.availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        try {
            List<Membership> memberships = this.loadMembershipsFromDB();

            this.membershipTable.setItems(FXCollections.observableArrayList(memberships));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
