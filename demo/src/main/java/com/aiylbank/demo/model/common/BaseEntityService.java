package com.aiylbank.demo.model.common;

import com.aiylbank.demo.web.common.exception.NotFoundException;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public abstract class BaseEntityService<T extends BaseEntity, D, I, S extends CrudStorageService<T, I>> {

    private final ModelMapper modelMapper = new ModelMapper();

    protected abstract S getService();

    protected abstract Class<D> getDtoClass();

    public D save(T entity) {
        return modelMapper.map(getService().save(entity), getDtoClass());
    }

    public D findById(I id) {
        Optional<T> optional = getService().findById(id);
        if (optional.isPresent()) {
            return modelMapper.map(optional.get(), getDtoClass());
        }
        throw new NotFoundException("Entity not found by id: " + id);
    }

    public List<D> findAll() {
        return getService().findAll().stream()
                .map(entity -> modelMapper.map(entity, getDtoClass()))
                .toList();
    }

    public String delete(I id) {
        Optional<T> optional = getService().findById(id);

        if (optional.isPresent()) {
            T entity = optional.get();

            getService().delete(entity);
            return "Successfully deleted!";
        } else {
            throw new NotFoundException("Entity not found by id: " + id);
        }
    }
}