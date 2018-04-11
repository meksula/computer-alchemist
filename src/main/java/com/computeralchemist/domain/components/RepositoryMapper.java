package com.computeralchemist.domain.components;

import com.computeralchemist.domain.components.exceptions.RepositoryMapperException;
import com.computeralchemist.repository.components.ComponentRepository;
import com.computeralchemist.repository.components.compCase.ComputerCaseRepository;
import com.computeralchemist.repository.components.cpu.CpuRepository;
import com.computeralchemist.repository.components.disk.DiskRepository;
import com.computeralchemist.repository.components.gpu.GraphicsCardRepository;
import com.computeralchemist.repository.components.ram.RamRepository;
import com.computeralchemist.repository.components.motherboard.MotherboardRepository;
import com.computeralchemist.repository.components.supply.PowerSupplyRepository;
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
    private PowerSupplyRepository powerSupplyRepository;
    private GraphicsCardRepository graphicsCardRepository;
    private ComputerCaseRepository computerCaseRepository;

    @Autowired
    public void setMotherboardRepository(MotherboardRepository motherboardRepository,
                                         CpuRepository cpuRepository,
                                         RamRepository ramRepository,
                                         DiskRepository diskRepository,
                                         PowerSupplyRepository powerSupplyRepository,
                                         GraphicsCardRepository graphicsCardRepository,
                                         ComputerCaseRepository computerCaseRepository) {
        this.motherboardRepository = motherboardRepository;
        this.cpuRepository = cpuRepository;
        this.ramRepository = ramRepository;
        this.diskRepository = diskRepository;
        this.powerSupplyRepository = powerSupplyRepository;
        this.graphicsCardRepository = graphicsCardRepository;
        this.computerCaseRepository = computerCaseRepository;

        fillMap();
    }

    private void fillMap() {
        repositories.put("motherboard", motherboardRepository);
        repositories.put("cpu", cpuRepository);
        repositories.put("ram", ramRepository);
        repositories.put("disk", diskRepository);
        repositories.put("supply", powerSupplyRepository);
        repositories.put("gpu", graphicsCardRepository);
        repositories.put("computercase", computerCaseRepository);
    }

    public ComputerComponent findComponent(String component, long id) {
        ComponentRepository componentRepository = repositories.get(component);
        return (ComputerComponent) componentRepository.findByProductId(id);
    }

    private String uri;
    private ComponentTypeExtracter extracter = ComponentTypeExtracter.getInstance();

    public void saveComponent(String json) throws RepositoryMapperException {
        String type = assignType(json);
        ComponentRepository componentRepository = repositories.get(type);
        long productId = 0;
        try {
            productId = componentRepository.save(JsonParsers.valueOf(type).parseStringToComponent(json));
        } catch (IllegalArgumentException e) {
            throw new RepositoryMapperException(type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        uri = "/computer-alchemist/components/" + type + "/" + productId;
    }

    private String assignType(String json) {
        return extracter.extractTypeFromJson(json);
    }

    public String getPathToLastAddedComponent() {
        return "http://localhost:8080" + uri;
    }

}
