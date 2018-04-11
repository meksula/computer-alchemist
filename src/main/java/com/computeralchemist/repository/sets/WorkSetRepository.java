package com.computeralchemist.repository.sets;

import com.computeralchemist.domain.creator.WorkComputerSet;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

public interface WorkSetRepository extends MongoRepository<WorkComputerSet, Long> {

}
