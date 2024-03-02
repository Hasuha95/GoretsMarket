package com.example.currencies.service;

import com.example.currencies.model.CurrentCurrency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Data
@Slf4j
@Service
@PropertySource("classpath:connection.properties")
public class GetAndSerialiseCurrencyService {
    private Timestamp time = null;
    @Value("${connection.url}")
    private String url;
    @Autowired
    private CurrencyRepoService service;

    @Scheduled(cron = "7 * * * * *")
    private void currency(){
        HttpResponse<String> response = connect(url);

        if (time == null) {
            try {
                time = service.getSingleCurrency().getDate();
            } catch (NoSuchElementException | EmptyResultDataAccessException e ) {
                time = Timestamp.valueOf(LocalDateTime.now().minusHours(1));
                log.warn("No elements in DB, then currency date = " + time);
            }
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap<String, CurrentCurrency> map =
                    objectMapper.readValue(parsString(response.body()),
                            new TypeReference<HashMap<String, CurrentCurrency>>() {});

            List<CurrentCurrency> list = map.values().stream().toList();

            Timestamp timestamp = list.get(1).getDate();

            if (!timestamp.equals(time)){
                time = timestamp;
                service.saveCurrencies(list);
                log.info("Currencies added with date: " + time);
            } else {
                log.info("Currencies not added, because date has not been updated");
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            log.error("NullPointerException: " + e.getMessage());
        }

    }



    /**
     * @param jsonStr
     * @return  StringBuilder
     */
    private String parsString(String jsonStr){
        String[]  strArr = jsonStr.split("\n");
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        String date = "";

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].startsWith("}")) {
                flag = false;
            }

            if (strArr[i].startsWith("    \"Timestamp\":")){
                date = strArr[i];
            }

            if (flag) {
                if (strArr[i].startsWith("            \"ID\"")){
                    builder.append(date);
                }
                builder.append(strArr[i]);
            }

            if (strArr[i].startsWith("    \"Valute\"")) {
                flag = true;
                builder.append("{");
            }
        }

        return builder.toString();
    }


    /**
     * @param urlString
     * @return HttpURLConnection
     */
    private HttpResponse<String> connect(String urlString) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(urlString)).build();
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200){
                log.info("Connected. Response status code is 200");
            }

        } catch (ConnectException e) {
            log.error("ConnectException: " + e.getMessage());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

}
