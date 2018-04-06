package com.computeralchemist.domain.components;

import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 06-04-2018
 * */

public enum JsonParsers {

    motherboard {
        @Override
        public ComputerComponent parseStringToComponent(String json) throws IOException {
            return objectMapper.readValue(json, Motherboard.class);
        }
    },

    cpu {
        @Override
        public ComputerComponent parseStringToComponent(String json) throws IOException {
            return objectMapper.readValue(json, Cpu.class);
        }
    },

    ram {
        @Override
        public ComputerComponent parseStringToComponent(String json) throws IOException {
            return objectMapper.readValue(json, Ram.class);
        }
    };

    public abstract ComputerComponent parseStringToComponent(String json) throws IOException;

    protected ObjectMapper objectMapper = new ObjectMapper();
}
