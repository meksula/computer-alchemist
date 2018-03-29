package com.computeralchemist.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@Document
public class User {
    @Id
    private long id;

    @Field("username")
    private String username;

    @Field("name")
    private String name;

    @Field("surname")
    private String surname;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Field("bornyear")
    private int bornyear;


    @Override
    public String toString() {
        String c = " ,";
        return username + c + name + c + surname +
                email + bornyear;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBornyear() {
        return bornyear;
    }

    public void setBornyear(int bornyear) {
        this.bornyear = bornyear;
    }
}
