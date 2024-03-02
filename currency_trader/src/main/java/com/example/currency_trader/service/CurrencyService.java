package com.example.currency_trader.service;

import com.example.currency_trader.model.CurrentCurrency;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public interface CurrencyService{
    List<CurrentCurrency> getAllCurrencies();
    List<CurrentCurrency> getAllByCharCode(String char_code);

    CurrentCurrency getCurrencyByCharCodeInDate(String char_name, LocalDateTime date);

    List<CurrentCurrency> getListOfCurrenciesByCharCodeForTheDay(String char_name, LocalDateTime date);

    List<CurrentCurrency>getListOfCurrenciesByCharCodeForTheWeek(String char_code);

    CurrentCurrency getLastCurrencyByCharCode(String charCode);

    }
