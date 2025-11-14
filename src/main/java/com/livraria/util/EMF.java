package com.livraria.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMF {
    private static final EntityManagerFactory emf=
            Persistence.createEntityManagerFactory("livrariaPU");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();}

    public void closeEMF(){
        if(emf.isOpen())
            emf.close();}
}
