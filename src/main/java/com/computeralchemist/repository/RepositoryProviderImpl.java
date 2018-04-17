package com.computeralchemist.repository;

import com.computeralchemist.domain.components.ComponentTypeExtracter;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.JsonParsers;
import com.computeralchemist.domain.components.exceptions.RepositoryMapperException;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.repository.components.ComponentRepository;
import com.computeralchemist.repository.components.compCase.ComputerCaseRepository;
import com.computeralchemist.repository.components.cpu.CpuRepository;
import com.computeralchemist.repository.components.disk.DiskRepository;
import com.computeralchemist.repository.components.gpu.GraphicsCardRepository;
import com.computeralchemist.repository.components.ram.RamRepository;
import com.computeralchemist.repository.components.motherboard.MotherboardRepository;
import com.computeralchemist.repository.components.supply.PowerSupplyRepository;
import com.computeralchemist.repository.sets.FamilySetRepository;
import com.computeralchemist.repository.sets.GamingSetRepository;
import com.computeralchemist.repository.sets.WorkSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 06-04-2018
 * */

@Service
public class RepositoryProviderImpl implements RepositoryProvider {
    private Map<String, ComponentRepository> componentRepositories = new HashMap<>();
    private Map<String, MongoRepository> setRepositories = new HashMap<>();

    private MotherboardRepository motherboardRepository;
    private CpuRepository cpuRepository;
    private RamRepository ramRepository;
    private DiskRepository diskRepository;
    private PowerSupplyRepository powerSupplyRepository;
    private GraphicsCardRepository graphicsCardRepository;
    private ComputerCaseRepository computerCaseRepository;

    private WorkSetRepository workSetRepository;
    private GamingSetRepository gamingSetRepository;
    private FamilySetRepository familySetRepository;

    @Autowired
    public void setRepositories(MotherboardRepository motherboardRepository,
                                CpuRepository cpuRepository,
                                RamRepository ramRepository,
                                DiskRepository diskRepository,
                                PowerSupplyRepository powerSupplyRepository,
                                GraphicsCardRepository graphicsCardRepository,
                                ComputerCaseRepository computerCaseRepository,
                                WorkSetRepository workSetRepository,
                                GamingSetRepository gamingSetRepository,
                                FamilySetRepository familySetRepository) {
        this.motherboardRepository = motherboardRepository;
        this.cpuRepository = cpuRepository;
        this.ramRepository = ramRepository;
        this.diskRepository = diskRepository;
        this.powerSupplyRepository = powerSupplyRepository;
        this.graphicsCardRepository = graphicsCardRepository;
        this.computerCaseRepository = computerCaseRepository;

        this.workSetRepository = workSetRepository;
        this.gamingSetRepository = gamingSetRepository;
        this.familySetRepository = familySetRepository;

        fillMap();
    }

    private void fillMap() {
        componentRepositories.put("motherboard", motherboardRepository);
        componentRepositories.put("cpu", cpuRepository);
        componentRepositories.put("ram", ramRepository);
        componentRepositories.put("disk", diskRepository);
        componentRepositories.put("supply", powerSupplyRepository);
        componentRepositories.put("gpu", graphicsCardRepository);
        componentRepositories.put("computercase", computerCaseRepository);

        setRepositories.put("work", workSetRepository);
        setRepositories.put("family", familySetRepository);
        setRepositories.put("gaming", gamingSetRepository);
    }

    @Override
    public ComputerComponent findComponent(String componentType, long id) {
        ComponentRepository componentRepository = componentRepositories.get(componentType);
        return (ComputerComponent) componentRepository.findByProductId(id);
    }

    @Override
    public ComputerSet findSet(String setType, long setId) {
        Optional<ComputerSet> optional = setRepositories.get(setType).findById(setId);
        return optional.get();
    }

    @Override
    public void saveSet(ComputerSet computerSet) {
        String type = computerSet.getType().toString();
        setRepositories.get(type).save(computerSet);
    }

    @Override
    public long assignSetId(String type) {
        return setRepositories.get(type).count() + 1;
    }

    @Override
    public List<ComputerSet> getListOfComputerSet(String type) {
        return setRepositories.get(type).findAll();
    }

    @Override
    public List<ComputerComponent> getListOfComputerComponent(String type) {
        return componentRepositories.get(type).findAllComponents();
    }

    private ComponentTypeExtracter extracter = ComponentTypeExtracter.getInstance();

    @Override
    public long saveComponent(String json) throws RepositoryMapperException {
        String type = assignType(json);
        ComponentRepository componentRepository = componentRepositories.get(type);
        long id = 0;
        try {
            id = componentRepository.save(JsonParsers.valueOf(type).parseStringToComponent(json));
        } catch (IllegalArgumentException e) {
            throw new RepositoryMapperException(type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    private String assignType(String json) {
        return extracter.extractTypeFromJson(json);
    }

}
