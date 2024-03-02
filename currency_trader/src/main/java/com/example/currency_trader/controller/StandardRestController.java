package com.example.currency_trader.controller;

import com.example.currency_trader.exception.BadRequestParametersException;
import com.example.currency_trader.model.CurrentCurrency;
import com.example.currency_trader.service.CurrencyService;
import jakarta.annotation.Nullable;
import jakarta.persistence.NoResultException;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/standard/v1")
public class StandardRestController {
    @Autowired
    @Setter
    private CurrencyService repoService;

    /**
     * Возвращает курс всех валют за весь период
     * @return
     */
    @GetMapping("/getAll")
    public List<CurrentCurrency> getAll(){
        return repoService.getAllCurrencies();
    }

    /**
     * Возвращает курс указанной валюты за весь период
     * @param char_code
     * @return
     * @throws BadRequestParametersException
     */
    @GetMapping("/getAllByCharCode")
    public List<CurrentCurrency> getAllByCharCode(@RequestParam String char_code) throws BadRequestParametersException {
        ParameterIsNull(char_code);
        log.info("parameter: " + char_code);

        return repoService.getAllByCharCode(char_code);
    }

    /**
     * Возвращает курс указанной валюты на заданный день
     * @param char_code String
     * @param date format must be yyyy-mm-dd hh:mm:ss[.fffffffff]  String
     * @return  CurrentCurrency
     * @throws BadRequestParametersException
     */
    @GetMapping("/getCurrencyByCharCodeInDate")
    public CurrentCurrency getCurrencyByCharCodeInDate(@RequestParam String char_code,
                                                       @RequestParam(required = false) @Nullable String date) throws BadRequestParametersException {
        ParameterIsNull(char_code);
        ParameterIsNull(date);
        LocalDateTime DATE;
        if (ParameterIsNull(date)){
            DATE = LocalDateTime.now();
        } else {
            DATE = Timestamp.valueOf(date).toLocalDateTime();
        }

        return repoService.getCurrencyByCharCodeInDate(char_code, DATE);
    }

    /**
     * Возвращает список указанных валют за день
     * @param char_code String
     * @param date  format must be yyyy-mm-dd hh:mm:ss[.fffffffff]  String
     * @return List<CurrentCurrency>
     * @throws BadRequestParametersException
     */
    @GetMapping("/getListOfCurrenciesByCharCodeForTheDay")
    public List<CurrentCurrency> getListOfCurrenciesByCharCodeForTheDay(@RequestParam String char_code,
                                                                        @RequestParam(required = false) @Nullable String date) throws BadRequestParametersException {
        ParameterIsNull(char_code);
        LocalDateTime DATE;
        if (ParameterIsNull(date)){
            DATE = LocalDateTime.now();
        } else {
            DATE = Timestamp.valueOf(date).toLocalDateTime();
        }

        return repoService.getListOfCurrenciesByCharCodeForTheDay(char_code, DATE);
    }













    @GetMapping("/getCurrencyByChar_Name")
    public List<CurrentCurrency> getCurrencyByChar_Name(@RequestParam String char_name) throws BadRequestParametersException {
        ParameterIsNull(char_name);

        return repoService.getAllByCharCode(char_name);
    }


    /**
     * Возвращает список указанных валют за неделю
     * @param char_name
     * @return
     */
    @GetMapping("/getListOfCurrenciesByChar_NameForTheWeek")
    public List<CurrentCurrency> getListOfCurrenciesByChar_NameForTheWeek(@RequestParam String char_name) throws BadRequestParametersException {
        ParameterIsNull(char_name);
//        return charNameService.getListOfCurrencyForTheWeek();
        return null;
    }







    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestParametersException.class)
    private ResponseEntity<String> BadRequestParametersExceptionExceptionHandler(BadRequestParametersException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoResultException.class)
    private ResponseEntity<String> NoResultExceptionExceptionHandler(NoResultException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    private boolean ParameterIsNull(Object par) throws BadRequestParametersException {
        if (par == null){
            throw new BadRequestParametersException();
        } else{
            return true;
        }
    }

}
