package com.computeralchemist.domain.components.ram;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RamParameters {
    private String memoryType;
    private String cooler;
    private int modules;
    private int capacityGb;
    private double frequency;
    private String socketType;
}
