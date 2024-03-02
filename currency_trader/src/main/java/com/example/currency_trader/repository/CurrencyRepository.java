package com.example.currency_trader.repository;

import com.example.currency_trader.model.CurrentCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CurrencyRepository  extends CrudRepository<CurrentCurrency, Long> , CustomCurrencyRepository{

}
