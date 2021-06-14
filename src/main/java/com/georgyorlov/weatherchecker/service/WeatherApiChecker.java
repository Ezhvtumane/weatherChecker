package com.georgyorlov.weatherchecker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class WeatherApiChecker {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    private static final String url = "%s?q=%s&appid=%s";

    @Value("${apiKey:noApiKeyFound}")
    private String apiKey;

    @Value("${baseUrl:noUrlFound}")
    private String baseUrl;

    public String update(String cityName) {
        final String fullUrl = String.format(url, baseUrl, cityName, apiKey);
        HttpEntity<String> response = restTemplate.exchange(fullUrl, HttpMethod.GET, new HttpEntity<>(String.class), String.class);
        String responseBody = response.getBody();
        log.info(responseBody);
        return responseBody;
    }
}
