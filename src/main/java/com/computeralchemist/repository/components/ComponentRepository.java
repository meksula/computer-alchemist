package com.computeralchemist.repository.components;

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

    long save(T computerComponent);

    T findByProductId(long productId);

    void deleteByProductId(long productId);

}
