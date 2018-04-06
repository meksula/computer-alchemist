package com.computeralchemist.domain.components;

import com.computeralchemist.domain.components.motherboard.Motherboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

public enum ComponentType {
    MOTHERBOARD, CPU, GPU, RAM, DISK, POWER_SUPPLY, CASE, OTHERS;

}
