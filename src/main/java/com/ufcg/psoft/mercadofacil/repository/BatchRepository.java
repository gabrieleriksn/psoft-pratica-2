package com.ufcg.psoft.mercadofacil.repository;

import java.util.List;

public interface BatchRepository<T, ID> {
    T save(T batch);
    T find(ID id);
    List<T> findAll();
    T update(T batch);
    void delete(T batch);
    void deleteAll();
}
