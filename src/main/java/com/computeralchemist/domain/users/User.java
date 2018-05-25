package com.computeralchemist.domain.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@Getter
@Setter
@EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Document(collection = "users")
public class User {

    @Id
    private long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String username;

    @NotNull
    @Size(min = 2, max = 15)
    private String name;

    @NotNull
    @Size(min = 2, max = 20)
    private String surname;

    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 30)
    private String password;

    @Min(1930)
    @Max(2015)
    private int bornyear;

    private String[] roles;

    public User() {}

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.bornyear = user.getBornyear();
        this.roles = user.getRoles();
    }

}
