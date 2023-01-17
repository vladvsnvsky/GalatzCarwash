package com.carwash.carwash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    @FXML
    private TableColumn<Membership, Void> actionColumn;
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
    public void initialize() {
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

        actionColumn.setCellFactory(param -> {
            final TableCell<Membership, Void> cell = new TableCell<Membership, Void>() {
                private final Button updateButton = new Button("Update");

                {
                    updateButton.setOnAction((ActionEvent event) -> {
                        Membership data = getTableView().getItems().get(getIndex());
                        String currentLicensePlate = data.getLicensePlateNumber();
                        String email = data.getEmail();
                        LocalDate membershipStartDate = LocalDate.now();
                        LocalDate membershipEndDate = membershipStartDate.minusMonths(1);
                        try {
                            Database.updateMembership(currentLicensePlate, email, membershipStartDate, membershipEndDate);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(updateButton);
                    }
                }
            };
            return cell;
        });
    }
}
