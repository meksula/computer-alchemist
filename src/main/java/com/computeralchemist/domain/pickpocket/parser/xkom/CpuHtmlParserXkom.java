package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.cpu.CpuParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class CpuHtmlParserXkom extends AbstractHtmlParser {
    private Cpu cpu;
    private CpuParameters parameters;

    private final int DESCRIPTION_INDEX = 59;
    private final int SERIES_INDEX = 6;
    private final int SOCKET_INDEX = 8;
    private final int FREQUENCY_INDEX = 9;
    private final int CORES_INDEX = 10;
    private final int THREADS_INDEX = 11;
    private final int CACHE_INDEX = 12;
    private final int GPU_INDEX = 13;

    private final String DEFAULT_BIT_ARCH = "64bit";

    public CpuHtmlParserXkom() {
        computerComponent = new Cpu();
        parameters = new CpuParameters();
        this.cpu = (Cpu) computerComponent;
        cpu.setCpuParameters(parameters);
    }

    @Override
    public void documentToObject() {
        cpu.setComponentType(ComponentType.cpu);
        parameters.setBitArchitecture(DEFAULT_BIT_ARCH);
        setProducent();
        setModel();
        setDescription();
        setSeries();
        setSocket();
        setFrequency();
        setCores();
        setThreads();
        setCache();
        setGpu();
    }

    private void setDescription() {
        List<String> textList = document.select("p").eachText();
        String description = textList.get(DESCRIPTION_INDEX);

        computerComponent.setDescription(description);
    }

    private void setSeries() {
        String series = fetchTrTags().get(SERIES_INDEX).text();
        String[] splited = series.split("\\s");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < splited.length; i++) {
            if (i > 1)
                builder.append(splited[i]);
            if (i > 1 && i < splited.length - 1)
                builder.append(" ");
        }

        parameters.setSeries(builder.toString());
    }

    private void setSocket() {
        String socket = fetchTrTags().get(SOCKET_INDEX).text();
        String socketExtracted = socket.substring(27);
        parameters.setSocket(socketExtracted);
    }

    private void setFrequency() {
        double frequency = extractDoubleFromString(fetchTrTags().get(FREQUENCY_INDEX).text());
        parameters.setFrequency(frequency);
    }

    private void setCores() {
        double cores = extractDoubleFromString(fetchTrTags().get(CORES_INDEX).text());
        parameters.setCores((int) cores);
    }

    private void setThreads() {
        double threads = extractDoubleFromString(fetchTrTags().get(THREADS_INDEX).text());
        parameters.setThreads((int) threads);
    }

    private void setCache() {
        double cache = extractDoubleFromString(fetchTrTags().get(CACHE_INDEX).text());
        parameters.setCache((int) cache);
    }

    private void setGpu() {
        final int POSITION_INDEX = 29;
        String gpu = fetchTrTags().get(GPU_INDEX).text();
        String extractedGpu = gpu.substring(POSITION_INDEX);
        parameters.setIntegratedGpu(extractedGpu);
    }

}
