package com.computeralchemist.repository.sets;

import com.computeralchemist.domain.creator.setTypes.FamilyComputerSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface FamilySetRepository extends MongoRepository<FamilyComputerSet, Long> {
    @Override
    long count();

    FamilyComputerSet findBySetId(long id);

    @Override
    <S extends FamilyComputerSet> S save(S entity);

    List<FamilyComputerSet> findByAuthor(String author);

    @Override
    List<FamilyComputerSet> findAll();
}