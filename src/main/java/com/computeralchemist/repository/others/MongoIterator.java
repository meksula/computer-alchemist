package com.computeralchemist.repository.others;

import com.computeralchemist.repository.components.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Service
public class MongoIterator {
    private MotherboardRepository motherboardRepository;

    @Autowired
    public void setMotherboardRepository(MotherboardRepository motherboardRepository) {
        this.motherboardRepository = motherboardRepository;
    }

    private long id;

    public long getId() {
        id = motherboardRepository.count() + 1;
        return id;
    }
}
