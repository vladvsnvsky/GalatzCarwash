package com.carwash.carwash;

import java.time.LocalDate;

public class Membership {

    public int id;

    public String email;
    public LocalDate membershipStartDate;
    public LocalDate membershipEndDate;
    public int carId;
    public String licensePlateNumber;
    public boolean availability;

    public Membership(int id, String email, String licensePlateNumber, LocalDate membershipStartDate, LocalDate membershipEndDate, int carId) {
        this.id = id;
        this.email = email;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
        this.licensePlateNumber = licensePlateNumber;
        this.carId = carId;
    }

    public Membership(String email, LocalDate membershipStartDate, LocalDate membershipEndDate, int carId) {
        this.email = email;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
        this.carId = carId;
    }

    public Membership(String email, LocalDate membershipStartDate, LocalDate membershipEndDate) {
        this.email = email;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public LocalDate getMembershipEndDate() {
        return membershipEndDate;
    }

    public int getCarId() {
        return carId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public boolean isAvailability() {
        return availability;
    }
}
