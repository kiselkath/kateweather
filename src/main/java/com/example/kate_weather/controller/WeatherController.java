package com.example.kate_weather.controller;

import com.example.kate_weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/temperature")
    public String getTemperature() {
        Double temp = weatherService.getTemperature();
        return temp != null ? String.format("Current temperature in %s is %.2f°C", weatherService.getCity(), temp) : "Temperature data not available.";
    }
}
