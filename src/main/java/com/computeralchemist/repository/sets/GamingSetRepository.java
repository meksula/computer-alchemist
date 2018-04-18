package com.computeralchemist.repository.sets;

import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface GamingSetRepository extends MongoRepository<GamingComputerSet, Long> {

    @Override
    long count();

    GamingComputerSet findBySetId(long id);

    @Override
    <S extends GamingComputerSet> S save(S gamingSet);

    List<GamingComputerSet> findByAuthor(String author);

    @Override
    List<GamingComputerSet> findAll();

}
