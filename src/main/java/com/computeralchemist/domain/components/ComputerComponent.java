package com.computeralchemist.domain.components;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class ComputerComponent {

    @NotNull
    private ComponentType componentType;

    @NotNull
    private String producent;

    @NotNull
    private String model;
    private String description;
    private String urlToResource;
    private double compatibleIndex;

}
