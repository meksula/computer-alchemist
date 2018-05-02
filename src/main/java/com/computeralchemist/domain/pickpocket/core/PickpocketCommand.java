package com.computeralchemist.domain.pickpocket.core;

import com.computeralchemist.domain.components.ComputerComponent;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public interface PickpocketCommand {
    ComputerComponent executeUrl(String url, String componentType);
}
