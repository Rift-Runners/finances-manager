/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.service;

import com.rift.runners.finances.manager.entity.Finance;
import com.rift.runners.finances.manager.util.EMFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Guilherme
 */
@Stateless
public class FinanceService {

    private final EMFactory emf = EMFactory.getInstance();
    
    public FinanceService(){
        
    }
    
    public void save(Finance finance) {
        final EntityManager em = emf.createManager();
        em.getTransaction().begin();
        em.persist(finance);
        em.getTransaction().commit();
        em.close();
    }

    public List<Finance> listAll() {
        final EntityManager em = emf.createManager();
        final List<Finance> allFinances = em.createQuery(("FROM " + Finance.class.getName())).getResultList();
        return allFinances;
    }
}
