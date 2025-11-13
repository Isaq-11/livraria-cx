package com.livraria.dao;
import java.io.Serializable;
import java.util.List;

public interface InterfaceDAOGenerica<T, ID extends Serializable> {
    public void save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T findById(ID id);
    public List<T> findAll();
}
