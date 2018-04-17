package com.computeralchemist.domain.creator.setTypes;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.supply.PowerSupply;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class ComputerSet extends ResourceSupport {
    private ComputerSetTypes type;
    private String author;
    private String createDate;
    private long votes;
    private boolean compatible;
    private boolean finished;
    private boolean isPublic;

    private Cpu cpu;
    private Motherboard motherboard;
    private Ram ram;
    private Disk disk;
    private GraphicsCard graphicsCard;
    private PowerSupply powerSupply;
    private ComputerCase computerCase;

}
