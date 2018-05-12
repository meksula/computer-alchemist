package com.computeralchemist.domain.pickpocket.core;

import com.computeralchemist.domain.components.ComputerComponent;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public interface PickpocketCommand {
    ComputerComponent executeUrl(String url, String componentType);

    List<String> executeUrlForProperties(String url, String componentType);
}
