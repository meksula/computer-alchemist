package com.computeralchemist.domain.components;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public abstract class ComputerComponent {
    private String producent;
    private String model;
    private String description;
    private String urlToResource;
    private double compatibiltyIndex;
    private ComponentType componentType;

    public String getModel() {
        return model;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCompatibiltyIndex() {
        return compatibiltyIndex;
    }

    public void setCompatibiltyIndex(double compatibiltyIndex) {
        this.compatibiltyIndex = compatibiltyIndex;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public String getUrlToResource() {
        return urlToResource;
    }

    public void setUrlToResource(String urlToResource) {
        this.urlToResource = urlToResource;
    }
}
