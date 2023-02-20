package com.example.CsvFileUploader;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName(column = "Id")
    private long id;
    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "Email")
    private String email;
    @CsvBindByName(column = "Number")
    private String number;

    public User() {

    }

    public User(long id, String name, String email, String number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
