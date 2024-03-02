package com.example.currency_trader.service.trader;

import com.example.currency_trader.model.CurrentCurrency;
import com.example.currency_trader.service.CurrencyService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@Service
@PropertySource("variable.properties")
public class Trader {
    private CurrencyService service;
    private BuyAndSell buyAndSell;
    private List<CurrentCurrency> listOfWeekCurrency;
    private float previousCurrencyValue;
    @Value("${trader.charCode}")
    private String charCode;

    // false - падает. true - растёт
    private boolean status;

    @Autowired
    public Trader(CurrencyService service) {
        this.listOfWeekCurrency = service.getListOfCurrenciesByCharCodeForTheWeek(charCode);
        status = false;
    }

    @Scheduled(cron = "8 * * * * *")
    private void trade() {
        log.info("Scheduled_  ...");
        if (previousCurrencyValue == 0) {
            previousCurrencyValue = listOfWeekCurrency.get(listOfWeekCurrency.size() - 1).getValue();
        }
        CurrentCurrency currentCurrency = service.getLastCurrencyByCharCode(charCode);

        float delta = previousCurrencyValue - currentCurrency.getValue();
        analise(delta);
        log.info("normal working");
    }

    private void analise(float delta) {
        if (delta < 0 && !status) {
            status = true;
            buyAndSell.buy();
        } else if (delta > 0 && status) {
            status = false;
            buyAndSell.sell();
        }
    }
}
