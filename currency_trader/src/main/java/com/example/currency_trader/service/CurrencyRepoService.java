package com.example.currency_trader.service;

import com.example.currency_trader.model.CurrentCurrency;
import com.example.currency_trader.repository.CurrencyRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyRepoService implements CurrencyService{
    @Autowired
    private CurrencyRepository repository;

    @Override
    public List<CurrentCurrency> getAllCurrencies() throws NoResultException {
        return (List<CurrentCurrency>) repository.findAll();
    }

    @Override
    public List<CurrentCurrency> getAllByCharCode(String char_code) throws NoResultException {
        return repository.findByCharCode(char_code);
    }

    @Override
    public CurrentCurrency getCurrencyByCharCodeInDate
            (String char_code, LocalDateTime date) throws NoResultException{
        return repository.findCurrencyByCharCodeInDate(char_code, date);
    }

    @Override
    public List<CurrentCurrency> getListOfCurrenciesByCharCodeForTheDay
            (String char_name, LocalDateTime date) throws NoResultException {
        return repository.findListOfCurrenciesByCharCodeForTheDay(char_name, date);
    }


    public List<CurrentCurrency> getListOfCurrenciesByCharCodeForTheWeek
            (String char_code) throws NoResultException {

       return repository.findListOfCurrenciesByCharCodeForTheWeek(char_code);
    }

    public CurrentCurrency getLastCurrencyByCharCode(String charCode) {
        return repository.findLastCurrencyByCharCode(charCode);
    }
}
