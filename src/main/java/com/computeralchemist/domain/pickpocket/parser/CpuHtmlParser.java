package com.computeralchemist.domain.pickpocket.parser;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.cpu.Cpu;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class CpuHtmlParser extends AbstractHtmlParser {

    @Override
    public ComputerComponent parseHtmlToObject(String url) {
        ComputerComponent computerComponent = new Cpu();
        computerComponent.setProducent("intel");
        return computerComponent;
    }
}
