package com.computeralchemist.domain.components.motherboard;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public class MotherboardParameters {
    private String chipset;
    private String socket;
    private int ramSockets;
    private String bios;
    private List<String> procesorAvailables;
    private List<String> otherSockets;

    public String info() {
        return "chipset: " + chipset + ", socket: " + socket + ", " + bios;
    }

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


}
