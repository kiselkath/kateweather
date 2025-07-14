package com.example.kate_weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Represents a city the user wants to visit,
 * including the fetched weather info.
 */
@Document(collection = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    /** Unique MongoDB Identifier. */
    @Id
    private String id;

    /** Name of city. Must not be blank. */
    @NotBlank(message = "City name is required.")
    private String name;

    /** Country of the city (optional, but nice to have). */
    private String country;

    /** Current weather description fetched from OpenWeather. */
    private String weatherDescription;

    /** Current temperature in Celsius fetched from OpenWeather. */
    private double temperature;
}
