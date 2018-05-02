package com.computeralchemist.domain.components.motherboard;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MotherboardParameters {
    private String type;
    private String chipset;
    private String socket;
    private int ramSockets;
    private String bios;
    private String memoryType;
    private double memoryFrequency;
    private List<String> procesorAvailables;
    private List<String> otherSockets;
}
