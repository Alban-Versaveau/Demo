package com.example.demo.services;

import com.example.demo.dtos.RateListDTO;
import com.example.demo.dtos.SymbolListDTO;
import com.example.demo.enums.CurrencyEnum;
import com.example.demo.enums.StockTypeEnum;
import com.fasterxml.jackson.databind.MapperFeature;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Service
public class MyService {

    protected static OkHttpClient httpClient = new OkHttpClient();

    private static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    public MyService() {
    }

    public int m() throws IOException {
        this.call1();
        this.call2();
        return 0;
    }

    private void call1() throws IOException {
        String symbolsUrl = "http://data.fixer.io/api/symbols?access_key=a344c55340963ffe0a5e86a641d2b734";
        Request request = new Request.Builder().url(symbolsUrl).get().build();
        Call call = httpClient.newCall(request);
        Response response = call.execute();
        String responseBody = response.body().string();
        response.close();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        SymbolListDTO symbolListDTO = mapper.readValue(responseBody, SymbolListDTO.class);
    }

    private void call2() throws IOException {
        String ratesUrl = "http://data.fixer.io/api/latest?access_key=a344c55340963ffe0a5e86a641d2b734";
        Request request = new Request.Builder().url(ratesUrl).get().build();
        Call call = httpClient.newCall(request);
        Response response = call.execute();
        String responseBody = response.body().string();
        response.close();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        RateListDTO rateListDTO = mapper.readValue(responseBody, RateListDTO.class);
    }

    private double compute_value(Wallet wallet, EUR, rateProvider)) {

    }

    private double rateProvider(StockTypeEnum stockTypeEnum, CurrencyEnum currencyEnum) {
        
    }

}
