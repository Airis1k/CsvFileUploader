package com.example.CsvFileUploader.Entity;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class User {

    @Id
    @Column(name = "id")
    @CsvBindByName(column = "Id")
    private long id;
    @Column(name = "name")
    @CsvBindByName(column = "Name")
    private String name;
    @Column(name = "email")
    @CsvBindByName(column = "Email")
    private String email;
    @Column(name = "number")
    @CsvBindByName(column = "Number")
    private String number;

    public User() {
        super();
    }

    public User(long id, String name, String email, String number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public User(String name, String email, String number) {
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
