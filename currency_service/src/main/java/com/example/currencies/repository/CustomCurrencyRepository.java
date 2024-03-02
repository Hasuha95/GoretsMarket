package com.example.currencies.repository;

import com.example.currencies.model.CurrentCurrency;

import java.util.Optional;

public interface CustomCurrencyRepository {
    CurrentCurrency finedOneLastCurrency();
}
