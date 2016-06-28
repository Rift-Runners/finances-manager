/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.service;

import com.rift.runners.finances.manager.entity.Subject;
import com.rift.runners.finances.manager.util.EMFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 * @author Diego Peixoto
 * @author Guilherme Matuella
 */
@Stateless
public class SubjectService {

    private final EMFactory emf = EMFactory.getInstance();

    public SubjectService() {

    }

    public void save(Subject subject) {
        final EntityManager em = emf.createManager();
        em.getTransaction().begin();
        em.persist(subject);
        em.getTransaction().commit();
        em.close();
    }

    public List<Subject> listAll() {
        final EntityManager em = emf.createManager();
        final List<Subject> allSubjects = em.createQuery(("FROM " + Subject.class.getName())).getResultList();
        return allSubjects;
    }

}
