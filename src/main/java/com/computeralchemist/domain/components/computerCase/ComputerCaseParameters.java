package com.computeralchemist.domain.components.computerCase;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

public class ComputerCaseParameters {
    private String type;
    private double height;
    private double width;
    private double weight;
    private List<String> compatibilityMotherboards;
    private List<String> connectors;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<String> getCompatibilityMotherboards() {
        return compatibilityMotherboards;
    }

    public void setCompatibilityMotherboards(List<String> compatibilityMotherboards) {
        this.compatibilityMotherboards = compatibilityMotherboards;
    }

    public List<String> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<String> connectors) {
        this.connectors = connectors;
    }
}
