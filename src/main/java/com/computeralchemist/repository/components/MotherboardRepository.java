package com.computeralchemist.repository.components;

import com.computeralchemist.domain.components.motherboard.Motherboard;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public interface MotherboardRepository extends MongoRepository<Motherboard, Long> {

    @Override
    long count();

    @Override
    <S extends Motherboard> S save(S motherboard);

    Motherboard findByModel(String model);

    Motherboard findByProductId(long productId);

    void deleteByProductId(long productId);

}
