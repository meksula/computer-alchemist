package com.computeralchemist.domain.components.supply;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

@Getter
@Setter
@EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PowerSupplyParameters {
    private String standard;
    private int power;
    private String pfc;
    private String cooler;
    private boolean modularCable;
    private List<String> connectors;
}
