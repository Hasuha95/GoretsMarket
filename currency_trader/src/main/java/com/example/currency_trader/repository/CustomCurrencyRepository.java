package com.example.currency_trader.repository;

import com.example.currency_trader.model.CurrentCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public interface CustomCurrencyRepository{
    List<CurrentCurrency> findByCharCode(String charCode);
    CurrentCurrency findCurrencyByCharCodeInDate(String charCode, LocalDateTime date);
    List<CurrentCurrency> findListOfCurrenciesByCharCodeForTheDay(String char_name, LocalDateTime date);

    List<CurrentCurrency> findListOfCurrenciesByCharCodeForTheWeek(String char_name);

    CurrentCurrency findLastCurrencyByCharCode(String charCode);
}
