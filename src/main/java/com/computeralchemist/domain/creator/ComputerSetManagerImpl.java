package com.computeralchemist.domain.creator;

import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.controller.exception.NothingHasChangedException;
import com.computeralchemist.controller.exception.SetNotFoundException;
import com.computeralchemist.controller.exception.SetTypeNotSupportedException;
import com.computeralchemist.domain.components.ComponentTypeExtracter;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.repository.RepositoryProvider;
import com.computeralchemist.domain.creator.compatibility.CompatibilityChecker;
import com.computeralchemist.domain.creator.fitter.ComputerFitter;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.ComputerSetTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Service
public class ComputerSetManagerImpl implements ComputerSetManager {
    private ComponentTypeExtracter extracter = ComponentTypeExtracter.getInstance();
    private ComputerFitter computerFitter;
    private RepositoryProvider repositoryProvider;

    private ComputerSet computerSet;
    private ComputerSetTypes type;

    @Autowired
    public void setRepository(ComputerFitter computerFitter,
                                     RepositoryProvider repositoryProvider) {
        this.computerFitter = computerFitter;
        this.repositoryProvider = repositoryProvider;
    }

    @Override
    public ComputerSet initSet(String user, String jsonType) {
        assignType(jsonType);
        ComputerSet computerSet = type.createSet(assignSetId());
        computerSet.setAuthor(user);
        computerSet.setCreateDate(String.valueOf(LocalDate.now()));
        this.computerSet = computerSet;
        return computerSet;
    }

    @Override
    public ComputerSet initSet(String user, ComputerSetTypes types) {
        this.type = types;
        ComputerSet computerSet = types.createSet(assignSetId());
        computerSet.setAuthor(user);
        computerSet.setCreateDate(String.valueOf(LocalDate.now()));
        this.computerSet = computerSet;
        return computerSet;
    }

    private void assignType(String jsonType) {
        try {
            this.type = ComputerSetTypes.valueOf(extracter.extractComputerTypeFromJson(jsonType));
        } catch (IllegalArgumentException e) {
            throw new SetTypeNotSupportedException(jsonType);
        }
    }

    private long assignSetId() {
        return repositoryProvider.assignSetId(type.toString());
    }

    @Override
    public ComputerSet updateSet() {
        repositoryProvider.saveSet(computerSet);
        return computerSet;
    }

    private ComputerComponent computerComponent;

    @Override
    public void prepareComponentToAssembling(String type, long productId) {
        this.computerComponent = repositoryProvider.findComponent(type, productId);

        if (computerComponent == null)
            throw new ComponentNotFoundException(type, productId);
    }

    @Override
    public ComputerSet assembleComponent() {
        CompatibilityChecker checker = CompatibilityChecker
                .build(computerComponent.getComponentType());

        boolean compatible = checker.compatibilityCheck(computerSet, computerComponent);

        if (compatible) {
            return buildSet();
        }

        else throw new NothingHasChangedException(computerSet, computerComponent);
    }

    @Override
    public ComputerSet loadExistComputerSet(String compSetType, long id) {
        this.computerSet = repositoryProvider.findSet(compSetType, id);

        if (computerSet == null)
            throw new SetNotFoundException(compSetType, id);

        return computerSet;
    }

    @Override
    public ComputerSet findComputerSet(String jsonComponent, long id) {
        String toFind = extracter.extractComputerTypeFromJson(jsonComponent);
        return repositoryProvider.findSet(toFind, id);
    }

    @Override
    public List<ComputerSet> getComputerSetList(String type) {
        return repositoryProvider.getListOfComputerSet(type);
    }

    @Override
    public boolean hasLoadedSet() {
        return computerSet != null;
    }

    private ComputerSet buildSet() {
        return computerFitter.assembleComputerSet(this.computerSet, this.computerComponent);
    }

}
