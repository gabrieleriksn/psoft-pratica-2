package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Batch;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VolatilLoteRepository implements BatchRepository<Batch, Long>{

    private List<Batch> batches = new ArrayList<>();

    @Override
    public Batch save(Batch batch) {
        this.batches.add(batch);
        return batches.get(this.batches.size() - 1);
    }

    @Override
    public Batch find(Long id) {
        return this.batches.get(Integer.parseInt("" + id));
    }

    @Override
    public List<Batch> findAll() {
        return this.batches;
    }

    @Override
    public Batch update(Batch batch) {
        this.batches.clear();
        this.batches.add(batch);
        return this.batches.stream().findFirst().orElse(null);
    }

    @Override
    public void delete(Batch batch) {
        this.batches.clear();
    }

    @Override
    public void deleteAll() {
        this.batches.clear();
    }

}
