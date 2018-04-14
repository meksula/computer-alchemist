package com.computeralchemist.domain.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Document(collection = "users")
public class User {
    @NotNull
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
        String c = ", ";
        return username + c + name + c + surname + c
                + email + c + bornyear;
    }

}
