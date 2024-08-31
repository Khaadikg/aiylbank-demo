package com.aiylbank.demo.database.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
public abstract class BaseStorageService <T, I, R extends JpaRepository<T, I>> implements CrudRepository<T, I> {

    protected abstract R getRepository();

    @Override
    public <S extends T> S save(S entity) {
        return getRepository().save(entity);
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        return getRepository().saveAll(entities);
    }

    @Override
    public Optional<T> findById(I id) {
        return getRepository().findById(id);
    }

    @Override
    public boolean existsById(I id) {
        return getRepository().existsById(id);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAllById(Iterable<I> ids) {
        return getRepository().findAllById(ids);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void deleteById(I i) {
        getRepository().deleteById(i);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends I> ids) {
        getRepository().deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        getRepository().deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }
}
