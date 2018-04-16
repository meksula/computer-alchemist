package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.supply.PowerSupply;
import com.computeralchemist.domain.creator.fitter.ComputerFitter;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ComputerFitterImplTest {

    @Autowired
    private ComputerFitter fitter;

    @Test
    public void injectionCorrectly() {
        assertNotNull(fitter);
    }
    private final String AUTHOR = "Mikołaj Kopernik";
    private ComputerSet gamingSet = new GamingComputerSet();

    private Motherboard motherboard = new Motherboard();
    private final String PRODUCENT = "Gigabyte";
    private final String MODEL = "Gaming Pro 200x";

    private Cpu cpu = new Cpu();
    private final String CPU_MODEL = "core i7";

    private Disk disk = new Disk();
    private final String DISK_MODEL = "Kingston 42md";

    private Ram ram = new Ram();
    private final String RAM_MODEL = "Crucial 3242";

    private GraphicsCard gpu = new GraphicsCard();
    private final String GPU_MODEL = "Geforce 19391ti";

    private PowerSupply supply = new PowerSupply();
    private final String SUPPLY_MODEL = "be silent! 334mdk";

    private ComputerCase computerCase = new ComputerCase();
    private final String CASE_MODEL = "Genesis 3ds";

    @Before
    public void setUp() {
        motherboard.setProducent(PRODUCENT);
        motherboard.setModel(MODEL);
        motherboard.setComponentType(ComponentType.motherboard);

        gamingSet.setAuthor(AUTHOR);

        cpu.setModel(CPU_MODEL);
        cpu.setComponentType(ComponentType.cpu);

        disk.setModel(DISK_MODEL);
        disk.setComponentType(ComponentType.disk);

        ram.setModel(RAM_MODEL);
        ram.setComponentType(ComponentType.ram);

        gpu.setModel(GPU_MODEL);
        gpu.setComponentType(ComponentType.gpu);

        supply.setModel(SUPPLY_MODEL);
        supply.setComponentType(ComponentType.supply);

        computerCase.setModel(CASE_MODEL);
        computerCase.setComponentType(ComponentType.computercase);
    }

    @Test
    public void gamingSetShouldNotHaveAMotherboard() {
        assertNull(gamingSet.getMotherboard());
    }

    @Test
    public void computerFitterShouldBeAbleToAssembleMotherboardToSet() {
        ComputerSet updatedSet = fitter.assembleComputerSet(gamingSet, motherboard);
        assertEquals(MODEL, updatedSet.getMotherboard().getModel());
        assertEquals(AUTHOR, updatedSet.getAuthor());
        assertEquals(PRODUCENT, updatedSet.getMotherboard().getProducent());
    }


    @Test
    public void computerFitterShouldBeAbleToAssembleCpuToSet() {
        ComputerSet computerSet = fitter.assembleComputerSet(gamingSet, cpu);
        assertEquals(CPU_MODEL, computerSet.getCpu().getModel());
    }

    @Test
    public void computerFitterShouldBeAbleToAssembleDiskToSet() {
        ComputerSet computerSet = fitter.assembleComputerSet(gamingSet, disk);
        assertEquals(DISK_MODEL, computerSet.getDisk().getModel());
    }

    @Test
    public void computerFitterShouldBeAbleToAssembleRamToSet() {
        ComputerSet computerSet = fitter.assembleComputerSet(gamingSet, ram);
        assertEquals(RAM_MODEL, computerSet.getRam().getModel());
    }

    @Test
    public void computerFitterShouldBeAbleToAssembleGraphicsCardToSet() {
        ComputerSet computerSet = fitter.assembleComputerSet(gamingSet, gpu);
        assertEquals(GPU_MODEL, computerSet.getGraphicsCard().getModel());
    }

    @Test
    public void computerFitterShouldBeAbleToAssemblePowerSupplyToSet() {
        ComputerSet computerSet = fitter.assembleComputerSet(gamingSet, supply);
        assertEquals(SUPPLY_MODEL, computerSet.getPowerSupply().getModel());
    }

    @Test
    public void computerFitterShouldBeAbleToAssembleComputerCaseToSet() {
        ComputerSet computerSet = fitter.assembleComputerSet(gamingSet, computerCase);
        assertEquals(CASE_MODEL, computerSet.getComputerCase().getModel());
    }

}