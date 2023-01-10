package com.carwash.carwash;

public class Car {
    public int id;
    public String licensePlateNumber;
    public String make;

    public String model;
    public int year;
    public int owner;

    public Car() {
    }

    public Car(String licensePlateNumber, String make, String model, int year) {
        this.licensePlateNumber = licensePlateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(int id, String licensePlateNumber, String make, String model, int year) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }
}
