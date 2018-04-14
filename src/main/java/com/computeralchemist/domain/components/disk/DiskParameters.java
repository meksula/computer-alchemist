package com.computeralchemist.domain.components.disk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 07-04-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DiskParameters {
    private DriveType type;
    private String format;
    private int capacity;
    private double readSpeed;
    private double writeSpeed;
}
