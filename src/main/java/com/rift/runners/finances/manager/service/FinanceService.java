/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rift.runners.finances.manager.service;

import com.rift.runners.finances.manager.entity.Finance;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guilherme
 */
@Stateless
public class FinanceService {

    @PersistenceContext(unitName = "financesPU")
    private EntityManager em;

    public void save(Finance finance) {
        em.persist(finance);
    }

    public void listAll() {
         List<Object> unparsedFinances = em.createNativeQuery("SELECT f.name, f.subject, f.type, f.finance_value, f.paid FROM finances ")
                .getResultList();
    }
}
