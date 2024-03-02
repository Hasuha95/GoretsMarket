package com.example.currency_trader.service.trader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class BuyAndSell {

    @Transactional
    public void buy() {
        log.info("Transaction: buy");
    }

    @Transactional
    public void sell() {
        log.info("Transaction: sell");
    }

}
