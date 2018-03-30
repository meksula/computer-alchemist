package com.computeralchemist.repository.components;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.Motherboard;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public interface MotherboardRepository extends MongoRepository<Motherboard, Long> {

    @Override
    <S extends Motherboard> S save(S motherboard);

    Motherboard findByModel(String model);

    @Override
    long count();
}
