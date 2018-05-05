package com.computeralchemist.domain.components.cpu;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CpuParameters {
    private int cores;
    private String series;
    private String socket;
    private int threads;
    private String bitArchitecture;
    private int cache;
    private double frequency;
    private String integratedGpu;
}
