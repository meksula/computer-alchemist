package com.computeralchemist.controller.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 03-06-2018
 * */

@Getter
@Setter
public class BasicCredentials {
    private String username;
    private String password;

    public BasicCredentials(@JsonProperty("username") String username,
                            @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }
}
