package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComponentTypeExtracter;
import com.computeralchemist.repository.sets.FamilySetRepository;
import com.computeralchemist.repository.sets.GamingSetRepository;
import com.computeralchemist.repository.sets.WorkSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Service
public class ComputerSetManagerImpl implements ComputerSetManager {
    private ComponentTypeExtracter extracter = ComponentTypeExtracter.getInstance();
    private WorkSetRepository workSetRepository;
    private FamilySetRepository familySetRepository;
    private GamingSetRepository gamingSetRepository;
    private Map<ComputerSetTypes, MongoRepository> repositoryTypeMap;
    private String type;

    @Autowired
    public void setWorkSetRepository(WorkSetRepository workSetRepository,
                                     FamilySetRepository familySetRepository,
                                     GamingSetRepository gamingSetRepository) {
        this.workSetRepository = workSetRepository;
        this.familySetRepository = familySetRepository;
        this.gamingSetRepository = gamingSetRepository;
        initMap();
    }

    private void initMap() {
        repositoryTypeMap = new LinkedHashMap<>();
        repositoryTypeMap.put(ComputerSetTypes.work, workSetRepository);
        repositoryTypeMap.put(ComputerSetTypes.family, familySetRepository);
        repositoryTypeMap.put(ComputerSetTypes.gaming, gamingSetRepository);
    }

    @Override
    public ComputerSet initSet(String user, String jsonType) {
        this.type = extracter.extractComputerTypeFromJson(jsonType);
        ComputerSet computerSet = ComputerSetTypes.valueOf(type).createSet(assignId());
        computerSet.setAuthor(user);
        computerSet.setCreateDate(String.valueOf(LocalDate.now()));
        updateSet(computerSet);
        return computerSet;
    }

    @Override
    public ComputerSet updateSet(ComputerSet computerSet) {
        MongoRepository repository = repositoryTypeMap.get(computerSet.getType());
        repository.save(computerSet);
        return computerSet;
    }

    @Override
    public ComputerSet findComputerSetById(String type, long setId) {
        MongoRepository<ComputerSet, Long> mongoRepository = repositoryTypeMap.get(ComputerSetTypes.valueOf(type));
        Optional<ComputerSet> computerSet = mongoRepository.findById(setId);
        return computerSet.get();
    }

    @Override
    public long assignId() {
        return repositoryTypeMap.get(ComputerSetTypes.valueOf(type)).count() + 1;
    }

    //TODO
    @Override
    public List<ComputerSet> getListOfCompSet(String type, int amount) {
        return repositoryTypeMap.get(ComputerSetTypes.valueOf(type)).findAll();
    }

}
