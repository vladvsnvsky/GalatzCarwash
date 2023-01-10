package com.carwash.carwash;

public class Owner {
    public int id;
    public String last_name;

    public String first_name;

    public String email;

    public Owner(String last_name, String first_name, String email) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
    }

    public Owner(int id, String last_name, String first_name, String email) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
    }
}
