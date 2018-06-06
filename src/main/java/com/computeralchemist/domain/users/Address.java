package com.computeralchemist.domain.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author
 * Karol Meksuła
 * 01-06-2018
 * */

@Getter
@Setter
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Address {
    private String country;
    private String city;
    private String zipCode;
    private String houseNumber;
}
