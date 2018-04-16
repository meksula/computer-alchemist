package com.computeralchemist.repository.sets;

import com.computeralchemist.domain.creator.setTypes.WorkComputerSet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface WorkSetRepository extends MongoRepository<WorkComputerSet, Long> {

    @Override
    long count();

    WorkComputerSet findById(long id);

    @Override
    <S extends WorkComputerSet> S save(S workSet);

    List<WorkComputerSet> findByAuthor(String author);

    @Override
    List<WorkComputerSet> findAll();

}
