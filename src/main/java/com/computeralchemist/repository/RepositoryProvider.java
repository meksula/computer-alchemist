package com.computeralchemist.repository;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 16-04-2018
 * */

public interface RepositoryProvider {
    void saveComponent(String json);

    ComputerComponent findComponent(String componentType, long productId);

    ComputerSet findSet(String setType, long setId);

    void saveSet(ComputerSet computerSet);

    long assignSetId(String type);
}
