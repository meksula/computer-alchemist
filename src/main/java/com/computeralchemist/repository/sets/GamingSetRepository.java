package com.computeralchemist.repository.sets;

import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface GamingSetRepository extends MongoRepository<GamingComputerSet, Long> {
}
