package com.computeralchemist.repository.opinions;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.OpinionDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 23-04-2018
 * */

public interface OpinionRepository extends MongoRepository<OpinionDto, Long> {

    @Override
    long count();

    @Override
    <S extends OpinionDto> S save(S opinion);

    List<OpinionDto> findByComponentTypeAndProductId(ComponentType type, long productId);

    OpinionDto findByOpinionId(long opinionId);

    void deleteByOpinionId(long opinionId);

    default long assignId() {
        return count() + 1;
    }
}