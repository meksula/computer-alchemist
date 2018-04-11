package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComputerComponent;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface ComputerSetManager {
    ComputerSet initSet(String user, String type);

    ComputerSet updateSet(ComputerSet computerSet);

    ComputerSet findComputerSetById(long setId);

    boolean isSetCompatible();

    boolean isFinished();

    boolean isPublic();

    List<ComputerComponent> getContent();

    void setAuthor(String author);
}
