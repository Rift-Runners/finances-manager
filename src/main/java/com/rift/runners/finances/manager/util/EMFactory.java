/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Guilherme
 */
public final class EMFactory {

    private static EMFactory instance;
    private final EntityManagerFactory factory;

    public static EMFactory getInstance() {
        if (instance == null) {
            inicializaInstancia();
        }
        return instance;
    }
    
    private EMFactory() {
        this.factory = Persistence.createEntityManagerFactory("financesPU");
    }
    
    private static synchronized void inicializaInstancia() {
        if (instance == null) {
            instance = new EMFactory();
        }
    }

    public EntityManager createManager() {
        return factory.createEntityManager();
    }
}
