package com.computeralchemist.domain.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private int bornyear;
    private Address address;

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
        this.address = user.getAddress();
    }

}
