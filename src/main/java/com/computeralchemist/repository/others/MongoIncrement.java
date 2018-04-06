package com.computeralchemist.repository.others;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.repository.components.cpu.CpuRepository;
import com.computeralchemist.repository.components.motherboard.MotherboardRepository;
import com.computeralchemist.repository.components.ram.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Service
public class MongoIncrement {
    private MotherboardRepository motherboardRepository;
    private CpuRepository cpuRepository;
    private RamRepository ramRepository;
    private long id;

    @Autowired
    public void setMotherboardRepository(MotherboardRepository motherboardRepository,
                                         CpuRepository cpuRepository, RamRepository ramRepository) {
        this.motherboardRepository = motherboardRepository;
        this.cpuRepository = cpuRepository;
        this.ramRepository = ramRepository;
    }

    public long assignComponentId(ComputerComponent computerComponent) {
        if (computerComponent instanceof Motherboard) {
            id = motherboardRepository.count() + 1;
            return id;
        }
        if (computerComponent instanceof Cpu) {
            id = cpuRepository.count() + 1;
            return id;
        }
        if (computerComponent instanceof Ram) {
            id = ramRepository.count() + 1;
            return id;
        }

        throw new IllegalArgumentException();
    }

}
