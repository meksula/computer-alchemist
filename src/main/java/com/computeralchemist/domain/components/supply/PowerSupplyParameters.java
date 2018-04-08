package com.computeralchemist.domain.components.supply;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

public class PowerSupplyParameters {
    private String standard;
    private int power;
    private String pfc;
    private String cooler;
    private boolean modularCable;
    private List<String> connectors;

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getPfc() {
        return pfc;
    }

    public void setPfc(String pfc) {
        this.pfc = pfc;
    }

    public String getCooler() {
        return cooler;
    }

    public void setCooler(String cooler) {
        this.cooler = cooler;
    }

    public boolean isModularCable() {
        return modularCable;
    }

    public void setModularCable(boolean modularCable) {
        this.modularCable = modularCable;
    }

    public List<String> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<String> connectors) {
        this.connectors = connectors;
    }
}
