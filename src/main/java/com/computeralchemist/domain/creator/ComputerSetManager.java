package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.ComputerSetTypes;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface ComputerSetManager {
    ComputerSet initSet(String user, String type);

    ComputerSet initSet(String user, ComputerSetTypes types);

    ComputerSet updateSet();

    void prepareComponentToAssembling(String type, long productId);

    ComputerSet assembleComponent() throws NothingHasChangedException;

    ComputerSet loadExistComputerSet(String compSetType, long id);

    ComputerSet findComputerSet(String jsonComponent, long id);

    List<ComputerSet> getComputerSetList(String type);

    boolean hasLoadedSet();
}
