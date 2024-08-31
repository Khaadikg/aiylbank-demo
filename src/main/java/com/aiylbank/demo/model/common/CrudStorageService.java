package com.aiylbank.demo.model.common;

import java.util.List;
import java.util.Optional;

public interface CrudStorageService<T, I> {

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    Optional<T> findById(I id);

    boolean existsById(I id);

    List<T> findAll();

    List<T> findAllById(Iterable<I> ids);

    long count();

    void deleteById(I i);

    void delete(T entity);

    void deleteAllById(Iterable<? extends I> ids);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();
}
