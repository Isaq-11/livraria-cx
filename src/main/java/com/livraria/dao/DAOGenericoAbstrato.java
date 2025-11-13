package com.livraria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class DAOGenericoAbstrato<T, ID extends Serializable> implements
        InterfaceDAOGenerica<T, ID>{

    private static final EntityManagerFactory emf=
            Persistence.createEntityManagerFactory("livrariaPU");

    protected EntityManager em= emf.createEntityManager();
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public DAOGenericoAbstrato(){
        this.entityClass= (Class<T>)
                ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

}
