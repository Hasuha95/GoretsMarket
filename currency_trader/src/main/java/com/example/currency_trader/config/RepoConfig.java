package com.example.currency_trader.config;

import com.example.currency_trader.repository.CurrencyRepository;
import com.example.currency_trader.repository.CustomCurrencyRepository;
import com.example.currency_trader.repository.CustomCurrencyRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    @Bean()
    public CustomCurrencyRepository customCurrencyRepository(){
        return new CustomCurrencyRepositoryImpl();
    }
}
