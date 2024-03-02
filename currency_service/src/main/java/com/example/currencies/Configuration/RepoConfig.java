package com.example.currencies.Configuration;

import com.example.currencies.repository.CustomCurrencyRepository;
import com.example.currencies.repository.CustomCurrencyRepositoryImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    public CustomCurrencyRepository customCurrencyRepositoryImpl(){
        return new CustomCurrencyRepositoryImpl();
    }
}
