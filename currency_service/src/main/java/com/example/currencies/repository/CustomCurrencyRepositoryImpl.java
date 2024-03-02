package com.example.currencies.repository;

import com.example.currencies.model.CurrentCurrency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class CustomCurrencyRepositoryImpl implements CustomCurrencyRepository{
    private Query query;

    @PersistenceContext
    private EntityManager em;

    @Override
    public CurrentCurrency finedOneLastCurrency() {
        query = em.createQuery("from CurrentCurrency c ORDER BY c.Date DESC");
        query.setMaxResults(1);
//        query.setParameter(1, "USD");

        return (CurrentCurrency) query.getSingleResult();
    }
}
