package com.spring.boot.coffeine.dao.reponsitories.impl;


import com.spring.boot.coffeine.dao.reponsitories.CoffeineRepository;
import com.spring.boot.coffeine.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Implement all methods in CoffeineRepository
 * Using @EntityManager to impl query
 */
@Repository("coffeineRepository")
@Transactional
public class CoffeineReponsitoryImpl implements CoffeineRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeineReponsitoryImpl.class);

    @PersistenceContext
    private EntityManager em;


    public String toDoSomething(String queryString) {
        String query = queryString;
        Query q = em.createNativeQuery(query);
        try {
            String result = Utils.nullToEmpty(q.getSingleResult());
            return result;
        } catch (NoResultException e) {
            return "";
        }
    }
}
