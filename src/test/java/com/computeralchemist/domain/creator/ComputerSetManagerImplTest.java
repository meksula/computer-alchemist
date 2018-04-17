package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.ComputerSetTypes;
import com.computeralchemist.domain.creator.setTypes.WorkComputerSet;
import com.computeralchemist.repository.components.disk.DiskRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ComputerSetManagerImplTest {

    @Autowired
    private ComputerSetManager manager;

    @Autowired
    private DiskRepository diskRepository;

    private final String USER = "MikolajKopernik";
    private final ComputerSetTypes SET_TYPE = ComputerSetTypes.work;
    private final String JSON_TYPE = "{\"type\":\"gaming\"}";
    /*If collection is empty it'll return '1' always.*/
    private final long ID = 1;

    @Before
    public void setUp() {

    }

    @Test
    public void singletonInjectionTest() {
        assertNotNull(manager);
    }

    @Test
    public void shouldCreateNewComputerSetByJson() {
        ComputerSet computerSet = manager.initSet(USER, JSON_TYPE);
        assertEquals(ComputerSetTypes.gaming, computerSet.getType());
        assertEquals(USER, computerSet.getAuthor());
    }

    @Test
    public void shouldCreateNewComputerSet() {
        ComputerSet computerSet = manager.initSet(USER, SET_TYPE);
        assertEquals(ComputerSetTypes.work, computerSet.getType());
        assertEquals(USER, computerSet.getAuthor());
    }

    @Test
    public void shouldBeAbleToSaveSet() {
        WorkComputerSet computerSet = (WorkComputerSet) manager.updateSet();
        assertNotNull(computerSet);
        assertEquals(SET_TYPE, computerSet.getType());
        assertEquals(USER, computerSet.getAuthor());
        log.info(String.valueOf(computerSet.getId()));
    }

    private WorkComputerSet workComputerSet;

    @Test
    public void shouldBeAbleToLoadSetJustSaved() {
        workComputerSet = (WorkComputerSet) manager.loadExistComputerSet(SET_TYPE.toString(), ID);
        assertNotNull(workComputerSet);
        assertEquals(SET_TYPE, workComputerSet.getType());
        assertEquals(USER, workComputerSet.getAuthor());
        log.info(workComputerSet.getCreateDate());
    }

    private final String DISK_MODEL = "SuperDrive1003m";

    @Test
    public void assemblingProcessShouldWorkCorrectly() throws NothingHasChangedException {
        saveToDBFakecomponent();
        ComputerSet computerSet = manager.initSet(USER, JSON_TYPE);
        manager.prepareComponentToAssembling("disk", 1);
        ComputerSet assembled = manager.assembleComponent();
        log.info(computerSet.getDisk().getModel());

        assertEquals(DISK_MODEL, assembled.getDisk().getModel());
    }

    private void saveToDBFakecomponent() {
        Disk disk = new Disk();
        disk.setComponentType(ComponentType.disk);
        disk.setProducent("HardDrivesExtrm");
        disk.setModel(DISK_MODEL);
        diskRepository.save(disk);
    }
}