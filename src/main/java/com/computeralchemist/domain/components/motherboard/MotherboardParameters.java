package com.computeralchemist.domain.components.motherboard;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

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

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public List<String> getProcesorAvailables() {
        return procesorAvailables;
    }

    public void setProcesorAvailables(List<String> procesorAvailables) {
        this.procesorAvailables = procesorAvailables;
    }

    public int getRamSockets() {
        return ramSockets;
    }

    public void setRamSockets(int ramSockets) {
        this.ramSockets = ramSockets;
    }

    public List<String> getOtherSockets() {
        return otherSockets;
    }

    public void setOtherSockets(List<String> otherSockets) {
        this.otherSockets = otherSockets;
    }

    public String getBios() {
        return bios;
    }

    public void setBios(String bios) {
        this.bios = bios;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMemoryFrequency() {
        return memoryFrequency;
    }

    public void setMemoryFrequency(double memoryFrequency) {
        this.memoryFrequency = memoryFrequency;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }
}
