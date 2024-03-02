package com.example.currency_trader.repository;

import com.example.currency_trader.model.CurrentCurrency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CustomCurrencyRepositoryImpl implements CustomCurrencyRepository{

    private Query query;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CurrentCurrency> findByCharCode(String charCode) {
        query = entityManager.createQuery( "from CurrentCurrency c where c.CharCode=?1");
        query.setParameter(1, charCode);

        return query.getResultList();
    }

    @Override
    public CurrentCurrency findCurrencyByCharCodeInDate(String charCode, LocalDateTime date) {
        query = entityManager.createQuery("from CurrentCurrency c where c.CharCode=?1 and c.Date=?2");
        query.setMaxResults(1);
        query.setParameter(1, charCode);
        query.setParameter(2, date);

        return (CurrentCurrency) query.getSingleResult();
    }

    @Override
    public List<CurrentCurrency> findListOfCurrenciesByCharCodeForTheDay(String char_name, LocalDateTime date) {
        query = entityManager.createQuery("from CurrentCurrency c where c.CharCode=?1 and c.Date=?2");
        query.setParameter(1, char_name);
        query.setParameter(2, date);

        return query.getResultList();
    }

    @Override
    public List<CurrentCurrency> findListOfCurrenciesByCharCodeForTheWeek(String char_code) {
        query = entityManager.createQuery("from CurrentCurrency c where c.Date <= ?1 and c.CharCode = ?2");
        query.setMaxResults(10);
        query.setParameter(1, LocalDateTime.now());
        query.setParameter(2, char_code);

        return query.getResultList();
    }

    @Override
    public CurrentCurrency findLastCurrencyByCharCode(String charCode) {
        return null;
    }
}
