package com.utn.ba.ddsi.climaalertapi.dtos.weather.WeatherAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Current(

    @JsonProperty("last_updated")
    String actualizacion,

    @JsonProperty("temp_c")
    double temperatura,

    @JsonProperty("humidity")
    int humedad) {
}
