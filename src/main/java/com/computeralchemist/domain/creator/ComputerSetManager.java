package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface ComputerSetManager {
    ComputerSet initSet(String user, String type);

    ComputerSet updateSet();

    long assignId();

    ComputerSet assembleComponent(String type, long productId) throws NothingHasChangedException;

    ComputerSet pullComputerSet(String compSetType, long id);
}
