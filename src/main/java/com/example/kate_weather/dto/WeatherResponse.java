package com.example.kate_weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private List<Weather> weather;
    private Main main;

    public String getDescription() {
        return weather != null && !weather.isEmpty() ? weather.get(0).getDescription() : "N/A";
    }

    public double getTemperature() {
        return main != null ? main.getTemp() : Double.NaN;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private String description;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {
        private double temp;
    }
}

