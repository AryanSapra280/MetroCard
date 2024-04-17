package com.example.geektrust.repositories.interfaces;

import java.util.*;

public interface CRUDRepository<T,ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    Boolean isPresent(ID id);
    void delete(T entity);
}
