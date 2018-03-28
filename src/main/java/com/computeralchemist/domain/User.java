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

}
