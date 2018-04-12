package com.computeralchemist.domain.creator;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface ComputerSetManager {
    ComputerSet initSet(String user, String type);

    ComputerSet updateSet(ComputerSet computerSet);

    ComputerSet findComputerSetById(String type, long setId);

    long assignId();

    List<ComputerSet> getListOfCompSet(String type, int amount);
}
