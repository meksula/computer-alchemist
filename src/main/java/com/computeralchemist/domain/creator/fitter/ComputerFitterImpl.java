package com.computeralchemist.domain.creator.fitter;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.supply.PowerSupply;
import com.computeralchemist.domain.creator.fitter.ComputerFitter;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 13-04-2018
 * */

@Service
public class ComputerFitterImpl implements ComputerFitter {
    private Map<ComponentType, Runnable> assemblingMethods;
    private ComputerSet computerSet;
    private ComputerComponent computerComponent;

    public void initMap() {
        this.assemblingMethods = new LinkedHashMap<>();

        assemblingMethods.put(ComponentType.motherboard, () -> {
            computerSet.setMotherboard((Motherboard) computerComponent);
        });

        assemblingMethods.put(ComponentType.cpu, () -> {
            computerSet.setCpu((Cpu) computerComponent);
        });

        assemblingMethods.put(ComponentType.disk, () -> {
            computerSet.setDisk((Disk) computerComponent);
        });

        assemblingMethods.put(ComponentType.ram, () -> {
            computerSet.setRam((Ram) computerComponent);
        });

        assemblingMethods.put(ComponentType.gpu, () -> {
            computerSet.setGraphicsCard((GraphicsCard) computerComponent);
        });

        assemblingMethods.put(ComponentType.supply, () -> {
            computerSet.setPowerSupply((PowerSupply) computerComponent);
        });

        assemblingMethods.put(ComponentType.computercase, () -> {
            computerSet.setComputerCase((ComputerCase) computerComponent);
        });

    }

    @Override
    public ComputerSet assembleComputerSet(ComputerSet computerSet, ComputerComponent computerComponent) {
        initMap();
        this.computerSet = computerSet;
        this.computerComponent = computerComponent;
        System.out.println(computerComponent.getModel());

        ComponentType type = computerComponent.getComponentType();
        assemblingMethods.get(type).run();

        return this.computerSet;
    }

}
