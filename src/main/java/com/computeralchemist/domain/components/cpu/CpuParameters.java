package com.computeralchemist.domain.components.cpu;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

public class CpuParameters {
    private int cores;
    private String series;
    private String socket;
    private int threads;
    private String bitArchitecture;
    private int cache;
    private double frequency;

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public String getBitArchitecture() {
        return bitArchitecture;
    }

    public void setBitArchitecture(String bitArchitecture) {
        this.bitArchitecture = bitArchitecture;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
