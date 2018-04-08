package com.computeralchemist.domain.components.gpu;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

public class GraphicsCardParameters {
    private String chipset;
    private int memory;
    private String memoryType;
    private String mainConnectorType;
    private double length;
    private double clockFrequency;
    private double memoryFrequency;
    private String resolution;
    private String cooler;
    private List<String> standards;
    private List<String> connectors;

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getMainConnectorType() {
        return mainConnectorType;
    }

    public void setMainConnectorType(String mainConnectorType) {
        this.mainConnectorType = mainConnectorType;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getClockFrequency() {
        return clockFrequency;
    }

    public void setClockFrequency(double clockFrequency) {
        this.clockFrequency = clockFrequency;
    }

    public double getMemoryFrequency() {
        return memoryFrequency;
    }

    public void setMemoryFrequency(double memoryFrequency) {
        this.memoryFrequency = memoryFrequency;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCooler() {
        return cooler;
    }

    public void setCooler(String cooler) {
        this.cooler = cooler;
    }

    public List<String> getStandards() {
        return standards;
    }

    public void setStandards(List<String> standards) {
        this.standards = standards;
    }

    public List<String> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<String> connectors) {
        this.connectors = connectors;
    }
}
