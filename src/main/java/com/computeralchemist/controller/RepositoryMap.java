package com.computeralchemist.controller;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.JsonParsers;
import com.computeralchemist.repository.components.ComponentRepository;
import com.computeralchemist.repository.components.cpu.CpuRepository;
import com.computeralchemist.repository.components.ram.RamRepository;
import com.computeralchemist.repository.components.motherboard.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RepositoryMap {
    private Map<String, ComponentRepository> repositories = new HashMap<>();

    private MotherboardRepository motherboardRepository;
    private CpuRepository cpuRepository;
    private RamRepository ramRepository;

    @Autowired
    public void setMotherboardRepository(MotherboardRepository motherboardRepository,
                                         CpuRepository cpuRepository,
                                         RamRepository ramRepository) {
        this.motherboardRepository = motherboardRepository;
        this.cpuRepository = cpuRepository;
        this.ramRepository = ramRepository;

        fillMap();
    }

    public ComputerComponent findComponent(String component, long id) {
        ComponentRepository componentRepository = repositories.get(component);
        return (ComputerComponent) componentRepository.findByProductId(id);
    }

    public void saveComponent(String json, String type) throws IOException {
        ComponentRepository componentRepository = repositories.get(type);
        componentRepository.save(JsonParsers.valueOf(type).parseStringToComponent(json));
    }

    private void fillMap() {
        repositories.put("motherboard", motherboardRepository);
        repositories.put("cpu", cpuRepository);
        repositories.put("ram", ramRepository);
    }

}
