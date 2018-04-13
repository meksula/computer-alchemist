package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComponentTypeExtracter;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.RepositoryMapper;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.ComputerSetTypes;
import com.computeralchemist.repository.sets.FamilySetRepository;
import com.computeralchemist.repository.sets.GamingSetRepository;
import com.computeralchemist.repository.sets.WorkSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
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
    private CompatibilityManager compatibilityManager;
    private ComputerFitter computerFitter;
    private String type;
    private ComputerSet computerSet;
    private RepositoryMapper repositoryMapper;

    @Autowired
    public void setWorkSetRepository(WorkSetRepository workSetRepository,
                                     FamilySetRepository familySetRepository,
                                     GamingSetRepository gamingSetRepository,
                                     CompatibilityManager compatibilityManager,
                                     ComputerFitter computerFitter,
                                     RepositoryMapper repositoryMapper) {
        this.workSetRepository = workSetRepository;
        this.familySetRepository = familySetRepository;
        this.gamingSetRepository = gamingSetRepository;
        this.compatibilityManager = compatibilityManager;
        this.computerFitter = computerFitter;
        this.repositoryMapper = repositoryMapper;
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
        this.computerSet = computerSet;
        updateSet();
        return computerSet;
    }

    @Override
    public ComputerSet updateSet() {
        MongoRepository repository = repositoryTypeMap.get(computerSet.getType());
        repository.save(computerSet);
        return computerSet;
    }

    @Override
    public long assignId() {
        return repositoryTypeMap.get(ComputerSetTypes.valueOf(type)).count() + 1;
    }

    @Override
    public ComputerSet assembleComponent(String type, long productId) throws NothingHasChangedException {
        ComputerComponent component = repositoryMapper.findComponent(type, productId);
        boolean compatible = compatibilityManager.checkComponentsCompatibility(computerSet, component);

        if (compatible)
            buildSet(component);

        else throw new NothingHasChangedException();

        return updateSet();
    }

    @Override
    public ComputerSet pullComputerSet(String compSetType, long id) {
        MongoRepository mongoRepository = repositoryTypeMap.get(ComputerSetTypes.valueOf(type));
        Optional<ComputerSet> computerSet = mongoRepository.findById(id);
        return computerSet.get();
    }

    private void buildSet(ComputerComponent computerComponent) {
        computerFitter.assembleComputerSet(computerComponent);
    }

}
