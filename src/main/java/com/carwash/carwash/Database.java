package com.carwash.carwash;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/carwash";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void insertOwner(String lastName, String firstName, String email) {
        String sql = "INSERT INTO owner (last_name, first_name, email) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, email);

            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertCar(String licensePlateNumber, String make, String model, int year) {
        String sql = "INSERT INTO cars (license_plate_number, make, model, year) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, licensePlateNumber);
            statement.setString(2, make);
            statement.setString(3, model);
            statement.setInt(4, year);

            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertMembership(String licensePlate, String email, LocalDate membershipStartDate, LocalDate membershipEndDate) throws SQLException {
        // Construct the SQL INSERT statement
        String sql = "INSERT INTO membership (car_id, email, license_plate_number, membership_start_date, membership_end_date) VALUES (?, ?, ?, ?, ?)";

        // Create a PreparedStatement
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the values for the placeholders in the SQL statement

            int carId = Database.getCarByLicensePlateNumber(licensePlate).id;

            statement.setInt(1, carId);
            statement.setString(2, email);
            statement.setString(3, licensePlate);
            statement.setObject(4, membershipStartDate);
            statement.setObject(5, membershipEndDate);

            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Car getCarByLicensePlateNumber(String licensePlate) {
        String sql = "SELECT * FROM cars WHERE license_plate_number = ?";

        Car c = new Car();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, licensePlate);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                c.id = rs.getInt(1);
                c.licensePlateNumber = rs.getString(2);
                c.make = rs.getString(3);
                c.model = rs.getString(4);
                c.year = rs.getInt(5);
                c.owner = rs.getInt(6);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public static List<Membership> getAllMemberships() throws SQLException{

        List<Membership> memberships = new ArrayList<>();
        String sql = "SELECT * FROM membership";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                int car_id = rs.getInt(2);
                String licensePlateNumber = rs.getString(6);
                LocalDate startDate = rs.getDate(4).toLocalDate();
                LocalDate endDate = rs.getDate(5).toLocalDate();
                String email= rs.getString(3);
                Membership m = new Membership(id, email, licensePlateNumber, startDate, endDate, car_id);

                if(endDate.isBefore(LocalDate.now()))
                    m.availability = false;
                else m.availability = true;

                memberships.add(m);
            }
            return memberships;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
