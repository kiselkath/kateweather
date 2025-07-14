package com.example.kate_weather.dto;

import com.example.kate_weather.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Fetches weather data from OpenWeatherMap API.
 */
@Component
public class WeatherClient {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String apiUrl;

    public WeatherClient(RestTemplate restTemplate,
                         @Value("${openweather.api.key}") String apiKey,
                         @Value("${openweather.api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    /**
     * Fetches current weather for the given city name.
     *
     * @param cityName name of the city
     * @return WeatherResponse with description and temperature
     */
    public WeatherResponse getWeatherForCity(String cityName) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, cityName, apiKey);

        try {
            return restTemplate.getForObject(url, WeatherResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data: " + e.getMessage(), e);
        }
    }
}
