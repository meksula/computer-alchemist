package com.computeralchemist.repository.sets;

import com.computeralchemist.domain.creator.FamilyComputerSet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface FamilySetRepository extends MongoRepository<FamilyComputerSet, Long> {
    @Override
    long count();

    FamilyComputerSet findById(long id);

    FamilyComputerSet findByAuthor(String author);

    //todo querry (ma pobierać 20 najpopularniejszych)
    List<FamilyComputerSet> findByVotes(long votesAmount);
}
