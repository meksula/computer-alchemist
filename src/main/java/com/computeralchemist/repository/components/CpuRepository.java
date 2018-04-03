package com.computeralchemist.repository.components;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.cpu.Cpu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

public interface CpuRepository extends MongoRepository<Cpu, Long> {

    @Override
    long count();

    @Override
    <S extends Cpu> S save(S entity);

    Cpu findByProductId(long producentId);

    List<Cpu> findAllByComponentType(ComponentType componentType);

    void deleteByProductId(long productId);
}
