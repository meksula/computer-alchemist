package com.computeralchemist.repository;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 16-04-2018
 * */

public interface RepositoryProvider {
    ComputerComponent saveComponent(String json);

    ComputerComponent saveComponent(ComputerComponent component);

    ComputerComponent findComponent(String componentType, long productId);

    ComputerComponent findComponentByProducentAndModel(ComputerComponent component);

    ComputerSet findSet(String setType, long setId);

    void updateComponent(ComputerComponent computerComponent);

    void saveSet(ComputerSet computerSet);

    long assignSetId(String type);

    List<ComputerSet> getListOfComputerSet(String type);

    List<ComputerComponent> getListOfComputerComponent(String type);

    boolean removeSet(String type, long id);

    boolean removeComponent(String component, long id);
}
