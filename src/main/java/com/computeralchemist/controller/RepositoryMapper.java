package com.computeralchemist.controller;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.JsonParsers;
import com.computeralchemist.domain.components.exceptions.RepositoryMapperException;
import com.computeralchemist.repository.components.ComponentRepository;
import com.computeralchemist.repository.components.cpu.CpuRepository;
import com.computeralchemist.repository.components.disk.DiskRepository;
import com.computeralchemist.repository.components.ram.RamRepository;
import com.computeralchemist.repository.components.motherboard.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 06-04-2018
 * */

@Service
public class RepositoryMapper {
    private Map<String, ComponentRepository> repositories = new HashMap<>();

    private MotherboardRepository motherboardRepository;
    private CpuRepository cpuRepository;
    private RamRepository ramRepository;
    private DiskRepository diskRepository;

    @Autowired
    public void setMotherboardRepository(MotherboardRepository motherboardRepository,
                                         CpuRepository cpuRepository,
                                         RamRepository ramRepository,
                                         DiskRepository diskRepository) {
        this.motherboardRepository = motherboardRepository;
        this.cpuRepository = cpuRepository;
        this.ramRepository = ramRepository;
        this.diskRepository = diskRepository;

        fillMap();
    }

    public ComputerComponent findComponent(String component, long id) {
        ComponentRepository componentRepository = repositories.get(component);
        return (ComputerComponent) componentRepository.findByProductId(id);
    }

    public void saveComponent(String json, String type) throws RepositoryMapperException {
        ComponentRepository componentRepository = repositories.get(type);
        try {
            componentRepository.save(JsonParsers.valueOf(type).parseStringToComponent(json));
        } catch (IllegalArgumentException e) {
            throw new RepositoryMapperException(type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillMap() {
        repositories.put("motherboard", motherboardRepository);
        repositories.put("cpu", cpuRepository);
        repositories.put("ram", ramRepository);
        repositories.put("disk", diskRepository);
    }

}
