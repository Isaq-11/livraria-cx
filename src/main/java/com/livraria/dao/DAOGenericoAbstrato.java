package com.livraria.dao;

import jakarta.persistence.EntityManager;
import com.livraria.util.EMF;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class DAOGenericoAbstrato<T, ID extends Serializable> implements
        InterfaceDAOGenerica<T, ID>{

    protected EntityManager em= EMF.getEntityManager();

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public DAOGenericoAbstrato(){
        this.entityClass= (Class<T>)
                ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();}

    @Override
    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();}

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        entity= em.merge(entity);
        em.remove(entity);
        em.getTransaction().commit();}

    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("FROM " + entityClass.getSimpleName(), entityClass)
                .getResultList();}

    public void closeEM(){
        if(em.isOpen())
            em.close();}

}
