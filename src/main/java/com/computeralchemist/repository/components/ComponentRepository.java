package com.computeralchemist.repository.components;

import com.computeralchemist.domain.components.ComputerComponent;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

public interface ComponentRepository<T> {

    long count();

    default long nextId() {
        return count() + 1;
    }

    ComputerComponent save(T computerComponent);

    void update(T computerComponent);

    T findByProductId(long productId);

    T findByModel(String model);

    List<T> findAllComponents();

    void deleteByProductId(long productId);

}
