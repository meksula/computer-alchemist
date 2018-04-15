package com.computeralchemist.repository.components.disk;

import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.components.disk.DiskParameters;
import com.computeralchemist.domain.components.disk.DriveType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiskRepositoryImplTest {

    @Autowired
    private DiskRepository repository;

    private Disk disk = new Disk();
    private DiskParameters parameters = new DiskParameters();
    private final String MODEL = "H320s";
    private final String TYPE = "HDD";

    @Before
    public void setUp() {
        parameters.setType(DriveType.valueOf(TYPE));
        disk.setDiskParameters(parameters);
        disk.setModel(MODEL);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(repository);
    }

    @Test
    public void shouldSaveAndFindById() {
        long id = repository.save(disk);

        Disk component = repository.findByProductId(id);
        assertEquals(MODEL, component.getModel());
        assertEquals(TYPE, component.getDiskParameters().getType().toString());
    }

    @Test
    public void countTest() {
        long amount = repository.count();
        assertEquals(1, amount);

        repository.save(disk);
        amount = repository.count();
        assertEquals(2, amount);
    }

    @Test
    public void findByModelTest() {
        repository.save(disk);

        Disk disk = repository.findByModel(MODEL);
        assertNotNull(disk);
        assertEquals(MODEL, disk.getModel());
    }

    @Test
    public void findAllComponentsTest() {
        List<Disk> list = repository.findAllComponents();
        long size = repository.count();
        assertEquals(size, list.size());
    }

    @Test
    public void deleteByProductIdTest() {
        String model = "Sea34";
        Disk component = new Disk();
        component.setModel(model);

        long id = repository.save(component);
        repository.deleteByProductId(id);

        assertNull(repository.findByModel(model));
    }
}